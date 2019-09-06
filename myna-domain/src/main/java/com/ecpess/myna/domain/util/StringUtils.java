package com.ecpess.myna.domain.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static boolean isBlank(String string) {
        return string == null || string.trim().equals("");
    }

    public static boolean notBlank(String string) {
        return !isBlank(string);
    }

    public static long parseLong(String s) {
        return Long.parseLong(s.trim());
    }

    public static BigDecimal parseBigDecimal(String s) {
        return new BigDecimal(s);
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 手机号码验证
     *
     * @param mobile 手机号码
     * @return 验证结果
     */
    public static boolean isMobile(String mobile) {
        String regular = "1[3-9]\\d{9}";
        Pattern pattern = Pattern.compile(regular);
        boolean flag = false;
        if (notBlank(mobile)) {
            Matcher matcher = pattern.matcher(mobile);
            flag = matcher.matches();
        }
        return flag;
    }

    /**
     * 字符串长度规则(汉字算2个字符)
     *
     * @param str       字符串
     * @param minLength 最小长度
     * @param maxLength 最大长度
     * @return 符合：true
     */
    public static boolean stringLengthRule(String str, int minLength, int maxLength) {
        if (str == null) {
            return false;
        }
        int length = str.length() + fileChin(str).length();
        return length >= minLength && length <= maxLength;
    }

    private static String fileChin(String chin) {
        if (null == chin) {
            return "";
        }
        chin = chin.replaceAll("[a-zA-Z0-9_ ]", "");
        return chin;
    }

    /**
     * 生成随机流水号
     *
     * @param business 业务
     * @param userId   用户ID
     * @return
     */
    public static String getSerialNumber(String business, String userId) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String orderNo = business + formatter.format(new Date()).substring(2) + Math.round(Math.random() * 900 + 100) + userId;
        return orderNo;
    }

    /**
     * 身份证号加*显示 11****3333****5555
     *
     * @param idCard
     * @return
     */
    public static String maskIdCard(String idCard) {
        if (StringUtils.isBlank(idCard)) {
            return null;
        }
        StringBuilder buffer = new StringBuilder(idCard);
        buffer.replace(6, idCard.length()-4, "****");
        return buffer.toString();
    }

    /**
     * 银行卡号加*显示
     *
     * @param bankCard
     * @return
     */
    public static String maskBankCard(String bankCard) {
        if (StringUtils.isBlank(bankCard)) {
            return null;
        }
        StringBuilder buffer = new StringBuilder(bankCard);
        buffer.replace(6, bankCard.length()-4, "****");
        return buffer.toString();
    }

    public static void main(String[] args) {
        String str = maskBankCard("6228480661103842919");
        System.out.println(str+"====");
    }
}
