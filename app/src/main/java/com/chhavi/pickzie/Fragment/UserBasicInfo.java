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
public class UserBasicInfo extends Fragment {


    public UserBasicInfo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_basic_info, container, false);
    }


}
