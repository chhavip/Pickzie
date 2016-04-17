package com.chhavi.pickzie.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.ContactsContract;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
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
import com.cocosw.bottomsheet.BottomSheet;

public class ProfilePage extends AppCompatActivity implements View.OnClickListener {

    ImageView imageViewBackgroundDP;
    Toolbar toolbar;
    ProfilePagePicture picture;
    ProfilePagePlaces places;
    ProfilePageReview review;
    ImageView Home, Plus, Profile;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        imageViewBackgroundDP = (ImageView) findViewById(R.id.imageView_profilePage_backgroundDP);
        findViewById(R.id.profilepage_profile).setOnClickListener(this);

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
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.viewPager_profile);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.profile_tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.place);
        tabLayout.getTabAt(1).setIcon(R.drawable.picture);
        tabLayout.getTabAt(2).setIcon(R.drawable.review);


        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dp);
        int startColor = Color.argb(170,0, 0, 0);
        int endColor =Color.argb(200, 0, 0, 0);
        GradientOverImageDrawable gradientOverImageDrawable = new GradientOverImageDrawable(getResources(), bitmap);
        gradientOverImageDrawable.setGradientStart(0);
        gradientOverImageDrawable.setGradientEnd(1);
        gradientOverImageDrawable.setGradientColors(startColor, endColor);
        imageViewBackgroundDP.setImageDrawable(gradientOverImageDrawable);

        Home = (ImageView) findViewById(R.id.profilepage_home);
        Plus = (ImageView) findViewById(R.id.profilepage_plus);
        Profile = (ImageView) findViewById(R.id.profilepage_profile);

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
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.v("MyApp", getClass().toString() + " onCreateOptionsMenu");
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_profile_page, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.v("MyApp", getClass().toString() + " onOptionsItemSelected");
        Intent intent;
        switch (item.getItemId()){
            case R.id.action_settings:
                intent = new Intent(ProfilePage.this, UserSettings.class);
                startActivity(intent);
                break;
            case R.id.action_favourite:
                intent = new Intent(ProfilePage.this, Favourite.class);
                startActivity(intent);
                break;

            default: Toast.makeText(getApplicationContext(),"Wrong Item Selected", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        Intent intent ;
        switch(v.getId()){
//            case R.id.homepage_userprofile:
//                intent = new Intent(ProfilePage.this, ProfilePage.class);
//                startActivity(intent);
//                break;
            case R.id.profilepage_plus:
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
            case R.id.profilepage_home:
                intent = new Intent(ProfilePage.this, HomePage.class);
                startActivity(intent);
        }
    }//onClick()

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0: return new ProfilePagePlaces();
                case 1: return new ProfilePagePicture();
                case 2: return new ProfilePageReview();
                default : return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

//        @Override
//        public CharSequence getPageTitle(int position) {
//            switch (position) {
//                case 0:
//                    return "Places";
//                case 1:
//                    return "Pictures";
//                case 2:
//                    return "Review";
//            }
//            return null;
//        }
    }

}
