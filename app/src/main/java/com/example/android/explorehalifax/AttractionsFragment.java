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
public class AttractionsFragment extends Fragment {

    private ArrayList<ActivityInformation> mActivityInformation;

    public AttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_information_list, container, false);

        // Create a list showing attractions information
        mActivityInformation = new ArrayList<ActivityInformation>();
        mActivityInformation.add(new ActivityInformation(
                "The Waterfront", // Activity name
                "Halifax Waterfront, NS", // Activity address
                R.drawable.waterfront, // Activity image
                "Free", // Activity price
                "Busy hub with a working port & 1 of the world’s " +
                    "longest downtown boardwalks, plus eateries & stores.", // Activity description
                "http://www.novascotia.com/explore/top-25/halifax-waterfront", // Activity website
                "902.422.6591")); // Activity phone number
        mActivityInformation.add(new ActivityInformation(
                "Central Library", // Activity name
                "5440 Spring Garden Road, Halifax, NS", // Activity address
                R.drawable.library, // Activity image
                "Free", // Activity price
                "The Halifax Central Library is a public library in " +
                    "Halifax, Nova Scotia, Canada on the corner of Spring Garden Road and " +
                    "Queen Street.",
                "http://halifaxcentrallibrary.ca/", // Activity website
                "902.490.5700")); // Activity phone number
        mActivityInformation.add(new ActivityInformation(
                "Citadel Hill", // Activity name
                "5425 Sackville Street,Halifax, NS", // Activity address
                R.drawable.citadel_hill, // Activity image
                "$", // Activity price
                "It’s not an exaggeration to say Halifax, a city on " +
                "the sea, owes its existence to the Citadel. It was the large hill " +
                    "overlooking theeasily defended harbour below that led the British" +
                    " military to found the town there in 1749. Among the first buildings " +
                    "constructed was a wooden guardhouse on top of what would eventually " +
                    "be called Citadel Hill, with Halifax’s first settlers building their " +
                    "homes at the base of the hill, closer to the water. Over the years, " +
                    "as the fort grew, so too did the town, with much of Halifax dedicated " +
                    "to supplying the soldiers with both essential supplies and off-duty " +
                    "entertainment.", // Activity description
                "http://www.pc.gc.ca/en/lhn-nhs/ns/halifax", // Activity website
                "902.426.1990")); // Activity phone number
        mActivityInformation.add(new ActivityInformation(
                "Public Gardens", // Activity name
                "5665 Spring Garden Road, Halifax, NS", // Activity address
                R.drawable.public_gardens, // Activity image
                "Free", // Activity price
                "The Halifax Public Gardens are Victorian era public gardens formally established " +
                    "in 1867, the year of Canadian Confederation.", // Activity description
                "http://www.halifaxpublicgardens.ca/", // Activity website
                "")); // Activity phone number

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
