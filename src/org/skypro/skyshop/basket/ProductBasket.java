package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;
    private int size;

    public ProductBasket() {
        this.products = new Product[5];
    }

    public void addProduct(Product newProduct) {
        if (size >= products.length) {
            System.out.println("Корзина полна. Невозможно добавить продукт.");
            return;
        }
        products[size++] = newProduct;
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
        for (int i = 0; i < size; i++) {
            Product product = products[i];
            if (product.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < size; i++) {
            products[i] = null;
        }
        size = 0;
    }
}
