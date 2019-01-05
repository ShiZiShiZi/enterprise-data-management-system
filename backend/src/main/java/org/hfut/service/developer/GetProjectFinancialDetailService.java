package org.hfut.service.developer;

import org.hfut.mapper.SelectProjectFinancialmodeldetailMapper;
import org.hfut.pojo.SelectProjectFinancialmodeldetail;
import org.hfut.pojo.SelectProjectFinancialmodeldetailExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * GetProjectFinancialDetailService
 *
 * @author WeiXin
 * @date 2019/1/3
 **/
@Service
public class GetProjectFinancialDetailService {
    @Autowired
    private SelectProjectFinancialmodeldetailMapper projectFinancialmodeldetailMapper;

    public List<SelectProjectFinancialmodeldetail> getFinancialModelDetail(Integer projectId) {
        SelectProjectFinancialmodeldetailExample financialmodeldetailExample = new SelectProjectFinancialmodeldetailExample();
        SelectProjectFinancialmodeldetailExample.Criteria criteria = financialmodeldetailExample.createCriteria();
        List<SelectProjectFinancialmodeldetail> financialmodeldetailList;
        final byte cost = 0;

        criteria.andProjectidEqualTo(projectId);
        criteria.andTypeEqualTo(cost);
        financialmodeldetailList = projectFinancialmodeldetailMapper.selectByExample(financialmodeldetailExample);

        return financialmodeldetailList;
    }
}
