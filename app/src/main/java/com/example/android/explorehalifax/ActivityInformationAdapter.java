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
 * Created by Gavin on 10/10/2017.
 */

/**
 * {@link ActivityInformationAdapter} is an {@link ArrayAdapter} that can provide the layout
 * for each list item based on a data source, which is a list of {@link ActivityInformation} objects
 */
public class ActivityInformationAdapter extends ArrayAdapter<ActivityInformation> {

    public ActivityInformationAdapter(Context context, ArrayList<ActivityInformation>
            activityInformation) {
        super(context, 0, activityInformation);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link ActivityInformation} object located at this position in the list
        ActivityInformation currentActivity = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID activity_name.
        TextView activityNameTextView = (TextView) listItemView.findViewById(R.id.activity_name);
        // Get the activity name from the currentActivity object and set this text on
        // the activity name TextView.
        activityNameTextView.setText(currentActivity.getActivityName());

        // Find the TextView in the list_item.xml layout with the ID activity_address.
        TextView activityAddressTextView = (TextView) listItemView.findViewById
                (R.id.activity_address);
        // Get the activity address from the currentActivity object and set this text on
        // the activity address TextView.
        activityAddressTextView.setText(currentActivity.getActivityAddress());

        // Find the ImageView in the list_item.xml layout with the ID activity_image.
        ImageView activityImageView = (ImageView) listItemView.findViewById(R.id.activity_image);
        // Display the provided image based on the resource ID
        activityImageView.setImageResource(currentActivity.getImageResourceId());

        // Find the TextView in the list_item.xml layout with the ID activity_price.
        TextView activityPriceTextView = (TextView) listItemView.findViewById(R.id.activity_price);
        // Get the activity name from the currentActivity object and set this text on
        // the activity name TextView.
        activityPriceTextView.setText(currentActivity.getActivityPrice());

         // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;

    }

}
