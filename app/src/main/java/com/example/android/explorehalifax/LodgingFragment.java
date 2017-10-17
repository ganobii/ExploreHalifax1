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
public class LodgingFragment extends Fragment {

    private ArrayList<ActivityInformation> mActivityInformation;


    public LodgingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_information_list, container, false);

        // Create a list showing restaurant information
        mActivityInformation = new ArrayList<ActivityInformation>();
        mActivityInformation.add(new ActivityInformation(
                "Lord Nelson", // Activity name
                "1515 South Park Street, Halifax, NS", // Activity address
                R.drawable.lord_nelson, // Activity image
                "$$$", // Activity price
                "The Lord Nelson Hotel is a grand hotel in Halifax, Nova Scotia, Canada. It is " +
                        "located on the corner of Spring Garden and South Park Streets across " +
                        "from the Halifax Public Gardens. It was built in 1927 by a consortium of " +
                        "investors led by the Canadian Pacific Railway who wanted a Halifax anchor " +
                        "to the chain of hotels operated by its Nova Scotian subsidiary, the " +
                        "Dominion Atlantic Railway.[1] Along with the rival Canadian National " +
                        "Railway's Hotel Nova Scotian which began the same year, the Lord Nelson " +
                        "was Halifax's first modern hotel. The hotel was named after Admiral " +
                        "Horatio Nelson, who ironically never came to Halifax in his famous naval " +
                        "career, but whose name stood for naval traditions strongly associated " +
                        "with the heritage of Halifax.", // Activity description
                "http://www.lordnelsonhotel.com", // Activity website
                "902.423.6331")); // Activity phone number
        mActivityInformation.add(new ActivityInformation(
                "Courtyard by Marriott", // Activity name
                "5120 Salter Street, Halifax, NS", // Activity address
                R.drawable.courtyard_marriott, // Activity image
                "$$$", // Activity price
                "As Halifax bustles along outside, through our hotel doors you are welcomed " +
                        "with first-class hotel services and amenities. Our spacious guest rooms " +
                        "feature complimentary wireless high-speed Internet. Our fireside lounge, " +
                        "incredible restaurants, 24-hour fitness centre and indoor heated pool add " +
                        "to your enjoyment.", // Activity description
                "http://www.marriott.com", // Activity website
                "902.428.1900")); // Activity phone number
        mActivityInformation.add(new ActivityInformation(
                "Prince George", // Activity name
                "1725 Market Street, Halifax, NS", // Activity address
                R.drawable.prince_george, // Activity image
                "$$$$", // Activity price
                "World-class hotel excellence in the heart of downtown Halifax. Experience " +
                        "the sophistication and charm of The Prince George Hotel, from the moment" +
                        " you arrive to the time you checkout, you'll love our Four Diamond " +
                        "service and impeccably appointed accommodations. Our 200+ stylish " +
                        "guestrooms and suites feature contemporary design and luxe amenities for " +
                        "an unparalleled hotel experience that will please even the most discerning " +
                        "of travellers.", // Activity description
                "http://www.princegeorgehotel.com", // Activity website
                "902.425.1986")); // Activity phone number
        mActivityInformation.add(new ActivityInformation(
                "Harbourfront Marriott", // Activity name
                "1919 Upper Water Street, Halifax, NS", // Activity address
                R.drawable.marriott_harbourfront, // Activity image
                "$$$$", // Activity price
                "A truly special hotel experience awaits you here in Nova Scotia's vibrant capital " +
                        "city. With luxury accommodations, excellent on-site dining and a prime " +
                        "waterfront location, the Halifax Marriott Harbourfront Hotel is an " +
                        "extraordinary destination for both business and leisure travel.", // Activity
                // description
                "http://www.marriott.com", // Activity website
                "902.421.1700")); // Activity phone number

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
