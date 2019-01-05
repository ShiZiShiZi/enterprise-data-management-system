package org.hfut.service.developer;

import org.hfut.mapper.SelectPersonProjectMapper;
import org.hfut.pojo.Project;
import org.hfut.pojo.SelectPersonProject;
import org.hfut.pojo.SelectPersonProjectExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetProjectService {
    @Autowired
    private SelectPersonProjectMapper sppm;

    public List<SelectPersonProject> listProject(int id) {
        List<SelectPersonProject> lp = new ArrayList<>();
        SelectPersonProjectExample sppe = new SelectPersonProjectExample();
        SelectPersonProjectExample.Criteria criteria = sppe.createCriteria();
        criteria.andIdEqualTo(id);
        lp = sppm.selectByExample(sppe);
        return lp;
    }
}
