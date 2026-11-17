public class WordFrequencyApp {
    public static void main(String[] args) {
        WordCounter counter = new WordCounter();

        counter.addText("Java is fun. Java, Python, and JAVA!");
        counter.addText("Python is great.");

        System.out.println("java: " + counter.getCount("java"));
        System.out.println("python: " + counter.getCount("Python"));
        System.out.println("rust: " + counter.getCount("rust"));
        System.out.println("Most frequent: " + counter.getMostFrequentWord());
    }
}