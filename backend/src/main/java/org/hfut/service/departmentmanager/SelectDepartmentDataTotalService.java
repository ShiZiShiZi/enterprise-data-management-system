package org.hfut.service.departmentmanager;

import org.hfut.mapper.SelectDepartmentFinancialLogMapper;
import org.hfut.pojo.SelectDepartmentFinancialLog;
import org.hfut.pojo.SelectDepartmentFinancialLogExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author panbaoqiang
 * @date 2019/1/15
 **/
@Service
public class SelectDepartmentDataTotalService {
    @Autowired
    private SelectDepartmentFinancialLogMapper selectDepartmentFinancialLogMapper;

    public Map<String,Object> getDepartmentDataTotal(Integer departmentId){
        Map<String,Object> map = new HashMap<>(3);
        //获取预收
        List<SelectDepartmentFinancialLog> reivableInAdvanceList =
                selectDepartmentFinancialLogMapper.selectByExample(getSelectDepartmentFinancialLogExample(departmentId,(byte)0));
        //获取收入
        List<SelectDepartmentFinancialLog> realIncomeList =
                selectDepartmentFinancialLogMapper.selectByExample(getSelectDepartmentFinancialLogExample(departmentId,(byte)1));
        //获取费用支出
        List<SelectDepartmentFinancialLog> costExpenditureList =
                selectDepartmentFinancialLogMapper.selectByExample(getSelectDepartmentFinancialLogExample(departmentId,(byte)2));
        Double income = getCountBy(reivableInAdvanceList)+getCountBy(realIncomeList);
        Double output = -1 * getCountBy(costExpenditureList);
        Double profit = income + output;
        map.put("totalInput",income);
        map.put("totalOutput",output);
        map.put("grossProfit",profit);
        return map;
    }
    private Double getCountBy(List<SelectDepartmentFinancialLog> financialList){
        Double sum = 0.0;
        for(SelectDepartmentFinancialLog selectDepartmentFinancialLog:financialList){
            sum += selectDepartmentFinancialLog.getLogNum();
        }
        return sum;
    }
    private SelectDepartmentFinancialLogExample getSelectDepartmentFinancialLogExample(Integer departmentId, Byte type){
        SelectDepartmentFinancialLogExample selectDepartmentFinancialLogExample = new SelectDepartmentFinancialLogExample();
        SelectDepartmentFinancialLogExample.Criteria criteria = selectDepartmentFinancialLogExample.createCriteria();
        criteria.andDepartmentIdEqualTo(departmentId).andLogTypeEqualTo(type);
        return selectDepartmentFinancialLogExample;
    }
}
