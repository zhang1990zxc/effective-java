package com.zhang.effective.article23_29;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhang
 * @Description
 * @Date 2020-08-10 16:02
 * @Version 1.0
 **/
public class Favorites {

    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorites(Class<T> type, T instance) {
        if (type == null)
            throw new NullPointerException("Type is null");
        favorites.put(type, type.cast(instance));
    }

    public <T> T getFavorites(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    public static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName){
        Class<?> annotationType = null;
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return element.getAnnotation(annotationType.asSubclass(Annotation.class));
    }

}
