package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductBasket {
    private final ArrayList <Product> products;
    private int size;

    public ProductBasket() {
        this.products = new ArrayList <Product>();
    }

    public void addProduct(Product newProduct) {

        products.add(newProduct);
        size++;
    }

    public int getTotalCostBasket() {
        int totalCost = 0;
        for (Product product : products) {
            if (product != null) {
                totalCost += product.getPrice();
            }
        }
        return totalCost;
    }

    public int getQuantitySpecialProduct() {
        int counter = 0;
        for (Product product : products) {
            if (product != null && product.isSpecial()) {
                counter += 1;
            }
        }
        return counter;
    }

    public void printProductBasket() {
        if (size == 0) {
            System.out.println("В корзине пусто.");
        }
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
            }
        }
        System.out.println("Стоимость корзины: " + getTotalCostBasket());
        System.out.println("Специальных товров: " + getQuantitySpecialProduct());

    }

    public boolean findProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (Product product : products) {
            product = null;
        }
        size = 0;
    }

    public ArrayList<Product> deleteFromBasket(String productName) {
        Iterator<Product> iterator = products.iterator();
        ArrayList<Product> deleteProducts = new ArrayList<Product>();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(productName)) {
                deleteProducts.add(product);
                iterator.remove();
            }
        }
        if (deleteProducts.isEmpty()){
            System.out.println("Список пуст");
        }
        return deleteProducts;
    }
}
