package org.skypro.skyshop.product;

public class FixPrice extends Product {
    private static final int FIX_PRICE = 200;

    public FixPrice(String name) {
        super(name);

    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return this.name + ": Фиксированная цена " + FIX_PRICE;
    }

    @Override
    public Boolean isSpecial() {
        return true;
    }
}
