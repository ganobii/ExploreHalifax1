package com.example.android.explorehalifax;

import android.widget.Toast;

/**
 * Created by andrewshand on 2017-10-15.
 */

public class Toaster {
    public static void show(String text) {
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(ExploreHalifaxApplication.getContext(), text, duration);
        toast.show();

    }
}
