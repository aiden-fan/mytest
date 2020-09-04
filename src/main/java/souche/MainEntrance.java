package souche;

import com.souche.pojo.OfflineEo;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.*;

/***
 *@author fanmiao
 *@date 2020/1/9 13:58 
 */
public class MainEntrance {
    public static void main(String[] args) {
        reflexTest();
    }

    public static void reflexTest() {
        OfflineEo offlineEo = new OfflineEo();
//        ReflexTest reflexTest = new ReflexTest();
//        offlineEo.setAmount1(BigDecimal.valueOf(20));
//        offlineEo.setAmount2(BigDecimal.valueOf(10));
//        offlineEo.setId("123");
//        reflexTest.method5(offlineEo);
//        offlineEo.setId("123");
//        String s = JSONObject.toJSONString(offlineEo);
//        System.out.println(s);
//
//        OfflineEo offlineEo1 = JSON.parseObject(s, OfflineEo.class);
//        System.out.println(offlineEo1.getId());


//
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.set(Calendar.DAY_OF_MONTH,1);
//        calendar.add(Calendar.MONTH,1);
//        calendar.set(Calendar.HOUR_OF_DAY,0);
//        calendar.set(Calendar.MINUTE,0);
//        calendar.set(Calendar.SECOND,0);
//        Date time = calendar.getTime();
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = simpleDateFormat.format(time);
//        System.out.println(format);

        Long nowTimeMillisecond = 1579622400000L;
        Date date = new Date();
        date.setTime(nowTimeMillisecond);
        String format = DateFormatUtils.format(date, "yyyy-MM-dd");
        System.out.println(format);
    }


    private static void method() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        int sum = integers.stream().mapToInt(x -> x + 10).sum();
        System.out.println(sum);
    }


}


