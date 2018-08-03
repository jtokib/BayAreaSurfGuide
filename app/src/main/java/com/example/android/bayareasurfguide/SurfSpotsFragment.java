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

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SurfSpotsFragment extends Fragment {

    public SurfSpotsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.spot_1), getString(R.string.spot_1_desc), getString(R.string.spot_1_loc), R.drawable.chron));
        places.add(new Place(getString(R.string.spot_2), getString(R.string.spot_2_desc), getString(R.string.spot_2_loc), R.drawable.ftpt));
        places.add(new Place(getString(R.string.spot_3), getString(R.string.spot_3_desc), getString(R.string.spot_3_loc), R.drawable.noimage));
        places.add(new Place(getString(R.string.spot_4), getString(R.string.spot_4_desc), getString(R.string.spot_4_loc), R.drawable.obsf));
        places.add(new Place(getString(R.string.spot_5), getString(R.string.spot_5_desc), getString(R.string.spot_5_loc), R.drawable.sharppark));
        places.add(new Place(getString(R.string.spot_6), getString(R.string.spot_6_desc), getString(R.string.spot_6_loc), R.drawable.rockaway));
        places.add(new Place(getString(R.string.spot_7), getString(R.string.spot_7_desc), getString(R.string.spot_7_loc), R.drawable.lindy));
        places.add(new Place(getString(R.string.spot_8), getString(R.string.spot_8_desc), getString(R.string.spot_8_loc), R.drawable.graywhale));
        places.add(new Place(getString(R.string.spot_9), getString(R.string.spot_9_desc), getString(R.string.spot_9_loc), R.drawable.montara));
        places.add(new Place(getString(R.string.spot_10), getString(R.string.spot_10_desc), getString(R.string.spot_10_loc), R.drawable.mavericks));

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
