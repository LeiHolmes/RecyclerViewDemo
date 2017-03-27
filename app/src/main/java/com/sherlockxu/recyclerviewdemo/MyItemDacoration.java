package com.sherlockxu.recyclerviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 创建者:任仲瑞
 * 创建日期:2015/12/29
 * 功能描述:
 */
public class MyItemDacoration extends RecyclerView.ItemDecoration {

    private int space;
    public MyItemDacoration(Context context,int space){
        this.space=space;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {

    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        if (parent.getChildLayoutPosition(view)!=0){
            outRect.top=space;
        }
    }

}