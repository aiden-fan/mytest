package com.souche.pojo;

import com.souche.annotations.Anno;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/***
 *@author fanmiao
 *@date 2020/1/9 15:53 
 */
public class OfflineEo implements BaseEo {

    private String id;

    private String name;

    @Anno(receiveItemCode = "receiveItemCode1",refundItemCode = "refundItemCode1")
    private BigDecimal amount1;


    @Anno(receiveItemCode = "receiveItemCode2",refundItemCode = "refundItemCode2")
    private BigDecimal amount2;

    private Date date;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount1() {
        return amount1;
    }

    public void setAmount1(BigDecimal amount1) {
        this.amount1 = amount1;
    }

    public BigDecimal getAmount2() {
        return amount2;
    }

    public void setAmount2(BigDecimal amount2) {
        this.amount2 = amount2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
