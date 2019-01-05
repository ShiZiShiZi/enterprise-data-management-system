package org.hfut.service.developer;

import org.hfut.mapper.SelectCloseprojectinfoMapper;
import org.hfut.model.CloseProjectInfo;
import org.hfut.pojo.SelectCloseprojectinfo;
import org.hfut.pojo.SelectCloseprojectinfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CloseProjectInfoService {
    @Autowired
    private SelectCloseprojectinfoMapper scm;

    public List<CloseProjectInfo> listCloseProject(int id) {
        List<SelectCloseprojectinfo> lp = new ArrayList<>();
        List<CloseProjectInfo> l = new ArrayList<>();
        SelectCloseprojectinfoExample sce = new SelectCloseprojectinfoExample();
        SelectCloseprojectinfoExample.Criteria criteria = sce.createCriteria();
        criteria.andIdEqualTo(id);
        lp = scm.selectByExample(sce);
        double allget = 0;
        double allcost = 0;
        double allreceive = 0;
        for (int i = 0; i < lp.size(); i++) {
            CloseProjectInfo c = new CloseProjectInfo();
            if (lp.get(i).getType() == 0) {
                allreceive += lp.get(i).getNum();
                c.setPerreceive(lp.get(i).getNum());
            } else if (lp.get(i).getType() == 1) {
                allget += lp.get(i).getNum();
                c.setPerget(lp.get(i).getNum());
            } else if (lp.get(i).getType() == 2) {
                allcost += lp.get(i).getNum();
                c.setPercost(lp.get(i).getNum());
            }
            c.setMonth(lp.get(i).getTime().getMonth() + 1);
            l.add(c);
        }
        for (int j = 0; j < l.size(); j++) {
            l.get(j).setAllcost(allcost);
            l.get(j).setAllget(allget);
            l.get(j).setAllreceive(allreceive);
        }
        return l;
    }
}
