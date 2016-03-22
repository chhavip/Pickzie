package com.chhavi.pickzie.Activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chhavi.pickzie.Helper.ContentCardSpa;
import com.chhavi.pickzie.Helper.GradientOverImageDrawable;
import com.chhavi.pickzie.Helper.RecyclerViewTouchListener;
import com.chhavi.pickzie.Helper.ViewPagerAdapter;
import com.chhavi.pickzie.R;
import com.cocosw.bottomsheet.BottomSheet;

import java.util.List;

public class Search extends AppCompatActivity implements View.OnClickListener {

    ContentCardSpa contentCardSpa;
    RecyclerView recyclerView;
    RVAdapter rvAdapter;
    Toolbar toolbar;
    ImageView Home, Plus, Profile;
    Drawable dr, d;
    Bitmap bitmapToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        contentCardSpa = new ContentCardSpa();
        findViewById(R.id.search_home).setOnClickListener(this);
        findViewById(R.id.search_profile).setOnClickListener(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        //enabling toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

//        Drawable dr = getResources().getDrawable(R.drawable.home150);
//        Bitmap bitmapToolbar = ((BitmapDrawable) dr).getBitmap();
//        Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapToolbar, 35, 35, true));
//        getSupportActionBar().setLogo(d);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_card_spa);
        recyclerView.setHasFixedSize(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        contentCardSpa.addItem(new ContentCardSpa.DummyItem("MyXYZ Salon and Spa", "Central Market, Punjabi Bagh", "10", "4.7", "30",
                BitmapFactory.decodeResource(getResources(), R.drawable.spa1),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa2),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa3),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa4),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa5)));

        contentCardSpa.addItem(new ContentCardSpa.DummyItem("MyABC Salon and Spa", "Main Market, Avantika", "2", "5", "20",
                BitmapFactory.decodeResource(getResources(), R.drawable.spa1),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa2),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa3),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa4),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa5)));

        contentCardSpa.addItem(new ContentCardSpa.DummyItem("MyABC Salon and Spa", "Main Market, Avantika", "2", "5", "20",
                BitmapFactory.decodeResource(getResources(), R.drawable.spa1),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa2),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa3),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa4),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa5)));

        contentCardSpa.addItem(new ContentCardSpa.DummyItem("MyABC Salon and Spa", "Main Market, Avantika", "2", "5", "20",
                BitmapFactory.decodeResource(getResources(), R.drawable.spa1),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa2),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa3),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa4),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa5)));

        contentCardSpa.addItem(new ContentCardSpa.DummyItem("MyABC Salon and Spa", "Main Market, Avantika", "2", "5", "20",
                BitmapFactory.decodeResource(getResources(), R.drawable.spa1),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa2),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa3),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa4),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa5)));

        rvAdapter = new RVAdapter(contentCardSpa.ITEMS);
        recyclerView.setAdapter(rvAdapter);

        Home = (ImageView) findViewById(R.id.search_home);
        Plus = (ImageView) findViewById(R.id.search_plus);
        Profile = (ImageView) findViewById(R.id.search_profile);

        Profile.setOnClickListener(this);
        Home.setOnClickListener(this);

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


        CardListener();
    }

    private void CardListener(){
        recyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(getApplicationContext(),
                new RecyclerViewTouchListener.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Log.v("MyApp", getClass().toString()+" CardListener " + position );
                Intent intent = new Intent(Search.this, ViewSalonSpa.class);
                startActivity(intent);
            }
        }));
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.search_profile :
                intent = new Intent(Search.this, ProfilePage.class);
                startActivity(intent);
                break;
            case R.id.search_home :
                intent = new Intent(Search.this, HomePage.class);
                startActivity(intent);
                break;
            case R.id.search_plus :
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


    private class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardViewHolder> {

        ContentCardSpa content = new ContentCardSpa();
        Animation animation;
        public RVAdapter ( List<ContentCardSpa.DummyItem> list_dummy ){
            content.ITEMS = list_dummy;
        }

        @Override
        public RVAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_spa, parent, false);
            CardViewHolder cardViewHolder = new CardViewHolder(view);
            return cardViewHolder;
        }

        @Override
        public void onBindViewHolder(RVAdapter.CardViewHolder holder, int position) {
            holder.name.setText(content.ITEMS.get(position).Name);
            holder.location.setText(content.ITEMS.get(position).Locality);
            holder.distance.setText(content.ITEMS.get(position).Distance + " Kms");
            holder.discount.setText(content.ITEMS.get(position).Discount + " % OFF");
            holder.votes.setText(content.ITEMS.get(position).Votes);

            int startColor = Color.argb(170, 0, 0, 0);
            int endColor =Color.argb(200, 0, 0, 0);
            GradientOverImageDrawable gradientOverImageDrawable = new GradientOverImageDrawable(getResources(),
                    content.ITEMS.get(position).BG);
            gradientOverImageDrawable.setGradientStart(0);
            gradientOverImageDrawable.setGradientEnd(1);
            gradientOverImageDrawable.setGradientColors(startColor, endColor);
            holder.BG.setImageDrawable(gradientOverImageDrawable);

            holder.P1.setImageBitmap(content.ITEMS.get(position).BG);
            holder.P2.setImageBitmap(content.ITEMS.get(position).p1);
            holder.P3.setImageBitmap(content.ITEMS.get(position).p2);

            gradientOverImageDrawable = new GradientOverImageDrawable(getResources(),
                    content.ITEMS.get(position).p3);
            gradientOverImageDrawable.setGradientStart(0);
            gradientOverImageDrawable.setGradientEnd(1);
            startColor = Color.argb(100, 0, 0, 0);
            endColor =Color.argb(100, 0, 0, 0);
            gradientOverImageDrawable.setGradientColors(startColor, endColor);

            Drawable[] layers = new Drawable[2];
            layers[0] = gradientOverImageDrawable;
            layers[1] = ContextCompat.getDrawable(getApplicationContext(),R.drawable.more);
            LayerDrawable layerDrawable = new LayerDrawable(layers);
            holder.P4.setImageDrawable(layerDrawable);
//            holder.P4.setImageBitmap(content.ITEMS.get(position).p3);

            holder.imageViewCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadeout);
                    animation.setDuration(250);
                    animation.setRepeatMode(Animation.REVERSE);
                    v.startAnimation(animation);
                    animation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            Toast.makeText(getApplicationContext(), "Calling", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent phoneIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:9716354354"));
                            try {
                                startActivity(phoneIntent);
                            } catch (SecurityException e) {
                                Toast.makeText(getApplicationContext(), "Not Allowed To call", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                }
            });

            holder.P4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.v("MyApp", getClass().toString() + "cardspaP4");
