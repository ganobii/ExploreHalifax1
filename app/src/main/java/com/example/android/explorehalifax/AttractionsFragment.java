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

/**
 * A simple {@link Fragment} subclass.
 */
public class AttractionsFragment extends Fragment {

    public AttractionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_information_list, container, false);

        // Create a list showing restaurant information
        final ArrayList<ActivityInformation> activityInformation =
                new ArrayList<ActivityInformation>();
        activityInformation.add(new ActivityInformation("The Waterfront", "Downtown Halifax",
                R.drawable.waterfront, "Free", "", "Website", "902.422.6591"));
        activityInformation.add(new ActivityInformation("Central Library", "5440 Spring Garden Road",
                R.drawable.library, "Free", "", "Website", "902.490.5700"));
        activityInformation.add(new ActivityInformation("Citadel Hill", "5425 Sackville Street",
                R.drawable.citadel_hill, "$", "", "Website", "902.426.1990"));
        activityInformation.add(new ActivityInformation("Public Gardens",
                "5665 Spring Garden Road", R.drawable.public_gardens, "Free", "", "Website", ""));


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

        // Set a click listener to the listView.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

            Intent activityPage = new Intent(getActivity(), ActivityPage.class);

                startActivity(activityPage);
        }
    });

        return rootView;

    }

}
