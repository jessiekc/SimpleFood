package com.cityscholar.cs465.simplefood.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.cityscholar.cs465.simplefood.R;

public class Cover extends Inflatable<CardView> {
    @LayoutRes
    private static final int LAYOUT = R.layout.item_cover_card;

    @DrawableRes
    private final int imageId;

    public Cover(int imageId) {
        super(LAYOUT);
        this.imageId = imageId;
    }

    Cover(Parcel in) {
        super(in);
        imageId = in.readInt();
    }

    public static final Parcelable.Creator<Cover> CREATOR
            = new Parcelable.Creator<Cover>() {
        public Cover createFromParcel(Parcel in) {
            return new Cover(in);
        }

        public Cover[] newArray(int size) {
            return new Cover[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(imageId);
    }

    @Override
    public CardView inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        CardView coverCard = super.inflate(inflater, root, attachToRoot);
        ImageView cover = coverCard.findViewById(R.id.restaurantCover);
        cover.setImageDrawable(ResourcesCompat.getDrawable(root.getResources(), imageId, null));
        return coverCard;
    }
}
