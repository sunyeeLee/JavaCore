package com.sunyee.javacore.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 使用 LinkedHashMap 实现的一个 LRU 缓存：
 *
 * 设定最大缓存空间 MAX_ENTRIES 为 3；
 * 使用 LinkedHashMap 的构造函数将 accessOrder 设置为 true，开启 LRU 顺序；
 * 覆盖 removeEldestEntry() 方法实现，在节点多于 MAX_ENTRIES 就会将最近最久未使用的数据移除。
 *
 * Created by lishunyi on 2019/5/22
 */
public class LRUCacheByLinkedHashMap<k, v> extends LinkedHashMap<k, v> {
    private static final Integer MAX_ENTRIES = 3;

    LRUCacheByLinkedHashMap(){
        super(MAX_ENTRIES, 0.75f, true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
        return size() > MAX_ENTRIES;
    }

    public static void main(String[] args) {
        LRUCacheByLinkedHashMap<Integer, String> cache = new LRUCacheByLinkedHashMap<>();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.get(1);
        cache.put(4, "d");
        System.out.println(cache.keySet()); //[3, 1, 4]
    }
}
