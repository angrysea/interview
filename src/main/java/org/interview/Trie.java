package org.interview;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Trie {

    static class TrieNode {

        static final int ALPHABET_SIZE = 26;
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

    Trie() {
        root = new TrieNode();
    }

    void insert(final String word) {
        TrieNode crawler = root;
        for (char c : word.toCharArray()) {
            crawler = crawler.has(c - 'a');
        }
        crawler.isEndOfWord = true;
    }

//    boolean search(final String word) {
//        word.chars().mapToObj(ch -> (char)ch)
//
//    }

    boolean search(final String word) {
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
        final String[] words = {"this", "th", "is", "famous", "word", "break",
                "b", "r", "e", "a", "k", "br", "bre", "brea", "ak", "problem"};
        Trie dictionary = new Trie();
        Arrays.stream(words).forEach(dictionary::insert);

        List<Boolean> results = Arrays.stream(words)
                .map(dictionary::search)
                .collect(Collectors.toList());

        results.add(dictionary.search("abscent"));

        results.forEach(System.out::println);
    }
}
