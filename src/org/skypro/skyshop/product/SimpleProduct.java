package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена продукта должна быть больше 0!. Введите цену для " + name);
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.getName() + ": " + this.getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
