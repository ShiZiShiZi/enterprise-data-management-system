package org.hfut.mapper.model;

import org.hfut.model.ProjectProfitData;

import java.util.List;
import java.util.Map;

/**
 * MaxProjectProfitQueryMapper
 *
 * @author WeiXin
 * @date 2019/1/11
 */
public interface MaxProjectProfitQueryMapper {

    /**
     * 用于查找某部门利润最高的15个项目
     *
     * @param exampleMap 条件表，包含departmentID，startTime和finishTime
     *
     * @return 返回项目利润列表，包含项目标题，利润和利润率
     */
    List<ProjectProfitData> selectProjectMaxProfitData(Map<String, Object> exampleMap);
}
