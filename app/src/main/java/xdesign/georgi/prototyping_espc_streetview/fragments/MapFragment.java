package xdesign.georgi.prototyping_espc_streetview.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xdesign.georgi.prototyping_espc_streetview.R;

/**
 * Created by georgi on 11/07/16.
 */
public class MapFragment extends Fragment {
    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return inflater.inflate(R.layout.map_fragment_layout, container, false);
    }
}
