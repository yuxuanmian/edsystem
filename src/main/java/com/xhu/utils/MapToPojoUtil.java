package com.xhu.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 从封装了json的map中得到pojo类
 */
public class MapToPojoUtil {

    private MapToPojoUtil(){
        //不允许直接实例化
    }

    /**
     * 转换
     *
     * @param aClass     pojo类的class
     * @param jsonStrMap 封装json字符串的map
     * @param <T>        T
     * @return 转换完成的pojo类
     */
    public static <T> T convert(Class<T> aClass, Map<String, ?> jsonStrMap) {
        //将所有的key转换为小写并去除所有的"_"
        Map<String,Object> newMap=new HashMap<>();
        jsonStrMap.forEach((k,v)-> newMap.put(k.toLowerCase(), v));
        jsonStrMap=newMap;
        //用户返回
        T t = null;
        try {
            //得到实例
            t = aClass.newInstance();

            Method[] methods = aClass.getMethods();

            //得到所有set方法
            List<Method> getMethods = new ArrayList<>();
            for (Method method : methods) {
                String name = method.getName();
                if (name.startsWith("set")) {
                    getMethods.add(method);
                }
            }
            //用于lambda表达式
            T finalT = t;
            Map<String, ?> finalJsonStrMap = jsonStrMap;
            getMethods.forEach((method -> {
                //将方法名去掉set并转换为小写，然后和map中的key对比
                String param = method.getName().substring(3).toLowerCase();
                if (finalJsonStrMap.containsKey(param)) {
                    try {
                        //执行set方法
                        method.invoke(finalT, finalJsonStrMap.get(param));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }));
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return t;

    }

}
