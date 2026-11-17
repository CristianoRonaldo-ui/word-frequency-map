import java.util.HashMap;

public class WordCounter {
    private HashMap<String, Integer> counts;

    public WordCounter() {
        counts = new HashMap<>();
    }

    // Adds one occurrence of a word to the map
    public void addWord(String word) {
        String key = word.toLowerCase();
        counts.put(key, counts.getOrDefault(key, 0) + 1);
    }

    // Splits a full text into words and counts each one
    public void addText(String text) {
        String cleaned = text.replaceAll("[^a-zA-Z\\s]", " ");
        String[] words = cleaned.trim().split("\\s+");

        for (String word : words) {
            if (!word.isEmpty()) {
                addWord(word);
            }
        }
    }

    // Returns how many times a word appears (0 if never seen)
    public int getCount(String word) {
        return counts.getOrDefault(word.toLowerCase(), 0);
    }
}