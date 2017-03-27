package com.sherlockxu.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class StaggerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<String> list;
    private StaggerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stagger);
        initView();
        initListener();
        initData();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_stagger);
    }

    private void initListener() {
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            list.add("" + (char) i);
        }
        adapter = new StaggerAdapter(this, list);
        recyclerView.setAdapter(adapter);
        //设置RecyclerView布局管理
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL));
        //设置RecyclerView的Item分割线
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        //设置RecyclerView的动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
