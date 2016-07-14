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
    //    private GroundOverlay groundOverlay;
    private RadiusAnimation groundAnimation;
    private AnimationSet breadingAnimations;

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

        breadingAnimations = new AnimationSet(false);
//        breadingAnimations.setRepeatCount(Animation.INFINITE);
//        breadingAnimations.setRepeatMode(Animation.RESTART);
//        breadingAnimations.setStartOffset(500);


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


//Add smallest image drawable overlay

        Bitmap mDotMarkerBitmap1 = generateBitmapFromDrawable(R.drawable.circle_drawable);

        GroundOverlay groundOverlay1 = mMap.addGroundOverlay(new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromBitmap(mDotMarkerBitmap1))
                .position(xDesign, 80));

        groundAnimation = new RadiusAnimation(groundOverlay1);
        groundAnimation.setRepeatCount(Animation.INFINITE);
        groundAnimation.setRepeatMode(Animation.RESTART);
        groundAnimation.setDuration(1200);
//        groundAnimation.setStartOffset(700);
        breadingAnimations.addAnimation(groundAnimation);


        Bitmap mDotMarkerBitmap2 = generateBitmapFromDrawable(R.drawable.circle_drawable2);
        GroundOverlay groundOverlay2 = mMap.addGroundOverlay(new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromBitmap(mDotMarkerBitmap2))
                .position(xDesign, 200));

        Animation groundAnimation2 = new RadiusAnimation(groundOverlay2);
        groundAnimation2.setRepeatCount(Animation.INFINITE);
        groundAnimation2.setRepeatMode(Animation.RESTART);
        groundAnimation2.setDuration(2000);
//        groundAnimation2.setStartOffset(1500);
        breadingAnimations.addAnimation(groundAnimation2);


        Bitmap mDotMarkerBitmap3 = generateBitmapFromDrawable(R.drawable.circle_drawable3);
        GroundOverlay groundOverlay3 = mMap.addGroundOverlay(new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromBitmap(mDotMarkerBitmap3))
                .position(xDesign, 300));

        Animation groundAnimation3 = new RadiusAnimation(groundOverlay3);
        groundAnimation3.setRepeatCount(Animation.INFINITE);
        groundAnimation3.setRepeatMode(Animation.RESTART);
//        groundAnimation3.setStartOffset(500);
        groundAnimation3.setDuration(3000);

        breadingAnimations.addAnimation(groundAnimation3);

        mapFragment.getView().startAnimation(breadingAnimations); // start animation


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(xDesign, 15));
    }

    private void logThis(String message) {
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
