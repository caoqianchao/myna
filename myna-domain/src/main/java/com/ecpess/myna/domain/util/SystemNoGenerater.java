package com.ecpess.myna.domain.util;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 系统流水生成器
 *
 * @author sunxy 2016年2月16日 上午11:34:16
 * @since 1.0
 */
public class SystemNoGenerater {

    public static String DIRECTSETTLE_ORDER_PRE = "DS";

    public static String LIFESERVICE = "LS";

    private static AtomicLong concurrent = new AtomicLong();

    /**
     * 生成系统流水
     *
     * @param busCode bussiness code
     * @param merNo   merchant code
     * @return system no
     */
    public static String generateNo(String busCode, String merNo) {
        StringBuilder builer = new StringBuilder(busCode);
        builer.append(merNo);

        builer.append(DateUtils.formatDate(new Date(), "yyyyMMddHHmmss"));

        String con = String.valueOf(concurrent.incrementAndGet());
        builer.append(con);

        //重置
        if (concurrent.get() > 10000) {
            synchronized (SystemNoGenerater.class) {
                if (concurrent.get() > 10000) {
                    concurrent = new AtomicLong();
                }
            }
        }
        return builer.toString();
    }
}
