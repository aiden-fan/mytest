package com.souche;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.WeekendSqls;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/***
 *@author fanmiao
 *@date 2019/10/1 3:08 下午 
 */
public class Demo02 {
    public static void main(String[] args) throws FileNotFoundException {
       method11();
    }
    private static PersonMapper personMapper;


    /***
     * date
     */
    public static void method11() {
        long l = System.currentTimeMillis();
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.minusDays(1);
        LocalDate now = LocalDate.now();
        LocalTime now1 = LocalTime.now();
        System.out.println(now1);
        System.out.println(now);
        LocalDateTime localDateTime2 = now.atStartOfDay();

        LocalDate localDate = now.plusDays(1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String s = "2019-11-11";
        try {
            Date parse = simpleDateFormat.parse(s);
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy/MM/dd");
            String format = simpleDateFormat1.format(parse);
            System.out.println(format);
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(localDateTime2);

        System.out.println(localDateTime1);

    }


    /***
     * stream
     */
    public static void method10() {
        Person person = new Person(1,"lisi","shanghai");
        Person person1 = new Person(1,"zhangsan","shanghai");
        Person person2 = new Person(3,"wangwu","shanghai");
        ArrayList<Person> people = Lists.newArrayList();
        people.add(person);
        people.add(person1);
        people.add(person2);


        Map<Integer, List<Person>> map = people.stream().collect(Collectors.groupingBy(Person::getId));
        Map<String, Person> collect = people.stream().collect(Collectors.toMap(Person::getName, Function.identity()));



        List<Person> people1 = map.get(1);
        for (Person person3 : people1) {

            System.out.println(person3);
        }

    }

    public static void method9() {
        Person person = new Person(1,"lisi","shanghai");
        Person person1 = new Person(2,"zhangsan","shanghai");
        Person person2 = new Person(3,"wangwu","shanghai");

        Person[] people = new Person[3];
        people[0]= person;
        people[1]= person1;
        people[2]= person2;
        ArrayList<String> strings = new ArrayList<>();
        Arrays.stream(people).forEach(person3 -> {
            strings.add(person3.getName());
        });
        System.out.println(strings.toString());
    }


    public static void method8() throws FileNotFoundException {
        Person person = new Person(1,"lisi","shanghai");
        Person person1 = new Person(2,"zhangsan","shanghai");
        Person person2 = new Person(3,"wangwu","shanghai");
        Person person3 = new Person(4,"zhaoliu","shanghai");
        ArrayList<Person> persons = Lists.newArrayList();
        persons.add(person);
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        ArrayList<List<String>> objects = Lists.newArrayList();

        persons.stream().forEach(p -> {
            ArrayList<String> objects1 = Lists.newArrayList();
            objects1.add(p.getId().toString());
            objects1.add(p.getName());
            objects1.add(p.getAddr());
            objects.add(objects1);
        });



        FileOutputStream outputStream = new FileOutputStream("b.xls");
        ExcelWriter writer = new ExcelWriter(outputStream,ExcelTypeEnum.XLS);
        Sheet sheet = new Sheet(1,1,Person.class);

        sheet.setSheetName("test");
        writer.write0(objects,sheet);
        writer.finish();

    }

    public static void method7() {
        WeekendSqls<Person> personWeekendSqls = WeekendSqls.<Person>custom().andEqualTo(Person::getName, "");
        Example build = Example.builder(Person.class).where(personWeekendSqls).build();
        personMapper.selectByExample(build);

        Example example = new Example(Person.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("","");
    }


    public static void method1() {
        Person person = new Person();
        person.setName("zjj");
        person.setAddr("hangzhou");
        Person person1 = new Person();
        person1.setName("lisi");
        person1.setAddr("shanghai");
        List<Person> lists = new ArrayList<Person>();
        List<String> strings = new ArrayList<>();
        lists.add(person);
        lists.add(person1);
        Map<String, Person> collect = lists.stream().collect(Collectors.toMap(Person::getName, Function.identity()));

    }

    public static void method2(){
        BigDecimal bigDecimal = BigDecimal.valueOf(110);

        Long a = 22L;
        BigDecimal bigDecimal1 = Optional.ofNullable(a).map(aLong -> BigDecimal.valueOf(aLong,1))
                .orElse(BigDecimal.ZERO);
        System.out.println(bigDecimal1);
    }

    public static void method3() {

        boolean blank = StringUtils.isBlank(null);
        System.out.println(blank);
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("1","3");
        HashMap<Object, Object> ss = Validate.notEmpty(new HashMap<>(), "hash为null",stringStringHashMap);
        System.out.println(ss);
    }

    public static void method4() {
        String format = String.format("222", "33");
        System.out.println(format);
    }

    /***
     * json
     */
    public static void method5() {
        String s = "[{\"name\":\"zhansan\",\"addr\":\"shanghai\"},{\"name\":\"lisi\",\"addr\":\"hangzhou\"}]";
        List<Person> people = JSON.parseArray(s, Person.class);
        String s1 = JSON.toJSONString(people);
        Person person = JSON.parseObject(s, Person.class);
        System.out.println(people.get(1).getName());
    }


    public static void method6() {
        Person person = new Person();
        person.setName("zjj");
        person.setAddr("hangzhou");
        Person person1 = new Person();
        person1.setName("lisi");
        person1.setAddr("shanghai");
        ArrayList<Object> lists = Lists.newArrayList();
        lists.add(person);
        lists.add(person1);
        String s = JSON.toJSONString(lists);
        System.out.println(s);
    }
}