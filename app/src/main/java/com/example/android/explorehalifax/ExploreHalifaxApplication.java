package com.example.android.explorehalifax;

import android.app.Application;
import android.content.Context;

/**
 * Created by andrewshand on 2017-10-15.
 */

public class ExploreHalifaxApplication extends Application {
    private static ExploreHalifaxApplication mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}
