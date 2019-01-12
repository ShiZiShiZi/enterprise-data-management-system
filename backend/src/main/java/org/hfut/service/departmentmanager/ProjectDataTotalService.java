package org.hfut.service.departmentmanager;
import org.hfut.mapper.ProjectMapper;
import org.hfut.mapper.SelectAllFinancialInformationMapper;
import org.hfut.pojo.Project;
import org.hfut.pojo.SelectAllFinancialInformation;
import org.hfut.pojo.SelectAllFinancialInformationExample;
import org.hfut.pojo.ProjectExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * @author panbaoqiang
 * @date 2019/1/10
 **/
@Service
public class ProjectDataTotalService {
    /**
     * 这个是管理员查看36个月项目收支的，
     * 第一个解决的就是如何查找这个项目下面的所有财务信息
     *这些财务信息有些是不同月份的，并且是实际收入，也就是说我们可以通过financial_log进行获取
     *用三个表进行去合并!!!
     *finacial_log  拼接 financial_detail 拼接 financial_model
     * 形成 SelectAllFinancialInformation
    **/
    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private SelectAllFinancialInformationMapper selectAllFinancialInformationMapper;

    public Map<String,List<Object>> getProjectDataTotal(Integer projectId){
        Map<String,List<Object>> totalMap = new HashMap<>(3);
        List<Object> monthList = new ArrayList<>();
        List< Object> incomeList = new ArrayList<>();
        List<Object> expenditureList = new ArrayList<>();
        List<Object> profitList =new ArrayList<>();
        Project project = getProjectById(projectId);
        Date startTimeDate = project.getStartTime();
        Date finaTimeDate = project.getActive() ? new Date() : project.getCloseTime();
        Calendar beginCalendar = initializationCalender(startTimeDate);
        Calendar endCalendar = initializationCalender(finaTimeDate);

        for(int countMonth = 1 ;
            countMonth <= 36 &&(beginCalendar.equals(endCalendar) || beginCalendar.before(endCalendar));
            countMonth++){
            //月份从第一个开始，添加这个月份
            monthList.add(beginCalendar.get(Calendar.MONTH)+1);
            //获取他每个月的区间， firstDay = xxxx-xx-01 00:00:00
            // last = xxxx-xx-xx 23:59:59
            Date firstDay = getDate(beginCalendar.getTime(),false,0,0,0);
            Date lastDay = getDate(beginCalendar.getTime(),true,23,59,59);
            //获取他这个月的预收的list
            SelectAllFinancialInformationExample selectAllFinancialInformationExample = getSelectAllFinancialInformationExample(firstDay,lastDay,projectId,(byte)0);
            List<SelectAllFinancialInformation> advanceList = getLogDetail(selectAllFinancialInformationExample);
            //获取他这个月实际收入的list
            SelectAllFinancialInformationExample selectAllFinancialInformationExample1 = getSelectAllFinancialInformationExample(firstDay,lastDay,projectId,(byte)1);
            List<SelectAllFinancialInformation> realIncomeList = getLogDetail(selectAllFinancialInformationExample1);
            //将这个月预收还有实际收入加起来
            Double totalMonthIncome = getCount(advanceList) + getCount(realIncomeList);
            incomeList.add(totalMonthIncome);

            //获取这个月的支出添加的list
            SelectAllFinancialInformationExample selectAllFinancialInformationExample2 = getSelectAllFinancialInformationExample(firstDay,lastDay,projectId,(byte)2);
            List<SelectAllFinancialInformation> costList = getLogDetail(selectAllFinancialInformationExample2);
            Double totalMonthExpenditure = -1 * getCount(costList);
            //添加支出
            expenditureList.add(totalMonthExpenditure);
            //添加利润
            profitList.add(totalMonthExpenditure + totalMonthIncome);
            //将月份加一
            beginCalendar.add(Calendar.MONTH,1);
        }
        totalMap.put("month",monthList);
        totalMap.put("income",incomeList);
        totalMap.put("expenditure",expenditureList);
        totalMap.put("profit",profitList);
        return totalMap;
    }
    private Double getCount(List<SelectAllFinancialInformation> allList){
        //将生成的视图关于financial_log财务细节的logNum增加
        Double sum = 0.0;
        for(SelectAllFinancialInformation selectAllFinancialInformation:allList){
            sum += selectAllFinancialInformation.getLogNum();
        }
        return sum;
    }
    private SelectAllFinancialInformationExample getSelectAllFinancialInformationExample(Integer projectId,
                                                                                         Byte state){
        SelectAllFinancialInformationExample selectAllFinancialInformationExample = new SelectAllFinancialInformationExample();
        SelectAllFinancialInformationExample.Criteria criteria = selectAllFinancialInformationExample.createCriteria();
        criteria.andProjectIdEqualTo(projectId).andLogTypeEqualTo(state);
        return selectAllFinancialInformationExample;
    }
    private SelectAllFinancialInformationExample getSelectAllFinancialInformationExample(Date begin,
                                                                                               Date end,
                                                                                               Integer projectId,
                                                                                               Byte state){
        SelectAllFinancialInformationExample selectAllFinancialInformationExample = new SelectAllFinancialInformationExample();
        SelectAllFinancialInformationExample.Criteria criteria = selectAllFinancialInformationExample.createCriteria();
        criteria.andLogTimeBetween(begin, end).andProjectIdEqualTo(projectId).andLogTypeEqualTo(state);
        return selectAllFinancialInformationExample;
    }

