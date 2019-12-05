package com.source;

import java.util.Map;

/**
 * @Author qtq
 * @Created on 2019-11-17 20:40.
 */
public class MapTest {

    public static void main(String[] args) {

        HashMaps<String, Integer> maps = new HashMaps<>(16); // 指定初始化大小，防止多次扩容，影响性能
        System.out.println(maps.put("刘飞", 30));
        System.out.println(maps.put("刘飞", 31));

//        System.out.println(maps.get("鲁班"));
        System.out.println(maps.get("刘飞"));

        // Map

    }
}
