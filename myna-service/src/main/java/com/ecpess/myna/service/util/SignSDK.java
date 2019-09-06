package com.ecpess.myna.service.util;

import com.ecpess.myna.domain.util.RsaUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author caoqc
 * @Description:签名工具
 * @date 2019/9/4 16:14
 */
public class SignSDK {

    private static Logger logger = LoggerFactory.getLogger(SignSDK.class);

    public static void sign(LinkedHashMap map,String priKey) {
        if (null == map) {
            logger.info("sign map is null");
            return;
        }
        if (null == priKey) {
            logger.info("priKey map is null");
            return;
        }
        String mapString = coverMap2String(map);
        RsaUtils rsaUtils = RsaUtils.getInstance();
        logger.info("-------------------------加密的串：" + mapString);
        String sign = rsaUtils.signData(mapString, priKey);
        logger.info("-------------------------加密后的sign：" + sign);
        map.put("sign", sign);
    }

    public static String coverMap2String(LinkedHashMap data) {
        if (null == data) {
            logger.info("coverMap2String map is null");
            return null;
        }

        Iterator<Map.Entry<String, String>> it = data.entrySet().iterator();
        StringBuffer sf = new StringBuffer();
        while (it.hasNext()) {
            Map.Entry<String, String> en = it.next();

            if ("sign".equals(en.getKey().trim())) {
                continue;
            }
            sf.append(en.getKey() + "=" + en.getValue()
                    + "&");
        }
        return sf.substring(0, sf.length() - 1);
    }

}
