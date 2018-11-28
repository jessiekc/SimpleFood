package com.cityscholar.cs465.simplefood.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class Inflatable<T extends View> implements Parcelable {
    public static final int COVER = 0x1;
    public static final int DETAIL_TEXT = 0x2;
    public static final int FIGURE = 0x3;

    @LayoutRes
    private final int layout;

    public Inflatable(int layout) {
        this.layout = layout;
    }

    Inflatable(Parcel in) {
        layout = in.readInt();
    }

    public static final Creator<Inflatable> CREATOR = new Creator<Inflatable>() {
        @Override
        public Inflatable createFromParcel(Parcel in) {
            switch (in.readByte()) {
                case COVER:
                    return new Cover(in);
                case DETAIL_TEXT:
                    return new DetailText(in);
                case FIGURE:
                    return new Figure(in);
                default:
                    throw new RuntimeException("No such class found");
            }
        }

        @Override
        public Inflatable[] newArray(int size) {
            return new Inflatable[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(layout);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public T inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return (T) inflater.inflate(layout, root, attachToRoot);
    }
}
