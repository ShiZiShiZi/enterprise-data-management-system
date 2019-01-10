package org.hfut.service.global;

import org.hfut.mapper.SelectProjectMaxExpenditureTypeMapper;
import org.hfut.pojo.SelectProjectMaxExpenditureType;
import org.hfut.pojo.SelectProjectMaxExpenditureTypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Lee
 * @date 2019/1/10
 **/
@Service
public class ProjectMaxExpenditureTypeService {
    @Autowired
    SelectProjectMaxExpenditureTypeMapper selectProjectMaxExpenditureTypeMapper;

    public List<Map> searchProjectMaxExpenditureType(Integer projectId, List<String> chooseDate) {
        List<Map> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>(11);
        List<SelectProjectMaxExpenditureType> l = new ArrayList<>();
        String[] time1 = chooseDate.get(0).split("-");
        String[] time2 = chooseDate.get(1).split("-");
        int year1 = Integer.parseInt(time1[0]);
        int month1 = Integer.parseInt(time1[1]);
        int day1 = Integer.parseInt(time1[2]);
        int year2 = Integer.parseInt(time2[0]);
        int month2 = Integer.parseInt(time2[1]);
        int day2 = Integer.parseInt(time2[2]);
        Date date1 = new Date();
        date1.setYear(year1 - 1900);
        date1.setMonth(month1);
        date1.setDate(day1);
        date1.setHours(0);
        date1.setMinutes(0);
        date1.setSeconds(0);

        Date date2 = new Date();
        date2.setYear(year2 - 1900);
        date2.setMonth(month2);
        date2.setDate(day2);
        date2.setHours(23);
        date2.setMinutes(59);
        date2.setSeconds(59);

        SelectProjectMaxExpenditureTypeExample selectProjectMaxExpenditureTypeExample = new SelectProjectMaxExpenditureTypeExample();
        SelectProjectMaxExpenditureTypeExample.Criteria criteria = selectProjectMaxExpenditureTypeExample.createCriteria();
        criteria.andProjectIdEqualTo(projectId);
        criteria.andTimeBetween(date1, date2);
        l = selectProjectMaxExpenditureTypeMapper.selectByExample(selectProjectMaxExpenditureTypeExample);
        Map<String, Double> m = new TreeMap<String, Double>();
        Double sum = new Double(0);
        int x = 10;
        for (int i = 0; i < l.size(); i++) {
            m.put(l.get(i).getTitle(), l.get(i).getNum());
        }
        List<Map.Entry<String, Double>> lists = new ArrayList<Map.Entry<String, Double>>(m.entrySet());
        Collections.sort(lists, new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                double q1 = o1.getValue();
                double q2 = o2.getValue();
                double p = q2 - q1;
                if (p > 0) {
                    return 1;
                } else if (p == 0) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        for (Map.Entry<String, Double> set : lists) {
            System.out.println(set.getKey() + " " + set.getValue());
        }
        if (lists.size() > x) {
            for (int j = 10; j < lists.size(); j++) {
                sum += lists.get(j).getValue();
            }
            m.put("其他", sum);
            list.add(m);
        } else {
            list.add(m);
        }
        return list;
    }

}
