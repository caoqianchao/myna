package com.ecpess.myna.service.taxcut;

import com.ecpess.myna.domain.taxcut.dto.EmployDTO;
import com.ecpess.myna.domain.taxcut.dto.TradeDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author caoqc
 * @Description:
 * @date 2019/9/5 15:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaxcutApiServiceImplTest.class)
@SpringBootApplication(scanBasePackages = "com.cqc.test")
@Ignore
public class TaxcutApiServiceImplTest {

    @Resource
    private TaxcutApiService userApiService;

    private static final String MER_NO = "473487";

    private static final String ADVICE_URL = "http://192.168.1.77:8080/callback/tarde.do";

    @Test
    @Ignore
    public void batchAddEmploy() {
        List<EmployDTO> employDTOList = new ArrayList<>();
        // String realName, String cardNo, String mobile, String empNo, String bankCard
        for (int i = 0; i < 10; i++) {
            String realName = "阿拉丁" + i;
            String cardNo = "52263119920427423"+i;
            String mobile = "1580000001" + i;
            String empNo = "" + i;
            String bankCard = "622202100112862568" + i;
            EmployDTO employDTO = new EmployDTO(realName, cardNo, mobile, empNo, bankCard);
            employDTOList.add(employDTO);
        }
        userApiService.batchAddEmploy(MER_NO, employDTOList);
    }

    @Test
    @Ignore
    public void getUserInfo() {
        String realName = "曹瑞1";
        String cardNo = "522631199204274233";
        String mobile = "15800000001";
        String empNo = "bh1";
        String bankCard = "6222021001128625680";
        userApiService.getUserInfo(MER_NO, realName, cardNo, mobile, bankCard);
    }

    @Test
    @Ignore
    public void getMerBalance() {
        userApiService.getMerBalance(MER_NO);
    }


    @Test
    @Ignore
    public void uploadTrade() {
        List<TradeDTO> tradeDTOList = new ArrayList<>();
        String userName = "曹瑞0";
        String userCard = "522631199204274233";
        String cardNo = "6222021001128625680";
        String amount = "20.78"; //经营服务费税后，保留2位小数
        String bank = "中国银行";
        TradeDTO tradeDTO = new TradeDTO(userName, userCard, cardNo, amount, bank);
        tradeDTOList.add(tradeDTO);
        /*tradeDTO = new TradeDTO("冯谈", "6228480030820693713", "110101199011078355", amount, bank);
        tradeDTO = new TradeDTO("林龙", "6228480030820693718", "21010219900307176X", amount, bank);*/
        tradeDTOList.add(tradeDTO);




        userApiService.uploadTrade(MER_NO, ADVICE_URL, tradeDTOList);
    }

    @Test
    public void queryTrade() {
        userApiService.queryTrade(MER_NO,"4734872019090516555917");
    }

}