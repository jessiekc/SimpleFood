package com.cityscholar.cs465.simplefood.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cityscholar.cs465.simplefood.R;

public class DetailText extends Inflatable<TextView> {
    @LayoutRes
    private static final int LAYOUT = R.layout.item_detail_text;

    private final String content;

    public DetailText(String content) {
        super(LAYOUT);
        this.content = content;
    }

    DetailText(Parcel in) {
        super(in);
        content = in.readString();
    }

    public static final Parcelable.Creator<DetailText> CREATOR
            = new Parcelable.Creator<DetailText>() {
        public DetailText createFromParcel(Parcel in) {
            return new DetailText(in);
        }

        public DetailText[] newArray(int size) {
            return new DetailText[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(content);
    }

    @Override
    public TextView inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        TextView textView = super.inflate(inflater, root, attachToRoot);
        textView.setText(content);
        return textView;
    }
}
