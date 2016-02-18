package com.chhavi.pickzie.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.chhavi.pickzie.Helper.HomeViewPager;
import com.chhavi.pickzie.R;

public class HomePage extends Activity implements View.OnClickListener {

    ViewPager viewPager;
    HomeViewPager adapterHomeViewPager;
    ImageView imageViewUserProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        viewPager= (ViewPager) findViewById(R.id.view_pager_home);
        adapterHomeViewPager = new HomeViewPager(this);
        viewPager.setAdapter(adapterHomeViewPager);

        findViewById(R.id.home_linear_salon).setOnClickListener(this);
        findViewById(R.id.home_linear_spa).setOnClickListener(this);
        findViewById(R.id.homepage_userprofile).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.home_linear_salon:
                intent = new Intent(HomePage.this, Search.class);
                startActivity(intent);
                break;
            case R.id.home_linear_spa:
                intent = new Intent(HomePage.this, Search.class);
                startActivity(intent);
                break;
            case R.id.homepage_userprofile:
                intent = new Intent(HomePage.this, ProfilePage.class);
                startActivity(intent);
                break;
        }
    }
}
