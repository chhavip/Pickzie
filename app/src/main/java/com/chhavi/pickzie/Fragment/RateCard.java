package com.chhavi.pickzie.Fragment;


import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chhavi.pickzie.Helper.ContentCardPictures;
import com.chhavi.pickzie.Helper.ContentCardReview;
import com.chhavi.pickzie.Helper.ContentRateCard;
import com.chhavi.pickzie.Helper.ExpandableListAdapter;
import com.chhavi.pickzie.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RateCard extends Fragment implements View.OnClickListener {


    public RateCard() {
        // Required empty public constructor
    }

    private RecyclerView recyclerview;
    List<ExpandableListAdapter.Item> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rate_card, container, false);
        recyclerview = (RecyclerView) view.findViewById(R.id.recyclerviewRateCard);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        data = new ArrayList<>();

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "Waxing", "10"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Apple", "20"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Orange", "30"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Banana", "40"));

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "Tanning", "50"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Audi", "60"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Aston Martin", "70"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "BMW", "80"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Cadillac", "90"));

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "Facial", "50"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Audi", "60"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Aston Martin", "70"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "BMW", "80"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Cadillac", "90"));

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "Tanning", "50"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Audi", "60"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Aston Martin", "70"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "BMW", "80"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Cadillac", "90"));

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "Tanning", "50"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Audi", "60"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Aston Martin", "70"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "BMW", "80"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Cadillac", "90"));

        recyclerview.setAdapter(new ExpandableListAdapter(data));

        view.findViewById(R.id.findSelected).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.findSelected:
                for(int i=0;i<data.size();i++) {
                    if(data.get(i).checked)
                        Log.v("MyApp", "Checked" + data.get(i).text);
                    else
                        Log.v("MyApp", "Not Checked" + data.get(i).text );
                }
                break;
        }
    }
}
