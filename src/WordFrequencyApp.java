public class WordFrequencyApp {
    public static void main(String[] args) {
        WordCounter counter = new WordCounter();

        counter.addText("Java is fun. Java, Python, and JAVA!");
        counter.addText("Python is great.");

        System.out.println("java: " + counter.getCount("java"));
        System.out.println("python: " + counter.getCount("Python"));
        System.out.println("rust: " + counter.getCount("rust"));
        System.out.println("Most frequent: " + counter.getMostFrequentWord());
        runTests();
    }

    // Manual tests: prints PASS or FAIL for each case
    public static void runTests() {
        System.out.println("\n--- Running tests ---");

        // Test 1: counting ignores uppercase/lowercase
        WordCounter c1 = new WordCounter();
        c1.addText("Hello hello HELLO");
        if (c1.getCount("hello") == 3) {
            System.out.println("Test 1 PASS: case-insensitive counting");
        } else {
            System.out.println("Test 1 FAIL: expected 3, got " + c1.getCount("hello"));
        }

        // Test 2: punctuation is ignored
        WordCounter c2 = new WordCounter();
        c2.addText("Hello, world!");
        if (c2.getCount("hello") == 1 && c2.getCount("world") == 1) {
            System.out.println("Test 2 PASS: punctuation is ignored");
        } else {
            System.out.println("Test 2 FAIL: hello=" + c2.getCount("hello") + ", world=" + c2.getCount("world"));
        }

        // Test 3: empty text has no most frequent word
        WordCounter c3 = new WordCounter();
        c3.addText("");
        if (c3.getMostFrequentWord() == null) {
            System.out.println("Test 3 PASS: empty text returns null");
        } else {
            System.out.println("Test 3 FAIL: expected null, got " + c3.getMostFrequentWord());
        }
    }
}