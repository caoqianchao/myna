package com.ecpess.myna.testport.controller.taxcut;

import com.alibaba.fastjson.JSONObject;
import com.ecpess.myna.domain.taxcut.dto.CallBackDTO;
import com.ecpess.myna.domain.util.ResponBodyUtil;
import com.ecpess.myna.domain.util.sign.SystemSign;
import com.ecpess.myna.service.util.SignSDK;
import java.util.LinkedHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author caoqc
 * @Description:
 * @date 2019/9/5 14:46
 */
@Controller
@RequestMapping("/callback")
public class CallBackController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${TAXCUT_MER_NO}")
    String merNo;

    @Value("${TAXCUT_ADVICE_URL}")
    String adviceUrl;

    @Value("${TAXCUT_PLAT_PUB_KEY}")
    String platPubKey;

    @RequestMapping(value = "/tarde.do", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String callBack(CallBackDTO callBackDTO) {
        ResponBodyUtil responBodyUtil = new ResponBodyUtil();
        try {
            logger.info("-----------请求交易回调接收参数：[{}]", JSONObject.toJSON(callBackDTO));
            logger.info("-----------请求交易回调验签结果：[{}]", JSONObject.toJSON(callBackDTO));

            LinkedHashMap map = new LinkedHashMap();
            map.put("merNo", merNo);
            map.put("adviceUrl", adviceUrl);
            //merNo=999666&adviceUrl=http://ecpss.com
            String signData = SignSDK.coverMap2String(map);
            String sign = callBackDTO.getSign();
            boolean signResult = SystemSign.verify(signData, sign, platPubKey);
            if (signResult) {
                responBodyUtil.success(null);
            } else {
                responBodyUtil.fail("ddd", "验签失败");
            }
            logger.info("-----------请求交易回调验签结果：[{}]", signResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
        String result = responBodyUtil.toString();
        logger.info("-----------请求交易回调处理结果：[{}]", result);
        return result;
    }

}
