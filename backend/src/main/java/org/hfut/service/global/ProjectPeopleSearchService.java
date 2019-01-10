package org.hfut.service.global;

import org.hfut.mapper.ProjectPeopleMapper;
import org.hfut.pojo.ProjectPeople;
import org.hfut.pojo.ProjectPeopleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lee
 * @date 2019/1/7
 **/
@Service
public class ProjectPeopleSearchService {
    @Autowired
    private ProjectPeopleMapper projectPeopleMapper;

    public List<ProjectPeople> listProjectPeople(List<Integer> projectId, String name, Integer isAcrossDepartment,
                                                 Integer isDepartmentIdIn, Integer departmentId, String sortColumn,
                                                 Integer sortOrder) {
        List<ProjectPeople> list = new ArrayList<>();
        String str = "0";
        Integer num = -1;
        Integer num1 = 0;
        Integer num2 = 1;
        ProjectPeopleExample projectPeopleExample = new ProjectPeopleExample();
        ProjectPeopleExample.Criteria criteria = projectPeopleExample.createCriteria();
        if (!projectId.isEmpty()) {
            for (int i = 0; i < projectId.size(); i++) {
                criteria.andIdEqualTo(projectId.get(i));
            }
        }
        if (!name.equals(str)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (isAcrossDepartment.equals(num1)) {
            criteria.andAcrossDepartmentEqualTo(false);
        }
        if (isAcrossDepartment.equals(num2)) {
            criteria.andAcrossDepartmentEqualTo(true);
        }
        if (!departmentId.equals(num)) {
            if (isDepartmentIdIn.equals(num2)) {
                criteria.andDepartmentIdEqualTo(departmentId);
            } else if (isDepartmentIdIn.equals(num1)) {
                criteria.andDepartmentIdNotEqualTo(departmentId);
            }
        }
        if (sortOrder.equals(num)) {
            sortColumn += " DESC";
        }
        if (sortOrder.equals(num2)) {
            sortColumn += " ASC";
        }
        List<Byte> l = new ArrayList<>();
        Byte b1 = 1;
        Byte b3 = 3;
        l.add(b1);
        l.add(b3);
        criteria.andPermissionsIn(l);
        projectPeopleExample.setOrderByClause(sortColumn);
        list = projectPeopleMapper.selectByExample(projectPeopleExample);
        for (int j = 0; j < list.size(); j++) {
            list.get(j).setPassword(null);
        }
        return list;
    }
}
