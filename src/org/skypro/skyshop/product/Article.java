package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable {

    protected final String title;
    protected final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String toString() {
        return title + "\n" + text;
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String getName() {
        //return toString();
        return title;
    }

    @Override
    public String getTypeContent() {
        return "ARTICLE";
    }

    @Override
    public String getStringRepresentation() {
        return getName() + " - " + getTypeContent();
    }
}
