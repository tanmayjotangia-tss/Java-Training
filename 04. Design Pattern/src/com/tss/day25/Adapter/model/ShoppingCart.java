package com.tss.day25.Adapter.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<IItems> itemsList;

    public ShoppingCart() {
        this.itemsList = new ArrayList<>();
    }

    public List<IItems> getItemsList() {
        return itemsList;
    }
}
