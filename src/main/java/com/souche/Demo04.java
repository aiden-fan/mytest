package com.souche;

import com.alibaba.fastjson.JSONObject;
import com.souche.pojo.Person;
import org.apache.commons.compress.utils.Lists;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/***
 *@author fanmiao
 *@date 2019/11/7 8:30 下午 
 */
public class Demo04 {
    public static void main(String[] args) throws ParseException {
        String s = "2019-08-10";
        String s1 = "2019-02-10";
        int i = s.compareTo(s1);
        System.out.println(i);
    }

    private static void method3() {
        List<String> strings = Lists.newArrayList();
        strings.add("2011-09-08");
        strings.add("2012-09-10");
        strings.add("2012-02-08");
        strings.add("2012-09-08");
        Collections.sort(strings);
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }

    private static void method2() throws ParseException {
        List<Date> refundTimes = Lists.newArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        refundTimes.add(simpleDateFormat.parse("2011-09-08"));
        refundTimes.add(simpleDateFormat.parse("2012-09-10"));
        refundTimes.add(simpleDateFormat.parse("2012-02-08"));
        refundTimes.add(simpleDateFormat.parse("2012-09-08"));
        Collections.sort(refundTimes);
        for (int i = 0; i < refundTimes.size(); i++) {
            System.out.println(simpleDateFormat.format(refundTimes.get(i)));
        }

    }

    public static void method() {
        Person person = new Person();
        person.setPersonName("zjj");
        person.setAddr("hangzhou");
        Person person1 = new Person();
        person1.setPersonName("lisi");
        person1.setAddr("shanghai");
        List<Person> lists = new ArrayList<Person>();
        lists.add(person);
        lists.add(person1);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("people", lists);
        method2(jsonObject);
    }

    public static void method2(JSONObject object) {
        Object people = object.get("people");
        String s = JSONObject.toJSONString(people);
        List<Person> people1 = JSONObject.parseArray(s, Person.class);
        for (Person person : people1) {
            System.out.println(people.toString());
        }
    }
}
