package com.souche.pojo;

import lombok.Data;

/***
 *@author fanmiao
 *@date 2020/3/26 3:52 下午 
 */
@Data
public class Account {
//    [{"bizNo":"153727","itemCode":"00101010","orderCode":"516071751930","position":"3","requestNo":""}]

    private String bizNo;
    private String itemCode;
    private String orderCode;
    private String position;
    private String requestNo;

}
