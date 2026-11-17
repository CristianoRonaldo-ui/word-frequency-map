# Word Frequency Map

A Java program that counts how often each word appears in a text using `HashMap`, and reports the most frequent word.

## Features

- Counts words **case-insensitively** ("Java", "java", "JAVA" are the same word)
- **Ignores punctuation** ("java," and "java!" count as "java")
- Finds the **most frequent word** by iterating over the map's entries
- Handles empty input safely (returns `null` instead of crashing)
- Manual PASS/FAIL tests for edge cases

## Project Structure

```
word-frequency-map/
├── .gitignore
├── src/
│   ├── WordCounter.java       # Core logic: HashMap<String, Integer> word counts
│   └── WordFrequencyApp.java  # Entry point: demo + manual tests
└── README.md
```

## How to Run

Requires Java (JDK 17+ recommended).

```bash
javac src/*.java
java -cp src WordFrequencyApp
```

## Example Output

```
java: 3
python: 2
rust: 0
Most frequent: java

--- Running tests ---
Test 1 PASS: case-insensitive counting
Test 2 PASS: punctuation is ignored
Test 3 PASS: empty text returns null
```

## Complexity Analysis

| Method | Time | Notes |
|---|---|---|
| `addWord(word)` | O(1) average | One `HashMap` lookup + one insert |
| `getCount(word)` | O(1) average | One `HashMap` lookup |
| `addText(text)` | O(n) | n = number of characters in the text |
| `getMostFrequentWord()` | O(k) | k = number of unique words; must scan every entry |

Space: O(k) to store one entry per unique word.

## What I Learned

- **HashMap vs. array:** In an earlier project I counted letters with `int[26]` because there are exactly 26 letters. Words have no fixed set, so a `HashMap<String, Integer>` is the right tool — it grows as new keys appear.
- **`Integer` vs. `int`:** Generics only accept objects, so the map uses `Integer` (wrapper class). Java converts between `int` and `Integer` automatically (autoboxing/unboxing).
- **`getOrDefault` prevents crashes:** `counts.get(word) + 1` throws a `NullPointerException` the first time a word is seen, because `get` returns `null`. `getOrDefault(word, 0)` avoids that.
- **Escaping in regex:** In a Java string, `\s` must be written as `"\\s"`, because the backslash itself needs escaping.
- **Iterating a map:** Java has no `for key, value in dict.items()`. Instead, each loop step gives one `Map.Entry` object with `getKey()` and `getValue()`.
- **HashMap has no order:** If two words tie for most frequent, which one is returned is not guaranteed.

## Python ↔ Java Cheat Sheet

| Python `dict` | Java `HashMap` |
|---|---|
| `counts = {}` | `HashMap<String, Integer> counts = new HashMap<>();` |
| `counts[k] = v` | `counts.put(k, v)` |
| `counts.get(k, 0)` | `counts.getOrDefault(k, 0)` |
| `for k, v in counts.items():` | `for (Map.Entry<String, Integer> e : counts.entrySet())` |
| `len(counts)` | `counts.size()` |