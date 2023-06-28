import java.util.ArrayList;

public class MyHashMap<K, V> {
    private int size;
    private ArrayList<ArrayList<Pair<K, V>>> customMap;

    public MyHashMap() {
        size = 6;
        customMap = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            customMap.add(null);
        }
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode() % size);
    }

    public boolean put(K key, V value) {
        int hash = getHash(key);
        ArrayList<Pair<K, V>> bucket = customMap.get(hash);

        if (bucket == null) {
            bucket = new ArrayList<>();
            customMap.set(hash, bucket);
        }

        for (Pair<K, V> pair : bucket) {
            if (pair.getKey().equals(key)) {
                pair.setValue(value);
                return true;
            }
        }

        bucket.add(new Pair<>(key, value));
        return true;
    }

    public boolean containsKey(K key) {
        int hash = getHash(key);
        ArrayList<Pair<K, V>> bucket = customMap.get(hash);

        if (bucket != null) {
            for (Pair<K, V> pair : bucket) {
                if (pair.getKey().equals(key)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isEmpty() {
        for (ArrayList<Pair<K, V>> bucket : customMap) {
            if (bucket != null && !bucket.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public ArrayList<V> getAllValues() {
        ArrayList<V> values = new ArrayList<>();

        for (ArrayList<Pair<K, V>> bucket : customMap) {
            if (bucket != null) {
                for (Pair<K, V> pair : bucket) {
                    values.add(pair.getValue());
                }
            }
        }

        return values;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for (ArrayList<Pair<K, V>> bucket : customMap) {
            if (bucket != null) {
                for (Pair<K, V> pair : bucket) {
                    sb.append("\t").append(pair.getKey()).append(" => ").append(pair.getValue()).append(",\n");
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }
    public void replace(K key,V oldValue,V newValue) {
        int hash = getHash(key);
        ArrayList<Pair<K, V>> bucket = customMap.get(hash);

        if (bucket != null) {
            for (Pair<K, V> pair : bucket) {
                if (pair.getKey().equals(key) & pair.getValue().equals(oldValue)) {
                    pair.setValue(newValue);
                }
            }
        }
    }
}