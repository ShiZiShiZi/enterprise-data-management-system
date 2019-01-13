package org.hfut.service.departmentmanager;

import org.hfut.mapper.FinancialModelMapper;
import org.hfut.pojo.FinancialModel;
import org.hfut.tool.departmentmanager.DepartmentManagerTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AlertFinancialModelService
 *
 * @author WeiXin
 * @date 2019/1/10
 **/
@Service
public class AlertFinancialModelService {

    private FinancialModelMapper financialModelMapper;

    @Autowired
    public AlertFinancialModelService(FinancialModelMapper financialModelMapper) {
        this.financialModelMapper = financialModelMapper;
    }

    public void alertName(FinancialModel financialModel, String name) {
        if(name != null && name.length() > 0) {
            financialModel.setName(name);
        } else {
            financialModel.setName(null);
        }
    }

    public void alertAmount(FinancialModel financialModel, Double amount) {
        if(amount != null) {
            financialModel.setNum(amount);
        } else {
            financialModel.setNum(null);
        }
    }

    public void alertActive(FinancialModel financialModel, Integer isClose) {
        Boolean targetActiveState = DepartmentManagerTool.getFinancialModeActiveBoolean(isClose);

        if(!financialModel.getActive().equals(targetActiveState)) {
            financialModel.setActive(targetActiveState);
        } else {
            financialModel.setActive(null);
        }
    }

    public void alertFinancialModel(FinancialModel financialModeId) {
        financialModelMapper.updateByPrimaryKeySelective(financialModeId);
    }

    public FinancialModel selectModelById(Integer modelId) {
        return financialModelMapper.selectByPrimaryKey(modelId);
    }

}
