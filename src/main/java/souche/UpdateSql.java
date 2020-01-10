package souche;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/***
 *@author fanmiao
 *@date 2019/12/13 12:52 
 */
public class test {

    public static void main(String[] args)throws Exception {
        List<String> read = read();

        for (String s : read) {
            String s1 = method1(s);
            System.out.println(s1);
        }
    }


    public static String method2(String s) {
        StringBuilder stringBuilder = new StringBuilder("UPDATE t_relationship_receivables SET serial_unique_code = '[");
        String[] split = s.split("\"serialNumber\":\"");
        //serialNumber array
        String[] serialNumber = split[1].split(",");
        String substring = split[0].substring(8);
        for (int j = 0; j < serialNumber.length; j++) {
            stringBuilder.append(substring).append("\"serialNumber\":\"").append(serialNumber[j]).append("\"").append("}");
            if (j != serialNumber.length - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]'");
        String id ="'" + s.substring(1,5) + "'";
        stringBuilder.append("where id = ").append(id).append(";");

        return stringBuilder.toString();
    }





    public static String method1(String s) {
//        String s = "(833,'[{\"accountNo\":\"95200155300001827\",\"requestNo\":\"\",\"serialNumber\":\"AAAAA2710782-D-20190826174938，AAAAA0590784-D-20190826175048，AAAAA4730563-D-20190826175133，AAAAA3270564-D-20190826175220\"}]'),";
                String[] split = s.split("，");

        //id      orderCodeSize = 5 -> 6
        String id ="'" + s.substring(1, 6) + "'";

        //头  {"accountNo":"95200155300001827","requestNo":"","serialNumber":
        int i = split[0].lastIndexOf(":");
        //  orderCodeSize = 5 -> 9
        String tou = s.substring(9, i) + ":";

        //serialNumber
        split[0] = split[0].substring(i+1)+ "\"";
        split[split.length - 1] = "\"" + split[split.length -1].substring(0,split[split.length -1].indexOf("}"));

        //尾

        StringBuilder stringBuilder = new StringBuilder("UPDATE t_relationship_receivables SET serial_unique_code = '[");
        for (int j = 0; j < split.length; j++) {
            if (j > 0 && j < split.length - 1) {
                split[j] = "\"" + split[j] + "\"";
            }
            stringBuilder.append(tou).append(split[j]).append("}");

            if (j != split.length - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]'");
        stringBuilder.append("where id = ").append(id).append(";");

        return stringBuilder.toString();

    }
    

    public static List<String> read() throws Exception{
        ArrayList<String> arrayList = new ArrayList<>();

            FileReader fr = new FileReader("src/data-20191213-023514.text");
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            fr.close();
            return arrayList;
    }
}
