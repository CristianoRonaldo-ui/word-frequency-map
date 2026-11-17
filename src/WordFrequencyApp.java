public class WordFrequencyApp {
    public static void main(String[] args) {
        WordCounter counter = new WordCounter();

        counter.addWord("Java");
        counter.addWord("java");
        counter.addWord("Python");

        System.out.println("java: " + counter.getCount("java"));
        System.out.println("python: " + counter.getCount("Python"));
        System.out.println("rust: " + counter.getCount("rust"));
    }
}