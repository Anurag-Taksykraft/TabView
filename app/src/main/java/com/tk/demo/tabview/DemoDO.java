package com.tk.demo.tabview;

import android.graphics.drawable.Drawable;

/**
 * Created by ANURAG on 16-09-2017.
 */

public class DemoDO {

    // Getter and Setter model for recycler view items
    private Drawable image;

    public DemoDO(Drawable image) {

        this.image = image;
    }

    public Drawable getImage() {
        return image;
    }
}
