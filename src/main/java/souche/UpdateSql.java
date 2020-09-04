package souche;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.souche.pojo.Account;
import com.souche.pojo.Bill;
import com.souche.pojo.Extension;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 *@author fanmiao
 *@date 2019/12/13 12:52 
 */
public class UpdateSql {

    public static void main(String[] args)throws Exception {
        //t_relationship_receivables
//        List<String> read = read("src/data-20191213-023514.text");
//        for (String s : read) {
//            String s1 = method1(s);
//            System.out.println(s1);
//        }

//        update
//          update 02
        String[] strings ={
        };
        List<String> strings1 = Arrays.asList(strings);
        //bill -> t_relationship_receivables
        List<String>read = read("src/bill.text");
        int count = 0;
        for (String s : read) {
            Bill bill = JSONObject.parseObject(s, Bill.class);
            if (strings1.contains(bill.getUniqueNo())) {
                count ++;
                continue;
            }
            method4(bill);
        }
        System.out.println(count);
    }


    /**
     * bill -> t_relationship_receivables
     *
     * @param
     * @return
     */
    public static void method4(Bill bill) {
        //INSERT INTO `t_relationship_receivables` (`approval_paper_id`,`payment_type`,`order_code`,`account_receivable_flow`,`serial_unique_code`,`amount`,`operation`,`operation_time`,`payment_account`,`collection_account`,`processing_state`,`caller`,`payload`,`trading_time`,`serial_number`) values
        Extension extension = JSONObject.parseObject(bill.getExtension(), Extension.class);
        Account account = new Account();
        account.setBizNo(extension.getRefundNo());
        account.setItemCode("00101010");
        account.setRequestNo("");
        account.setPosition(extension.getNumber());
        account.setOrderCode(bill.getOrderCode());
        String s = JSONObject.toJSONString(account);
        System.out.print("('");
        System.out.print(bill.getUniqueNo());
        System.out.print("','ACCOUNTS_REFUND',");
        System.out.print("'"+bill.getOrderCode()+"',");
        System.out.print("'[" + s + "]',");
        System.out.print("null,");
        System.out.print(bill.getTradeMoney()+",");
        System.out.print("'"+extension.getSubmitter()+"',");
        System.out.print("'"+bill.getAuditTime()+"',");
        System.out.print("'"+extension.getPayerAccount()+"',");
        System.out.print("'"+extension.getPayeeAccount()+"',");
        System.out.print("'PROCESS',");
        System.out.print("'finance-counter',");
        System.out.print("'t_bill',");
        System.out.print("'"+bill.getAuditTime()+"',");
        System.out.println("'"+bill.getSerialNum()+"'),");



    }




    public static String method3(String s) {

        StringBuilder str = new StringBuilder();
        Bill bill = JSONObject.parseObject(s, Bill.class);
        str.append("\"").append(bill.getUniqueNo()).append("\",\"ACCOUNTS_REFUND\",").append("\"").append(bill.getOrderCode()).append("\"");
        //account_receivable_flow
        str.append("");
        //serial_unique_code
        str.append("");
                str.append(bill.getTradeMoney()).append("");
        return null;
    }

    /**
     * t_relationship_receivables
     * @param s
     * @return
     */
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
    

    public static List<String> read(String filePath) throws Exception{
        ArrayList<String> arrayList = new ArrayList<>();

            FileReader fr = new FileReader(filePath);
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
