<template>
  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="项目总览" class="finance">
      <el-card class="box-card">
        <el-row>
          <el-col :span="20">
            <div id="showTotal" :style="{width: '1000px', height: '400px'}"></div>
          </el-col>
          <el-col :span="3">
            <el-alert type="success" :closable="false">
              总收入: {{financialData.totalInput}}
            </el-alert>
            <el-alert type="warning" :closable="false">
              总支出: {{financialData.totalOutput}}
            </el-alert>
            <el-alert type="success" :closable="false">
              总利润: {{financialData.grossProfit}}
            </el-alert>
          </el-col>
        </el-row>
      </el-card>
    </el-tab-pane>
    <el-tab-pane label="项目收入类别" class="finance">
      <el-card class="box-card">
        <el-row>
          <el-col :span="16">
            <div id="showIncomeType" :style="{width: '1000px', height: '400px'}"></div>
          </el-col>
          <el-col :span="7">
            <el-date-picker
              v-model="projectData.chooseDate" type="daterange"
              range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期"
              @change="drawIncome" unlink-panels format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd">
            </el-date-picker>
          </el-col>
        </el-row>
      </el-card>
    </el-tab-pane>
    <el-tab-pane label="项目支出类别" class="finance">
      <el-card class="box-card">
        <el-row>
          <el-col :span="16">
            <div id="showExpenditureType" :style="{width: '1000px', height: '400px'}"></div>
          </el-col>
          <el-col :span="7">
            <el-date-picker
              v-model="projectData.chooseDate" type="daterange"
              range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期"
              @change="drawExpenditure" unlink-panels format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd">
            </el-date-picker>
          </el-col>
        </el-row>
      </el-card>
    </el-tab-pane>
  </el-tabs>
</template>

<script>import axios from 'axios'
export default {
  name: 'ProjectFinanceManage',
  data: function () {
    return {
      projectId: 0,
      name: '',
      financialData: {
        totalInput: 0,
        totalOutput: 0,
        grossProfit: 0,
        financialPart: {'month': [],
          'income': [],
          'expenditure': [],
          'profit': []}
      },
      projectData: {
        chooseDate: [],
        incomePart: [],
        expenditurePart: []
      }
    }
  },
  created: function () {
    this.projectId = this.$route.params.id
    this.name = this.$route.params.name
    axios.get('http://localhost:8080/static/projectDataTotal.json', {
      params: {
        projectId: this.projectId
      }
    }).then(res => {
      this.financialData.totalInput = res.data.financialData.totalInput
      this.financialData.totalOutput = res.data.financialData.totalOutput
      this.financialData.grossProfit = res.data.financialData.grossProfit
    }).catch(function (error) {
      alert(error)
    })
    let myDate = new Date()
    let lastMonth = new Date(new Date().setMonth(myDate.getMonth() - 1))
    this.projectData.chooseDate.push(lastMonth.getFullYear().toString() + '-' + (lastMonth.getMonth() + 1).toString() + '-' + lastMonth.getDate().toString())
    this.projectData.chooseDate.push(myDate.getFullYear().toString() + '-' + (myDate.getMonth() + 1).toString() + '-' + myDate.getDate().toString())
  },
  mounted: function () {
    this.drawTotal()
    this.drawIncome()
    this.drawExpenditure()
  },
  methods: {
    drawTotal: function () {
      axios.get('http://localhost:8080/static/projectDataTotal.json', {
        params: {
          projectId: this.projectId
        }
      }).then(res => {
        this.financialData.financialPart.month = res.data.financialData.financialPart.month
        this.financialData.financialPart.income = res.data.financialData.financialPart.income
        this.financialData.financialPart.expenditure = res.data.financialData.financialPart.expenditure
        this.financialData.financialPart.profit = res.data.financialData.financialPart.profit
        this.drawTotalChart()
      }).catch(function (error) {
        alert(error)
      })
    },
    drawTotalChart: function () {
      let myChart = this.$echarts.init(document.getElementById('showTotal'))

      let option = {
        title: {
          text: this.name + '收支状况'
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        legend: {
          data: ['利润', '支出', '收入']
        },
        dataZoom: [{
          type: 'slider',
          start: 50,
          end: 70
        }, {
          type: 'inside',
          start: 50,
          end: 70
        }],
        xAxis: {
          type: 'category',
          axisTick: {show: false},
          data: this.financialData.financialPart.month
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: '利润',
            type: 'bar',
            label: {
              normal: {
                show: true,
                position: 'inside'
              }
            },
            data: this.financialData.financialPart.profit
          },
          {
            name: '收入',
            type: 'bar',
            stack: '总量',
            label: {
              normal: {
                show: true
              }
            },
            data: this.financialData.financialPart.income
          },
          {
            name: '支出',
            type: 'bar',
            stack: '总量',
            label: {
              normal: {
                show: true,
                position: 'inside'
              }
            },
            data: this.financialData.financialPart.expenditure
          }
        ]
      }
      myChart.setOption(option, true)
    },
    drawIncome: function () {
      axios.get('http://localhost:8080/static/projectMaxIncomeType.json', {
        params: {
          projectId: this.projectId,
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
      let showIncomeType = this.$echarts.init(document.getElementById('showIncomeType'))

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
            radius: [10, 120],
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
      showIncomeType.setOption(option, true)
    },
    drawExpenditure: function () {
      axios.get('http://localhost:8080/static/projectMaxExpenditureType.json', {
        params: {
          projectId: this.projectId,
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
      let showExpenditureType = this.$echarts.init(document.getElementById('showExpenditureType'))

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
            radius: [10, 120],
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
      showExpenditureType.setOption(option, true)
    }
  }
}
</script>

<style scoped>
  .box-card {
    width: 480px;
    text-align: left;
    margin-top: 20px;
  }
  .finance .box-card {
    width: 1200px;
  }
</style>
