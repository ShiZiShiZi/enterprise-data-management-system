package org.hfut.service.developer;

import org.hfut.mapper.*;
import org.hfut.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * InsertFinancialCostService
 *
 * @author WeiXin
 * @date 2019/1/3
 **/
@Service
public class InsertFinancialCostService {

    @Autowired
    private FinancialmodeldetailMapper financialmodeldetailMapper;
    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private FinancialdetailMapper financialdetailMapper;
    @Autowired
    private FinancialdetailcontractMapper financialdetailcontractMapper;
    @Autowired
    private FinancialdetailfeedbackMapper financialdetailfeedbackMapper;

    public boolean isFinancialModelDetailActive(Integer modelDetailId) {
        Financialmodeldetail financialmodeldetail = financialmodeldetailMapper.selectByPrimaryKey(modelDetailId);
        return financialmodeldetail.getActive();
    }

    public Integer insertContract(byte[] contractByte) {
        Contract contract = new Contract();
        contract.setContract(contractByte);
        contractMapper.insert(contract);
        return contract.getId();
    }

    public Integer insertFinancialDetail(String title, Double num, Integer financialModelDetailId,
                                         Integer projectPeopleId) {
        Financialdetail financialdetail = new Financialdetail();
        final byte cost = 1;

        financialdetail.setId(null);
        financialdetail.setTitle(title);
        financialdetail.setNum(num);
        financialdetail.setTime(new Date());
        financialdetail.setFinancialmodeldetailid(financialModelDetailId);
        financialdetail.setType(cost);
        financialdetail.setProjectpeopleid(projectPeopleId);

        financialdetailMapper.insert(financialdetail);
        return financialdetail.getId();
    }

    public void insertFinancialDetailContract(Integer financialDetailId, Integer contractId) {
        FinancialdetailcontractKey financialdetailcontractKey = new FinancialdetailcontractKey();

        financialdetailcontractKey.setFinancialdetailid(financialDetailId);
        financialdetailcontractKey.setContractid(contractId);

        financialdetailcontractMapper.insert(financialdetailcontractKey);
    }

    public void insertFinancialDetailFeedback(Integer financialDetailId) {
        Financialdetailfeedback financialdetailfeedback = new Financialdetailfeedback();
        final byte waitingReview = 0;

        financialdetailfeedback.setFinancialdetailid(financialDetailId);
        financialdetailfeedback.setRequesttime(new Date());
        financialdetailfeedback.setProjectpeopleid(null);
        financialdetailfeedback.setAudittime(null);
        financialdetailfeedback.setState(waitingReview);
        financialdetailfeedback.setDescription(null);

        financialdetailfeedbackMapper.insert(financialdetailfeedback);
    }
}
