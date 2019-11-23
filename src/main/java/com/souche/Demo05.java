package com.souche;

import java.util.Date;
import java.util.Optional;

/***
 *@author fanmiao
 *@date 2019/11/12 8:25 下午 
 */
public class Demo05 {
    public static void main(String[] args) {
        String s = null;
        Date date = Optional.ofNullable(s).map(x -> hasText(x) ? new Date(Long.valueOf(x) * 1000) : null).orElse(null);
        System.out.println(date);
    }





    public static boolean hasText(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }
}
