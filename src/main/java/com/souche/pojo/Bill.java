package com.souche.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/***
 *@author fanmiao
 *@date 2020/3/26 2:17 下午 
 */
@Data
public class Bill {
    private Long id;

    private String requestNo;

    private String uniqueNo;

    private String orderCode;

    private String billType;

    private BigDecimal tradeMoney;

    private String tradeType;

    private BigDecimal walletBalance;

    private BigDecimal sfee;

    private String callBackUrl;

    private String extension;

    private String status;

    private String remark;

    private Date gmtCreate;

    private Date gmtModify;

    private Date auditTime;

    private String serialNum;

    private String account;

    private String payload;

    private String subOrderCode;

    /**
     * 退款凭证图片url
     */
    private String downPaymentImgUrl;

    /**
     * 车辆类型 1-集采新车 2-集采二手车（再弹））  3-（非集采新车）工具化新车 4-（非集采二手车）工具化二手车
     */
    private Integer carStyle;

    /**
     * 实收金额
     */
    private BigDecimal receiveAmount;

    private String reason;

    /**
     * 业务类型（暂时被取消，先留着）
     */
    private String businessType;

    /**
     * 支付单号
     */
    private String payOrderNo;
}
