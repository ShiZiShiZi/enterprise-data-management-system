package org.hfut.service.financialstaff;

import org.hfut.mapper.ContractMapper;
import org.hfut.mapper.FinancialLogContractMapper;
import org.hfut.mapper.FinancialLogMapper;
import org.hfut.pojo.Contract;
import org.hfut.pojo.FinancialLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 卅果果
 * @date 2019/1/11
 **/
@Service
public class AddFinancialLogService {
    @Autowired
    private FinancialLogMapper financialLogMapper;

    @Autowired
    private ContractMapper contractMapper;

    public String addFinancialLog(Integer projectPeopleId, Double amount, Float taxRate, Byte type, Integer financialDetailId, byte[] contract, String name) {
        String msg = "插入失败";
        FinancialLog financialLog = new FinancialLog();
        byte num = 1;
        Date date = new Date();
        financialLog.setNum(amount);
        financialLog.setType(type);
        financialLog.setFinancialDetailId(financialDetailId);
        financialLog.setTime(date);
        financialLog.setProjectPeopleId(projectPeopleId);
        if (type.equals(num)) {
            financialLog.setTaxRate(taxRate);
        }
        if (financialLogMapper.insert(financialLog) == 1) {
            Contract contract1 = new Contract();
            contract1.setContract(contract);
            contract1.setName(name);
            if (contractMapper.insert(contract1) == 1) {
                msg = "插入成功";
            }
        }
        return msg;

    }
}
