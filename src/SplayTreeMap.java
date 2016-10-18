public class SplayTreeMap<K extends Comparable<K>,V> implements Map<K,V> {

    SplayTree<K,V> splayTree;

    public SplayTreeMap () {
        splayTree = new SplayTree<K,V>();
    }

    @Override
    public void put(K key, V value) {
        splayTree.insert(key, value);
    }

    @Override
    public V get(K key) {
        return splayTree.find(key);
    }
}
