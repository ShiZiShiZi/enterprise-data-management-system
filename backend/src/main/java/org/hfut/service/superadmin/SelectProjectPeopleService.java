package org.hfut.service.superadmin;

import org.hfut.mapper.SelectProjectPeopleInfoMapper;
import org.hfut.pojo.SelectProjectPeopleInfo;
import org.hfut.pojo.SelectProjectPeopleInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectProjectPeopleService {
    @Autowired
    private SelectProjectPeopleInfoMapper selectProjectPeopleInfoMapper;
    public List<SelectProjectPeopleInfo> getAllProjectPeople(){
        SelectProjectPeopleInfoExample selectprojectpeopleinfoExample = new SelectProjectPeopleInfoExample();
        return selectProjectPeopleInfoMapper.selectByExample(selectprojectpeopleinfoExample);
    }
}
