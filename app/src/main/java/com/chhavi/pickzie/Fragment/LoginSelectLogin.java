package com.chhavi.pickzie.Fragment;


import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chhavi.pickzie.Activity.HomePage;
import com.chhavi.pickzie.Activity.ProfilePage;
import com.chhavi.pickzie.R;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginSelectLogin extends Fragment implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {


    public LoginSelectLogin() {
        // Required empty public constructor
    }

    private static final int RC_SIGN_IN = 9001;
    private GoogleApiClient mGoogleApiClient;
    private GoogleSignInOptions gso;

    LoginButton loginButton;
    CallbackManager callbackManager;
    AccessTokenTracker accessTokenTracker;
    FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {

        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException error) {

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FacebookSdk.sdkInitialize(getContext());
        View view = inflater.inflate(R.layout.fragment_login_select_login, container, false);
        view.findViewById(R.id.login_login_login).setOnClickListener(this);
        view.findViewById(R.id.image_selectLogin_fb).setOnClickListener(this);
        view.findViewById(R.id.image_selectLogin_gplus).setOnClickListener(this);

        // Build a GoogleApiClient with access to the Google Sign-In API and the
        // options specified by gso.
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestScopes(new Scope(Scopes.PLUS_LOGIN)).requestEmail().build();
//        Log.v("MyApp", "onCreate() 1");

        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso).addApi(Plus.API).build();

        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_login_login:
                Intent intent = new Intent(getActivity(), HomePage.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                getActivity().finish();
                break;
            case R.id.image_selectLogin_gplus:
                signIn();
                break;
            case R.id.image_selectLogin_fb:
                loginButton = new LoginButton(getActivity());
                loginButton.performClick();
                accessTokenTracker = new AccessTokenTracker() {
                    @Override
                    protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken newAccessToken) {
                        updateWithToken(newAccessToken);
                    }
                };
                callbackManager = CallbackManager.Factory.create();
                loginButton.setReadPermissions(Arrays.asList("public_profile", "email"));
                loginButton.registerCallback(callbackManager, callback);
                break;
        }
    }

    // FaceBook Sign In ---------------------------------------------------------------------------------------
    private void updateWithToken( AccessToken currentAccessToken ){
        if(currentAccessToken!=null){
            Log.v("MyApp", getClass().toString() + "updateWithToken:If(Token NonNull)");

            GraphRequest request = GraphRequest.newMeRequest(currentAccessToken, new GraphRequest.GraphJSONObjectCallback() {
                @Override
                public void onCompleted(JSONObject object, GraphResponse response) {
                    Log.v("MyApp",getClass().toString() + response.toString());
                    // Get facebook data from login
//                    Bundle bFacebookData = getFacebookData(object);
                    try {
                        Log.v("MyApp", getClass().toString() + object.toString()+ "name " + object.getString("first_name"));

//                        editor.putString("fname", object.getString("first_name"));
//                        editor.putString("lname", object.getString("last_name"));
//                        editor.putString("gender", CapitalizeWord(object.getString("gender")));
//                        editor.putString("email", object.getString("email"));

                    } catch (JSONException e) {
                        Log.v("MyApp", getClass().toString() + "LoginJSON");
//                        Toast.makeText(getApplicationContext(), "Unable to get your EMail-ID", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
//                    editor.commit();
//                    Intent intent = new Intent(Login.this, MyHealthLitmus.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                    startActivity(intent);
//                    finish();
                }
            });

            Bundle parameters = new Bundle();
            // Parámetros que pedimos a facebook
            parameters.putString("fields", "id, first_name, last_name, email,gender, birthday, location");
            request.setParameters(parameters);
            request.executeAsync();

        } else {
            Log.v("MyApp", getClass().toString() + "updateWithToken:Else(Token Null)");
//            dialog.dismiss();
        }
    }//updatewithtoken
    //--------------------------------------------------------------------------------------- FaceBook Sign In

    // Google Sign In ---------------------------------------------------------------------------------------
    private void signIn() {
//        Log.v("MyApp", "signIn Login");
//        editor.putString("loginVia", "google");
//        editor.commit();
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void handleSignInResult(GoogleSignInResult result) {
        Log.v("MyApp", getClass().toString() + " handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            Log.v("MyApp", getClass().toString() + " Google handleSignInResult() if Login");
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
            if(mGoogleApiClient.hasConnectedApi(Plus.API)){
                Person person  = Plus.PeopleApi.getCurrentPerson(mGoogleApiClient);
                Log.v("MyApp", "--------------------------------");
                String a[] = person.getDisplayName().split(" ");

                try {
                    int sz = a.length;
                    if(sz>2) {
//                        editor.putString("fname", a[0] + " " + a[1]);
//                        editor.putString("lname", a[2]);
                    } else {
//                        editor.putString("fname", a[0]);
//                        editor.putString("lname", a[1]);
                    }
//                    editor.putString("gender", person.getGender() == 0 ? "Male" : "Female");
//                    editor.putString("email", acct.getEmail());
                } catch (NullPointerException e ){
                    Log.v("MyApp", getClass().toString() + " NullPointerException" );
                }
            } else {
                String a[] = acct.getDisplayName().split(" ");
                try {
                    int sz = a.length;
                    if(sz>2) {
//                        editor.putString("fname", a[0] + " " + a[1]);
//                        editor.putString("lname", a[2]);
                    } else {
//                        editor.putString("fname", a[0]);
//                        editor.putString("lname", a[1]);
                    }
//                    editor.putString("email", acct.getEmail());
                } catch (NullPointerException e ){
                    Log.v("MyApp", getClass().toString() + " NullPointerException" );
                }
            }
//            editor.commit();
//            Toast.makeText(this, "GOT IT", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(this, MyHealthLitmus.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
//            finish();
        } else {
            // Signed out, show unauthenticated UI.
            Log.v("MyApp", getClass().toString() + "Google handleSignInResult() else Login");
            Toast.makeText(getContext(), "Unable Sign In", Toast.LENGTH_SHORT).show();
        }
    }
    //--------------------------------------------------------------------------------------- Google Sign In

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.v("MyApp", getClass().toString() + " Request:" + requestCode + " Result:" + resultCode);
        if (requestCode == RC_SIGN_IN) {
            Log.v("MyApp", getClass().toString() + " onActivityResult:If Google");
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        } else if (requestCode==64206) {
            Log.v("MyApp", getClass().toString() + " onActivityResult:Else If Facebook");
            callbackManager.onActivityResult(requestCode, resultCode, data);
        } else if(requestCode==65538) {
            int errorCode = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(getContext());
            Log.v("MyApp", getClass().toString() + " onActivityResult:Else If 65538" + " Error:" +errorCode);
        }
    }

}
