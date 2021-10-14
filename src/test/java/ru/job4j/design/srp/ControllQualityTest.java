package ru.job4j.design.srp;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ControllQualityTest {
    @Test
    public void testSortProducts() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        List<Food> products = new ArrayList<>();
        Food apple1 = new Apple("red apple", dateFormat.parse("10.06.2021"), dateFormat.parse("10.12.2021"), 30.0, 0.0);
        Food apple2 = new Apple("green apple", dateFormat.parse("11.09.2021"), dateFormat.parse("15.09.2021"), 15.0, 0.0);
        Food milk = new Milk("milk", dateFormat.parse("01.08.2020"), dateFormat.parse("10.10.2021"), 55.0, 0.0);
        Food blackBread = new Bread("black bread", dateFormat.parse("20.08.2021"), dateFormat.parse("13.09.2021"), 33.0, 0.0);
        Food whiteBread = new Bread("whiteBread", dateFormat.parse("01.09.2021"), dateFormat.parse("19.09.2021"), 60.0, 0.0);
        Food milk2 = new Milk("milk2", dateFormat.parse("01.09.2021"), dateFormat.parse("12.09.2021"), 40.0, 0.0);
        Food milk3 = new Milk("milk3", dateFormat.parse("13.09.2021"), dateFormat.parse("12.12.2021"), 20.0, 0.0);
        Food apple3 = new Apple("super apple", dateFormat.parse("10.05.2021"), dateFormat.parse("10.12.2021"), 10.0, 0.0);

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
        List storageStore = new ArrayList<>(List.of(warehouse, shop, trash));
        ControllQuality controllQuality = new ControllQuality(storageStore);
        controllQuality.sortProducts(products);

        assertThat(warehouse.getProducts().size(), is(3));
        assertThat(warehouse.getProducts().get(0).getName(), is("red apple"));
        assertThat(warehouse.getProducts().get(1).getName(), is("super apple"));
        assertThat(warehouse.getProducts().get(2).getName(), is("milk3"));
        assertThat(whiteBread.getPrice(), is(60.0));
        assertThat(whiteBread.getDiscount(), is(0.0));
    }
}