package com.ecpess.myna.domain.taxcut.dto;

/**
 * @author caoqc
 * @Description: 交易申请表tradeList具体参数
 * @date 2019/9/5 15:05
 */
public class TradeDeaDTO {
    private String tradeDetailStates;
    private String amountAfter;
    private String userName;
    private String userCard;
    private String cardNo;
    private String serviceRate;
    private String amountBefore;
    private String incomeExtraTax;
    private String totalAmount;
    private String incomeTax;

    public String getTradeDetailStates() {
        return tradeDetailStates;
    }

    public void setTradeDetailStates(String tradeDetailStates) {
        this.tradeDetailStates = tradeDetailStates;
    }

    public String getAmountAfter() {
        return amountAfter;
    }

    public void setAmountAfter(String amountAfter) {
        this.amountAfter = amountAfter;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getServiceRate() {
        return serviceRate;
    }

    public void setServiceRate(String serviceRate) {
        this.serviceRate = serviceRate;
    }

    public String getAmountBefore() {
        return amountBefore;
    }

    public void setAmountBefore(String amountBefore) {
        this.amountBefore = amountBefore;
    }

    public String getIncomeExtraTax() {
        return incomeExtraTax;
    }

    public void setIncomeExtraTax(String incomeExtraTax) {
        this.incomeExtraTax = incomeExtraTax;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(String incomeTax) {
        this.incomeTax = incomeTax;
    }
}
