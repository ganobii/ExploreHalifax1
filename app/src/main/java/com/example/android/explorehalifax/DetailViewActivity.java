package com.example.android.explorehalifax;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by andrewshand on 2017-10-15.
 */

public class DetailViewActivity extends AppCompatActivity {

    private ActivityInformation mActivityInformation;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Set the back button
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: // back button
                this.finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_description);

        try {
            mActivityInformation = (ActivityInformation) getIntent().getSerializableExtra("detailViewData");
        } catch (Exception ignored) { }

        if (mActivityInformation != null) {
            // Populate your view
            Toaster.show(mActivityInformation.getActivityName() + "   " +  mActivityInformation.getActivityAddress());

            TextView text = (TextView) findViewById(R.id.activity_name);

            text.setText(mActivityInformation.getActivityName());
        } else {
            // Show an error
        }

        super.onCreate(savedInstanceState);
    }


}

