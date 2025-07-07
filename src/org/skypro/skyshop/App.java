package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product milk = new Product("milk", 80);
        Product fish = new Product("fish", 200);
        Product corn = new Product("corn", 120);
        Product eggs = new Product("eggs", 140);
        Product lemon = new Product("lemon", 60);
        Product orange = new Product("orange", 100);

        ProductBasket basketIvanovI = new ProductBasket();
        basketIvanovI.addProduct(milk);
        basketIvanovI.addProduct(fish);
        basketIvanovI.addProduct(eggs);
        basketIvanovI.addProduct(lemon);
        basketIvanovI.addProduct(corn);
        basketIvanovI.addProduct(lemon);

        basketIvanovI.printProductBasket();

        System.out.println("Товар: "+ corn.getName() + " в корзине " +basketIvanovI.findProduct(corn.getName()));
        System.out.println("Товар: "+ orange.getName() + " в корзине " +basketIvanovI.findProduct(orange.getName()));

        basketIvanovI.clearBasket();
        basketIvanovI.printProductBasket();
        System.out.println("Товар: "+ corn.getName() + " в корзине " +basketIvanovI.findProduct(corn.getName()));

    }
}
