package com.chhavi.pickzie.Fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import com.chhavi.pickzie.Helper.ContentCardPictures;
import com.chhavi.pickzie.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilePagePicture extends Fragment {

    public ProfilePagePicture() {
        // Required empty public constructor
    }

    private	ContentCardPictures contentCardPictures;
    private RecyclerView recyclerView;
    private RVAdapter rvAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_page_picture, container, false);

        contentCardPictures = new ContentCardPictures();

//        Drawable dr = getResources().getDrawable(R.drawable.picture);
//        Bitmap bitmapToolbar = ((BitmapDrawable) dr).getBitmap();
//        Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapToolbar, 35, 35, true));
//        getSupportActionBar().setLogo(d);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_card_pictures);
        recyclerView.setHasFixedSize(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        contentCardPictures.addItem(new ContentCardPictures.DummyItem("ABC Person", "Central Market, Punjabi Bagh",
                BitmapFactory.decodeResource(getResources(), R.drawable.dp),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa2)));

        contentCardPictures.addItem(new ContentCardPictures.DummyItem("ABC Person", "Main Market, Avantika",
                BitmapFactory.decodeResource(getResources(), R.drawable.dp),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa3)));


        contentCardPictures.addItem(new ContentCardPictures.DummyItem("ABC Person", "Main Market, Avantika",
                BitmapFactory.decodeResource(getResources(), R.drawable.dp),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa3)));


        contentCardPictures.addItem(new ContentCardPictures.DummyItem("ABC Person", "Main Market, Avantika",
                BitmapFactory.decodeResource(getResources(), R.drawable.dp),
                BitmapFactory.decodeResource(getResources(), R.drawable.spa3)));


        rvAdapter = new RVAdapter( contentCardPictures.ITEMS );
        recyclerView.setAdapter(rvAdapter);

        return view;
    }

    private class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardViewHolder>{
        ContentCardPictures contentCardPictures = new ContentCardPictures();

        public RVAdapter(List<ContentCardPictures.DummyItem> vITEMS ){
            contentCardPictures.ITEMS = vITEMS;
        }

        @Override
        public RVAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_pictures, parent, false);
            return new CardViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RVAdapter.CardViewHolder holder, int position) {
            holder.name.setText(contentCardPictures.ITEMS.get(position).Name);
            holder.location.setText(contentCardPictures.ITEMS.get(position).Locality);

            holder.image.setAdjustViewBounds(true);
            holder.image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            holder.userDP.setImageBitmap(contentCardPictures.ITEMS.get(position).UserDP);
            holder.image.setImageBitmap(contentCardPictures.ITEMS.get(position).Image);
        }

        @Override
        public int getItemCount() {
            return contentCardPictures.ITEMS.size();
        }

        public class CardViewHolder extends RecyclerView.ViewHolder {
            CardView card;
            TextView name, location;
            ImageView image;
            CircleImageView userDP;
            public CardViewHolder(View itemView) {
                super(itemView);
                card = (CardView) itemView.findViewById(R.id.cardView_pictures);
                name = (TextView) itemView.findViewById(R.id.cardPicturesName);
                location = (TextView) itemView.findViewById(R.id.cardPicturesLocation);
                userDP = (CircleImageView) itemView.findViewById(R.id.cardPicturesUserDP);
                image = (ImageView) itemView.findViewById(R.id.cardPicturesImage);
            }
        }
    }


}
