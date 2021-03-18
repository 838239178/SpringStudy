package com.example.demo.utils;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections Factory
 * @since 1.7
 */
public class cl {

    @SafeVarargs
    public static <T> List<T> list(@NotNull T... item){
        ArrayList<T> array = new ArrayList<>(item.length);
        Collections.addAll(array, item);
        return array;
    }

    public static MapBuilder.MapBuildAction map(){
        return  MapBuilder.map();
    }
}
