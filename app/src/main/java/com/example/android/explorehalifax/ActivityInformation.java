package com.example.android.explorehalifax;

import java.io.Serializable;

/**
 * Created by Gavin on 10/10/2017.
 */

public class ActivityInformation implements Serializable {

    // String value for the activity's name
    private String mActivityName;

    // String value for the activity's address
    private String mActivityAddress;

    // int value of the image resource ID.
    private int mImageResourceId;

    // String value for the activity's price range
    private String mActivityPrice;

    // String value for the activity's description
    private String mActivityDescription;

    // String value for the activity's phone number
    private String mActivityPhone;

    // String value for the activity's website
    private String mActivityWebsite;

    /**
     * Create a new ActivityInformation object.
     *
     * @param activityName is the name for the specific activity (restaurant, attraction, etc.
     * @param activityAddress is the address of the activity.
     */
    public ActivityInformation(String activityName, String activityAddress, int imageResourceId,
                               String activityPrice, String activityDescription,
                               String activityPhone, String activityWebsite) {
        mActivityName = activityName;
        mActivityAddress = activityAddress;
        mImageResourceId = imageResourceId;
        mActivityPrice = activityPrice;
        mActivityDescription = activityDescription;
        mActivityPhone = activityPhone;
        mActivityWebsite = activityWebsite;
    }

    // Get the activity name.
    public String getActivityName() {
        return mActivityName;
    }

    // Get the activity adress.
    public String getActivityAddress() {
        return mActivityAddress;
    }

    // Get the activity image.
    public int getImageResourceId() {
        return mImageResourceId;
    }

    // Get the activity price.
    public String getActivityPrice() {
        return mActivityPrice;
    }

        // Get the activity description.
    public String getActivityDescription() {
        return mActivityDescription;
    }

    // Get the activity phone number.
    public String getActivityPhone() {
        return mActivityPhone;
    }

    // Get the activity website.
    public String getActivityWebsite() {
        return mActivityWebsite;
    }

}





