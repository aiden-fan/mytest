package com.souche.pojo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/***
 *@author fanmiao
 *@date 2020/3/5 4:01 下午 
 */

@Data
@Builder
public class RefundDockingTradingPlatformDTO implements Serializable {

    private static final long serialVersionUID = -5138124398766904141L;

    /**
     * 退款类型 (款项用途)
     */
    private String itemUse;

    /**
     * 订单中心编号
     */
    private String orderCode;

    /**
     * 天猫订单号
     */
    private String tmallOrderCode;

    /**
     * 天猫支付宝交易号
     */
    private String aliPayBusinessCode;

//    /**
//     * 退款金额
//     */
//    private BigDecimal refundTotalAmount;

    /**
     * 退款时间
     */
    private String refundTime;

    /**
     * 出款账户号
     */
    private String payAccount;

}
