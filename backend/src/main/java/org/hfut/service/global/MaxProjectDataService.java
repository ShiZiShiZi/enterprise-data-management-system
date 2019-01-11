package org.hfut.service.global;

import org.hfut.mapper.model.MaxProjectProfitQueryMapper;
import org.hfut.mapper.model.ProjectMaxDataQueryMapper;
import org.hfut.model.ProjectData;
import org.hfut.model.ProjectProfitData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * ProjectMaxDataService
 *
 * @author WeiXin
 * @date 2019/1/11
 **/
@Service
public class MaxProjectDataService {

    private ProjectMaxDataQueryMapper projectMaxDataQueryMapper;
    private MaxProjectProfitQueryMapper maxProjectProfitQueryMapper;

    @Autowired
    public MaxProjectDataService(ProjectMaxDataQueryMapper projectMaxDataQueryMapper,
                                 MaxProjectProfitQueryMapper maxProjectProfitQueryMapper) {
        this.projectMaxDataQueryMapper = projectMaxDataQueryMapper;
        this.maxProjectProfitQueryMapper = maxProjectProfitQueryMapper;
    }

    public void maxDataQuery(Integer departmentId, List<String> queryTimes, int queryType,
                             Map<String, Object> resultMap) throws ParseException {
        final int incomeQuery = 0;
        final int expenditureQuery = 1;
        final int profitQuery = 2;

        Date startTime;
        Date endTime;
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
                maxProfitDataQuery(exampleMap, resultMap);
                return;
            default:
                throw new RuntimeException("MaxDataQueryTypeError");
        }
    }

    public void maxProfitDataQuery(Map<String, Object> exampleMap, Map<String, Object> resultMap) {
        ProjectData projectData;
        String projectName;
        List<ProjectProfitData> projectProfitDataList = maxProjectProfitQueryMapper.selectProjectMaxProfitData(exampleMap);
        Integer projectNum = projectProfitDataList.size();
        Map<String, Object> profitMap = new HashMap<>(2);
        List<ProjectData> profitList = new ArrayList<>(projectNum);
        List<ProjectData> profitRateList = new ArrayList<>(projectNum);

        for(ProjectProfitData projectProfitData : projectProfitDataList) {
            projectName = projectProfitData.getTitle();

            projectData = new ProjectData(projectName, projectProfitData.getProfit());
            profitList.add(projectData);

            projectData = new ProjectData(projectName, projectProfitData.getProfitRate());
            profitRateList.add(projectData);
        }
        profitMap.put("profit", profitList);
        profitMap.put("profitRate", profitRateList);
        resultMap.put("profitPart", profitMap);
    }

}
