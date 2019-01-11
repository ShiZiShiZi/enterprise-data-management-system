package org.hfut.tool.departmentmanager;

/**
 * DepartmentManagerTool
 *
 * @author WeiXin
 * @date 2019/1/10
 **/
public class DepartmentManagerTool {

    public static Boolean getFinancialModeActiveBoolean(Integer isActive) {
        final int notActive = 0;
        final int active = 1;

        switch(isActive) {
            case notActive:
                return false;
            case active:
                return true;
            default:
        }
        throw new RuntimeException("FinancialModelActiveTypeError");
    }
}
