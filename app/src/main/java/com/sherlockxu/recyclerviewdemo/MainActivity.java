package com.sherlockxu.recyclerviewdemo;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.sherlockxu.recyclerviewdemo.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private ArrayList<String> list;
    private MyAdapter adapter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initView();
        initData();
        initListener();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_main);
    }

    private void initListener() {
        binding.setPresenter(new Presenter());
        adapter.setOnItemClickedListener(new MyAdapter.onItemClickedListener() {
            @Override
            public void onClick(View view, int position) {
                adapter.addItem(position);
                Toast.makeText(MainActivity.this, "点击click:"+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                adapter.removeItem(position);
                Toast.makeText(MainActivity.this, "长按click:"+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            list.add("" + (char) i);
        }
        adapter = new MyAdapter(this, list);
        recyclerView.setAdapter(adapter);
        //设置RecyclerView布局管理
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //设置RecyclerView的Item分割线
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        //设置RecyclerView的动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public class Presenter {
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_listview://ListView
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                    break;
                case R.id.button_gridview://GridView
                    recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
                    break;
                case R.id.button_hor_gridview://水平GridView
                    recyclerView.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.HORIZONTAL));
                    break;
                case R.id.button_staggered://瀑布流
                    MainActivity.this.startActivity(new Intent(MainActivity.this, StaggerActivity.class));
                    break;
            }
        }
    }
}
