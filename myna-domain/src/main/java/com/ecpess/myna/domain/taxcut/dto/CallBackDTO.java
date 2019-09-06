package com.ecpess.myna.domain.taxcut.dto;

/**
 * @author caoqc
 * @Description:
 * @date 2019/9/5 14:49
 */
public class CallBackDTO {
    private String batchNo;
    private String countSuc;
    private String countFail;
    private String countTotal;
    private String amountSuc;
    private String amountFail;
    private String tradeList;
    private String sign;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getCountSuc() {
        return countSuc;
    }

    public void setCountSuc(String countSuc) {
        this.countSuc = countSuc;
    }

    public String getCountFail() {
        return countFail;
    }

    public void setCountFail(String countFail) {
        this.countFail = countFail;
    }

    public String getCountTotal() {
        return countTotal;
    }

    public void setCountTotal(String countTotal) {
        this.countTotal = countTotal;
    }

    public String getAmountSuc() {
        return amountSuc;
    }

    public void setAmountSuc(String amountSuc) {
        this.amountSuc = amountSuc;
    }

    public String getAmountFail() {
        return amountFail;
    }

    public void setAmountFail(String amountFail) {
        this.amountFail = amountFail;
    }

    public String getTradeList() {
        return tradeList;
    }

    public void setTradeList(String tradeList) {
        this.tradeList = tradeList;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
