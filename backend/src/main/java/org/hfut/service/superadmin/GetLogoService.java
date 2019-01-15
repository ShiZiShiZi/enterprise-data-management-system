package org.hfut.service.superadmin;

import org.hfut.mapper.EnterpriseMapper;
import org.hfut.pojo.Enterprise;
import org.hfut.pojo.EnterpriseExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lee
 * @date 2019/1/14
 **/
@Service
public class GetLogoService {
    @Autowired
    private EnterpriseMapper enterpriseMapper;

    public String getLogo() {
        EnterpriseExample enterpriseExample = new EnterpriseExample();
        List<Enterprise> list = enterpriseMapper.selectByExampleWithBLOBs(enterpriseExample);
        System.out.println(list.size());
        String msg=new String (list.get(0).getLogo());
        return msg;
    }
}
