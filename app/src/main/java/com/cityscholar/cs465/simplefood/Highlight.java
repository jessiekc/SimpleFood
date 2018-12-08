package com.cityscholar.cs465.simplefood;

import android.os.Parcel;
import android.os.Parcelable;

public class Highlight implements Parcelable {
    public final int level;
    public final String content;

    public Highlight(int level, String content) {
        this.level = level;
        this.content = content;
    }

    protected Highlight(Parcel in) {
        level = in.readInt();
        content = in.readString();
    }

    public static final Creator<Highlight> CREATOR = new Creator<Highlight>() {
        @Override
        public Highlight createFromParcel(Parcel in) {
            return new Highlight(in);
        }

        @Override
        public Highlight[] newArray(int size) {
            return new Highlight[size];
        }
    };

    public static Highlight empty() {
        return new Highlight(0, "ShouldnotAppear");
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(level);
        dest.writeString(content);
    }
}
