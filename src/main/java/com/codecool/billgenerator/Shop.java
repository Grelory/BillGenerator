package com.codecool.billgenerator;

import java.util.*;

public class Shop {

    private Map<Integer, Item> availableItems;

    public Shop() {
        this.availableItems = new HashMap<>();
    }

    public void add(Item item) {
        if (availableItems.containsKey(item.getBARCODE())) throw new IllegalArgumentException();
        availableItems.put(item.getBARCODE(), item);
    }

    public boolean containsItemWith(int barcode) {
        return availableItems.containsKey(barcode);
    }

    public Optional<Item> getAvailableItemByBarCode(int barcode) {
        Item item = availableItems.get(barcode);
        if (item == null) return Optional.empty();
        return Optional.of(item);
    }

}
