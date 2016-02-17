package com.chhavi.pickzie.Helper;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mukesh on 1/20/2016.
 */
public class ContentCardReview {
    public List<DummyItem> ITEMS = new ArrayList<DummyItem>();
    public Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    public void addItem(DummyItem item ) {
        ITEMS.add(item);
        ITEM_MAP.put(item.Name, item);
    }

    public void clear(){
        this.ITEMS.clear();
    }

    public static class DummyItem {
        public String Name, Locality, Review;
        public Bitmap UserDP;
        public DummyItem(String vName, String vLocality, String vReview, Bitmap vUserDP  ) {
            Name = vName ;
            Locality = vLocality;
            UserDP = vUserDP;
            Review = vReview;
        }

        @Override
        public String toString() {
            return Name;
        }
    }

}
