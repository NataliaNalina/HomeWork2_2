package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPrice;

public class App {
    public static void main(String[] args) {
        SimpleProduct milk = new SimpleProduct("milk", 80);
        SimpleProduct fish = new SimpleProduct("fish", 200);
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

    }
}
