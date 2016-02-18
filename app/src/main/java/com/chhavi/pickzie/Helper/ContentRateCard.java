package com.chhavi.pickzie.Helper;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mukesh on 2/12/2016.
 */
public class ContentRateCard {
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
        public String Name, Price;
        public DummyItem(String vName, String vPrice  ) {
            Name = vName ;
            Price = vPrice;
        }

        @Override
        public String toString() {
            return Name;
        }
    }

}
