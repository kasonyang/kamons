package kamons.collection;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/**
 *
 * @author Kason Yang
 */
public class MapList<K, V> {

    private final Map<K, List<V>> map = new HashMap();

    public void put(K key, V value) {
        List<V> list = map.get(key);
        if (list == null) {
            list = new LinkedList();
            map.put(key, list);
        }
        list.add(value);
    }

    @Nullable
    public List<V> get(K key) {
        return map.get(key);
    }
    
    public boolean containsKey(K key){
        return map.containsKey(key);
    }
    
    public int size(){
        return map.size();
    }

}
