package com.cityscholar.cs465.simplefood;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<SummaryViewHolder> {

    List<Restaurant> list = Collections.emptyList();
    Context context;

    public RecyclerViewAdapter(List<Restaurant> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public SummaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.summary_view_row_layout, parent, false);
        SummaryViewHolder holder = new SummaryViewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(SummaryViewHolder holder, int position) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.title.setText(list.get(position).getName());
        final SparseArray<Highlight> highlights = list.get(position).getHighlights();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < highlights.size(); i++) {
            builder.append(highlights.valueAt(i).content).append(" ");
        }
        holder.description.setText(builder.toString().trim());
        holder.imageView.setImageResource(list.get(position).getCover().getId());
        holder.checkButton.setOnClickListener(v -> {
            Uri gmmIntentUri = Uri.parse("geo:0,0?q="+list.get(position).getLocation());
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            v.getContext().startActivity(mapIntent);
        });
        holder.crossButton.setOnClickListener(v -> {
            ExampleRestaurants.remove(position);
            RecyclerViewAdapter.this.notifyDataSetChanged();
            Intent intent = new Intent();
            intent.putExtra("dismissed", true);
            ((Activity) v.getContext()).setResult(Activity.RESULT_OK, intent);
        });
    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

//    // Insert a new item to the RecyclerView on a predefined position
//    public void insert(int position, SummaryListData data) {
//        list.add(position, data);
//        notifyItemInserted(position);
//    }
//
//    // Remove a RecyclerView item containing a specified Data object
//    public void remove(SummaryListData data) {
//        int position = list.indexOf(data);
//        list.remove(position);
//        notifyItemRemoved(position);
//    }

}
