package org.hfut.service.financialstaff;

import org.hfut.mapper.FinancialDetailMapper;
import org.hfut.mapper.FinancialModelMapper;
import org.hfut.pojo.FinancialDetail;
import org.hfut.pojo.FinancialDetailExample;
import org.hfut.pojo.FinancialModel;
import org.hfut.pojo.FinancialModelExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lee
 * @date 2019/1/8
 **/
@Service
public class GetFinancialDetailsService {
    @Autowired
    private FinancialDetailMapper financialDetailMapper;
    @Autowired
    private FinancialModelMapper financialModelMapper;

    public List<FinancialDetail> listFinancialDetails(Integer projectId, Integer financialDetailType) {
        List<FinancialModel> list = new ArrayList<>();
        List<FinancialDetail> list1 = new ArrayList<>();
        FinancialModelExample financialModelExample = new FinancialModelExample();
        FinancialModelExample.Criteria criteria = financialModelExample.createCriteria();
        criteria.andProjectIdEqualTo(projectId);
        list = financialModelMapper.selectByExample(financialModelExample);
        int financialModelId = list.get(0).getId();
        FinancialDetailExample financialDetailExample = new FinancialDetailExample();
        FinancialDetailExample.Criteria criteria1 = financialDetailExample.createCriteria();
        criteria1.andFinancialModelIdEqualTo(financialModelId);
        Byte b = 0;
        Byte d = 1;
        Integer num = 0;
        Integer num1 = 1;
        if (financialDetailType.equals(num)) {
            criteria1.andTypeEqualTo(b);
        } else if (financialDetailType.equals(num1)) {
            criteria1.andTypeEqualTo(d);
        }
        list1 = financialDetailMapper.selectByExample(financialDetailExample);
        return list1;
    }
}
