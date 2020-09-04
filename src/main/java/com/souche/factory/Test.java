package com.souche.factory;

import com.google.common.base.Supplier;
import com.google.common.collect.Lists;
import com.souche.pojo.Person;
import org.apache.poi.ss.formula.functions.T;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 *@author fanmiao
 *@date 2020/5/24 2:00 下午 
 */
public class Test {
    public static void main(String[] args) {
        PersonFactory<Person> personFactory = Person::new;
        Person p1 = personFactory.method(1, "", "a");
        Person p2 = personFactory.method(6, "", "b");
        Person p3 = personFactory.method(3, "", "c");
        Person p4 = personFactory.method(4, "", "d");
        ArrayList<Person> list = Lists.newArrayList();
        list.add(p4);
        list.add(p2);
        list.add(p1);
        list.add(p3);
//        List<Person> collect = list.stream().sorted(Comparator.comparingInt(Person::getId)).collect(Collectors.toList());
//        List<Person> collect = list.stream().sorted((a, b) -> {
//            return a.getAddr().compareTo(b.getAddr());
//        }).collect(Collectors.toList());
        Map<String, String> map = new HashMap<>();
        map.computeIfAbsent("s",k -> {
            System.out.println(k);
            return map.put(k,"test");
        });

        String s = map.computeIfPresent("s", new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                System.out.println(s + s2);
                return map.put("", "");
            }
        });
        Optional<Person> reduce = list.stream().reduce((a,b) -> {
            a.getId();
            b.getId();
            return null;
        });

    }
}
