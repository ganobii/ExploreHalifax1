package com.example.android.explorehalifax;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gavin on 13/10/2017.
 */

public class ActivityPage extends ArrayAdapter<ActivityInformation> {

    public ActivityPage(Context context, ArrayList<ActivityInformation>
            activityInformation) {
        super(context, 0, activityInformation);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // Check if an existing view is being reused, otherwise inflate the view
        View pageView = convertView;
        if (pageView == null) {
            pageView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_description, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        ActivityInformation currentActivity = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID activity_name.
        TextView activityNameTextView = (TextView) pageView.findViewById(R.id.activity_name);
        // Get the activity name from the currentActivity object and set this text on
        // the activity name TextView.
        activityNameTextView.setText(currentActivity.getActivityName());

        // Find the TextView in the list_item.xml layout with the ID activity_description.
        TextView activityDescriptionTextView = (TextView) pageView.findViewById(R.id.activity_description);
        // Get the activity description from the currentActivity object and set this text on
        // the activity name TextView.
        activityDescriptionTextView.setText(currentActivity.getActivityDescription());

        // Find the TextView in the list_item.xml layout with the ID activity_address.
        TextView activityAddressTextView = (TextView) pageView.findViewById
                (R.id.activity_address);
        // Get the activity address from the currentActivity object and set this text on
        // the activity address TextView.
        activityAddressTextView.setText(currentActivity.getActivityAddress());

        // Find the ImageView in the list_item.xml layout with the ID activity_image.
        ImageView activityImageView = (ImageView) pageView.findViewById(R.id.activity_image);
        // Display the provided image based on the resource ID
        activityImageView.setImageResource(currentActivity.getImageResourceId());

        // Find the TextView in the list_item.xml layout with the ID activity_price.
        TextView activityPriceTextView = (TextView) pageView.findViewById(R.id.activity_price);
        // Get the activity price from the currentActivity object and set this text on
        // the activity name TextView.
        activityPriceTextView.setText(currentActivity.getActivityPrice());

        // Find the TextView in the list_item.xml layout with the ID activity_website.
        TextView activityWebsiteTextView = (TextView) pageView.findViewById(R.id.activity_website);
        // Get the activity website from the currentActivity object and set this text on
        // the activity name TextView.
        activityWebsiteTextView.setText(currentActivity.getActivityWebsite());

        // Find the TextView in the list_item.xml layout with the ID activity_phone.
        TextView activityPhoneTextView = (TextView) pageView.findViewById(R.id.activity_phone);
        // Get the activity phone from the currentActivity object and set this text on
        // the activity name TextView.
        activityPhoneTextView.setText(currentActivity.getActivityPhone());

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return pageView;

    }

}


