package com.chhavi.pickzie.Helper;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mukesh on 1/18/2016.
 */
public class ContentCardSpa {
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
        public String Name, Locality, Distance, Votes, Discount;
        public Bitmap BG,p1, p2, p3, p4;
        public DummyItem(String vName, String vLocality, String vDistance, String vVotes, String vDiscount, Bitmap vBG,
                            Bitmap vP1, Bitmap vP2, Bitmap vP3, Bitmap vP4  ) {
            Name = vName ;
            Locality = vLocality;
            Discount = vDiscount;
            Distance = vDistance;
            Votes = vVotes;
            BG = vBG;
            p1 = vP1;
            p2 = vP2;
            p3 = vP3;
            p4 = vP4;
        }

        @Override
        public String toString() {
            return Name;
        }
    }

}
