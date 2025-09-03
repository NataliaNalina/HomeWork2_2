package org.skypro.skyshop.search;

import java.util.ArrayList;

public class SearchEngine {
    private final ArrayList<Searchable> searchableItems;
    private int count = 0;

    public SearchEngine(int size) {
        searchableItems = new ArrayList<Searchable>();
    }

    public void add(Searchable item) {
        searchableItems.add(item);
        count++;

    }

    public ArrayList<Searchable> search(String term) {
        ArrayList<Searchable> results = new ArrayList<Searchable>();
        int resultCount = 0;

        for (Searchable item : searchableItems) {
            if (item != null && item.searchTerm().contains(term)) {
                results.add(item);
                resultCount++;
            }
        }
        return results;
    }

    public Searchable findBestMatch(String term) throws BestResultNotFound {

        Searchable bestResults = null;
        int found = 0;
        if (term.isBlank()) {
            throw new BestResultNotFound("Для пустой строки нет совпадений.");
        }
        for (Searchable item : searchableItems) {
            if (item != null) {
                String str = item.searchTerm().toLowerCase();
                int score = 0;
                int index = 0;
                while ((index = str.indexOf(term.toLowerCase(), index)) != -1) {
                    score++;
                    index++;
                }
                if (score > found) {
                    found = score;
                    bestResults = item;
                }
            }
        }

        if (bestResults == null) {
            throw new BestResultNotFound("Для строки " + term + " совпадений нет.");
        } else {
            System.out.println("Нашли лучший объект -" + bestResults.getStringRepresentation());
        }
        return bestResults;
    }
}
