package xdesign.georgi.prototyping_espc_streetview.fragments;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.roughike.swipeselector.SwipeSelector;

import xdesign.georgi.prototyping_espc_streetview.R;


/**
 * Created by georgi on 11/07/16.
 */
public class PhotosFragment extends Fragment {
    private SwipeSelector mSwipeSelector;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return inflater.inflate(R.layout.photos_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView kitchenImage = new ImageView(getContext());
        kitchenImage.setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.kitchen1));

        ImageView bedroomImage = new ImageView(getContext());
        bedroomImage.setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.bedroom));

        ImageView livingRoomImage = new ImageView(getContext());
        livingRoomImage.setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.living_room));

        mSwipeSelector = (SwipeSelector)view.findViewById(R.id.swipeSelector);
        mSwipeSelector.addView(kitchenImage,0);
        mSwipeSelector.addView(bedroomImage,1);
        mSwipeSelector.addView(livingRoomImage,2);




    }
}
