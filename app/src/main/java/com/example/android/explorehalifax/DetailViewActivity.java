package com.example.android.explorehalifax;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.android.explorehalifax.ActivityInformation.DETAIL_VIEW_DATA;

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
            mActivityInformation = (ActivityInformation) getIntent().getSerializableExtra
                    (DETAIL_VIEW_DATA);
        } catch (Exception ignored) {
        }

        if (mActivityInformation != null) {

            // Find the ImageView in the activity_description.xml layout with the ID activity_image.
            ImageView activityImageView = (ImageView) findViewById(R.id.activity_image);
            // Display the provided image based on the resource ID
            activityImageView.setImageResource(mActivityInformation.getImageResourceId());

            // Find the TextView in the activity_description.xml layout with the ID activity_name.
            TextView activityNameTextView = (TextView) findViewById(R.id.activity_name);
            // Display the provided text based on the ID.
            activityNameTextView.setText(mActivityInformation.getActivityName());

            // Find the TextView in the activity_description.xml layout with the ID activity_description.
            TextView activityDescriptionTextView = (TextView) findViewById(R.id.activity_description);
            // Display the provided text based on the ID.
            activityDescriptionTextView.setText(mActivityInformation.getActivityDescription());

            // Find the Button in the activity_description.xml layout with the ID activity_address.
            final Button activityAddressTextView = (Button) findViewById(R.id.activity_address);
            // Create new onClickListener for activityAddressTextView.
            activityAddressTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Create new String variable to store address.
                    String addressUri = "http://maps.google.com/maps?q=" +
                            mActivityInformation.getActivityAddress();
                    // Toaster displays activity address.
                    Toaster.show(mActivityInformation.getActivityAddress());
                    // Create new implicit Intent which will open a maps app and populate the search
                    // field with the ArrayList address when activity is started.
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(addressUri));
                    if (mapIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(mapIntent);
                    }
                }
            });

            // Find the TextView in the activity_description.xml layout with the ID activity_website.
            final Button activityWebsiteTextView = (Button) findViewById(R.id.activity_website);
            // Display the provided text based on the ID.
            //activityWebsiteTextView.setText(mActivityInformation.getActivityWebsite());

            // Create new onClickListener for activityWebsiteTextView.
            activityWebsiteTextView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Create new String variable to store website.
                    String websiteUrl = mActivityInformation.getActivityWebsite();
                    // Toaster displays activity website address.
                    Toaster.show(mActivityInformation.getActivityWebsite());
                    // Create new implicit Intent which will open a browser app and populate the search
                    // field with the ArrayList website when activity is started.
                    Intent websiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
                    if (websiteIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(websiteIntent);
                    }
                }

            });

            // Find the TextView in the activity_description.xml layout with the ID activity_phone.
            final TextView activityPhoneTextView = (TextView) findViewById(R.id.activity_phone);
            // Create new onClickListener for activityPhoneTextView.
            activityPhoneTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Create new String variable to store phone number.
                    String phoneUri = "tel:" +
                            mActivityInformation.getActivityPhone();
                    // Toaster displays activity phone number.
                    Toaster.show(mActivityInformation.getActivityPhone());
                    // Create new implicit Intent which will open a phone app and populate the search
                    // field with the ArrayList phone number when activity is started.
                    Intent phoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneUri));
                    if (phoneIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(phoneIntent);
                    }
                }
            });

        } else {
            // Show an error
        }

        super.onCreate(savedInstanceState);
    }


}

