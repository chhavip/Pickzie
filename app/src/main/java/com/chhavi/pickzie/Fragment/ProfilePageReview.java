package com.chhavi.pickzie.Fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
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
import android.widget.TextView;

import com.chhavi.pickzie.Helper.ContentCardReview;
import com.chhavi.pickzie.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilePageReview extends Fragment {


    public ProfilePageReview() {
        // Required empty public constructor
    }

    private ContentCardReview contentCardReview;
    private RecyclerView recyclerView;
    private RVAdapter rvAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_page_review, container, false);

        contentCardReview = new ContentCardReview();

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_card_review);
        recyclerView.setHasFixedSize(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        contentCardReview.addItem(new ContentCardReview.DummyItem("ABC Person", "Central Market, Punjabi Bagh",
                "This is small Review. Just one or two lines max, not more than that. It is to check. These are dummy content. " +
                        "Not to be taken seriously",
                BitmapFactory.decodeResource(getResources(), R.drawable.dp)));

        contentCardReview.addItem(new ContentCardReview.DummyItem("ABC Person", "Central Market, Punjabi Bagh",
                "This is Large Review. More than one or two lines, not more than that. It is to check. Few Stupid write stories while writing " +
                        "reviews. This is to check for those stupid people who writes stories in review. This is to check only. Not " +
                        "to be taken seriously. Write any amount of text u want but write only good thing about everyone",
                BitmapFactory.decodeResource(getResources(), R.drawable.dp)));
        contentCardReview.addItem(new ContentCardReview.DummyItem("ABC Person", "Central Market, Punjabi Bagh",
                "This is small Review. Just one or two lines max, not more than that. It is to check. These are dummy content. " +
                        "Not to be taken seriously",
                BitmapFactory.decodeResource(getResources(), R.drawable.dp)));

        contentCardReview.addItem(new ContentCardReview.DummyItem("ABC Person", "Central Market, Punjabi Bagh",
                "This is small Review. Just one or two lines max, not more than that. It is to check. These are dummy content. " +
                        "Not to be taken seriously",
                BitmapFactory.decodeResource(getResources(), R.drawable.dp)));

        contentCardReview.addItem(new ContentCardReview.DummyItem("ABC Person", "Central Market, Punjabi Bagh",
                "This is small Review. Just one or two lines max, not more than that. It is to check. These are dummy content. " +
                        "Not to be taken seriously",
                BitmapFactory.decodeResource(getResources(), R.drawable.dp)));

        contentCardReview.addItem(new ContentCardReview.DummyItem("ABC Person", "Central Market, Punjabi Bagh",
                "This is small Review. Just one or two lines max, not more than that. It is to check. These are dummy content. " +
                        "Not to be taken seriously",
                BitmapFactory.decodeResource(getResources(), R.drawable.dp)));

        contentCardReview.addItem(new ContentCardReview.DummyItem("ABC Person", "Central Market, Punjabi Bagh",
                "This is small Review. Just one or two lines max, not more than that. It is to check. These are dummy content. " +
                        "Not to be taken seriously",
                BitmapFactory.decodeResource(getResources(), R.drawable.dp)));

        contentCardReview.addItem(new ContentCardReview.DummyItem("ABC Person", "Central Market, Punjabi Bagh",
                "This is to check only.",
                BitmapFactory.decodeResource(getResources(), R.drawable.dp)));

        rvAdapter = new RVAdapter( contentCardReview.ITEMS );
        recyclerView.setAdapter(rvAdapter);

        return view;
    }

    private class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardViewHolder>{
        ContentCardReview contentCardReview = new ContentCardReview();

        public RVAdapter ( List<ContentCardReview.DummyItem> vItems ){
            contentCardReview.ITEMS = vItems ;
        }


        @Override
        public RVAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_review, parent, false);
            return new CardViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RVAdapter.CardViewHolder holder, int position) {
            holder.name.setText(contentCardReview.ITEMS.get(position).Name);
            holder.location.setText(contentCardReview.ITEMS.get(position).Locality);
            holder.review.setText(contentCardReview.ITEMS.get(position).Review);
            holder.userDP.setImageBitmap(contentCardReview.ITEMS.get(position).UserDP);
        }

        @Override
        public int getItemCount() {
            return contentCardReview.ITEMS.size();
        }

        public class CardViewHolder extends RecyclerView.ViewHolder {
            CardView cardView;
            TextView name, location, review;
            CircleImageView userDP;
            public CardViewHolder(View itemView) {
                super(itemView);
                cardView = (CardView) itemView.findViewById(R.id.cardView_review);
                name = (TextView) itemView.findViewById(R.id.cardReviewName);
                location = (TextView) itemView.findViewById(R.id.cardReviewLocation);
                review = (TextView) itemView.findViewById(R.id.cardReviewTextReview);
                userDP = (CircleImageView) itemView.findViewById(R.id.cardReviewUserDP);
            }
        }

    }

}
