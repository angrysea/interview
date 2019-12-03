package org.interview;

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
    }

    private int size = 64;

    private GenericEntry<K, V>[] entries;

    private GenericHashTable() {
        entries = new GenericEntry[size];
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
        return entries[hash(key)].value;
    }

    void put(K key, V value) {
        GenericEntry<K, V> entry = new GenericEntry<K, V>(key, value);
        int hashCode = hash(key);
        entries[hashCode] = entry;
    }

    public static void main(String[] args) {
        GenericHashTable<String, Integer> map = new GenericHashTable<>();
        map.put("Test", 1);
        System.out.println(map.get("Test"));
    }
}
