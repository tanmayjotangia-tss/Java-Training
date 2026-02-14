package com.tss.day25.Adapter.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    public static List<IItems> loadItems() {

        List<IItems> items = new ArrayList<>();

        items.add(new Biscuit("Parle-G", 10));
        items.add(new Biscuit("Oreo", 30));
        items.add(new Biscuit("Hide & Seek Fab", 40));

        items.add(new Chocolate("Dairy Milk", 50));
        items.add(new Chocolate("KitKat", 25));
        items.add(new Chocolate("Ferrero Rocher", 750));

        Hat hat1 = new Hat("Cap", "Baseball Cap", 200, 0.18);
        Hat hat2 = new Hat("Fedora", "Classic Fedora Hat", 500, 0.12);
        Hat hat3 = new Hat("Beanie", "Winter Beanie", 350, 0.15);
        Hat hat4 = new Hat("Panama", "Stylish Panama Hat", 450, 0.10);

        items.add(new HatAdapter(hat1));
        items.add(new HatAdapter(hat2));
        items.add(new HatAdapter(hat3));
        items.add(new HatAdapter(hat4));

        return items;
    }
}
