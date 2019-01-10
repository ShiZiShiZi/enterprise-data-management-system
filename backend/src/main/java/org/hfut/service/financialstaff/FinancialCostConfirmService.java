package org.hfut.service.financialstaff;

import org.hfut.mapper.*;
import org.hfut.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * FinancialCostConfirmController
 *
 * @author WeiXin
 * @date 2019/1/10
 **/
@Service
public class FinancialCostConfirmService {

    private FinancialDetailMapper financialDetailMapper;
    private FinancialDetailFeedbackMapper financialDetailFeedbackMapper;
    private ContractMapper contractMapper;
    private FinancialLogMapper financialLogMapper;
    private FinancialLogContractMapper financialLogContractMapper;

    @Autowired
    public FinancialCostConfirmService(FinancialDetailMapper financialDetailMapper,
                                       FinancialDetailFeedbackMapper financialDetailFeedbackMapper,
                                       ContractMapper contractMapper, FinancialLogMapper financialLogMapper,
                                       FinancialLogContractMapper financialLogContractMapper) {
        this.financialDetailFeedbackMapper = financialDetailFeedbackMapper;
        this.financialDetailMapper = financialDetailMapper;
        this.contractMapper = contractMapper;
        this.financialLogMapper = financialLogMapper;
        this.financialLogContractMapper = financialLogContractMapper;
    }

    public FinancialDetail selectFinancialDetailById(Integer financialId) {
        return financialDetailMapper.selectByPrimaryKey(financialId);
    }

    public FinancialDetailFeedback selectFinancialDetailFeedbackByFinancialDetailId(Integer financialDetailId) {
        FinancialDetailFeedbackExample example = new FinancialDetailFeedbackExample();
        FinancialDetailFeedbackExample.Criteria criteria = example.createCriteria();

        criteria.andFinancialDetailIdEqualTo(financialDetailId);

        return financialDetailFeedbackMapper.selectByExample(example).get(0);
    }

    public void updateFeedback(Integer state, Integer responsePeopleId, FinancialDetailFeedback financialDetailFeedback,
                               String description) {
        final int accept = 1;
        final int refuse = 0;
        final byte stateAccept = 1;
        final byte stateRefuse = 2;

        financialDetailFeedback.setResponseTime(new Date());
        financialDetailFeedback.setResponsePeopleId(responsePeopleId);
        switch(state) {
            case accept:
                financialDetailFeedback.setDescription(null);
                financialDetailFeedback.setState(stateAccept);
                break;
            case refuse:
                financialDetailFeedback.setDescription(description);
                financialDetailFeedback.setState(stateRefuse);
                break;
            default:
        }
        financialDetailFeedbackMapper.updateByPrimaryKey(financialDetailFeedback);
    }

    public void insertFinancialLog(Integer projectPeopleId, FinancialDetail financialDetail, List<char[]> contracts,
                                   List<String> contractNameList) {
        final byte costConfirm = 2;
        Contract contract = new Contract();
        FinancialLogContractKey contractKey = new FinancialLogContractKey();

        FinancialLog financialLog = new FinancialLog();
        financialLog.setNum(financialDetail.getNum());
        financialLog.setType(costConfirm);
        financialLog.setTime(new Date());
        financialLog.setFinancialDetailId(financialDetail.getId());
        financialLog.setProjectPeopleId(projectPeopleId);
        financialLogMapper.insert(financialLog);

        contractKey.setFinancialLogId(financialLog.getId());
        for(int i = 0; i < contracts.size(); i++) {
            contract.setContract(new String(contracts.get(i)).getBytes());
            contract.setName(contractNameList.get(i));
            contractMapper.insert(contract);
            contractKey.setContractId(contract.getId());
            financialLogContractMapper.insert(contractKey);
        }
    }
}
