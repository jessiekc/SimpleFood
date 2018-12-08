package com.cityscholar.cs465.simplefood;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.content.res.ResourcesCompat;
import android.util.SparseArray;
import com.cityscholar.cs465.simplefood.content.Cover;
import com.cityscholar.cs465.simplefood.content.DetailText;
import com.cityscholar.cs465.simplefood.content.Figure;
import com.cityscholar.cs465.simplefood.content.Inflatable;

import java.util.ArrayList;
import java.util.List;

public class Restaurant implements Parcelable {
    private final Cover cover;
    private final String name;
    private final SparseArray<String> highlights;
    private final List<Inflatable> details;
    private final String location;

    public Restaurant(Cover cover, String name, SparseArray<String> highlights, List<Inflatable> details, String location) {
        this.cover = cover;
        this.name = name;
        this.highlights = highlights;
        this.details = details;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "cover=" + cover +
                ", name='" + name + '\'' +
                ", highlights=" + highlights +
                ", details=" + details +
                '}';
    }

    private Restaurant(Parcel in) {
        cover = in.readParcelable(Cover.class.getClassLoader());
        name = in.readString();
        highlights = in.readSparseArray(String.class.getClassLoader());
        details = in.createTypedArrayList(Inflatable.CREATOR);
        location = in.readString();
    }

    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };

    public Cover getCover() {
        return cover;
    }

    public SparseArray<String> getHighlights() {
        return highlights;
    }

    public String getName() {
        return name;
    }

    public List<Inflatable> getDetails() {
        return details;
    }

    public String getLocation() {return location;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(cover, 0);
        dest.writeString(name);
        dest.writeSparseArray((SparseArray) highlights);
        dest.writeList(details);
        dest.writeString(location);
    }

    public static class Builder {
        private boolean built = false;
        private Cover cover;
        private SparseArray<String> highlights;
        private List<Inflatable> details;
        private String name;
        private String location;


        public Builder() {
            highlights = new SparseArray<>();
            highlights.append(0, "");
            details = new ArrayList<>();
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCover(int coverId) {
            this.cover = new Cover(coverId);
            return this;
        }

        public Builder putHighlight(int type, String content) {
            highlights.append(type, content);
            return this;
        }

        public Builder appendDetail(String content) {
            details.add(new DetailText(content));
            return this;
        }

        public Builder appendDetail(int imageId, String caption) {
            details.add(new Figure(imageId, caption));
            return this;
        }

        public Builder setLocation(String location){
            this.location = location;
            return this;
        }

        public Restaurant build() {
            if (!built) {
                built = true;
                return new Restaurant(cover, name, highlights, details, location);
            }
            throw new RuntimeException("Restaurants already instantiated!");
        }
    }
}
