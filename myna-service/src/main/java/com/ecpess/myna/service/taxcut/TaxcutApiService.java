package com.ecpess.myna.service.taxcut;

import com.ecpess.myna.domain.taxcut.dto.EmployDTO;
import com.ecpess.myna.domain.taxcut.dto.TradeDTO;
import java.util.List;

/**
 * @author caoqc
 * @Description:
 * @date 2019/9/4 16:03
 */
public interface TaxcutApiService {

    public String batchAddEmploy(String merNo, List<EmployDTO> employDTOList);

    public String getUserInfo(String merNo, String realName, String cardNo, String mobile, String backCard);

    public String getMerBalance(String merNo);

    public String uploadTrade(String merNo, String adviceUrl, List<TradeDTO> tradeDTOList);

    public String queryTrade(String merNo, String batchNo);

}
