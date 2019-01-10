package org.hfut.service.global;

import org.hfut.mapper.SelectDepartmentDataYearMapper;
import org.hfut.pojo.SelectDepartmentDataYear;
import org.hfut.pojo.SelectDepartmentDataYearExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Lee
 * @date 2019/1/10
 **/
@Service
public class DepartmentDataYearService {
    @Autowired
    SelectDepartmentDataYearMapper selectDepartmentDataYearMapper;

    public Map<String, Object> searchDepartmentDataYear(Integer departmentId, String year) {
        Map<String, Object> map = new HashMap<>(3);
        List<Double> income = new ArrayList<>();
        List<Double> expenditure = new ArrayList<>();
        List<Double> profit = new ArrayList<>();
        int y = Integer.parseInt(year);
        int x = 12;
        Date date1 = new Date();
        date1.setYear(y - 1900);
        Date date2 = new Date();
        date2.setYear(y - 1900);
        SelectDepartmentDataYearExample selectDepartmentDataYearExample = new SelectDepartmentDataYearExample();
        SelectDepartmentDataYearExample.Criteria criteria = selectDepartmentDataYearExample.createCriteria();
        for (int i = 0; i < x; i++) {
            List<SelectDepartmentDataYear> list = new ArrayList<>();
            Double in = new Double(0);
            Double out = new Double(0);
            Double make;
            Byte b1 = 1;
            Byte b2 = 2;
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, y);
            cal.set(Calendar.MONTH, i);

            date1.setMonth(i);
            date1.setDate(1);
            date1.setHours(0);
            date1.setMinutes(0);
            date1.setSeconds(0);
            date2.setMonth(i);
            date2.setDate(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
            date2.setHours(23);
            date2.setMinutes(59);
            date2.setSeconds(59);
            criteria.andDepartmentIdEqualTo(departmentId);
            criteria.andTimeBetween(date1, date2);
            list = selectDepartmentDataYearMapper.selectByExample(selectDepartmentDataYearExample);
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getType().equals(b1)) {
                    in += list.get(j).getNum();
                } else if (list.get(j).getType().equals(b2)) {
                    out += list.get(j).getNum();
                }
            }
            make = in - out;
            income.add(in);
            expenditure.add(out);
            profit.add(make);
        }
        map.put("income", income);
        map.put("expenditure", expenditure);
        map.put("profit", profit);
        return map;
    }
}
