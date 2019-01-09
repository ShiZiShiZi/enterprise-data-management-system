package org.hfut.service.departmentmanager;

import org.hfut.mapper.FinancialModelMapper;
import org.hfut.pojo.FinancialModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lee
 * @date 2019/1/9
 **/
@Service
public class AddFinancialModelService {
    @Autowired
    private FinancialModelMapper financialModelMapper;

    public String insertFinancialModel(Integer projectId, String name, Double amount, Integer modelDetailType) {
        String msg = "插入失败";
        FinancialModel financialModel = new FinancialModel();
        financialModel.setProjectId(projectId);
        financialModel.setName(name);
        financialModel.setNum(amount);
        Byte b1 = 0;
        Byte b2 = 1;
        Integer i1 = 0;
        Integer i2 = 1;
        if (modelDetailType.equals(i1)) {
            financialModel.setType(b1);
        }
        if (modelDetailType.equals(i2)) {
            financialModel.setType(b2);
        }
        financialModel.setActive(true);
        if (financialModelMapper.insert(financialModel) == 1) {
            msg = "插入成功";
        }
        return msg;
    }
}
