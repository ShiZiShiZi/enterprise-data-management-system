package org.hfut.service.developer;

import org.hfut.mapper.SelectProjectFinancialmodeldetailMapper;
import org.hfut.pojo.SelectProjectFinancialmodeldetail;
import org.hfut.pojo.SelectProjectFinancialmodeldetailExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetReceiveTypeService {
    @Autowired
    private SelectProjectFinancialmodeldetailMapper spfm;

    public List<SelectProjectFinancialmodeldetail> listProjectFinancialmodeldetail(int pid) {
        List<SelectProjectFinancialmodeldetail> lp = new ArrayList<>();
        SelectProjectFinancialmodeldetailExample spfe = new SelectProjectFinancialmodeldetailExample();
        SelectProjectFinancialmodeldetailExample.Criteria criteria = spfe.createCriteria();
        criteria.andProjectidEqualTo(pid);
        lp = spfm.selectByExample(spfe);
        return lp;
    }
}
