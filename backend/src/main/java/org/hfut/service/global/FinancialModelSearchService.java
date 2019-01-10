package org.hfut.service.global;

import org.hfut.mapper.FinancialModelMapper;
import org.hfut.pojo.FinancialModel;
import org.hfut.pojo.FinancialModelExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * FinancialModelSearchService
 *
 * @author WeiXin
 * @date 2019/1/9
 **/
@Service
public class FinancialModelSearchService {

    @Autowired
    FinancialModelMapper financialModelMapper;

    public void selectByProjectId(FinancialModelExample.Criteria criteria, Integer projectId) {
        criteria.andProjectIdEqualTo(projectId);
    }

    public void selectByType(FinancialModelExample.Criteria criteria, Integer type) {
        if(type != null) {
            byte typeByte = type.byteValue();
            criteria.andTypeEqualTo(typeByte);
        }
    }

    public void selectByActive(FinancialModelExample.Criteria criteria, Integer active) {
        if(active != null) {
            boolean isActive;
            if(active == 0) {
                isActive = false;
            } else {
                isActive = true;
            }

            criteria.andActiveEqualTo(isActive);
        }
    }

    public void selectFinancialModel(FinancialModelExample financialModelExample, Map<String, Object> resultMap) {
        List<FinancialModel> financialModelList;

        financialModelList = financialModelMapper.selectByExample(financialModelExample);
        resultMap.put("financialModelList", financialModelList);
    }
}