//                    Dialog dialog = new Dialog(Search.this);//, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                    Dialog dialog = new Dialog(Search.this, R.style.MyDialogTheme);
                    Window window = dialog.getWindow();
                    window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//                    window.setBackgroundDrawable(getDrawable(R.drawable.login_bg));
                    window.setDimAmount(0.8f);
//                    WindowManager.LayoutParams wmLayoutParams = getWindow().getAttributes();
//                    wmLayoutParams.dimAmount = 0.75f;
//                    dialog.getWindow().setAttributes(wmLayoutParams);

                    dialog.setTitle("My Dialog");
                    dialog.setContentView(R.layout.fragment_show_images);

                    Drawable[] imageDrawable = {ContextCompat.getDrawable(getApplicationContext(), R.drawable.dp ),
                            ContextCompat.getDrawable(getApplicationContext(), R.drawable.spa1),
                            ContextCompat.getDrawable(getApplicationContext(), R.drawable.spa2),
                            ContextCompat.getDrawable(getApplicationContext(), R.drawable.spa3),
                            ContextCompat.getDrawable(getApplicationContext(), R.drawable.spa5 ),
                            ContextCompat.getDrawable(getApplicationContext(), R.drawable.spa4)};
                    String text[] = {"ABC1", "ABC2", "ABC3", "ABC4", "ABC5", "ABC6"};
                    ViewPagerAdapter adapter = new ViewPagerAdapter(getApplicationContext(),
                            R.layout.frame_viewpager_images,imageDrawable, text );
                    ViewPager myPager = (ViewPager) dialog.findViewById(R.id.viewpager_showImage);
                    myPager.setAdapter(adapter);
                    myPager.setCurrentItem(0);
                    dialog.show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return content.ITEMS.size();
        }

        public class CardViewHolder extends RecyclerView.ViewHolder {
            CardView cardView;
            TextView name, location, distance, discount, votes;
            ImageView BG, P1, P2, P3, P4, imageViewCall;
            public CardViewHolder(View itemView) {
                super(itemView);
                cardView = (CardView) itemView.findViewById(R.id.cardView_spa);
                name = (TextView) itemView.findViewById(R.id.cardSpaName);
                location = (TextView) itemView.findViewById(R.id.cardSpaLocation);
                distance = (TextView) itemView.findViewById(R.id.cardSpaDistance);
                discount = (TextView) itemView.findViewById(R.id.cardSpaDiscount);
                votes = (TextView) itemView.findViewById(R.id.cardSpaVotes);
                BG = (ImageView) itemView.findViewById(R.id.cardSpaBG);
                P1 = (ImageView) itemView.findViewById(R.id.cardSpaP1);
                P2 = (ImageView) itemView.findViewById(R.id.cardSpaP2);
                P3 = (ImageView) itemView.findViewById(R.id.cardSpaP3);
                P4 = (ImageView) itemView.findViewById(R.id.cardSpaP4);
                imageViewCall = (ImageView) itemView.findViewById(R.id.imageView_card_spa_call);
            }
        }
    }
}
