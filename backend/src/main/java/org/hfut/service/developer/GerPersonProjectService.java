package org.hfut.service.developer;

import org.hfut.mapper.FinancialmodeldetailMapper;
import org.hfut.mapper.SelectPersonProjectMapper;
import org.hfut.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ProjectService
 *
 * @author WeiXin
 * @date 2019/1/1
 **/
@Service
public class GerPersonProjectService {

    @Autowired
    private SelectPersonProjectMapper selectPersonProjectMapper;


    public List<SelectPersonProject> getPersonProjectByPersonId(Integer id) {
        SelectPersonProjectExample selectPersonProjectExample = new SelectPersonProjectExample();
        SelectPersonProjectExample.Criteria criteria = selectPersonProjectExample.createCriteria();
        List<SelectPersonProject> personProjects;

        criteria.andProjectpeopleidEqualTo(id);
        personProjects = selectPersonProjectMapper.selectByExample(selectPersonProjectExample);


        return personProjects;
    }
}
