package com.ecpess.myna.domain.util;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author tiny on 2019/5/17.
 */
@SuppressWarnings({"unused", "unchecked"})
public class CollectionUtil {

//    @Deprecated
//    public static Map<String, Object> ofMap(Object... obj) {
//        Asserts.check(obj.length % 2 == 0, "Expected even, but the length of the pairs is odd!");
//        Map<String, Object> map = new HashMap<>(obj.length / 2);
//        Stream.iterate(0, i -> i + 2).limit(obj.length / 2).filter(i -> obj[i] instanceof String)
//                .forEach(i -> map.put((String) obj[i], obj[i + 1]));
//        return map;
//    }

    public static <K, V> Map<K, V> ofMap(K k, V v) {
        return Stream.of(ofEntry(k, v)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2) {
        return ofMapWithEntry(ofEntry(k1, v1), ofEntry(k2, v2));
    }

    public static <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3) {
        return ofMapWithEntry(ofEntry(k1, v1), ofEntry(k2, v2), ofEntry(k3, v3));
    }

    public static <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        return ofMapWithEntry(ofEntry(k1, v1), ofEntry(k2, v2), ofEntry(k3, v3), ofEntry(k4, v4));
    }

    public static <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return ofMapWithEntry(ofEntry(k1, v1), ofEntry(k2, v2), ofEntry(k3, v3), ofEntry(k4, v4), ofEntry(k5, v5));
    }

    private static <K, V> Map.Entry<K, V> ofEntry(K k, V v) {
        return new AbstractMap.SimpleEntry<>(k, v);
    }

    private static <K, V> Map<K, V> ofMapWithEntry(Map.Entry<K, V>... entry) {
        return ofMap(entry);
    }

    public static <K, V> Map<K, V> ofMap(Map.Entry<K, V>... entry) {
        return Arrays.stream(entry).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <E> List<E> ofList(E... element) {
        return Arrays.stream(element).collect(Collectors.toList());
    }

    public static <E> Set<E> ofSet(E... element) {
        return Arrays.stream(element).collect(Collectors.toSet());
    }
}
