package com.chhavi.pickzie.Fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chhavi.pickzie.Helper.GradientOverImageDrawable;
import com.chhavi.pickzie.Helper.ViewPagerAdapter;
import com.chhavi.pickzie.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginPage extends Fragment implements View.OnClickListener{


    public LoginPage() {
        // Required empty public constructor
    }


    ImageView imageViewBG;
    ViewPager viewPager;
    LoginSelectSignup loginSelectSignup;
    LoginSelectLogin loginSelectLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_page, container, false);

        imageViewBG = (ImageView) view.findViewById(R.id.login_page_bg);

        view.findViewById(R.id.login_page_button_login).setOnClickListener(this);
        view.findViewById(R.id.login_page_button_signup).setOnClickListener(this);

        Bitmap bitmapBG = BitmapFactory.decodeResource(getResources(), R.drawable.login_bg);
        int startColor = Color.argb(170, 0, 0, 0);
        int endColor =Color.argb(170, 0, 0, 0);
        GradientOverImageDrawable gradientOverImageDrawableBG = new GradientOverImageDrawable(getResources(), bitmapBG);
        gradientOverImageDrawableBG.setGradientColors(startColor, endColor);
        imageViewBG.setImageDrawable(gradientOverImageDrawableBG);

//        viewPager = (ViewPager) view.findViewById(R.id.login_page_viewpager);
//
//        startColor = Color.argb(0, 0, 0, 0);
//        endColor =Color.argb(255, 0, 0, 0);
//        List<Drawable> drawableList = new ArrayList<>();
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.spa1);
//        GradientOverImageDrawable gradientOverImageDrawable = new GradientOverImageDrawable(getResources(), bitmap);
//        gradientOverImageDrawable.setGradientColors(startColor, endColor);
//        gradientOverImageDrawable.setGradientStart(0.5d);
//        gradientOverImageDrawable.setGradientEnd(1d);
//        drawableList.add(gradientOverImageDrawable);
//
//        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.spa3);
//        gradientOverImageDrawable = new GradientOverImageDrawable(getResources(), bitmap);
//        gradientOverImageDrawable.setGradientColors(startColor, endColor);
//        gradientOverImageDrawable.setGradientStart(0.5d);
//        gradientOverImageDrawable.setGradientEnd(1d);
//        drawableList.add(gradientOverImageDrawable);
//
//        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.spa4);
//        gradientOverImageDrawable = new GradientOverImageDrawable(getResources(), bitmap);
//        gradientOverImageDrawable.setGradientColors(startColor, endColor);
//        gradientOverImageDrawable.setGradientStart(0.5d);
//        gradientOverImageDrawable.setGradientEnd(1d);
//        drawableList.add(gradientOverImageDrawable);
//
//        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.spa5);
//        gradientOverImageDrawable = new GradientOverImageDrawable(getResources(), bitmap);
//        gradientOverImageDrawable.setGradientColors(startColor, endColor);
//        gradientOverImageDrawable.setGradientStart(0.5d);
//        gradientOverImageDrawable.setGradientEnd(1d);
//        drawableList.add(gradientOverImageDrawable);
//
//        String text[] = {"Book a Saloon", "Take a photo", "Write a Review", "Rate Saloon"};
//        ViewPagerAdapter adapter = new ViewPagerAdapter(getContext(), R.layout.frame_viewpager_login,
//                drawableList.toArray(new Drawable[drawableList.size()] ), text );
//
//        viewPager.setAdapter(adapter);
//        viewPager.setCurrentItem(0);

        return view;
    }


    @Override
    public void onClick(View v) {
        android.support.v4.app.FragmentTransaction fragmentTransaction;
        switch ( v.getId()){
            case R.id.login_page_button_login:
                loginSelectLogin = new LoginSelectLogin();
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.framelayout_login, loginSelectLogin);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.login_page_button_signup:
                loginSelectSignup = new LoginSelectSignup();
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.framelayout_login, loginSelectSignup);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
        }
    }
}
