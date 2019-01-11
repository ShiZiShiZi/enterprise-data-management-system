package org.hfut.mapper.model;

import org.hfut.model.ProjectData;

import java.util.List;
import java.util.Map;

/**
 * ProjectMaxDataQueryMapper
 *
 * @author weixin
 * @date 2019/01/11
 */
public interface ProjectMaxDataQueryMapper {

    /**
     * 用于查询数据（收入，支出，利润）最高的15个项目
     *
     * @param exampleMap 参数字典，包括部门id，起止时间，数据类别
     *
     * @return List<ProjectData> 数据列表，包含两个字段，值和项目标题
     */
    List<ProjectData> selectProjectMaxData(Map<String, Object> exampleMap);
}
