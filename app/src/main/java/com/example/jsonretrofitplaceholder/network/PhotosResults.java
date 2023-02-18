package com.example.jsonretrofitplaceholder.network;

import com.google.gson.annotations.SerializedName;

public class PhotosResults {

    @SerializedName("albumId")

    int albumId;

    @SerializedName("id")
    int id;
    @SerializedName("title")
    String title;
    @SerializedName("image")  //image
    String thumbnail;

    public int getAlbumId() {
        return albumId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
