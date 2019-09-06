package com.ecpess.myna.domain.taxcut.dto;

/**
 * @author caoqc
 * @Description:
 * @date 2019/9/5 14:25
 */
public class EmployDTO {

    private String realName;
    private String cardNo;
    private String mobile;
    private String empNo;
    private String bankCard;

    public EmployDTO(String realName, String cardNo, String mobile, String empNo, String bankCard) {
        this.realName = realName;
        this.cardNo = cardNo;
        this.mobile = mobile;
        this.empNo = empNo;
        this.bankCard = bankCard;
    }

    public String getRealName() {
        return realName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmpNo() {
        return empNo;
    }

    public String getBankCard() {
        return bankCard;
    }
}
