package xdesign.georgi.prototyping_espc_streetview.fragments;


import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.renderscript.Double2;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.skyfishjy.library.RippleBackground;

import xdesign.georgi.prototyping_espc_streetview.R;

/**
 * Created by georgi on 11/07/16.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    private SupportMapFragment mapFragment;
    private LatLng xDesign = new LatLng(55.959509, -3.200501);
    private Marker mxDesignMarker;
    private Bitmap mDotMarkerBitmap;
    private MarkerOptions markerOptions;
    private final Handler handler = new Handler();
    private final long startTime = SystemClock.uptimeMillis();
    private final long duration = 2000;
    private RippleBackground rippleBackground;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rippleBackground = new RippleBackground(getContext());
        rippleBackground.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.pulseMarker));

        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.map_fragment_layout, container, false);
    }

    //55.959814, -3.200565
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mDotMarkerBitmap = generateBitmapFromDrawable();
        markerOptions = new MarkerOptions()
                .position(xDesign)
                .title("xDesign in Edinburgh")
                .icon(BitmapDescriptorFactory.fromBitmap(mDotMarkerBitmap));
        mxDesignMarker = mMap.addMarker(markerOptions);
//       mxDesignMarker.remove();

//        rippleBackground.addView(mxDesignMarker);


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(xDesign, 15));
    }

    @NonNull
    private Bitmap generateBitmapFromDrawable() {
        int px = getResources().getDimensionPixelSize(R.dimen.map_dot_marker_size);
        Bitmap mDotMarkerBitmap = Bitmap.createBitmap(px, px, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(mDotMarkerBitmap);
        Drawable shape = getResources().getDrawable(R.drawable.circle_drawable);
        shape.setBounds(0, 0, mDotMarkerBitmap.getWidth(), mDotMarkerBitmap.getHeight());
        shape.draw(canvas);
        return mDotMarkerBitmap;
    }

//    public void startPulseAnimation(){
//        final Circle circle = mMap.addCircle(new CircleOptions().center(xDesign)
//                .strokeWidth(30f)
//                .strokeColor(ContextCompat.getColor(getContext(),R.color.pulseMarker)).radius(100));
//
//        ValueAnimator vAnimator = new ValueAnimator();
//        vAnimator.setRepeatCount(ValueAnimator.INFINITE);
//        vAnimator.setRepeatMode(ValueAnimator.RESTART);  /* PULSE */
//        vAnimator.setIntValues(0, 100);
//        vAnimator.setDuration(2000);
//        vAnimator.setEvaluator(new IntEvaluator());
//        vAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
//        vAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                float animatedFraction = valueAnimator.getAnimatedFraction();
//                // Log.e("", "" + animatedFraction);
//                circle.setRadius(animatedFraction * 70);
//            }
//        });
//        vAnimator.start();
//    }

}
