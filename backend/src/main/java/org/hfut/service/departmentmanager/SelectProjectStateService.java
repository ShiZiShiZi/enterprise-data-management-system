package org.hfut.service.departmentmanager;
import org.hfut.mapper.FinancialModelMapper;
import org.hfut.mapper.ProjectMapper;
import org.hfut.mapper.SelectAllFinancialInformationMapper;
import org.hfut.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * @author panbaoqiang
 * @date 2019/1/11
 **/
@Service
public class SelectProjectStateService {

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private FinancialModelMapper financialModelMapper;

    @Autowired
    private SelectAllFinancialInformationMapper selectAllFinancialInformationMapper;


    public Map<Integer,List<Integer>> getProjectFinancialDetail(List<Integer> projectListId){
        Map<Integer,List<Integer>> projectMap = new HashMap<>(20);
        for(Integer projectId : projectListId){
            List<Integer> integerList = new ArrayList<>();
            /*算出类别费用累计超出预算数:0表示没超出*/
            integerList.add(getBudgetSate(projectId));
            /*类别收入超出目标数:0表示没超出*/
            integerList.add(getIncomeState(projectId));
            /*是否是超期并且未完结，也就是未关闭*/
            integerList.add(isOverdueAndEnd(projectId));
            projectMap.put(projectId,integerList);
        }
        return projectMap;
    }
    private Integer getBudgetSate(Integer projectId){
        //    先算出预算值
        double budget = getModel(projectId, (byte)0);
        //   算出费用值
        double actualCost = getLog(projectId,(byte)2);
        //    添加预算是否超出信息
        return actualCost>budget ? 1 : 0;
    }
    private Integer getIncomeState(Integer projectId){
        //   先算预先收了多少
        double beforehandIncome = getLog(projectId,(byte)0);
        //   算出确认收入
        double confirmedIncome = getLog(projectId,(byte)1);
        //  算出目标数
        double targetIncome = getModel(projectId,(byte)1);
        return targetIncome >= (beforehandIncome + confirmedIncome) ? 0 : 1;
    }

    private Double getModel(Integer projectId,Byte type){
        //直接单表查询financial_model，type = 0 预先可能支出的费用， type = 1 可能得到的收入（目标数）
        Double totalCount = 0.0 ;
        FinancialModelExample financialModelExample = new FinancialModelExample();
        FinancialModelExample.Criteria criteria = financialModelExample.createCriteria();
        criteria.andProjectIdEqualTo(projectId).andTypeEqualTo(type);
        //是这个项目并且是预算或预收的
        List<FinancialModel> financialModelList = financialModelMapper.selectByExample(financialModelExample);
        for(FinancialModel financialModel:financialModelList){
            totalCount+=financialModel.getNum();
        }
        return totalCount;
    }
    private Double getLog(Integer projectId,Byte type){
        //三个表连接,以financial_log为主拼接的表，三个表是financial_log,financial_detail，financial_model.
        //log_type = 2说明是确认支出也就是花费，1说明是已经确认的收入，0是指已经预先收了多少钱。
        Double totalCount=0.0;
        SelectAllFinancialInformationExample selectAllFinancialInformationExample = new SelectAllFinancialInformationExample();
        SelectAllFinancialInformationExample.Criteria criteria = selectAllFinancialInformationExample.createCriteria();
        criteria.andProjectIdEqualTo(projectId).andLogTypeEqualTo(type);
        List<SelectAllFinancialInformation> selectAllFinancialInformationList = selectAllFinancialInformationMapper.selectByExample(selectAllFinancialInformationExample);
        for(SelectAllFinancialInformation selectAllFinancialInformation:selectAllFinancialInformationList){
            totalCount += selectAllFinancialInformation.getLogNum();
        }
        return totalCount;
    }
    private Integer isOverdueAndEnd(Integer projectId){
        //前提id一定存在
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria criteria = projectExample.createCriteria();
        criteria.andIdEqualTo(projectId);
        Project project = projectMapper.selectByExample(projectExample).get(0);
        return new Date().after(project.getFinishTime()) && project.getActive() ? 1 : 0;
    }
}
