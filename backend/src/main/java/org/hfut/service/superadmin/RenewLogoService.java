package org.hfut.service.superadmin;

import org.hfut.mapper.EnterpriseMapper;
import org.hfut.pojo.Enterprise;
import org.hfut.pojo.EnterpriseExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lee
 * @date 2019/1/14
 **/
@Service
public class RenewLogoService {
    @Autowired
    private EnterpriseMapper enterpriseMapper;

    public String renewLogo(String logo) {
        String msg = "更新失败！";
        EnterpriseExample enterpriseExample = new EnterpriseExample();
        Enterprise enterprise = new Enterprise();
        enterprise.setLogo(logo.getBytes());
        if (enterpriseMapper.updateByExampleSelective(enterprise, enterpriseExample) == 1) {
            msg = "更新成功！";
        }
        return msg;
    }
}
