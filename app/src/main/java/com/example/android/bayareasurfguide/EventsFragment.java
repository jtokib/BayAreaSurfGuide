package com.example.android.bayareasurfguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.event_1), getString(R.string.event_1_desc), getString(R.string.event_1_loc), R.drawable.osl));
        places.add(new Place(getString(R.string.event_2), getString(R.string.event_2_desc), getString(R.string.event_2_loc), R.drawable.hardly));
        places.add(new Place(getString(R.string.event_3), getString(R.string.event_3_desc), getString(R.string.event_3_loc), R.drawable.sterngrove));
        places.add(new Place(getString(R.string.event_4), getString(R.string.event_4_desc), getString(R.string.event_4_loc), R.drawable.street));

        PlaceAdaptor adaptor = new PlaceAdaptor(getActivity(), places);

        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String plusCode = places.get(position).getLocation();
                String plusCodeUri = "http://plus.codes/" + plusCode;
                Uri gmmIntentUri = Uri.parse(plusCodeUri);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        return rootView;
    }
}
