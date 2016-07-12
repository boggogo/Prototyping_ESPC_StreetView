package xdesign.georgi.prototyping_espc_streetview.UI.fragments;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.skyfishjy.library.RippleBackground;

import xdesign.georgi.prototyping_espc_streetview.R;
import xdesign.georgi.prototyping_espc_streetview.Utils.RadiusAnimation;

/**
 * Created by georgi on 11/07/16.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {
    private static final String TAG = MapFragment.class.getSimpleName();
    private GoogleMap mMap;
    private SupportMapFragment mapFragment;
    private LatLng xDesign = new LatLng(55.959509, -3.200501);
    private Marker mXDesignMarker;
    private Bitmap mDotMarkerBitmap;
    private MarkerOptions markerOptions;
    private RippleBackground rippleBackground;
    private GroundOverlay groundOverlay;
    private RadiusAnimation groundAnimation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.map_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rippleBackground = new RippleBackground(getContext());
        rippleBackground.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.pulseMarker1));

        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    //55.959814, -3.200565
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

//        mDotMarkerBitmap = generateBitmapFromDrawable(R.drawable.circle_drawable);
//        markerOptions = new MarkerOptions()
//                .position(xDesign)
//                .title("xDesign in Edinburgh")
//                .icon(BitmapDescriptorFactory.fromBitmap(mDotMarkerBitmap));
//        mXDesignMarker = mMap.addMarker(markerOptions);



//Adding a comment
//Add biggest image drawable overlay

        mDotMarkerBitmap = generateBitmapFromDrawable(R.drawable.circle_drawable3);

        groundOverlay = mMap.addGroundOverlay(new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromBitmap(mDotMarkerBitmap))
                .position(xDesign, 100));
        groundAnimation = new RadiusAnimation(groundOverlay);
        groundAnimation.setRepeatCount(Animation.INFINITE);
        groundAnimation.setRepeatMode(Animation.RESTART);
        groundAnimation.setDuration(900);
        mapFragment.getView().startAnimation(groundAnimation); // MapView where i show my map
//TODO  Fix the animation tomorrow
//Add medium size image drawable overlay
//        mDotMarkerBitmap = generateBitmapFromDrawable(R.drawable.circle_drawable2);
//        groundOverlay = mMap.addGroundOverlay(new GroundOverlayOptions()
//                .image(BitmapDescriptorFactory.fromBitmap(mDotMarkerBitmap))
//                .position(xDesign, 100));
//        groundAnimation = new RadiusAnimation(groundOverlay);
//        groundAnimation.setRepeatCount(Animation.INFINITE);
//        groundAnimation.setRepeatMode(Animation.RESTART);
//        groundAnimation.setDuration(1400);
//        mapFragment.getView().startAnimation(groundAnimation); // MapView where i show my map
//
////Add smallest size image drawable overlay
//
//        mDotMarkerBitmap = generateBitmapFromDrawable(R.drawable.circle_drawable);
//        groundOverlay = mMap.addGroundOverlay(new GroundOverlayOptions()
//                .image(BitmapDescriptorFactory.fromBitmap(mDotMarkerBitmap))
//                .position(xDesign, 100));
//        groundAnimation = new RadiusAnimation(groundOverlay);
//        groundAnimation.setRepeatCount(Animation.INFINITE);
//        groundAnimation.setRepeatMode(Animation.RESTART);
//        groundAnimation.setDuration(2000);
//        mapFragment.getView().startAnimation(groundAnimation); // MapView where i show my map
//        //   Icons dont have animate method     icon.setAnimation(animation);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(xDesign, 15));
    }

    private void LogThis(String message) {
        Log.d(TAG, message);
    }

    @NonNull
    private Bitmap generateBitmapFromDrawable(int drawablesRes) {
        int px = getResources().getDimensionPixelSize(R.dimen.map_dot_marker_size);
        Bitmap mDotMarkerBitmap = Bitmap.createBitmap(px, px, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(mDotMarkerBitmap);
        Drawable shape = getResources().getDrawable(drawablesRes);
        shape.setBounds(0, 0, mDotMarkerBitmap.getWidth(), mDotMarkerBitmap.getHeight());
        shape.draw(canvas);
        return mDotMarkerBitmap;
    }


}
