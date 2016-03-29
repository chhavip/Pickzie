package com.chhavi.pickzie.Activity;

import android.app.Activity;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.chhavi.pickzie.Helper.HomeViewPager;
import com.chhavi.pickzie.R;
import com.cocosw.bottomsheet.BottomSheet;

public class HomePage extends AppCompatActivity implements View.OnClickListener {

    ViewPager viewPager;
    HomeViewPager adapterHomeViewPager;
    Toolbar toolbar;
    ImageView Home, Plus, Profile;

    Drawable dr, d;
    Bitmap bitmapToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        //enabling toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        viewPager= (ViewPager) findViewById(R.id.view_pager_home);
        adapterHomeViewPager = new HomeViewPager(this);
        viewPager.setAdapter(adapterHomeViewPager);

        Home = (ImageView) findViewById(R.id.homepage_home);
        Plus = (ImageView) findViewById(R.id.homepage_plus);
        Profile = (ImageView) findViewById(R.id.homepage_userprofile);

        findViewById(R.id.home_linear_salon).setOnClickListener(this);
        findViewById(R.id.home_linear_spa).setOnClickListener(this);
        Profile.setOnClickListener(this);
        Home.setOnClickListener(this);
        Plus.setOnClickListener(this);

        dr = getResources().getDrawable(R.drawable.home);
        bitmapToolbar = ((BitmapDrawable) dr).getBitmap();
        d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapToolbar, 50, 50, true));
        Home.setImageDrawable(d);

        dr = getResources().getDrawable(R.drawable.plus);
        bitmapToolbar = ((BitmapDrawable) dr).getBitmap();
        d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapToolbar, 50, 50, true));
        Plus.setImageDrawable(d);

        dr = getResources().getDrawable(R.drawable.ic_account_circle_white_36dp);
        bitmapToolbar = ((BitmapDrawable) dr).getBitmap();
        d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapToolbar, 55, 55, true));
        Profile.setImageDrawable(d);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.v("MyApp", getClass().toString() + " onCreateOptionsMenu");
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_home_page, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        SearchView searchView = (android.widget.SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));;
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        if(searchView==null){
            Log.v("MyApp", "SearchView Null");
        } if(searchManager==null){
            Log.v("MyApp", "SearchManager Null");
        } else {
            Log.v("MyApp", "else");
            searchView.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(getApplicationContext(), Search.class)));
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.v("MyApp", getClass().toString() + " onOptionsItemSelected");
        Intent intent;
        switch (item.getItemId()){
            case R.id.action_search:
//                intent = new Intent(HomePage.this, Search.class);
//                startActivity(intent);
                
                break;
            default: Toast.makeText(getApplicationContext(), "Wrong Item Selected", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

}
