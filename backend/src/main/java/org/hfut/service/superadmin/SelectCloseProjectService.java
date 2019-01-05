package org.hfut.service.superadmin;

import org.hfut.mapper.ProjectMapper;
import org.hfut.pojo.Project;
import org.hfut.pojo.ProjectExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class SelectCloseProjectService {
    @Autowired
    private ProjectMapper pm;

    public List<Project> listProjectName(String year, String month) {
        List<Project> lp = new ArrayList<>();
        ProjectExample pe = new ProjectExample();
        ProjectExample.Criteria criteria = pe.createCriteria();
        Date d = new Date();
        Date d1 = new Date();
        int y = Integer.parseInt(year);
        int m = Integer.parseInt(month);
        d.setYear(y - 1900);
        d.setMonth(m - 1);
        d.setDate(1);
        d1.setYear(y - 1900);
        d1.setMonth(m);
        d1.setDate(1);
        d1.setDate(d1.getDate() - 1);
        criteria.andActiveEqualTo(false);
        criteria.andClosetimeBetween(d, d1);
        lp = pm.selectByExample(pe);
        return lp;
    }

}
