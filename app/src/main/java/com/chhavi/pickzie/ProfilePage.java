package com.chhavi.pickzie;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.chhavi.pickzie.Helper.GradientOverImageDrawable;

public class ProfilePage extends AppCompatActivity {

    ImageView imageViewBackgroundDP, imageViewPeople, imageViewPlaces, imageViewPictures, imageViewReview;
    int selectedImage=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        imageViewBackgroundDP = (ImageView) findViewById(R.id.imageView_profilePage_backgroundDP);
        imageViewPeople = (ImageView) findViewById(R.id.imageView_profilePage_people);
        imageViewPlaces = (ImageView) findViewById(R.id.imageView_profilePage_place);
        imageViewPictures = (ImageView) findViewById(R.id.imageView_profilePage_pictures);
        imageViewReview = (ImageView) findViewById(R.id.imageView_profilePage_review);

        imageViewPeople.setBackgroundResource(R.color.colorAccentDark);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dp);
        int startColor = Color.argb(170,0, 0, 0);
        int endColor =Color.argb(200, 0, 0, 0);
        GradientOverImageDrawable gradientOverImageDrawable = new GradientOverImageDrawable(getResources(), bitmap);
        gradientOverImageDrawable.setGradientStart(0);
        gradientOverImageDrawable.setGradientEnd(1);
        gradientOverImageDrawable.setGradientColors(startColor, endColor);
        imageViewBackgroundDP.setImageDrawable(gradientOverImageDrawable);
        imageListener();
    }

    private void imageListener(){
        imageViewPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageViewPeople.setBackgroundResource(R.color.colorAccentDark);
                changeBGtoNormal(selectedImage);
                selectedImage=0;
                //code to show followers feed
            }
        });

        imageViewPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageViewPlaces.setBackgroundResource(R.color.colorAccentDark);
                changeBGtoNormal(selectedImage);
                selectedImage=1;
                //code to show recent places
            }
        });

        imageViewPictures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageViewPictures.setBackgroundResource(R.color.colorAccentDark);
                changeBGtoNormal(selectedImage);
                selectedImage=2;
                //code to show pictures
            }
        });

        imageViewReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageViewReview.setBackgroundResource(R.color.colorAccentDark);
                changeBGtoNormal(selectedImage);
                selectedImage=3;
                //code to show reviews
            }
        });


    }
    private void changeBGtoNormal(int selected){
        switch (selected){
            case 0:
                imageViewPeople.setBackgroundResource(R.color.colorAccent);
                break;
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
}
