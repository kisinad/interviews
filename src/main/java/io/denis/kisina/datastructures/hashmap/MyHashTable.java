package io.denis.kisina.datastructures.hashmap;

import java.util.LinkedList;

class MyHashTable implements IMyHashTable{
    private static final int INITIAL_SIZE = 20;
    private int tableSize;
    private LinkedList[] table;

    public MyHashTable() {
        this(INITIAL_SIZE);
    }

    public MyHashTable(int tableSize) {
        this.tableSize = tableSize;
        table = new LinkedList[tableSize];
    }

    public void put(Object key, Object value) {
        if(key == null){return;}

        int hashcode = key.hashCode();

        Entry e = new Entry(key, value);

        boolean keyAlreadyInUse = false;

        if(table[hashcode] != null) {
            for(Object ob: table[hashcode]){
                Entry ent = (Entry)ob;
                if(ent.key.equals(key)){
                    keyAlreadyInUse = true;
                    ent.value = value;
                }
            }
        }

        if(!keyAlreadyInUse){
            if(table[hashcode] == null){
                table[hashcode] = new LinkedList();
            }
            table[hashcode].add(e);
        }

    }

    private class Entry {

        private Object key;
        private Object value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
