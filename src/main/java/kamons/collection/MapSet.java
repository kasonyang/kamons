package kamons.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/**
 *
 * @author Kason Yang
 */
public class MapSet<K, V> {

    private final Map<K, Set<V>> map = new HashMap();

    public void put(K key, V value) {
        Set<V> list = map.get(key);
        if (list == null) {
            list = new HashSet();
            map.put(key, list);
        }
        list.add(value);
    }

    @Nullable
    public Set<V> get(K key) {
        return map.get(key);
    }
    
    public boolean containsKey(K key){
        return map.containsKey(key);
    }
    
    public int size(){
        return map.size();
    }

}
