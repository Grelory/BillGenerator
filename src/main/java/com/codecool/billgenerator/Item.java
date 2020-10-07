package com.codecool.billgenerator;

import java.util.*;

public class Item {

    private final int BARCODE;
    private String name;
    private Map<Integer, Float> amountPrice = new HashMap();

    public Item(int BARCODE, String name) {
        this.BARCODE = BARCODE;
        this.name = name;
    }

    public int getBARCODE() {
        return BARCODE;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return amountPrice.get(1);
    }

    public void setPrice(int amount, float price) {
        amountPrice.put(amount, price);
    }

    public float calculateDiscount(int numberOfProducts) {
        return numberOfProducts * getPrice() - calculateChargeForAmountOfProduct(numberOfProducts);
    }

    public float calculateChargeForAmountOfProduct(int amount) {
        List<Integer> keys = new ArrayList<>(amountPrice.keySet());
        keys.sort(Comparator.reverseOrder());
        float charge = 0;
        for (int key : keys) {
            while (amount >= key) {
                charge += amountPrice.get(key);
                amount -= key;
            }
        }
        return charge;
    }

}
