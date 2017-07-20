package com.sherlockxu.recyclerviewdemo;

import android.content.Context;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * author         xulei
 * Date           2017/3/22
 */

public class StaggerAdapter extends MyAdapter {
    private List<Integer> heights;

    public StaggerAdapter(Context context, ArrayList<String> datas) {
        super(context, datas);
        //添加item之后并未刷新heights数组，会导致翻到底部出现数组越界。这里并未处理
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
}
