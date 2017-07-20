package com.sherlockxu.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Description:
 * author         xulei
 * Date           2017/3/22
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    protected ArrayList<String> datas;
    private onItemClickedListener onItemClickedListener;

    public MyAdapter(Context context, ArrayList<String> datas) {
        this.context = context;
        this.datas = datas;
        inflater = LayoutInflater.from(context);
    }

    public void setOnItemClickedListener(MyAdapter.onItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(datas.get(position));
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recycler_view, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    /**
     * 添加条目
     */
    public void addItem(int position) {
        datas.add(position, "xulei");
//        notifyDataSetChanged();
        notifyItemInserted(position);//调用这个才有动画效果
    }

    /**
     * 移除条目
     */
    public void removeItem(int position) {
        datas.remove(position);
        notifyItemRemoved(position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            //初始化控件
            textView = (TextView) itemView.findViewById(R.id.item_textview);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickedListener != null)
                        onItemClickedListener.onClick(view, getAdapterPosition());//可立刻获取到当前position
//                        onItemClickedListener.onClick(view, getLayoutPosition());//需等当前视图更新完才能获取到当前position，<16ms。
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (onItemClickedListener != null)
                        onItemClickedListener.onLongClick(view, getAdapterPosition());
                    return false;
                }
            });
        }
    }

    /**
     * 点击回调的接口
     */
    interface onItemClickedListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }
}
