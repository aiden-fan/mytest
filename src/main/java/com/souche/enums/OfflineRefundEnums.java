package com.souche.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 *@author fanmiao
 *@date 2020/1/9 15:21 
 */
public enum OfflineRefundEnums {
    TSF("getPersonName","receiveItemCode","refundItemCode"),
    AGE("getAddr","1","2");

    private String methodName;
    private String receiveItemCode;
    private String refundItemCode;
    private static List<OfflineRefundEnums> itemList;

    static {
        itemList = Arrays.asList(OfflineRefundEnums.values());
    }

    OfflineRefundEnums(String methodName, String receiveItemCode, String refundItemCode) {
        this.methodName = methodName;
        this.receiveItemCode = receiveItemCode;
        this.refundItemCode = refundItemCode;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public String getReceiveItemCode() {
        return this.receiveItemCode;
    }

    public String getRefundItemCode() {
        return this.refundItemCode;
    }

    public static List<OfflineRefundEnums> getList() {
        return itemList;
    }
}
