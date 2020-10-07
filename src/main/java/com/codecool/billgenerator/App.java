package com.codecool.billgenerator;

public class App {
    public static void main( String[] args ) {
        BillGenerator billGenerator = new BillGenerator();
        billGenerator.loadItemsFromFile(args[0]);
        billGenerator.loadBasketFromFile(args[1]);
        billGenerator.generateBill();

    }
}
