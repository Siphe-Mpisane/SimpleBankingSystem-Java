package model;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K, V> {
    private Node<K, V>[] buckets;
    private int size = 16;

    public MyHashMap() {
        buckets = new Node[size];
    }

    //Hash functions
    private int getIndex(K key) {
        return (key.hashCode() & 0x7fffffff) % size;
    }


    //Insert
    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> current = buckets[index];

        if (current == null) {
            buckets[index] = new Node<>(key, value);
            return;
        }

        //Navigate list
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            if (current.next == null) {
                break;
            }
            current = current.next;
        }
        //adding new entry at the end
        current.next = new Node<>(key, value);

    }

    //Get (search)
    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    //Remove
    public void remove(K key) {
        int index = getIndex(key);
        Node<K, V> current = buckets[index];
        Node<K, V> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    buckets[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        Node<K, V> current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public List<V> values(){
        List<V> valuesList= new ArrayList<>();

        for (int i=0;i<buckets.length;i++)
        {
            Node<K,V> current = buckets[i];
            while (current!=null){
                valuesList.add(current.value);
                current=current.next;
            }
        }
        return valuesList;
    }
}
