package xdesign.georgi.prototyping_espc_streetview.UI.fragments;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import me.relex.circleindicator.CircleIndicator;
import xdesign.georgi.prototyping_espc_streetview.R;
import xdesign.georgi.prototyping_espc_streetview.adapters.GalleryAdapter;


/**
 * Created by georgi on 11/07/16.
 */
public class PhotosFragment extends Fragment {
    private GalleryAdapter mGalleryAdapter;
    private ViewPager mGallery;
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

        mGalleryAdapter = new GalleryAdapter(getContext());
        mGallery = (ViewPager) view.findViewById(R.id.galleryViewPager);

        mGallery.setAdapter(mGalleryAdapter);
        CircleIndicator indicator = (CircleIndicator) view.findViewById(R.id.indicator);


        indicator.setViewPager(mGallery);


    }
}
