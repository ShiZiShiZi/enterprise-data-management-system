package org.hfut.mapper.model;

import org.hfut.model.ProjectPeopleState;
import org.hfut.pojo.ProjectPeople;

import java.util.List;
import java.util.Map;

/**
 * ProjectPeopleStateMapper
 *
 * @author WeiXin
 * @date 2919/1/12
 */
public interface ProjectPeopleStateMapper {

    /**
     * 获得目标人员的跨部门请求状态
     *
     * @param exampleMap 目标人员ID,目标项目ID
     *
     * @return 人员状态集合列表
     */
    List<ProjectPeopleState> selectByTargetPeopleId(Map<String, Object> exampleMap);
}
