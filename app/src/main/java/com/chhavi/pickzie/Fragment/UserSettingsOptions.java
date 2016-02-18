package com.chhavi.pickzie.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chhavi.pickzie.R;

/**
 * A simple {@link Fragment} subclass.
 */


public class UserSettingsOptions extends Fragment implements View.OnClickListener {


    public UserSettingsOptions() {
        // Required empty public constructor
    }

    UserBasicInfo userBasicInfo;
    UserBookings userBookings;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_settings_options, container, false);

        view.findViewById(R.id.settings_aboutus).setOnClickListener(this);
        view.findViewById(R.id.settings_appsettings).setOnClickListener(this);
        view.findViewById(R.id.settings_basic).setOnClickListener(this);
        view.findViewById(R.id.settings_bookings).setOnClickListener(this);
        view.findViewById(R.id.settings_contactus).setOnClickListener(this);
        view.findViewById(R.id.settings_fav).setOnClickListener(this);
        view.findViewById(R.id.settings_legal).setOnClickListener(this);
        view.findViewById(R.id.settings_logout).setOnClickListener(this);
        view.findViewById(R.id.settings_rate).setOnClickListener(this);
        view.findViewById(R.id.settings_refer).setOnClickListener(this);
        view.findViewById(R.id.settings_send_feedback).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (v.getId()){
            case R.id.settings_aboutus:
//                fragmentTransaction.replace(R.id.framelayout_user_settings, userSettingsOptions);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
                break;
            case R.id.settings_appsettings:
//                fragmentTransaction.replace(R.id.framelayout_user_settings, userSettingsOptions);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
                break;
            case R.id.settings_basic:
                userBasicInfo = new UserBasicInfo();
                fragmentTransaction.replace(R.id.framelayout_user_settings, userBasicInfo);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.settings_bookings:
                userBookings = new UserBookings();
                fragmentTransaction.replace(R.id.framelayout_user_settings, userBookings);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.settings_fav:
//                fragmentTransaction.replace(R.id.framelayout_user_settings, userSettingsOptions);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
                break;
            case R.id.settings_legal:
//                fragmentTransaction.replace(R.id.framelayout_user_settings, userSettingsOptions);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
                break;
            case R.id.settings_logout:
//                fragmentTransaction.replace(R.id.framelayout_user_settings, userSettingsOptions);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
                break;
            case R.id.settings_rate:
//                fragmentTransaction.replace(R.id.framelayout_user_settings, userSettingsOptions);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
                break;
            case R.id.settings_refer:
//                fragmentTransaction.replace(R.id.framelayout_user_settings, userSettingsOptions);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
                break;
            case R.id.settings_send_feedback:
//                fragmentTransaction.replace(R.id.framelayout_user_settings, userSettingsOptions);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
                break;
        }
    }
}
