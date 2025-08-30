package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return (int) (basePrice * (1 - (double) (discount / 100)));
    }

    @Override
    public String toString() {
        return this.getName() + ": " + this.getPrice() + " (" + this.discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}

