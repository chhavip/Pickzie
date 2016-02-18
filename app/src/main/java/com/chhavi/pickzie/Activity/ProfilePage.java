package com.chhavi.pickzie.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.chhavi.pickzie.Fragment.ProfilePagePicture;
import com.chhavi.pickzie.Fragment.ProfilePagePlaces;
import com.chhavi.pickzie.Fragment.ProfilePageReview;
import com.chhavi.pickzie.Helper.GradientOverImageDrawable;
import com.chhavi.pickzie.R;

public class ProfilePage extends AppCompatActivity implements View.OnClickListener {

    ImageView imageViewBackgroundDP, imageViewPlaces, imageViewPictures, imageViewReview; // imageViewPeople,
    int selectedImage=1;
    Toolbar toolbar;
    ProfilePagePicture picture;
    ProfilePagePlaces places;
    ProfilePageReview review;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        imageViewBackgroundDP = (ImageView) findViewById(R.id.imageView_profilePage_backgroundDP);
//        imageViewPeople = (ImageView) findViewById(R.id.imageView_profilePage_people);
        imageViewPlaces = (ImageView) findViewById(R.id.imageView_profilePage_place);
        imageViewPictures = (ImageView) findViewById(R.id.imageView_profilePage_pictures);
        imageViewReview = (ImageView) findViewById(R.id.imageView_profilePage_review);
        findViewById(R.id.profilepage_profile).setOnClickListener(this);

        imageViewPlaces.setBackgroundResource(R.color.colorAccentDark);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

         //enabling toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Drawable dr = getResources().getDrawable(R.drawable.home);
        Bitmap bitmapToolbar = ((BitmapDrawable) dr).getBitmap();
        Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapToolbar, 35, 35, true));
        getSupportActionBar().setLogo(d);
        //

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dp);
        int startColor = Color.argb(170,0, 0, 0);
        int endColor =Color.argb(200, 0, 0, 0);
        GradientOverImageDrawable gradientOverImageDrawable = new GradientOverImageDrawable(getResources(), bitmap);
        gradientOverImageDrawable.setGradientStart(0);
        gradientOverImageDrawable.setGradientEnd(1);
        gradientOverImageDrawable.setGradientColors(startColor, endColor);
        imageViewBackgroundDP.setImageDrawable(gradientOverImageDrawable);

        places = new ProfilePagePlaces();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout_profile_page, places);
        fragmentTransaction.commit();

        ViewListener();
    }

    private void ViewListener(){
        imageViewPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBGtoNormal(selectedImage);
                selectedImage=1;
                places = new ProfilePagePlaces();
                imageViewPlaces.setBackgroundResource(R.color.colorAccentDark);
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framelayout_profile_page, places);
                fragmentTransaction.commit();
            }
        });

        imageViewPictures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBGtoNormal(selectedImage);
                selectedImage=2;
                picture = new ProfilePagePicture();
                imageViewPictures.setBackgroundResource(R.color.colorAccentDark);
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framelayout_profile_page, picture);
                fragmentTransaction.commit();
            }
        });

        imageViewReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBGtoNormal(selectedImage);
                selectedImage=3;
                review = new ProfilePageReview();
                imageViewReview.setBackgroundResource(R.color.colorAccentDark);
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framelayout_profile_page, review);
                fragmentTransaction.commit();
            }
        });
    }

    private void changeBGtoNormal(int selected){
        switch (selected){
            case 1:
                imageViewPlaces.setBackgroundResource(R.color.colorAccent);
                break;
            case 2:
                imageViewPictures.setBackgroundResource(R.color.colorAccent);
                break;
            case 3:
                imageViewReview.setBackgroundResource(R.color.colorAccent);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.v("MyApp", getClass().toString() + " onCreateOptionsMenu");
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_profile_page, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.v("MyApp", getClass().toString() + " onOptionsItemSelected");
        switch (item.getItemId()){
            case R.id.action_settings:
                Intent intent = new Intent(ProfilePage.this, UserSettings.class);
                startActivity(intent);
                break;
            default: Toast.makeText(getApplicationContext(),"Wrong Item Selected", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if( v.equals(imageViewPlaces)){
            imageViewPlaces.setBackgroundResource(R.color.colorAccentDark);
            changeBGtoNormal(selectedImage);
            selectedImage=1;
            //code to show recent places
        } else if ( v.equals(imageViewPictures)){
            imageViewPictures.setBackgroundResource(R.color.colorAccentDark);
            changeBGtoNormal(selectedImage);
            selectedImage=2;
            //code to show pictures
        } else if ( v.equals(imageViewReview)) {
            imageViewReview.setBackgroundResource(R.color.colorAccentDark);
            changeBGtoNormal(selectedImage);
            selectedImage=3;
            //code to show reviews
        }

        switch(v.getId()){
            case R.id.profilepage_profile:
        }

    }
}
