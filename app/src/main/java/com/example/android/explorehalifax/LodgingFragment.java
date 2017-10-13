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
public class LodgingFragment extends Fragment {


    public LodgingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_information_list, container, false);

        // Create a list showing restaurant information
        final ArrayList<ActivityInformation> activityInformation =
                new ArrayList<ActivityInformation>();
        activityInformation.add(new ActivityInformation("Lord Nelson", "1515 South Park Street",
                R.drawable.lord_nelson, "$$$", "", "lordnelsonhotel.com", "902.423.6331"));
        activityInformation.add(new ActivityInformation("Courtyard by Marriott",
                "5120 Salter Street", R.drawable.courtyard_marriott, "$$$", "", "marriott.com",
                "902.428.1900"));
        activityInformation.add(new ActivityInformation("Prince George", "1725 Market Street",
                R.drawable.prince_george, "$$$", "", "princegeorgehotel.com", "902.425.1986"));
        activityInformation.add(new ActivityInformation("Harbourfront Marriott",
                "1919 Upper Water Street", R.drawable.marriott_harbourfront, "$$$", "",
                "marriott.com", "902.421.1700"));

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
