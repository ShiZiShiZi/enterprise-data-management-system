package org.hfut.model;

/**
 * ProjectProfitData
 *
 * @author WeiXin
 * @date 2019/1/11
 **/
public class ProjectProfitData {

    private Double profit;
    private Double profitRate;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(Double profitRate) {
        this.profitRate = profitRate;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }
}
