package org.hfut.service.global;

import org.hfut.mapper.model.ProjectMaxDataQueryMapper;
import org.hfut.model.ProjectData;
import org.hfut.tool.global.DataTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ProjectMaxDataService
 *
 * @author WeiXin
 * @date 2019/1/11
 **/
@Service
public class MaxProjectDataService {

    private ProjectMaxDataQueryMapper projectMaxDataQueryMapper;

    @Autowired
    public MaxProjectDataService(ProjectMaxDataQueryMapper projectMaxDataQueryMapper) {
        this.projectMaxDataQueryMapper = projectMaxDataQueryMapper;
    }

    public void maxDataQuery(Integer departmentId, List<String> queryTimes, int queryType,
                             Map<String, Object> resultMap) throws ParseException {
        final int incomeQuery = 0;
        final int expenditureQuery = 1;
        final int profitQuery = 2;

        Date startTime;
        Date endTime;
        List<ProjectData> incomeData;
        List<ProjectData> expenditureData;
        Map<String, Object> profitMap;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Map<String, Object> exampleMap = new HashMap<>(4);


        startTime = simpleDateFormat.parse(queryTimes.get(0));
        endTime = simpleDateFormat.parse(queryTimes.get(1));
        exampleMap.put("departmentId", departmentId);
        exampleMap.put("startTime", startTime);
        exampleMap.put("finishTime", endTime);
        switch(queryType) {
            case incomeQuery:
                exampleMap.put("dataType", 1);
                resultMap.put("incomePart", projectMaxDataQueryMapper.selectProjectMaxData(exampleMap));
                return;
            case expenditureQuery:
                exampleMap.put("dataType", 2);
                resultMap.put("expenditurePart", projectMaxDataQueryMapper.selectProjectMaxData(exampleMap));
                return;
            case profitQuery:
                exampleMap.put("dataType", 1);
                incomeData = projectMaxDataQueryMapper.selectProjectMaxData(exampleMap);
                exampleMap.put("dataType", 2);
                expenditureData = projectMaxDataQueryMapper.selectProjectMaxData(exampleMap);
                resultMap.put("profitPart", DataTool.getProjectExpenditure(incomeData, expenditureData));
                return;
            default:
                throw new RuntimeException("MaxDataQueryTypeError");
        }
    }
}
