package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] searchableItems;
    private int count = 0;

    public SearchEngine(int size) {
        searchableItems = new Searchable[size];
    }

    public void add(Searchable item) {
        if (count < searchableItems.length) {
            searchableItems[count++] = item;
        }
    }

    public Searchable[] search(String term) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;

        for (Searchable item : searchableItems) {
            if (item != null && item.searchTerm().contains(term)) {
                if (resultCount < results.length) {
                    results[resultCount++] = item;
                } else {
                    break;
                }
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
