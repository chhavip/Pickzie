package com.chhavi.pickzie.Activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.chhavi.pickzie.Helper.HomeViewPager;
import com.chhavi.pickzie.R;
import com.cocosw.bottomsheet.BottomSheet;

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
        findViewById(R.id.homepage_plus).setOnClickListener(this);

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
            case R.id.homepage_plus:
                Log.v("MyApp", "Plus button");
                new BottomSheet.Builder(this, R.style.BottomSheet_StyleDialog).title("Add Now").sheet(R.menu.plus_bottomsheet)
                    .listener(new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case R.id.bs_book:
                                    Toast.makeText(getApplicationContext(),"Book an Appointment", Toast.LENGTH_SHORT).show();
                                    break;
                                case R.id.bs_check:
                                    Toast.makeText(getApplicationContext(),"Check In", Toast.LENGTH_SHORT).show();
                                    break;
                                case R.id.bs_write:
                                    Toast.makeText(getApplicationContext(),"Write a Review", Toast.LENGTH_SHORT).show();
                                    break;
                                case R.id.bs_upload:
                                    Toast.makeText(getApplicationContext(),"Upload a Photo", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
                    }).show();
                break;
        }
    }
}
