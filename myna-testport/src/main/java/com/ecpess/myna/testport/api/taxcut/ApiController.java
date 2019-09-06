package com.ecpess.myna.testport.api.taxcut;

import com.ecpess.myna.domain.taxcut.dto.EmployDTO;
import com.ecpess.myna.domain.taxcut.dto.TradeDTO;
import com.ecpess.myna.service.taxcut.TaxcutApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caoqc
 * @Description:
 * @date 2019/9/5 20:38
 */
@RestController
@RequestMapping(value = "/taxcut")
@Api(value = "省心宝API")
public class ApiController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private TaxcutApiService taxcutApiService;

    @ApiOperation(value = "查询账户余额", notes = "查询账户余额")
    @ApiImplicitParam(name = "merNo", value = "商户号", required = true, dataType = "String")
    @RequestMapping(value = "/getMerBalance.do", method = RequestMethod.POST)
    public String getMerBalance(@RequestBody String merNo) {
        return taxcutApiService.getMerBalance(merNo);
    }


    @ApiOperation(value = "用户批量录入", notes = "用户批量录入")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "merNo", value = "商户号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "employList", value = "用户信息列表", required = true, dataType = "EmployDTO")
    })
    @RequestMapping(value = "/{merNo}/batchAddEmploy.do", method = RequestMethod.POST)
    public String batchAddEmploy(@PathVariable(value = "merNo") String merNo, @RequestBody List<EmployDTO> employList) {
        return taxcutApiService.batchAddEmploy(merNo, employList);
    }

    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "merNo", value = "商户号", paramType = "query", required = true,
                    dataType = "String"),
            @ApiImplicitParam(name = "realName", value = "姓名", paramType = "query", required = true,
                    dataType = "String"),
            @ApiImplicitParam(name = "cardNo", value = "身份证号", paramType = "query", required = true,
                    dataType = "String"),
            @ApiImplicitParam(name = "mobile", value = "手机号", paramType = "query", required = true,
                    dataType = "String"),
            @ApiImplicitParam(name = "bankCard", value = "银行卡号", paramType = "query", required = true,
                    dataType = "String")
    })
    @RequestMapping(value = "/getEmployInfo.do", method = RequestMethod.POST)
    public String getEmployInfo(String merNo, String realName, String cardNo, String mobile, String bankCard) {
        return taxcutApiService.getUserInfo(merNo, realName, cardNo, mobile, bankCard);
    }


    @ApiOperation(value = "上传交易申请单", notes = "上传交易申请单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "merNo", value = "商户号", paramType = "path", required = true,
                    dataType = "String",defaultValue = ""),
            @ApiImplicitParam(name = "adviceUrl", value = "回调地址", paramType = "query", required = true,
                    dataType = "String",defaultValue = "http://192.168.1.77:8080/callback/tarde.do"),
            @ApiImplicitParam(name = "tradeList", value = "身份证号", required = true,
                    dataType = "TradeDTO")
    })
    @RequestMapping(value = "/{merNo}/uploadTrade.do", method = RequestMethod.POST)
    public String uploadTrade(@PathVariable(value = "merNo") String merNo,
                              String adviceUrl,
                              @RequestBody List<TradeDTO> tradeList) {
        return taxcutApiService.uploadTrade(merNo, adviceUrl, tradeList);
    }

    @ApiOperation(value = "查询交易申请", notes = "查询交易申请")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "merNo", value = "商户号", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "batchNo", value = "交易批次号", paramType = "query", required = true, dataType = "String")
    })
    @RequestMapping(value = "/queryTrade.do", method = RequestMethod.POST)
    public String queryTrade(String merNo, String batchNo) {
        return taxcutApiService.queryTrade(merNo, batchNo);
    }


}
