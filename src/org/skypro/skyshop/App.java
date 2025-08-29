package org.skypro.skyshop;

import java.util.Arrays;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.search.SearchEngine;


public class App {
    public static void main(String[] args) {
        SimpleProduct milk = new SimpleProduct("milk", 80);
        SimpleProduct fish = new SimpleProduct("fish", 200);
        SimpleProduct fishFroze = new SimpleProduct("fish froze", 200);
        DiscountedProduct corn = new DiscountedProduct("corn", 120, 15);
        SimpleProduct eggs = new SimpleProduct("eggs", 140);
        FixPrice lemon = new FixPrice("lemon");
        SimpleProduct orange = new SimpleProduct("orange", 100);

        ProductBasket basketIvanovI = new ProductBasket();
        basketIvanovI.addProduct(milk);
        basketIvanovI.addProduct(fish);
        basketIvanovI.addProduct(eggs);
        basketIvanovI.addProduct(lemon);
        basketIvanovI.addProduct(corn);
        basketIvanovI.addProduct(lemon);

        basketIvanovI.printProductBasket();

        System.out.println("Товар: " + corn.getName() + " в корзине " + basketIvanovI.findProduct(corn.getName()));
        System.out.println("Товар: " + orange.getName() + " в корзине " + basketIvanovI.findProduct(orange.getName()));

        basketIvanovI.clearBasket();
        basketIvanovI.printProductBasket();
        System.out.println("Товар: " + corn.getName() + " в корзине " + basketIvanovI.findProduct(corn.getName()));

        Article Art1 = new Article("fish", " big fish");
        Article Art2 = new Article("encapsulation", " It is one of the main directions of object-oriented programming (OOP). fish");
        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(milk);
        searchEngine.add(fish);
        searchEngine.add(fishFroze);
        searchEngine.add(lemon);
        searchEngine.add(Art1);
        searchEngine.add(Art2);

        System.out.println(fish.getStringRepresentation());
        System.out.println(Art2.getStringRepresentation());

        System.out.println(Arrays.toString(searchEngine.search("fish")));

    }
}
