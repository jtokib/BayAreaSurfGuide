package com.example.android.bayareasurfguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdaptor extends ArrayAdapter<Place> {

    public PlaceAdaptor(Activity context, ArrayList<Place> places) {
        super(context, 0, places);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        final Place currentPlace = getItem(position);

        //TODO: add code for layout
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);

        if(currentPlace.hasImage()) {
            imageView.setImageResource(currentPlace.getImageResourceId());
        } else {
            imageView.setVisibility(View.GONE);
        }

        TextView titleTextView = listItemView.findViewById(R.id.title);
        titleTextView.setText(currentPlace.getTitle());

        TextView descriptionTextView = listItemView.findViewById(R.id.description);
        descriptionTextView.setText(currentPlace.getDescription());

        return listItemView;
    }
}
