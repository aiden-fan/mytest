package com.souche.pojo;

import lombok.Data;

/***
 *@author fanmiao
 *@date 2020/3/26 2:18 下午 
 */
@Data
public class Extension {

    private String submitter;
    private String payerAccount;
    private String payeeAccount;
    private String number;
    private String refundNo;
}
