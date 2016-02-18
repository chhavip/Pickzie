package com.chhavi.pickzie.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chhavi.pickzie.Fragment.UserSettingsOptions;
import com.chhavi.pickzie.R;

public class UserSettings extends AppCompatActivity {

    UserSettingsOptions userSettingsOptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);

        userSettingsOptions = new UserSettingsOptions();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout_user_settings, userSettingsOptions);
        fragmentTransaction.commit();

    }
}
