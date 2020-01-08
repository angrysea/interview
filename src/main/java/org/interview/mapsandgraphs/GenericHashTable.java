package org.interview.mapsandgraphs;

import org.interview.lists.LinkedList;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Iterator;
import java.util.Scanner;

public class GenericHashTable<K, V> {
    static class GenericEntry<K, V> {
        private K key;
        private V value;

        GenericEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private int size = (int)Math.round(Math.pow(2, 9));

    private LinkedList<GenericEntry<K, V>>[] entries;

    private GenericHashTable() {
        entries = new LinkedList[size];
    }

    private int hash(K key) {
        int hashValue = 0;
        if ((key != null)) {
            hashValue =  key.hashCode() ^ (hashValue >>> 16);
            hashValue = hashValue & (size - 1);
        }
        return hashValue;
    }

    V get(K key) {
        LinkedList<GenericEntry<K, V>> list = entries[hash(key)];
        if(list != null) {
            final Iterator<GenericEntry<K, V>> it = list.listIterator();
            while(it.hasNext()) {
                GenericEntry<K, V> entry = it.next();
                if(key.equals(entry.getKey())) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    void put(K key, V value) {
        int hashCode = hash(key);
        if(entries[hashCode] == null) {
            entries[hashCode] = new LinkedList<>();
        }

        final Iterator<GenericEntry<K, V>> it = entries[hashCode].listIterator();
        while(it.hasNext()) {
            GenericEntry<K, V> entry = it.next();
            if(key.equals(entry.getKey())) {
                entry.setValue(value);
                return;
            }
        }

        GenericEntry<K, V> entry = new GenericEntry<>(key, value);
        entries[hashCode].add(entry);
    }

    public static void main(String[] args) {
        GenericHashTable<String, Integer> map = new GenericHashTable<>();
        final String key = "The";
        String largestWord = null;
        int largest = 0;

        final String filename = "D:\\workspace\\interview\\data\\kingjames.txt";
//        final String filename = "/Users/graffeoa/workspace/data/kingjames.txt";
        try (Scanner scanner = new Scanner(new File(filename))) {
            int value = 0;
            while (scanner.hasNext()) {
                String line = scanner.next();
                if (line.length() > largest) {
                    largest = line.length();
                    largestWord = line;
                }
                map.put(line, value++);
            }
            System.out.println("Number of words stored: " + value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Instant start = Instant.now();
        System.out.println("Key's: " + key + " value is " + map.get(key));
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Milli seconds to find: " + timeElapsed);

        System.out.println("Key's: " + largestWord + " value is " + map.get(largestWord));
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Milli seconds to find: " + timeElapsed);

        System.out.println("Key's: David value is " + map.get("David"));
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Milli seconds to find: " + timeElapsed);

        System.out.println("Key's: Lion value is " + map.get("Lion"));
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Milli seconds to find: " + timeElapsed);

        System.out.println("Key's: Lion value is " + map.get("heaven"));
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Milli seconds to find: " + timeElapsed);
    }
}
