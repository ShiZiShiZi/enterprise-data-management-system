package org.hfut.service.superadmin;

import org.hfut.mapper.EnterpriseMapper;
import org.hfut.pojo.Enterprise;
import org.hfut.pojo.EnterpriseExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateEnterpriseService {
    @Autowired
    private EnterpriseMapper enterpriseMapper;

    //    第一个模块
    public List<Enterprise> getEnterpriseInfo(){
        //获取企业的信息
        EnterpriseExample enterpriseExample = new EnterpriseExample();
        List<Enterprise> listEnterprise = enterpriseMapper.selectByExampleWithBLOBs(enterpriseExample);
        return listEnterprise;
    }

    public void updateEnterpriseInfo(String name,byte[] logo){
        //更新企业信息
        EnterpriseExample enterpriseExample = new EnterpriseExample();
        Enterprise enterprise = new Enterprise();
        enterprise.setName(name);
        enterprise.setLogo(logo);
        enterpriseMapper.updateByExampleSelective(enterprise,enterpriseExample);
        //reviews 的人帮我看下是否有错，上面那一句,有的话通知我.
    }
}
