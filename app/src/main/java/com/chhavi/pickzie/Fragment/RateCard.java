package com.chhavi.pickzie.Fragment;


import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chhavi.pickzie.Helper.ContentCardPictures;
import com.chhavi.pickzie.Helper.ContentCardReview;
import com.chhavi.pickzie.Helper.ContentRateCard;
import com.chhavi.pickzie.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RateCard extends Fragment {


    public RateCard() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    private RVAdapter rvAdapter;
    private ContentRateCard contentRateCard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rate_card, container, false);

        contentRateCard = new ContentRateCard();

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_rate_card);
        recyclerView.setHasFixedSize(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        contentRateCard.addItem(new ContentRateCard.DummyItem("Hair", "100 Rs"));
        contentRateCard.addItem(new ContentRateCard.DummyItem("Face", "150 Rs"));
        contentRateCard.addItem(new ContentRateCard.DummyItem("Hair", "100 Rs"));
        contentRateCard.addItem(new ContentRateCard.DummyItem("Face", "150 Rs"));
        contentRateCard.addItem(new ContentRateCard.DummyItem("Hair", "100 Rs"));
        contentRateCard.addItem(new ContentRateCard.DummyItem("Face", "150 Rs"));
        contentRateCard.addItem(new ContentRateCard.DummyItem("Hair", "100 Rs"));
        contentRateCard.addItem(new ContentRateCard.DummyItem("Face", "150 Rs"));
        contentRateCard.addItem(new ContentRateCard.DummyItem("Hair", "100 Rs"));
        contentRateCard.addItem(new ContentRateCard.DummyItem("Face", "150 Rs"));


        rvAdapter = new RVAdapter( contentRateCard.ITEMS );
        recyclerView.setAdapter(rvAdapter);

        return view;
    }

    private class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardViewHolder>{
        ContentRateCard contentRateCard = new ContentRateCard();

        public RVAdapter(List<ContentRateCard.DummyItem> vITEMS ){
            contentRateCard.ITEMS = vITEMS;
        }

        @Override
        public RVAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_rate_card, parent, false);
            return new CardViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RVAdapter.CardViewHolder holder, int position) {
            holder.name.setText(contentRateCard.ITEMS.get(position).Name);
            holder.price.setText(contentRateCard.ITEMS.get(position).Price);
        }

        @Override
        public int getItemCount() {
            return contentRateCard.ITEMS.size();
        }

        public class CardViewHolder extends RecyclerView.ViewHolder {
            CardView card;
            TextView name, price;
            
            public CardViewHolder(View itemView) {
                super(itemView);
                card = (CardView) itemView.findViewById(R.id.cardView_rateCard);
                name = (TextView) itemView.findViewById(R.id.rateCard_name_rate);
                price = (TextView) itemView.findViewById(R.id.rateCard_name_price);
            }
        }
    }


}
