package org.hfut.tool.global;

import org.hfut.model.ProjectData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DataTool
 *
 * @author WeiXin
 * @date 2019/1/11
 **/
public class DataTool {

    public static Map<String, Object> getProjectExpenditure(List<ProjectData> incomePart,
                                                            List<ProjectData> expenditurePart) {
        Double income;
        Double expenditure;
        String projectName;
        int projectNum = incomePart.size();
        Map<String, Object> resultMap = new HashMap<>(2);
        List<ProjectData> profit = new ArrayList<>(projectNum);
        List<ProjectData> profitRate = new ArrayList<>(projectNum);

        for(int i = 0; i < projectNum; i++) {
            projectName = incomePart.get(i).getName();
            income = incomePart.get(i).getValue();
            expenditure = expenditurePart.get(i).getValue();
            setProfit(income, expenditure, profit, projectName);
            setProfitRate(income, expenditure, profitRate, projectName);
        }

        resultMap.put("profit", profit);
        resultMap.put("profitRate", profitRate);

        return resultMap;
    }

    private static void setProfit(Double income, Double expenditure, List<ProjectData> profit, String projectName) {
        ProjectData profitData = new ProjectData();
        profitData.setName(projectName);
        profitData.setValue(expenditure - income);
        profit.add(profitData);
    }

    private static void setProfitRate(Double income, Double expenditure, List<ProjectData> profitRate,
                                      String projectName) {
        ProjectData profitData = new ProjectData();
        profitData.setName(projectName);
        profitData.setValue(income / expenditure);
        profitRate.add(profitData);
    }
}
