package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final Map<String, Searchable> searchableItems;

    public SearchEngine(int size) {
        searchableItems = new TreeMap<>();
    }

    public void add(Searchable item) {
        searchableItems.put(item.getName(), item);
    }

    public Map<String, Searchable> search(String term) {
        int resultCount = 0;
        Map<String, Searchable> results = new TreeMap<>();
        for (Map.Entry<String, Searchable> entry : searchableItems.entrySet()) {

            if (entry.getValue().searchTerm().contains(term)) {
                results.put(entry.getKey(), entry.getValue());
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
        for (Searchable item : searchableItems.values()) {
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
