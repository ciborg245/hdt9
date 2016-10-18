import java.util.HashMap;

public class OwnHashMap<K,V> implements Map<K,V> {

    HashMap<K,V> hm;

    public OwnHashMap () {
        hm = new HashMap<>();
    }

    @Override
    public void put(K key, V value) {
        hm.put(key, value);
    }

    @Override
    public V get(K key) {
        return hm.get(key);
    }
}
