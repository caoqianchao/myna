package com.ecpess.myna.domain.taxcut.dto;

/**
 * @author caoqc
 * @Description:交易成功后回调通知
 * @date 2019/9/5 14:40
 */
public class TradeDTO {

    private String userName;
    private String userCard;
    private String cardNo;
    private String amount; //经营服务费税后，保留2位小数
    private String bank;

    public TradeDTO(String userName, String userCard, String cardNo, String amount, String bank) {
        this.userName = userName;
        this.userCard = userCard;
        this.cardNo = cardNo;
        this.amount = amount;
        this.bank = bank;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
