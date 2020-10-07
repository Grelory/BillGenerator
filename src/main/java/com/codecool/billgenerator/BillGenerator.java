package com.codecool.billgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class BillGenerator {

    private final int BARCODE_INDEX = 0;
    private final int NAME_INDEX = 1;
    private final int AMOUNT_INDEX = 2;
    private final int PRICE_INDEX = 3;
    private Shop shop = new Shop();
    private Basket basket = new Basket();

    public void loadItemsFromFile(String pathToFile) {
        try {
            Class<? extends BillGenerator> aClass = getClass();
            ClassLoader classLoader = aClass.getClassLoader();
            URL resource = classLoader.getResource(pathToFile);
            String file = resource.getFile();
            Scanner scanner = new Scanner(new File(file));
            if (scanner.hasNextLine()) scanner.nextLine();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                String[] line = s.split(", ");
                int barcode = Integer.parseInt(line[BARCODE_INDEX]);
                if (!shop.containsItemWith(barcode)) {
                    shop.add(new Item(barcode, line[NAME_INDEX]));
                }
                shop.getAvailableItemByBarCode(barcode)
                        .ifPresent(i -> i.setPrice(Integer.parseInt(line[AMOUNT_INDEX]),
                                    Float.parseFloat(line[PRICE_INDEX])));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }

    public void loadBasketFromFile(String pathToFile) {
        try {
            Class<? extends BillGenerator> aClass = getClass();
            ClassLoader classLoader = aClass.getClassLoader();
            URL resource = classLoader.getResource(pathToFile);
            String file = resource.getFile();
            Scanner scanner = new Scanner(new File(file));
            while (scanner.hasNextLine()) {
                int barcode = Integer.parseInt(scanner.nextLine());
                shop.getAvailableItemByBarCode(barcode).ifPresent(basket::add);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }

    public void generateBill() {
        basket.generateBill();
    }

}
