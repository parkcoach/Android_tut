package com.example.woojin.recyclerview;

import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by DBLAB on 2017-08-06.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    int images[] = {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3};
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //xml 디자인 한 부분 적용
        int width = parent.getResources().getDisplayMetrics().widthPixels/3;

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        view.setLayoutParams(new LinearLayoutCompat.LayoutParams(width,width));
        return new RowCell(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //xml 디자인한 부분에 안에 내용 변경
        ((RowCell)holder).imageView.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        //아이템을 측정하는 카운터
        return 3;
    }

    private static class RowCell extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public RowCell(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.recyclerview_item1);
        }
    }
}
