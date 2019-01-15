<template>
  <el-tabs width="800px" type="card">
    <el-tab-pane label="人员信息">
        <el-table ref="singleTable" :data="developerList" highlight-current-row>
          <el-table-column property="id" label="工号" width="120"></el-table-column>
          <el-table-column property="name" label="姓名" width="120"></el-table-column>
          <el-table-column property="phoneNum" label="电话" width="200"></el-table-column>
          <el-table-column property="email" label="邮箱" width="200"></el-table-column>
        </el-table>
        <el-pagination
          @current-change="handleCurrentChange"
          layout="prev, pager, next"
          :total="maxPage*10">
        </el-pagination>
    </el-tab-pane>
    <el-tab-pane label="财务信息" class="finance">
        <el-row :gutter="2">
          <el-col :span="19">
            <div id="showTotal" :style="{width: '1000px', height: '600px'}"></div>
          </el-col>
          <el-col :span="3">
            <el-row>
              <el-input-number v-model="year" :min="2000"
                               :max="new Date().getFullYear()" label="描述文字">
              </el-input-number>
            </el-row>
            <el-row>
              <el-alert type="success" :closable="false">
                总收入: {{totalInput}}
              </el-alert>
            </el-row>
            <el-row>
              <el-alert type="error" :closable="false">
                总支出: {{totalOutput}}
              </el-alert>
            </el-row>
            <el-row>
              <el-alert type="warning" :closable="false">
                毛利润: {{grossProfit}}
              </el-alert>
            </el-row>
          </el-col>
        </el-row>
    </el-tab-pane>
    <el-tab-pane label="项目收入" class="finance">
        <el-row>
          <el-col :span="16">
            <div id="showIncome" :style="{width: '1000px', height: '400px'}"></div>
          </el-col>
          <el-col :span="8">
            <el-date-picker
              v-model="projectData.chooseDate" type="daterange"
              range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期"
              @change="drawIncome" unlink-panels format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd">
            </el-date-picker>
          </el-col>
        </el-row>
    </el-tab-pane>
    <el-tab-pane label="项目支出" class="finance">
        <el-row>
          <el-col :span="16">
            <div id="showExpenditure" :style="{width: '1000px', height: '400px'}"></div>
          </el-col>
          <el-col :span="8">
            <el-date-picker
              v-model="projectData.chooseDate" type="daterange"
              range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期"
              @change="drawExpenditure" unlink-panels format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd">
            </el-date-picker>
          </el-col>
        </el-row>
    </el-tab-pane>
    <el-tab-pane label="项目利润" class="finance">
        <el-row>
          <el-col :span="16">
            <div id="showProfit" :style="{width: '1000px', height: '400px'}"></div>
          </el-col>
          <el-col :span="8">
            <el-date-picker
              v-model="projectData.chooseDate" type="daterange"
              range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期"
              @change="drawProfit" unlink-panels format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd">
            </el-date-picker>
          </el-col>
        </el-row>
    </el-tab-pane>
  </el-tabs>
</template>

<script>
import axios from 'axios'

