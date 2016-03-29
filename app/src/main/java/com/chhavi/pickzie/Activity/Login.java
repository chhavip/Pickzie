package com.chhavi.pickzie.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chhavi.pickzie.Fragment.LoginPage;
import com.chhavi.pickzie.R;

public class Login extends AppCompatActivity {


    LoginPage loginPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPage = new LoginPage();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framelayout_login, loginPage);
        fragmentTransaction.commit();
    }
}
