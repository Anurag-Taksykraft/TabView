package com.tk.demo.tabview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ANURAG on 16-09-2017.
 */

public class RecyclerView_Adapter extends
        RecyclerView.Adapter<RecyclerView_Adapter.RecyclerViewHolder> {// Recyclerview will extend to
    // recyclerview adapter
    private ArrayList<DemoDO> arrayList;
    private Context context;

    public class RecyclerViewHolder extends RecyclerView.ViewHolder  {
        // View holder for gridview recycler view as we used in listview
        public ImageView imageview;




        public RecyclerViewHolder(View view) {
            super(view);
            // Find all views ids

            this.imageview = (ImageView) view
                    .findViewById(R.id.image);


        }



    }

    public RecyclerView_Adapter(Context context,
                                ArrayList<DemoDO> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final DemoDO model = arrayList.get(position);

        RecyclerViewHolder mainHolder = (RecyclerViewHolder) holder;// holder

/*        Bitmap image = BitmapFactory.decodeResource(context.getResources(),
                model.getImage());// This will convert drawbale image into
        // bitmap


        mainHolder.imageview.setImageBitmap(image);*/
        Display display = ((MainActivity)context).getWindowManager().getDefaultDisplay();
        int mWidth = display.getWidth();
        int viewWidth = mWidth / 10;
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) new LinearLayout.LayoutParams(viewWidth, LinearLayout.LayoutParams.WRAP_CONTENT);
        mainHolder.imageview.setLayoutParams(params);
        mainHolder.imageview.setImageDrawable(model.getImage());



    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        // This method will inflate the custom layout and return as viewholder
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(
                R.layout.list_row, viewGroup, false);
        RecyclerViewHolder listHolder = new RecyclerViewHolder(mainGroup);
        return listHolder;

    }

}
