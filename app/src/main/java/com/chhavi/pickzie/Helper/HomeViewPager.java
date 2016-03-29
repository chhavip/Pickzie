package com.chhavi.pickzie.Helper;

/**
 * Created by Mukesh on 2/12/2016.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chhavi.pickzie.R;

public class HomeViewPager extends PagerAdapter {
    private int[] imaage_resources = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d, R.drawable.e};
    private String[] n={"LOOKS","HABIB","ABC","ASD","IIU"};
    private Context ctx;
    private LayoutInflater layoutinflator;

    public HomeViewPager(Context ctx){

        this.ctx= ctx;
    }
    @Override
    public int getCount() {
        return imaage_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return (view== (FrameLayout)o);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutinflator= (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutinflator.inflate(R.layout.home_swipe_layout,container,false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.image_view);
        TextView textview = (TextView) item_view.findViewById(R.id.myImageViewText);

        Bitmap bitmap = BitmapFactory.decodeResource(ctx.getResources(), imaage_resources[position]);

        int startColor = Color.argb(0, 0, 0, 0);
        int endColor = Color.argb(255, 189, 54, 65);
        GradientOverImageDrawable gradientOverImageDrawable = new GradientOverImageDrawable(ctx.getResources(), bitmap);
        gradientOverImageDrawable.setGradientColors(startColor, endColor);
        gradientOverImageDrawable.setGradientStart(0.5);
        gradientOverImageDrawable.setGradientEnd(1.0);
        imageView.setImageDrawable(gradientOverImageDrawable);

        textview.setText(n[position]);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((FrameLayout)object);
    }
}