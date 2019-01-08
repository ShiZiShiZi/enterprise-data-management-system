<template>
  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="项目总览" class="finance" @change="drawTotal">
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
              v-model="ProjectData.chooseDate" type="daterange" range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期" @change="drawIncome" unlink-panels format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd">
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
              v-model="ProjectData.chooseDate" type="daterange" range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期" @change="drawExpenditure" unlink-panels format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd">
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
      id: 0,
      name: '',
      financialData: {
        totalInput: 0,
        totalOutput: 0,
        grossProfit: 0,
        financialPart: {'month': ['2019.01', '2018.12', '2018.11', '2018.10', '2018.09', '2018.08', '2018.07', '2018.06', '2018.05', '2018.04', '2018.03', '2018.02'],
          'income': [122, 123, 200, 120, 132, 400, 134, 90, 230, 210, 120, 340],
          'expenditure': [-120, -132, -101, -134, -90, -230, -210, -110, -20, -23, -220, -219],
          'profit': [2, -9, 99, -14, 42, 170, -76, -20, 210, 187, -100, 121]}
      },
      ProjectData: {
        chooseDate: '',
        incomePart: {
          'data': [{value: 122, name: '收入1'}, {value: 123, name: '收入2'}, {value: 200, name: '收入3'}, {value: 120, name: '收入4'}, {value: 132, name: '收入5'}, {value: 400, name: '收入6'}, {value: 134, name: '收入7'}, {value: 90, name: '收入8'}, {value: 230, name: '收入9'}, {value: 40, name: '收入10'}, {value: 40, name: '其他收入'}]},
        expenditurePart: {
          'data': [{value: 120, name: '支出1'}, {value: 132, name: '支出2'}, {value: 101, name: '支出3'}, {value: 134, name: '支出4'}, {value: 90, name: '支出5'}, {value: 230, name: '支出6'}, {value: 210, name: '支出7'}, {value: 110, name: '支出8'}, {value: 200, name: '支出9'}, {value: 230, name: '支出10'}, {value: 220, name: '其他支出'}]}
      }
    }
  },
  created: function () {
    this.id = this.$route.params.id
    this.name = this.$route.params.name
    axios.get('http://localhost:8080/static/developerList.json', {
      params: {
        currentPage: this.currentPage,
        pageSize: this.pageSize
      }
    }).then(res => {
      this.developerList = res.data.developerList
      this.maxPage = res.data.maxPage
    }).catch(function (error) {
      alert(error)
    })
  },
  mounted: function () {
    this.drawTotal()
    this.drawIncome()
    this.drawExpenditure()
  },
  methods: {
    drawTotal: function () {
      // to do fasong qingqiu
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
      // to do fasong qingqiu
      let showIncomeType = this.$echarts.init(document.getElementById('showIncomeType'))

      let option = {
        title: {
          text: '项目收入对比',
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
            data: this.ProjectData.incomePart.data
          }
        ]
      }
      showIncomeType.setOption(option, true)
    },
    drawExpenditure: function () {
      // to do fasong qingqiu
      let showExpenditureType = this.$echarts.init(document.getElementById('showExpenditureType'))

      let option = {
        title: {
          text: '项目支出对比',
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
            data: this.ProjectData.expenditurePart.data
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
