package com.cityscholar.cs465.simplefood.content;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cityscholar.cs465.simplefood.R;

public class Figure extends Inflatable<TextView> {
    @LayoutRes
    private static final int LAYOUT = R.layout.item_detail_figure;

    @DrawableRes
    private final int imageId;
    private final String description;

    public Figure(int imageId, String description) {
        super(LAYOUT);
        this.imageId = imageId;
        this.description = description;
    }

    Figure(Parcel in) {
        super(in);
        imageId = in.readInt();
        description = in.readString();
    }

    public static final Parcelable.Creator<Figure> CREATOR
            = new Parcelable.Creator<Figure>() {
        public Figure createFromParcel(Parcel in) {
            return new Figure(in);
        }

        public Figure[] newArray(int size) {
            return new Figure[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(imageId);
        dest.writeString(description);
    }

    @Override
    public TextView inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        TextView figure = super.inflate(inflater, root, attachToRoot);
        figure.setText(description);
        figure.getViewTreeObserver().addOnGlobalLayoutListener(() -> {
            Drawable image = ResourcesCompat.getDrawable(root.getResources(), imageId, null);
            assert image != null;
            double ratio = (double) image.getIntrinsicHeight() / image.getIntrinsicWidth();
            int measuredWidth = figure.getMeasuredWidth();
            image.setBounds(0, 0, measuredWidth, Math.toIntExact(Math.round(measuredWidth * ratio)));
            figure.setCompoundDrawables(null, image, null, null);
        });
        return figure;
    }
}
