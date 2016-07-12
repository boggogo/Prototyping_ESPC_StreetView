package xdesign.georgi.prototyping_espc_streetview.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import xdesign.georgi.prototyping_espc_streetview.UI.fragments.MapFragment;
import xdesign.georgi.prototyping_espc_streetview.UI.fragments.PhotosFragment;
import xdesign.georgi.prototyping_espc_streetview.UI.fragments.StreetViewFragment;

/**
 * Created by georgi on 11/07/16.
 */
public class ESPCFragmentPageAdapter extends FragmentPagerAdapter {

    //integer to count number of tabs
    int tabCount;

    public ESPCFragmentPageAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                PhotosFragment tab1 = new PhotosFragment();
                return tab1;
            case 1:
                MapFragment tab2 = new MapFragment();
                return tab2;
            case 2:
                StreetViewFragment tab3 = new StreetViewFragment();
                return tab3;
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return tabCount;
    }
}
