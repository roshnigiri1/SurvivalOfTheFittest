package application;

import java.util.Map;
import java.util.TreeMap;

public class MultiReturnValues {

    public static <K,V> TreeMap<String, Double> getTreeMap(Map<K, V> hashMap)
    {
        TreeMap<K, V> treeMap = new TreeMap<>();

        treeMap.putAll(hashMap);

        return (TreeMap<String, Double>) treeMap;
    }

}
