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
public class FoodAndDrinkFragment extends Fragment {

    public FoodAndDrinkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list_view, container, false);

        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.food_drink_1), getString(R.string.food_drink_1_desc), getString(R.string.food_drink_1_loc)));
        places.add(new Place(getString(R.string.food_drink_2), getString(R.string.food_drink_2_desc), getString(R.string.food_drink_2_loc)));
        places.add(new Place(getString(R.string.food_drink_3), getString(R.string.food_drink_3_desc), getString(R.string.food_drink_3_loc)));
        places.add(new Place(getString(R.string.food_drink_4), getString(R.string.food_drink_4_desc), getString(R.string.food_drink_4_loc)));
        places.add(new Place(getString(R.string.food_drink_5), getString(R.string.food_drink_5_desc), getString(R.string.food_drink_5_loc)));
        places.add(new Place(getString(R.string.food_drink_6), getString(R.string.food_drink_6_desc), getString(R.string.food_drink_6_loc)));
        places.add(new Place(getString(R.string.food_drink_7), getString(R.string.food_drink_7_desc), getString(R.string.food_drink_7_loc)));
        places.add(new Place(getString(R.string.food_drink_8), getString(R.string.food_drink_8_desc), getString(R.string.food_drink_8_loc)));
        places.add(new Place(getString(R.string.food_drink_9), getString(R.string.food_drink_9_desc), getString(R.string.food_drink_9_loc)));
        places.add(new Place(getString(R.string.food_drink_10), getString(R.string.food_drink_10_desc), getString(R.string.food_drink_10_loc)));
        places.add(new Place(getString(R.string.food_drink_11), getString(R.string.food_drink_11_desc), getString(R.string.food_drink_11_loc)));

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