    private List<SelectAllFinancialInformation> getLogDetail(SelectAllFinancialInformationExample selectAllFinancialInformationExample){
        //state是实际财务的状态，预收，收入，还是支出，
        //从这个项目中筛选出logTime在begin - end的财务细节视图
        //是这个项目，并且是这个类型，而且在这个区间
        return selectAllFinancialInformationMapper.selectByExample(selectAllFinancialInformationExample);
    }
    private Date getDate(Date date,
                         Boolean status,
                         Integer hourOfDay,
                         Integer minute,
                         Integer second){
        //获取date日期的这个月的第一天0时0秒0分，或者是这个月的最后一天23时59分59秒
        //status = false说明是这个月第一天第一秒，true说明是这个月的最后一天最后一秒
        //每个月区间是第一天的00:00:00 到最后一天的23:59:59才能正确选择该月的财务细节
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //先将他设置成该月的第一天
        calendar.set(Calendar.DAY_OF_MONTH,1);
        if(status){
            //增加一个月
            calendar.add(Calendar.MONTH, 1);
            //在减去一天，就变成了原来月份的最后一天
            calendar.add(Calendar.DATE,-1);
        }
        //根据需要设置时
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        // 根据需要设置分
        calendar.set(Calendar.MINUTE, minute);
        // 根据需要设置秒
        calendar.set(Calendar.SECOND, second);
        return calendar.getTime();
    }
    private Calendar initializationCalender(Date date){
        // 项目是从2019-1-15 到 2025-3-7结束
        //而我每次都是根据起始日期一个月一个月的累加
        //对上面两个时间进行初始化下，将他变成：
        //2019-1-1 00:00:00 和 2025-3-1 00:00:00
        //这样我就是简单的判断前面一个是不是(before或者equal)（!after）后面哪一个
        //这是防止出现从2019-1-15一直增加到2025-3-15的时候由于
        //2025-3-15 是在 2025-3-7之后而退出，
        //我认定2025-3-1 到2025-3-7也算做一个月
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar;
    }
    private Project getProjectById(Integer projectId){
        //根据projectId获取项目
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria criteria = projectExample.createCriteria();
        criteria.andIdEqualTo(projectId);
        return projectMapper.selectByExample(projectExample).get(0);
    }

    public Double getTotalInputBy(Integer projectId){
        Double totalInput ;
        //所有预收加项目部署后的收入
        SelectAllFinancialInformationExample selectAllFinancialInformationExample = getSelectAllFinancialInformationExample(projectId,(byte)0);
        SelectAllFinancialInformationExample selectAllFinancialInformationExample1 = getSelectAllFinancialInformationExample(projectId,(byte)1);
        totalInput = getCount(getLogDetail(selectAllFinancialInformationExample))+getCount(getLogDetail(selectAllFinancialInformationExample1));
        return totalInput;
    }
    public Double getTotalOutputBy(Integer projectId){
        Double totalOutput;
        //所有的支出
        SelectAllFinancialInformationExample selectAllFinancialInformationExample = getSelectAllFinancialInformationExample(projectId,(byte)2);
        totalOutput = getCount(getLogDetail(selectAllFinancialInformationExample));
        return totalOutput;
    }
}
