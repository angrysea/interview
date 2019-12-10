package org.interview.trees;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Trie {

    static class TrieNode {
        static final int ALPHABET_SIZE = 'z' - 'a' + 1;
        final List<TrieNode> children;
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            Supplier<TrieNode> getNull = () -> null;
            children = Stream.generate(getNull)
                    .limit(ALPHABET_SIZE)
                    .collect(Collectors.toList());
        }

        TrieNode get(final int index) {
            return children.get(index);
        }

        TrieNode has(final int index) {
            TrieNode child = children.get(index);
            if (child == null) {
                child = new TrieNode();
                children.set(index, child);
            }
            return child;
        }
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(final String word) {
        TrieNode crawler = root;
        for (char c : word.toCharArray()) {
            crawler = crawler.has(c - 'a');
        }
        crawler.isEndOfWord = true;
    }

    public boolean search(final String word) {
        TrieNode crawler = root;
        for (char c : word.toCharArray()) {
            crawler = crawler.get(c - 'a');
            if (crawler == null) {
                return false;
            }
        }
        return crawler.isEndOfWord;
    }

    public static void main(String[] args) {
        Trie dictionary = new Trie();
        final String filename = "/Users/graffeoa/workspace/data/kingjames.txt";
        String largestWord = "";
        int largest = 0;

        var start = Instant.now();
        try (Scanner scanner = new Scanner(new File(filename))) {
            int value = 0;
            while (scanner.hasNext()) {
                String line = scanner.next();
                line = line.replaceAll("[^a-zA]", "").toLowerCase();
                if(!line.isEmpty()) {
                    try {
                        if (line.length() > largest) {
                            largest = line.length();
                            largestWord = line;
                        }
                        dictionary.insert(line);
                        value++;
                    }
                    catch(IndexOutOfBoundsException e) {
                        System.out.println(line);
                        System.out.println(e.getMessage());
                    }
                }
            }
            System.out.println("Number of words stored: " + value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        var finish = Instant.now();
        var timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Milli seconds to load book: " + timeElapsed);

        start = Instant.now();
        System.out.println("Key's: David value is " + dictionary.search("david"));
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toNanos();
        System.out.println("Nanos seconds to find: " + timeElapsed);

        start = Instant.now();
        System.out.println("Key's: Lion value is " + dictionary.search("lion"));
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toNanos();
        System.out.println("Nanos seconds to find: " + timeElapsed);

        start = Instant.now();
        System.out.println("Key's: heaven value is " + dictionary.search("heaven"));
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toNanos();
        System.out.println("Nanos seconds to find: " + timeElapsed);

        start = Instant.now();
        System.out.println("Key's: " + largestWord + " value is " + dictionary.search(largestWord));
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toNanos();
        System.out.println("Nanos seconds to find: " + timeElapsed);
    }
}
