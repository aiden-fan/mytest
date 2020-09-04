package com.souche.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.souche.annotations.LagerThanZero;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @Author laixiaoxing
 * @Description 线下解约退款 李慧琴模版
 * @Date 下午5:05 2019/10/28
 */
@Data
public class OfflineTerminationEventLhqEO extends BaseRowModel {

    /**
     * 对公\对私 0-对公1-对私
     * 0-false 1-true
     */
    private Boolean accountType;

    /**
     * 分类
     */
    @ExcelProperty(value = "分类", index = 0)
    private String itemUse;


    /**
     * 租后订单编号
     */
    @ExcelProperty(value = "租后/订单中心编号")
    private String orderCode;


    /**
     * 车架号
     */
    @ExcelProperty(value = "车架号")
    private String vin;

    /**
     * 收款人名称
     */
    @ExcelProperty(value = "收款人名称")
    private String customerAccountName;

    /**
     * 对方开户行
     */
    @ExcelProperty(value = "对方开户行")
    private String refundBank;

    /**
     * 对方开户支行
     */
    @ExcelProperty(value = "对方开户支行")
    private String refundBankSub;

    /**
     * 账户
     */
    @ExcelProperty(value = "账户")
    private String customerAccount;

    /**
     * 退款原因
     */
    @ExcelProperty("退款原因")
    private String refundCause;

    /**
     * 退尾款
     */
    @ExcelProperty("尾款退款")
    private String balancePaymentBackStr;


    @LagerThanZero
    private BigDecimal balancePaymentBack;


    @ExcelProperty("退车违章保证金（原租后违章保证金）退款")
    private String breachRegulationStr;

    private BigDecimal breachRegulation;


    @ExcelProperty("随车物品损失费退款")
    private String refundDamageLossChargesStr;

    private BigDecimal refundDamageLossCharges;

    @ExcelProperty("车辆占用使用费(原延迟换成滞纳金)退款")
    private String refundVehicleOccupancyFeeStr;

    private BigDecimal refundVehicleOccupancyFee;


    @ExcelProperty("延迟还款滞纳金退款")
    private String refundLatePaymentFineStr;

    private BigDecimal refundLatePaymentFine;


    @ExcelProperty("多收款退款")
    private String moreCreditBackStr;

    private BigDecimal moreCreditBack;


    @ExcelProperty("里程包退款")
    private String mileagePackageBackStr;

    private BigDecimal mileagePackageBack;


    @ExcelProperty("超里程费退款")
    private String refundExcessMileageStr;

    private BigDecimal refundExcessMileage;


    @ExcelProperty("不可退违约金退款")
    private String refundNotRefundableStr;

    private BigDecimal refundNotRefundable;

    @ExcelProperty("加速折旧费(原额外出险维修费)退款")
    private String refundAcceleratedDepreciationChargeStr;

    private BigDecimal refundAcceleratedDepreciationCharge;

    @ExcelProperty("整备费退款")
    private String preparingFeeRefundStr;

    private BigDecimal preparingFeeRefund;

    @ExcelProperty("收车费退款")
    private String chargeBackFareStr;

    private BigDecimal chargeBackFare;


    @ExcelProperty("延长过户费退款")
    private String refundExtensionTransferFeeStr;

    private BigDecimal refundExtensionTransferFee;

    @ExcelProperty("违章违约金(原违章处理费)退款")
    private String refundBreachContractPenaltyStr;

    private BigDecimal refundBreachContractPenalty;


    @ExcelProperty("分期首付款退款")
    private String refundInstalmentStr;

    private BigDecimal refundInstalment;


    @ExcelProperty("履约保证金(原逾期保证金）退款")
    private String withdrawalPerformanceBondStr;

    private BigDecimal withdrawalPerformanceBond;


    @ExcelProperty("剩余月租退款")
    private String refundRemainingMonthlyRentStr;

    private BigDecimal refundRemainingMonthlyRent;


    @ExcelProperty("年检费退款")
    private String returnCheckFeeStr;

    private BigDecimal returnCheckFee;


    @ExcelProperty("车辆维修费退款")
    private String refundVehicleMaintenanceFeeStr;

    private BigDecimal refundVehicleMaintenanceFee;


    @ExcelProperty("超里程保证金退款")
    private String refundExcessMileageMarginStr;

    private BigDecimal refundExcessMileageMargin;


    @ExcelProperty("出险保证金退款")
    private String exitMarginStr;

    private BigDecimal exitMargin;


    @ExcelProperty("变更过户费退款")
    private String refundChangeTransferFeeStr;

    private BigDecimal refundChangeTransferFee;


    @ExcelProperty("租中违章保证金(线下收取的)退款")
    private String depositBreachRegulationsStr;

    private BigDecimal depositBreachRegulations;


    @ExcelProperty("租中违章代缴退款")
    private String surrenderViolationRegulationStr;

    private BigDecimal surrenderViolationRegulation;


    @ExcelProperty("回购款退款")
    private String returnPurchaseMoneyStr;

    private BigDecimal returnPurchaseMoney;

    @ExcelProperty("逾期月租退款")
    private String overdueMonthlyRentRefundStr;

    private BigDecimal overdueMonthlyRentRefund;

    @ExcelProperty("逾期月租滞纳金退款")
    private String overdueMonthlyRentLateFeeRefundStr;

    private BigDecimal overdueMonthlyRentLateFeeRefund;

    @ExcelProperty("退车违约金退款")
    private String carReturnPenaltyRefundStr;

    private BigDecimal carReturnPenaltyRefund;

    @ExcelProperty("检测费-退款")
    private String testFeeRefundStr;

    private BigDecimal testFeeRefund;

    /**
     * 错误提示
     */
    @ExcelProperty("错误提示")
    private String msg;


}