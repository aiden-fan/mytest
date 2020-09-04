package souche;

import com.souche.pojo.Person;
import com.souche.annotations.Anno;
import com.souche.enums.OfflineRefundEnums;
import com.souche.pojo.BaseEo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

/***
 *@author fanmiao
 *@date 2020/1/9 13:48 
 */
public class ReflexTest {
    public void method() {
        Class<Person> personClass = Person.class;

        Person person = new Person();
        person.setPersonName("zhangsan");

        try {

            Field personName = personClass.getDeclaredField("personName");
            //暴力反射
            personName.setAccessible(true);
            String o = (String)personName.get(person);
            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void method2() {
        Class<Person> pClass = Person.class;
        Person person = new Person();
        person.setPersonName("zhangsan");
        try {
            Method personName = pClass.getDeclaredMethod("getPersonName");
            String invoke = (String)personName.invoke(person);
            System.out.println(invoke);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void method3(Person person) {
        List<OfflineRefundEnums> list = OfflineRefundEnums.getList();
        for (OfflineRefundEnums offlineRefundEnums : list) {
            try {
                Method declaredMethod = Person.class.getDeclaredMethod(offlineRefundEnums.getMethodName());
                String s = (String)declaredMethod.invoke(person);
                System.out.println(s + "," + offlineRefundEnums.getReceiveItemCode() +"," + offlineRefundEnums.getRefundItemCode());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void method4(BaseEo baseEo) {
        Class aClass = baseEo.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            boolean equals = declaredField.getType().equals(BigDecimal.class);
            System.out.println(equals);
            if (declaredField.isAnnotationPresent(Anno.class)) {
                Anno annotation = declaredField.getAnnotation(Anno.class);
                System.out.println(annotation.receiveItemCode() + "," + annotation.refundItemCode());
                String name = declaredField.getName();
                name ="get" +  name.substring(0,1).toUpperCase() + name.substring(1);
                try {
                    BigDecimal invoke =(BigDecimal)aClass.getMethod(name).invoke(baseEo);
                    System.out.println(name+","+invoke);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void method5(BaseEo baseEo) {

        Class<? extends BaseEo> baseEoClass = baseEo.getClass();
        try {
            Method setId = baseEoClass.getMethod("setId",String.class);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}






