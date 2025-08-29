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
        return this.name + ": " + this.getPrice() + " (" + this.discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public String getSearchTerm() {
        return super.searchTerm();
    }

    @Override
    public String getStringRepresentation() {
        return getName() + " - " + super.getTypeContent();
    }
}

