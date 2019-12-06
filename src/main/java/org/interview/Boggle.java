package org.interview;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class Boggle {
    static class Trie {

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

        private final TrieNode root = new TrieNode();

        Trie() {
        }

        void insert(final String word) {
            TrieNode crawler = root;
            for (char c : word.toCharArray()) {
                crawler = crawler.has(c - 'a');
            }
            crawler.isEndOfWord = true;
        }

        boolean search(final String word) {
            TrieNode crawler = root;
            for (char c : word.toCharArray()) {
                crawler = crawler.get(c - 'a');
                if (crawler == null) {
                    return false;
                }
            }
            return true;
        }

        TrieNode next(TrieNode node, final char c) {
            return node.get(c - 'a');
        }
    }

    private int N;
    private char[][] board;
    private boolean[][] visited;
    private final Trie dictionary = new Trie();

    public Boggle(int N) {
        this.N = N;
        visited = new boolean[N][N];
        generateBoard();
    }

    public Boggle(char[][] board) {
        this.N = board.length;
        visited = new boolean[N][N];
        this.board = board;
    }

    private void generateBoard() {
        board = new char[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = (char) (Math.random() * 26 + 'a');
    }

    private final static String filename = "/Users/graffeoa/workspace/data/words.txt";

    void loadDictionary() {
        var start = Instant.now();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    try {
                        if(line.length() > 3) {
                            dictionary.insert(line);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(line);
                        System.out.println(e.getMessage());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void showWords() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dfs(dictionary.root, "", i, j);
            }
        }
    }

    List<String> words = new LinkedList<>();

    private void dfs(Trie.TrieNode node, String prefix, int i, int j) {
        // Check to see if you fall off the board.
        if (i < 0 || j < 0 || i >= N || j >= N) {
            return;
        }

        if (visited[i][j] == true) {
            return;
        }

        Trie.TrieNode next = dictionary.next(node, board[i][j]);
        if(next == null) {
            return;
        }

        prefix = prefix + board[i][j];

        visited[i][j] = true;

        if(next.isEndOfWord && prefix.length() > 2) {
            words.add(prefix);
        }

        for (int ii = -1; ii <= 1; ii++) {
            for (int jj = -1; jj <= 1; jj++) {
                dfs(next, prefix, i + ii, j + jj);
            }
        }

        visited[i][j] = false;
    }

    void printFoundWords() {
        words.stream().forEach(System.out::println);
    }
    public String toString() {
        String s = "";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s = s + board[i][j] + " ";
            }
            s = s + "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        Boggle b = new Boggle(24);
        b.loadDictionary();
        System.out.println(b);
        b.showWords();
        b.printFoundWords();
    }

    private static void fixedTest() {
        int row = 4, col = 4;
        char[][] board = new char[row][col];

        board[0][0] = 'g';
        board[0][1] = 'u';
        board[0][2] = 'h';
        board[0][3] = 'l';

        board[1][0] = 'o';
        board[1][1] = 'm';
        board[1][2] = 's';
        board[1][3] = 'i';

        board[2][0] = 't';
        board[2][1] = 'b';
        board[2][2] = 'o';
        board[2][3] = 'w';

        board[3][0] = 'a';
        board[3][1] = 'n';
        board[3][2] = 'g';
        board[3][3] = 'f';

        Boggle b = new Boggle(board);
        b.loadDictionary();
        System.out.println(b);
        b.showWords();
        b.printFoundWords();
    }
}
