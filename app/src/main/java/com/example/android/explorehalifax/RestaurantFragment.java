package com.example.android.explorehalifax;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantFragment extends Fragment {


    public RestaurantFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_information_list, container, false);

        // Create a list showing restaurant information
        final ArrayList<ActivityInformation> activityInformation =
                new ArrayList<ActivityInformation>();
        activityInformation.add(new ActivityInformation("Edna", "2053 Gottingen Street",
                R.drawable.edna, "$$", "", "ednarestaurant.com", "902.431.5683"));
        activityInformation.add(new ActivityInformation("Sushi Shige", "1532 Granville Street",
                R.drawable.sushi_shige, "$$$", "", "sushishige.ca", "902.422.0740"));
        activityInformation.add(new ActivityInformation("The Press Gang", "5218 Prince Street",
                R.drawable.press_gang, "$$$$", "", "thepressgang.net", "902.423.8816"));
        activityInformation.add(new ActivityInformation("The Bicycle Thief",
                "1475 Lower Water Street", R.drawable.bicycle_thief, "$$$", "", "bicyclethief.ca",
                "902.425.7993"));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        ActivityInformationAdapter adapter = new ActivityInformationAdapter(getActivity(),
                activityInformation);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // words_listayout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        return rootView;

    }

}
