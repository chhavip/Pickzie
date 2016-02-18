package com.chhavi.pickzie.Fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chhavi.pickzie.Helper.ContentCardSpa;
import com.chhavi.pickzie.Helper.GradientOverImageDrawable;
import com.chhavi.pickzie.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilePagePlaces extends Fragment {


    public ProfilePagePlaces() {
        // Required empty public constructor
    }

    private ContentCardSpa contentCardSpa;
    private RecyclerView recyclerView;
    private RVAdapter rvAdapter;
    private Toolbar toolbar;
    private TextView textViewToolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_page_places, container, false);
        contentCardSpa = new ContentCardSpa();

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_card_places);
        recyclerView.setHasFixedSize(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        contentCardSpa.addItem(new ContentCardSpa.DummyItem("MyXYZ Salon and Spa", "Central Market, Punjabi Bagh", null, "4.7", null,
                BitmapFactory.decodeResource(getResources(), R.drawable.spa1),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa2),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa3),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa4),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa5)));

        contentCardSpa.addItem(new ContentCardSpa.DummyItem("MyABC Salon and Spa", "Main Market, Avantika", null, "5", null,
                BitmapFactory.decodeResource(getResources(), R.drawable.spa1),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa2),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa3),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa4),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa5)));
        contentCardSpa.addItem(new ContentCardSpa.DummyItem("MyABC Salon and Spa", "Main Market, Avantika", null, "5", null,
                BitmapFactory.decodeResource(getResources(), R.drawable.spa1),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa2),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa3),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa4),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa5)));

        rvAdapter = new RVAdapter( contentCardSpa.ITEMS );
        recyclerView.setAdapter(rvAdapter);

        return view;
    }

    private class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardViewHolder> {

        ContentCardSpa content = new ContentCardSpa();

        public RVAdapter ( List<ContentCardSpa.DummyItem> list_dummy ){
            content.ITEMS = list_dummy;
        }

        @Override
        public RVAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_places, parent, false);
            CardViewHolder cardViewHolder = new CardViewHolder(view);
            return cardViewHolder;
        }

        @Override
        public void onBindViewHolder(RVAdapter.CardViewHolder holder, int position) {
            holder.name.setText(content.ITEMS.get(position).Name);
            holder.location.setText(content.ITEMS.get(position).Locality);
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
            holder.P4.setImageBitmap(content.ITEMS.get(position).p3);
        }

        @Override
        public int getItemCount() {
            return content.ITEMS.size();
        }

        public class CardViewHolder extends RecyclerView.ViewHolder {
            CardView cardView;
            TextView name, location, votes;
            ImageView BG, P1, P2, P3, P4;
            public CardViewHolder(View itemView) {
                super(itemView);
                cardView = (CardView) itemView.findViewById(R.id.cardView_places);
                name = (TextView) itemView.findViewById(R.id.cardPlacesName);
                location = (TextView) itemView.findViewById(R.id.cardPlacesLocation);
                votes = (TextView) itemView.findViewById(R.id.cardPlacesVotes);
                BG = (ImageView) itemView.findViewById(R.id.cardPlacesBG);
                P1 = (ImageView) itemView.findViewById(R.id.cardPlacesP1);
                P2 = (ImageView) itemView.findViewById(R.id.cardPlacesP2);
                P3 = (ImageView) itemView.findViewById(R.id.cardPlacesP3);
                P4 = (ImageView) itemView.findViewById(R.id.cardPlacesP4);
            }
        }
    }
}
