package org.hfut.service.developer;

import org.hfut.mapper.ContractMapper;
import org.hfut.mapper.FinancialdetailMapper;
import org.hfut.mapper.FinancialdetailcontractMapper;
import org.hfut.pojo.Contract;
import org.hfut.pojo.Financialdetail;
import org.hfut.pojo.FinancialdetailcontractKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddCostService {
    @Autowired
    private FinancialdetailMapper fm;
    @Autowired
    private ContractMapper cm;
    @Autowired
    FinancialdetailcontractMapper fdm;

    public int insertFinancialDetail(String title, double receive, int projectpeopleid, int ReceiveType) {
        Financialdetail f = new Financialdetail();
        f.setNum(null);
        f.setTitle(title);
        f.setNum(receive);
        Date d = new Date();
        f.setTime(d);
        f.setFinancialmodeldetailid(ReceiveType);
        f.setType((byte) 0);
        f.setProjectpeopleid(projectpeopleid);
        fm.insert(f);
        int num = f.getId();
        return num;
    }

    public int insertContract(byte[] c) {
        Contract ct = new Contract();
        ct.setContract(c);
        ct.setId(null);
        cm.insert(ct);
        int num = ct.getId();
        return num;
    }

    public boolean insertFinancialdetailcontract(int id1, int id2) {
        FinancialdetailcontractKey fk = new FinancialdetailcontractKey();
        fk.setFinancialdetailid(id1);
        fk.setContractid(id2);
        fdm.insert(fk);
        return true;
    }

}
