package com.codecool.billgenerator;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Basket {

    private Map<Integer, Item> items;
    private Map<Integer, Integer> numbersOfItems;

    public Basket() {
        this.items = new HashMap<>();
        this.numbersOfItems = new HashMap<>();
    }

    public void add(Item item) {
        if (items.containsKey(item.getBARCODE())) {
            numbersOfItems.put(item.getBARCODE(), numbersOfItems.get(item.getBARCODE()) + 1);
            return;
        }
        items.put(item.getBARCODE(), item);
        numbersOfItems.put(item.getBARCODE(), 1);

    }

    public void generateBill() {
        System.out.printf("\t|%-10s|%-10s|%-10s|%-10s|%-10s\n", "name",
                "amount", "price", "discount", "total");
        Set<Integer> keys = items.keySet();
        float totalBillCharge = 0;
        for (Integer key : keys) {
            Item item = items.get(key);
            Integer amount = numbersOfItems.get(key);
            float totalPrice = item.calculateChargeForAmountOfProduct(amount);
            System.out.printf("\t|%-10s|%-10d|%-10.2f|%-10.2f|%-10.2f\n", item.getName(), amount,
                    item.getPrice(), item.calculateDiscount(amount), totalPrice);
            totalBillCharge += totalPrice;
        }
        System.out.printf("The total price is: %.2f EUR\n", totalBillCharge);
    }

}
