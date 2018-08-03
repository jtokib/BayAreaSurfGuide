package com.example.android.bayareasurfguide;

public class Place {
    //No image constant
    private static final int NO_IMAGE = -1;
    //Image for place
    private int _imageResourceId = NO_IMAGE;
    //Place name
    private String _title;
    //Place description
    private String _description;
    //Private Google Plus Location
    private String _location;

    public Place(String title, String description) {
        _title = title;
        _description = description;
    }

    public Place(String title, String description, String location) {
        _title = title;
        _description = description;
        _location = location;
    }

    public Place(String title, String description, int imageResourceId) {
        _title = title;
        _description = description;
        _imageResourceId = imageResourceId;
    }

    public Place(String title, String description, String location, int imageResourceId) {
        _title = title;
        _description = description;
        _location = location;
        _imageResourceId = imageResourceId;
    }

    public String getTitle() { return _title; }

    public String getDescription() {
        return _description;
    }

    public String getLocation() { return _location; }

    public int getImageResourceId() {
        return _imageResourceId;
    }

    public boolean hasImage() {
        return  _imageResourceId != NO_IMAGE;
    }
}
