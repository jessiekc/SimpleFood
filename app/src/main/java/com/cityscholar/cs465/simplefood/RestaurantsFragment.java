package com.cityscholar.cs465.simplefood;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.cityscholar.cs465.simplefood.content.Inflatable;

import java.util.Arrays;
import java.util.List;
import java.util.PrimitiveIterator;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RestaurantsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RestaurantsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RestaurantsFragment extends Fragment {
    private static final String TAG = RestaurantsFragment.class.getSimpleName();
    private static final String RESTAURANT = "restaurant";

    private Restaurant restaurant;

    private OnFragmentInteractionListener mListener;
    private SharedPreferences preferences;
    private boolean seen = false;

    private Long latestVisible = null;

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param restaurant restaurants to be displayed
     * @return A new instance of fragment RestaurantsFragment.
     */
    public static RestaurantsFragment newInstance(Restaurant restaurant) {
        RestaurantsFragment fragment = new RestaurantsFragment();
        Bundle args = new Bundle();
        Log.d(TAG, "Restaurant created" + restaurant.toString());
        args.putParcelable(RESTAURANT, restaurant);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setUserVisibleHint(false);
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            restaurant = getArguments().getParcelable(RESTAURANT);
            Log.d(TAG, "Get Parcelable: " + restaurant.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_restaurants, container, false);
        LinearLayout contentContainer = root.findViewById(R.id.content);
        contentContainer.<TextView>findViewById(R.id.titleRestaurant).setText(restaurant.getName());
        contentContainer.addView(restaurant.getCover().inflate(inflater, contentContainer, false), 1);

        preferences = container.getContext().getSharedPreferences(FilterActivity.PREFS, Context.MODE_PRIVATE);
        final String orderStr = preferences.getString("order", "filter1, filter2, filter3, filter4");
        SparseArray<Highlight> highlights = restaurant.getHighlights();
        Arrays.stream(orderStr.split(",", 5))
                .map(String::trim)
                .peek(s -> Log.d(TAG, "onCreateView get filter: " + s))
                .mapToInt(s -> Character.getNumericValue(s.charAt("filter".length())))
                .forEach(i -> {
                    TextView highlight = (TextView) inflater.inflate(R.layout.item_highlight, contentContainer, false);
                    Log.d(TAG, "Convert String to value: " + i);
                    highlight.setText(highlights.get(i).content);
                    contentContainer.addView(highlight, contentContainer.getChildCount() - 1);
                });
        for (Inflatable detail : restaurant.getDetails()) {
            contentContainer.addView(detail.inflate(inflater, contentContainer, false), contentContainer.getChildCount());
        }

        root.<Button>findViewById(R.id.buttonCheck).setOnClickListener(v -> {
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=1600 Amphitheatre Parkway, Mountain+View, California");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });
        root.<Button>findViewById(R.id.buttonCross).setOnClickListener(v -> onButtonPressed());

        root.<ImageView>findViewById(R.id.moreContent).setVisibility(View.VISIBLE);
        root.<ScrollView>findViewById(R.id.scrollView).setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            root.<ImageView>findViewById(R.id.moreContent).setVisibility(View.GONE);
            v.setOnScrollChangeListener(null);
        });
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        final String orderStr = preferences.getString("order", "filter1, filter2, filter3, filter4");
        SparseArray<Highlight> highlights = restaurant.getHighlights();
        LinearLayout contentContainer = getView().findViewById(R.id.content);
        final PrimitiveIterator.OfInt iterator = Arrays.stream(orderStr.split(",", 5))
                .map(String::trim)
                .peek(s -> Log.d(TAG, "onResume get filter: " + s))
                .mapToInt(s -> Character.getNumericValue(s.charAt("filter".length())))
                .iterator();
        for (int i = 3; i < 3 + 4 && iterator.hasNext(); i++) {
            TextView v = (TextView) contentContainer.getChildAt(i);
            v.setText(highlights.get(iterator.nextInt()).content);
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed() {
        if (mListener != null) {
            mListener.onFragmentInteraction(this, System.nanoTime() - latestVisible);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            seen = true;
            latestVisible = System.nanoTime();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            Log.w(TAG, "OnFragmentInteractionListener not available.");
            //throw new RuntimeException(context.toString()
            //        + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Fragment fragment, long duration);
    }

    public boolean isSeen() {
        return seen;
    }
}
