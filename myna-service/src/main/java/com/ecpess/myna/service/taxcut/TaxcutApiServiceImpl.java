package com.ecpess.myna.service.taxcut;

import com.alibaba.fastjson.JSONObject;
import com.ecpess.myna.domain.taxcut.dto.EmployDTO;
import com.ecpess.myna.domain.taxcut.dto.TradeDTO;
import com.ecpess.myna.domain.util.DateUtils;
import com.ecpess.myna.domain.util.HttpClientUtil;
import com.ecpess.myna.service.util.SignSDK;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author caoqc
 * @Description:
 * @date 2019/9/4 16:09
 */
@Service
public class TaxcutApiServiceImpl implements TaxcutApiService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${TAXCUT_API_HOST}")
    private String hostUrl;

    @Value("${TAXCUT_MER_RSA_PRI_KEY}")
    private String merRsaPriKey;

    @Override
    public String batchAddEmploy(String merNo, List<EmployDTO> employDTOList) {
        try {
            String url = hostUrl + ReqConfig.GET_BATCH_ADD_EMPLOY;
            LinkedHashMap map = new LinkedHashMap();
            map.put("merNo", merNo);
            map.put("requestTime", DateUtils.formatDate(new Date(), "yyyMMddHHmmss"));
            SignSDK.sign(map,merRsaPriKey);
            map.put("employList", JSONObject.toJSONString(employDTOList));
            logger.info("-----------用户批量录入请求地址：[{}]", url);
            logger.info("-----------用户批量录入请求参数：[{}]", JSONObject.toJSONString(map));
            String result = HttpClientUtil.doPost(url, map);
            logger.info("-----------用户批量录入结果：[{}]", result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getUserInfo(String merNo, String realName, String cardNo, String mobile, String backCard) {
        try {
            String url = hostUrl + ReqConfig.GET_USER_INFO;
            LinkedHashMap map = new LinkedHashMap();

           /* merNo=999666&requestTime=20190829143606&realName=张三&mobile=15877770001&cardNo=110101199006070770&
                    bankCard=6228480030820693714*/
            map.put("merNo", merNo);
            map.put("requestTime", DateUtils.formatDate(new Date(), "yyyMMddHHmmss"));
            map.put("realName", realName);
            map.put("mobile", mobile);
            map.put("cardNo", cardNo);
            map.put("bankCard", backCard);
            SignSDK.sign(map,merRsaPriKey);
            logger.info("-----------获取用户信息请求地址：[{}]", url);
            logger.info("-----------获取用户信息请求参数：[{}]", JSONObject.toJSONString(map));
            String result = HttpClientUtil.doPost(url, map);
            logger.info("-----------获取用户信息结果：[{}]", result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getMerBalance(String merNo) {
        try {
            String url = hostUrl + ReqConfig.GET_MER_BALANCE;
            LinkedHashMap map = new LinkedHashMap();
            map.put("merNo", merNo);
            map.put("requestTime", DateUtils.formatDate(new Date(), "yyyMMddHHmmss"));
            SignSDK.sign(map,merRsaPriKey);
            logger.info("-----------获取用户请求地址：[{}]", url);
            logger.info("-----------获取用户余额请求参数：[{}]", JSONObject.toJSONString(map));
            String result = HttpClientUtil.doPost(url, map);
            logger.info("-----------获取用户余额结果：[{}]", result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String uploadTrade(String merNo, String adviceUrl, List<TradeDTO> tradeDTOList) {
        try {
            String url = hostUrl + ReqConfig.UPLOAD_TRADE;
            LinkedHashMap map = new LinkedHashMap();
            map.put("merNo", merNo);
            map.put("adviceUrl", adviceUrl);
            //merNo=999666&adviceUrl=http://ecpss.com
            SignSDK.sign(map,merRsaPriKey);
            map.put("tradeList", JSONObject.toJSONString(tradeDTOList));
            logger.info("-----------上传交易申请单请求地址：[{}]", url);
            logger.info("-----------上传交易申请单请求参数：[{}]", JSONObject.toJSONString(map));
            String result = HttpClientUtil.doPost(url, map);
            logger.info("-----------上传交易申请单结果：[{}]", result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String queryTrade(String merNo, String batchNo) {
        try {
            String url = hostUrl + ReqConfig.QUERY_TRADE;
            LinkedHashMap map = new LinkedHashMap();
            map.put("merNo", merNo);
            map.put("batchNo", batchNo);
            SignSDK.sign(map,merRsaPriKey);
            logger.info("-----------查询交易申请请求地址：[{}]", url);
            logger.info("-----------查询交易申请请求参数：[{}]", JSONObject.toJSONString(map));
            String result = HttpClientUtil.doPost(url, map);
            logger.info("-----------查询交易申请结果：[{}]", result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
