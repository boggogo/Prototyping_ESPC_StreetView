package xdesign.georgi.prototyping_espc_streetview.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import xdesign.georgi.prototyping_espc_streetview.R;

/**
 * Created by georgi on 12/07/16.
 */
public class GalleryAdapter extends PagerAdapter {
    private Context mContext;
    private int[] galleryImages = new int[]{
            R.drawable.kitchen,
            R.drawable.bedroom,
            R.drawable.living_room
    };


    public GalleryAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return galleryImages.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView image = new ImageView(mContext);
        image.setImageDrawable(ContextCompat.getDrawable(mContext,galleryImages[position]));

        container.addView(image,0);
        return image;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView)object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
