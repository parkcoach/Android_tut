package com.example.woojin.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView view = (RecyclerView)findViewById(R.id.recyclerview);

        //그리드뷰로 만들것으로 정의하는 부분분
       RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,3);
        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter();

        //어댑터를 연결하는 부분
        view.setAdapter(myRecyclerViewAdapter);
        view.setLayoutManager(layoutManager);
    }
}
