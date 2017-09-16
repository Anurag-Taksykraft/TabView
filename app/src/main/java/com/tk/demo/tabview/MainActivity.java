package com.tk.demo.tabview;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    public static final Drawable[] IMAGES = new Drawable[10];

    RecyclerView recyclerview;
    ImageView iv_leftArrow,iv_rightArrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        IMAGES= {getResources().getDrawable(R.drawable.icon),R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon};
        for(int i = 0;i<10;i++){
            IMAGES[i] = getResources().getDrawable(R.drawable.icon);
        }
        recyclerview  = (RecyclerView) findViewById(R.id.recyclerview);
        iv_leftArrow  = (ImageView) findViewById(R.id.iv_leftArrow);
        iv_rightArrow = (ImageView) findViewById(R.id.iv_rightArrow);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
        populatRecyclerView();
        iv_leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                recyclerview.getLayoutManager().scrollToPosition(new LinearLayoutManager(MainActivity.this).findFirstVisibleItemPosition()-1);
                recyclerview.getLayoutManager().scrollToPosition(new LinearLayoutManager(MainActivity.this).findFirstVisibleItemPosition() - 1);
            }
        });
        iv_rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                recyclerview.getLayoutManager().scrollToPosition(new LinearLayoutManager(MainActivity.this).findFirstVisibleItemPosition()+1);
//                recyclerview.getLayoutManager().smoothScrollToPosition((int) recyclerview.getScrollX() - recyclerview.getWidth(), (int) recyclerview.getScrollY());
                recyclerview.getLayoutManager().scrollToPosition(new LinearLayoutManager(MainActivity.this).findFirstVisibleItemPosition() + 1);
            }
        });
    }


    // populate the list view by adding data to arraylist
    private void populatRecyclerView() {
        ArrayList<DemoDO> arrayList = new ArrayList<>();
        for (int i = 0; i < IMAGES.length; i++) {
            arrayList.add(new DemoDO(IMAGES[i]));
        }
        RecyclerView_Adapter  adapter = new RecyclerView_Adapter(MainActivity.this, arrayList);
        recyclerview.setAdapter(adapter);// set adapter on recyclerview
        adapter.notifyDataSetChanged();// Notify the adapter

    }
}
