/**
 * Created by user on 10/17/2016.
 */
public class MapFactory {
    public static <K extends Comparable<K>,V> Map<K, V> getMap(int i) {
        switch (i) {
            case 1:
                return new SplayTreeMap();
            case 2:
                return new OwnHashMap();
        }
        return null;
    }
}
