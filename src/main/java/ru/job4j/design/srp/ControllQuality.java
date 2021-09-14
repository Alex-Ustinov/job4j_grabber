package ru.job4j.design.srp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ControllQuality {

    private List<Storage> storages;

    ControllQuality (List<Storage> storages) {
        this.storages = storages;
    }

    public List<Storage> getStorages() {
        return storages;
    }

    public void sortProducts (List<Food> products) {
        for (Food product : products) {
            for (Storage storage : storages) {
                storage.addProduct(product);
            }
        }
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        List<Food> products = new ArrayList<>();
        Food apple1 = new Apple("red apple", dateFormat.parse("10.06.2021"), dateFormat.parse("10.12.2021"), 10.0, 15);
        Food apple2 = new Apple("green apple", dateFormat.parse("11.09.2021"), dateFormat.parse("15.09.2021"), 15.0, 20);
        Food milk = new Milk("milk", dateFormat.parse("01.08.2020"), dateFormat.parse("10.10.2021"), 10.0, 44);
        Food blackBread = new Bread("black bread", dateFormat.parse("20.08.2021"), dateFormat.parse("13.09.2021"), 33.0, 10);
        Food whiteBread = new Bread("whiteBread", dateFormat.parse("03.09.2021"), dateFormat.parse("30.09.2021"), 10.0, 50);
        Food milk2 = new Milk("milk2", dateFormat.parse("01.09.2021"), dateFormat.parse("12.09.2021"), 10.0, 50);
        Food milk3 = new Milk("milk3", dateFormat.parse("13.09.2021"), dateFormat.parse("12.12.2021"), 10.0, 50);
        Food apple3 = new Apple("super apple", dateFormat.parse("10.05.2021"), dateFormat.parse("10.12.2021"), 10.0, 50);
        products.add(apple1);
        products.add(apple2);
        products.add(apple3);
        products.add(milk2);
        products.add(milk);
        products.add(blackBread);
        products.add(whiteBread);
        products.add(milk3);
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();


        ControllQuality controllQuality = new ControllQuality(
                new ArrayList<>(List.of(warehouse, shop, trash))
        );
        controllQuality.sortProducts(products);

        System.out.println(" warehouse " + warehouse.getProducts().size());
        System.out.println(" shop " + shop.getProducts().size());
        System.out.println(" trash " + trash.getProducts().size());

    }
}
