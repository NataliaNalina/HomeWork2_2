package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap;
    private int size;

    public ProductBasket() {
        productsMap = new TreeMap<>();
    }

    public void addProduct(Product newProduct) {
        List<Product> products = new ArrayList<>();
        if (productsMap.containsKey(newProduct.getName())) {
            products = productsMap.get(newProduct.getName());
        }
        products.add(newProduct);
        productsMap.put(newProduct.getName(), products);
        size += 1;

    }

    public int getTotalCostBasket() {
        int totalCost = 0;
        for (Map.Entry<String, List<Product>> entry : productsMap.entrySet()) {
            List<Product> products = entry.getValue();
            for (Product product : products) {
                if (product != null) {
                    totalCost += product.getPrice();
                }
            }
        }
        return totalCost;
    }

    public int getQuantitySpecialProduct() {
        int counter = 0;
        for (Map.Entry<String, List<Product>> entry : productsMap.entrySet()) {
            List<Product> products = entry.getValue();
            for (Product product : products) {
                if (product != null && product.isSpecial()) {
                    counter += 1;
                }
            }
        }
        return counter;
    }

    public void printProductBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто.");
        }
        for (Map.Entry<String, List<Product>> entry : productsMap.entrySet()) {
            List<Product> products = entry.getValue();
            for (Product product : products) {
                if (product != null) {
                    System.out.println(product);
                }
            }

        }
        System.out.println("Стоимость корзины: " + getTotalCostBasket());
        System.out.println("Специальных товров: " + getQuantitySpecialProduct());
    }

    public boolean findProduct(String productName) {
        for (Map.Entry<String, List<Product>> entry : productsMap.entrySet()) {
            String nameProduct = entry.getKey();
            if (nameProduct.equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        productsMap.clear();
    }

    public ArrayList<Product> deleteFromBasket(String productName) {
        ArrayList<Product> deleteProducts = new ArrayList<Product>();
        Iterator<Map.Entry<String, List<Product>>> iterator = productsMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Product>> entry = iterator.next();
            String nameProduct = entry.getKey();
            if (nameProduct.equals(productName)) {
                List<Product> products = entry.getValue();
                deleteProducts.addAll(products);
                iterator.remove();
            }
        }

        if (deleteProducts.isEmpty()) {
            System.out.println("Список пуст");
        }
        return deleteProducts;
    }
}
