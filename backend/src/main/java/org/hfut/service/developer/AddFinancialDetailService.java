package org.hfut.service.developer;

import org.hfut.mapper.ContractMapper;
import org.hfut.mapper.FinancialDetailContractMapper;
import org.hfut.mapper.FinancialDetailFeedbackMapper;
import org.hfut.mapper.FinancialDetailMapper;
import org.hfut.pojo.Contract;
import org.hfut.pojo.FinancialDetail;
import org.hfut.pojo.FinancialDetailContractKey;
import org.hfut.pojo.FinancialDetailFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Lee
 * @date 2019/1/13
 **/
@Service
public class AddFinancialDetailService {
    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private FinancialDetailMapper financialDetailMapper;
    @Autowired
    private FinancialDetailContractMapper financialDetailContractMapper;
    @Autowired
    private FinancialDetailFeedbackMapper financialDetailFeedbackMapper;

    public String addFinancialDetail(Integer financialModelId, String title, Integer type, Double num, Integer id,
                                     List<String> fileNameList, List<String> fileByteList) {
        String msg = "插入失败！";
        Byte b = 0;
        Byte b1 = 1;
        Integer i = 0;
        Integer i1 = 1;
        FinancialDetail financialDetail = new FinancialDetail();
        financialDetail.setTitle(title);
        financialDetail.setNum(num);
        financialDetail.setTime(new Date());
        financialDetail.setFinancialModelId(financialModelId);
        if (type.equals(i)) {
            financialDetail.setType(b);
        } else if (type.equals(i1)) {
            financialDetail.setType(b1);
        }
        financialDetail.setProjectPeopleId(id);
        if (financialDetailMapper.insert(financialDetail) == 1) {
            msg = "插入成功！";
        }
        Integer financialDetailId = financialDetail.getId();

        if (type.equals(i1)) {
            FinancialDetailFeedback financialDetailFeedback = new FinancialDetailFeedback();
            financialDetailFeedback.setFinancialDetailId(financialDetailId);
            financialDetailFeedback.setRequestTime(new Date());
            financialDetailFeedback.setState(b);
            financialDetailFeedbackMapper.insert(financialDetailFeedback);
        }

        for (int k = 0; k < fileByteList.size(); k++) {
            Contract contract = new Contract();
            contract.setContract(fileByteList.get(k).getBytes());
            contract.setName(fileNameList.get(k));
            if (contractMapper.insert(contract) == 0) {
                msg = "插入失败！";
                break;
            }
            Integer contractId = contract.getId();

            FinancialDetailContractKey financialDetailContractKey = new FinancialDetailContractKey();
            financialDetailContractKey.setFinancialDetailId(financialDetailId);
            financialDetailContractKey.setContractId(contractId);
            if (financialDetailContractMapper.insert(financialDetailContractKey) == 0) {
                msg = "插入失败！";
                break;
            }
        }

        return msg;
    }
}
