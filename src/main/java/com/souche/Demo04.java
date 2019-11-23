package com.souche;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/***
 *@author fanmiao
 *@date 2019/11/7 8:30 下午 
 */
public class Demo04 {
    public static void main(String[] args) {
        method();
    }

    public static void method() {
        Person person = new Person();
        person.setName("zjj");
        person.setAddr("hangzhou");
        Person person1 = new Person();
        person1.setName("lisi");
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
