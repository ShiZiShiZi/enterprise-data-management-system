package org.hfut.tool.global;

import java.util.Date;

/**
 * @author panbaoqiang
 * @date 2019/1/10
 **/
public class StringConvertToDate {
    static public String initializedDateStr = "1900-01-01";

    static public Date getNewDate(String dateStr) {
        //根据一个date 的String返回一个Date对象，避免有异常抛出
        String[] dateArray = dateStr.split("-");
        return new Date(Integer.parseInt(dateArray[0]) - 1900, Integer.parseInt(dateArray[1]) - 1, Integer.parseInt(dateArray[2]));
    }
}