export default {
  name: 'DataManage',
  data: function () {
    return {
      id: 0,
      name: '',
      developerList: [],
      currentPage: 1,
      pageSize: 5,
      maxPage: 1,
      totalInput: 0,
      totalOutput: 0,
      grossProfit: 0,
      year: '',
      financialData: {
        'income': [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        'expenditure': [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        'profit': [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
      },
      projectData: {
        chooseDate: [],
        incomePart: [],
        expenditurePart: [],
        profitPart: {}
      }
    }
  },
  created: function () {
    let myDate = new Date()
    this.year = myDate.getFullYear().toString()
    this.getDeveloperList()
    axios.get('http://localhost:8080/static/departmentDataTotal.json', {
      params: {
        departmentId: this.id
      }
    }).then(res => {
      this.totalInput = res.data.totalInput
      this.totalOutput = res.data.totalOutput
      this.grossProfit = res.data.grossProfit
    }).catch(function (error) {
      alert(error)
    })
    let lastMonth = new Date(new Date().setMonth(myDate.getMonth() - 1))
    this.projectData.chooseDate.push(lastMonth.getFullYear().toString() + '-' + (lastMonth.getMonth() + 1).toString() + '-' + lastMonth.getDate().toString())
    this.projectData.chooseDate.push(myDate.getFullYear().toString() + '-' + (myDate.getMonth() + 1).toString() + '-' + myDate.getDate().toString())
  },
  mounted: function () {
    this.drawTotal()
    this.drawIncome()
    this.drawExpenditure()
    this.drawProfit()
  },
  methods: {
    drawTotal: function () {
      axios.get('http://localhost:8080/static/departmentDataYear.json', {
        params: {
          departmentId: this.id,
          year: this.year
        }
      }).then(res => {
        this.financialData.income = res.data.income
        this.financialData.expenditure = res.data.expenditure
        this.financialData.profit = res.data.profit
        this.drawTotalChart()
      }).catch(function (error) {
        alert(error)
      })
    },
    drawTotalChart: function () {
      let myChart = this.$echarts.init(document.getElementById('showTotal'))
      let colors = ['#5793f3', '#f56c6c', '#e6a23c']
      let option = {
        title: {
          text: this.year + '收支状况'
        },
        color: colors,
        tooltip: {
          trigger: 'none',
          axisPointer: {
            type: 'cross'
          }
        },
        legend: {
          data: ['收入', '支出', '利润']
        },
        grid: {
          top: 70,
          bottom: 50
        },
        xAxis: [
          {
            type: 'category',
            axisTick: {
              alignWithLabel: true
            },
            axisLine: {
              onZero: false,
              lineStyle: {
                color: colors[1]
              }
            },
            axisPointer: {
              label: {
                formatter: function (params) {
                  return '金额  ' + params.value + (params.seriesData.length ? '：' + params.seriesData[0].data : '')
                }
              }
            },
            data: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12']
          },
          {
            type: 'category',
            axisTick: {
              alignWithLabel: true
            },
            axisLine: {
              onZero: false,
              lineStyle: {
                color: colors[0]
              }
            },
            axisPointer: {
              label: {
                formatter: function (params) {
                  return '金额  ' + params.value +
                    (params.seriesData.length ? '：' + params.seriesData[0].data : '')
                }
              }
            },
            data: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12']
          }
        ],
        yAxis: [
          {
            type: 'value'
          }
        ],
        series: [
          {
            name: '收入',
            type: 'line',
            xAxisIndex: 1,
            smooth: true,
            data: this.financialData.income
          },
          {
            name: '支出',
            type: 'line',
            smooth: true,
            data: this.financialData.expenditure
          },
          {
            name: '利润',
            type: 'line',
            smooth: true,
            data: this.financialData.profit
          }
        ]
      }
      myChart.setOption(option, true)
    },
    drawIncome: function () {
      axios.get('http://localhost:8080/static/departmentMaxIncomeProject.json', {
        params: {
          departmentId: this.id,
          chooseDate: this.projectData.chooseDate
        }
      }).then(res => {
        this.projectData.incomePart = res.data.incomePart
        this.drawIncomeChart()
      }).catch(function (error) {
        alert(error)
      })
    },
    drawIncomeChart: function () {
      let showIncome = this.$echarts.init(document.getElementById('showIncome'))

      let option = {
        title: {
          text: this.projectData.chooseDate + '项目收入对比',
          x: 'center'
        },
        tooltip: {
          trigger: 'item',
          formatter: '{b}{a} : {c} ({d}%)'
        },
        legend: {
          x: 'center',
          y: 'bottom'
        },
        calculable: true,
        series: [
          {
            name: '收入',
            type: 'pie',
            radius: [10, 150],
            center: ['50%', '50%'],
            roseType: 'radius',
            label: {
              normal: {
                show: false
              },
              emphasis: {
                show: true
              }
            },
            lableLine: {
              normal: {
                show: false
              },
              emphasis: {
                show: true
              }
            },
            data: this.projectData.incomePart
          }
        ]
      }
      showIncome.setOption(option, true)
    },
    drawExpenditure: function () {
      axios.get('http://localhost:8080/static/departmentMaxExpenditureProject.json', {
        params: {
          departmentId: this.id,
          chooseDate: this.projectData.chooseDate
        }
      }).then(res => {
        this.projectData.expenditurePart = res.data.expenditurePart
        this.drawExpenditureChart()
      }).catch(function (error) {
        alert(error)
      })
    },
    drawExpenditureChart: function () {
      let showExpenditure = this.$echarts.init(document.getElementById('showExpenditure'))

      let option = {
        title: {
          text: this.projectData.chooseDate + '项目支出对比',
          x: 'center'
        },
        tooltip: {
          trigger: 'item',
          formatter: '{b}{a} : {c} ({d}%)'
        },
        legend: {
          x: 'center',
          y: 'bottom'
        },
        calculable: true,
        series: [
          {
            name: '支出',
            type: 'pie',
            radius: [10, 150],
            center: ['50%', '50%'],
            roseType: 'radius',
            label: {
              normal: {
                show: false
              },
              emphasis: {
                show: true
              }
            },
            lableLine: {
              normal: {
                show: false
              },
              emphasis: {
                show: true
              }
            },
            data: this.projectData.expenditurePart
          }
        ]
      }
      showExpenditure.setOption(option, true)
    },
    drawProfit: function () {
      axios.get('http://localhost:8080/static/departmentMaxProfitProject.json', {
        params: {
          departmentId: this.id,
          chooseDate: this.projectData.chooseDate
        }
      }).then(res => {
        this.projectData.profitPart.profit = res.data.profitPart.profit
        this.projectData.profitPart.profitRate = res.data.profitPart.profitRate
        this.drawProfitChart()
      }).catch(function (error) {
        alert(error)
      })
    },
    drawProfitChart: function () {
      let showProfit = this.$echarts.init(document.getElementById('showProfit'))

      let option = {
        title: {
          text: this.projectData.chooseDate + '项目利润对比与项目利润率对比',
          x: 'center'
        },
        tooltip: {
          trigger: 'item',
          formatter: '{b}{a} : {c} ({d}%)'
        },
        legend: {
          x: 'center',
          y: 'bottom'
        },
        calculable: true,
        series: [
          {
            name: '利润',
            type: 'pie',
            radius: [10, 150],
            center: ['25%', '50%'],
            roseType: 'radius',
            label: {
              normal: {
                show: false
              },
              emphasis: {
                show: true
              }
            },
            lableLine: {
              normal: {
                show: false
              },
              emphasis: {
                show: true
              }
            },
            data: this.projectData.profitPart.profit
          },
          {
            name: '利润率',
            type: 'pie',
            radius: [10, 150],
            center: ['75%', '50%'],
            roseType: 'radius',
            label: {
              normal: {
                show: false
              },
              emphasis: {
                show: true
              }
            },
            lableLine: {
              normal: {
                show: false
              },
              emphasis: {
                show: true
              }
            },
            data: this.projectData.profitPart.profitRate
          }
        ]
      }
      showProfit.setOption(option, true)
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage
      this.getDeveloperList()
    },
    getDeveloperList: function () {
      axios.get('http://localhost:8080/static/developerList.json', { // URL:/projectPeopleSearch
        params: {
          currentPage: this.currentPage,
          pageSize: this.pageSize,
          departmentId: this.id,
          sortColumn: 'id',
          sortOrder: 1
        }
      }).then(res => {
        this.developerList = res.data.projectPeopleList
        this.maxPage = res.data.maxPage
      }).catch(function (error) {
        alert(error)
      })
    }
  }
}
</script>

<style scoped>
  .el-pagination {
    text-align: center;
  }
  .el-row {
    margin-bottom: 20px;
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }

</style>
