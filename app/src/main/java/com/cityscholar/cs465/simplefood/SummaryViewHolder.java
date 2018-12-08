package com.cityscholar.cs465.simplefood;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SummaryViewHolder extends RecyclerView.ViewHolder {

    final ImageButton crossButton;
    final ImageButton checkButton;
    CardView cv;
    TextView title;
    TextView description;
    ImageView imageView;

    SummaryViewHolder(View itemView) {
        super(itemView);
        cv = itemView.findViewById(R.id.cardView);
        title = itemView.findViewById(R.id.title);
        description = itemView.findViewById(R.id.description);
        imageView = itemView.findViewById(R.id.imageView);
        crossButton = itemView.findViewById(R.id.buttonCross);
        checkButton = itemView.findViewById(R.id.buttonCheck);
    }
}
