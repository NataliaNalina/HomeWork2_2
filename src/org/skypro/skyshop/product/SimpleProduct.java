package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    public String getSearchTerm() {
        return super.searchTerm();
    }

    @Override
    public String getStringRepresentation() {
        return getName() + " - " + super.getTypeContent();
    }

}
