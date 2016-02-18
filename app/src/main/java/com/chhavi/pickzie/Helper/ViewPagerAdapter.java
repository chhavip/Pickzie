package com.chhavi.pickzie.Helper;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chhavi.pickzie.R;

/**
 * Created by Mukesh on 1/28/2016.
 */
public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    Drawable imageArray[];
    int layout;
    String textDesc[];

    public ViewPagerAdapter (Context vContext, int vLayout, Drawable[] vImageArray, String[] vTextDesc ){
        Log.v("MyApp", getClass().toString());
        layout = vLayout;
        imageArray = vImageArray;
        context = vContext;
        textDesc = vTextDesc;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        Log.v("MyApp", getClass().toString()+ "just next");
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(layout, collection, false );
        ImageView imageView = (ImageView) view.findViewById(R.id.viewpager_imageView);
        TextView textView = (TextView) view.findViewById(R.id.viewpager_textDesc);
        imageView.setImageDrawable(imageArray[position]);
        textView.setText(textDesc[position]);
        collection.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
//        super.destroyItem(container, position, object);
    }

    @Override
    public Parcelable saveState() {
        return super.saveState();
    }

    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==((View)object);
    }
}
