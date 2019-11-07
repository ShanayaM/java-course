package main.java.space.harbour.java.hw3;

import java.util.Map;

public final class Element<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;

    public Element(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(final V value) {
        this.value = value;
        return this.value;
    }
}
