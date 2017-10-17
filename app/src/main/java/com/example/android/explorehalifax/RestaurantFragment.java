package com.example.android.explorehalifax;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.android.explorehalifax.ActivityInformation.DETAIL_VIEW_DATA;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantFragment extends Fragment {

    private ArrayList<ActivityInformation> mActivityInformation;

    public RestaurantFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_information_list, container, false);

        // Create a list showing restaurant information
        mActivityInformation = new ArrayList<ActivityInformation>();
        mActivityInformation.add(new ActivityInformation(
                "Edna", // Activity name
                "2053 Gottingen Street, Halifax, NS", // Activity address
                R.drawable.edna, // Activity image
                "$$", // Activity price
                "Upmarket bistro-style menu with brunch, fresh seafood, wines & cocktails in a " +
                        "cozy atmosphere.", // Activity description
                "http://www.ednarestaurant.com", // Activity website
                "902.431.5683")); // Activity phone number
        mActivityInformation.add(new ActivityInformation(
                "Sushi Shige", // Activity name
                "1532 Granville Street, Halifax, NS", // Activity address
                R.drawable.sushi_shige, // Activity image
                "$$$", // Activity price
                "This classic eatery with hot Japanese entrees & sushi offers a fixed-price " +
                        "chef's choice option.", // Activity description
                "http://www.sushishige.ca", // Activity website
                "902.422.0740")); // Activity phone number
        mActivityInformation.add(new ActivityInformation(
                "The Press Gang", // Activity name
                "5218 Prince Street, Halifax, NS", // Activity address
                R.drawable.press_gang, // Activity image
                "$$$$", // Activity price
                "Choice seafood & meat dishes, classic cocktails & weekend live music in a " +
                        "rustic 18th-century space.", // Activity description
                "http://www.thepressgang.net", // Activity website
                "902.423.8816")); // Activity phone number
        mActivityInformation.add(new ActivityInformation(
                "The Bicycle Thief", // Activity name
                "1475 Lower Water Street, Halifax NS", // Activity address
                R.drawable.bicycle_thief, // Activity image
                "$$$", // Activity price
                "Hopping, contemporary eatery with outdoor seating, cocktails & a creative " +
                        "Italian menu.", // Activity description
                "http://www.bicyclethief.ca", // Activity website
                "902.425.7993")); // Activity phone number

        // Create an {@link ActivityInformationAdapter}, whose data source is a list of
        // {@link mActivityInformation}s. The adapter knows how to create list items for each
        // item in the list.
        ActivityInformationAdapter adapter = new ActivityInformationAdapter(getActivity(),
                mActivityInformation);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_information_list file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ActivityInformationAdapter} we created above,
        // so that the {@link ListView} will display list items for each
        // {@link mActivityInformation} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to the listView.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (mActivityInformation.size() > 0 &&
                        mActivityInformation.get(position) != null) {

                    // Create an {@link ActivityInformation} which stores the position of the
                    // {@link mActivityInformation} view which was clicked.
                    ActivityInformation activityInformationAtPosition = mActivityInformation.
                            get(position);

                    // Create an explicit {@link Intent} to start a new {DetailViewActivity}
                    Intent detailView = new Intent(getActivity(), DetailViewActivity.class);

                    // Add ArrayList position information to detailView.
                    detailView.putExtra(DETAIL_VIEW_DATA, activityInformationAtPosition);

                    // Start activity.
                    startActivity(detailView);
                }
            }
        });

        return rootView;

    }

}
