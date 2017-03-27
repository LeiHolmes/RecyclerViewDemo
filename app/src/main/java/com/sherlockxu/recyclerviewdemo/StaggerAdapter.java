package com.sherlockxu.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * author         xulei
 * Date           2017/3/22
 */

public class StaggerAdapter extends RecyclerView.Adapter<StaggerAdapter.MyViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<String> datas;
    private List<Integer> heights;

    public StaggerAdapter(Context context, ArrayList<String> datas) {
        this.context = context;
        this.datas = datas;
        inflater = LayoutInflater.from(context);
        heights = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            heights.add((int) (100 + Math.random() * 300));
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.height = heights.get(position);
//        layoutParams.width = heights.get(position);
        holder.itemView.setLayoutParams(layoutParams);
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

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            //初始化控件
            textView = (TextView) itemView.findViewById(R.id.item_textview);
        }
    }
}
