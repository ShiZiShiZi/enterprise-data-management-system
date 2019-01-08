<template>
  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="人员信息"><el-col :span="11">
      <el-card class="box-card">
        <el-table ref="singleTable" :data="developerList" highlight-current-row>
          <el-table-column type="index" width="50"></el-table-column>
          <el-table-column property="id" label="人员id" width="120"></el-table-column>
          <el-table-column property="name" label="姓名" width="120"></el-table-column>
        </el-table>
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          layout="prev, pager, next"
          :total="maxPage*10">
        </el-pagination>
      </el-card>
    </el-col></el-tab-pane>
    <el-tab-pane label="财务信息" class="finance">
      <el-card class="box-card">
        <el-row>
          <el-col :span="20">
            <div id="showTotal" :style="{width: '1000px', height: '400px'}"></div>
          </el-col>
          <el-col :span="3">
            <el-input-number v-model="financialData.financialPart.year" @change="drawTotal" :min="2016" :max="2100" label="描述文字"></el-input-number>
            <el-alert type="success" :closable="false">
              总收入: {{financialData.totalInput}}
            </el-alert>
            <el-alert type="warning" :closable="false">
              总支出: {{financialData.totalOutput}}
            </el-alert>
            <el-alert type="success" :closable="false">
              毛利润: {{financialData.grossProfit}}
            </el-alert>
          </el-col>
        </el-row>
      </el-card>
    </el-tab-pane>
    <el-tab-pane label="项目收入" class="finance">
      <el-card class="box-card">
        <el-row>
          <el-col :span="16">
            <div id="showIncome" :style="{width: '1000px', height: '400px'}"></div>
          </el-col>
          <el-col :span="7">
            <el-date-picker
              v-model="ProjectData.chooseDate" type="daterange" range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期" @change="drawIncome" unlink-panels>
            </el-date-picker>
          </el-col>
        </el-row>
      </el-card>
    </el-tab-pane>
    <el-tab-pane label="项目支出" class="finance">
      <el-card class="box-card">
        <el-row>
          <el-col :span="16">
            <div id="showExpenditure" :style="{width: '1000px', height: '400px'}"></div>
          </el-col>
          <el-col :span="7">
            <el-date-picker
              v-model="ProjectData.chooseDate" type="daterange" range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期" @change="drawExpenditure" unlink-panels>
            </el-date-picker>
          </el-col>
        </el-row>
      </el-card>
    </el-tab-pane>
    <el-tab-pane label="项目利润" class="finance">
      <el-card class="box-card">
        <el-row>
          <el-col :span="16">
            <div id="showProfit" :style="{width: '1000px', height: '400px'}"></div>
          </el-col>
          <el-col :span="7">
            <el-date-picker
              v-model="ProjectData.chooseDate" type="daterange" range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期" @change="drawProfit" unlink-panels>
            </el-date-picker>
          </el-col>
        </el-row>
      </el-card>
    </el-tab-pane>
  </el-tabs>
</template>

<script>import axios from 'axios'
export default {
  name: 'SubDepartmentManagement',
  data: function () {
    return {
      id: 0,
      name: '',
      developerList: [],
      currentPage: 1,
      pageSize: 8,
      maxPage: 1,
      financialData: {
        totalInput: 0,
        totalOutput: 0,
        grossProfit: 0,
        financialPart: {'year': '2018',
          'income': [122, 123, 200, 120, 132, 400, 134, 90, 230, 210, 120, 340],
          'expenditure': [120, 132, 101, 134, 90, 230, 210, 110, 20, 23, 220, 219],
          'profit': [2, -9, 99, -14, 42, 170, -76, -20, 210, 187, -100, 121]}
      },
      ProjectData: {
        chooseDate: '',
        incomePart: {
          'data': [{value: 122, name: '项目1'}, {value: 123, name: '项目2'}, {value: 200, name: '项目3'}, {value: 120, name: '项目4'}, {value: 132, name: '项目5'}, {value: 400, name: '项目6'}, {value: 134, name: '项目7'}, {value: 90, name: '项目8'}, {value: 230, name: '项目9'}, {value: 40, name: '项目10'}, {value: 40, name: '项目11'}, {value: 40, name: '项目12'}, {value: 210, name: '项目13'}, {value: 120, name: '项目14'}, {value: 340, name: '项目15'}]},
        expenditurePart: {
          'data': [{value: 120, name: '项目1'}, {value: 132, name: '项目2'}, {value: 101, name: '项目3'}, {value: 134, name: '项目4'}, {value: 90, name: '项目5'}, {value: 230, name: '项目6'}, {value: 210, name: '项目7'}, {value: 110, name: '项目8'}, {value: 200, name: '项目9'}, {value: 230, name: '项目10'}, {value: 220, name: '项目11'}, {value: 219, name: '项目12'}, {value: 210, name: '项目13'}, {value: 120, name: '项目14'}, {value: 340, name: '项目15'}]},
        profitPart: {
          'data1': [{value: 122, name: '项目1'}, {value: 123, name: '项目2'}, {value: 200, name: '项目3'}, {value: 120, name: '项目4'}, {value: 132, name: '项目5'}, {value: 400, name: '项目6'}, {value: 134, name: '项目7'}, {value: 90, name: '项目8'}, {value: 230, name: '项目9'}, {value: 40, name: '项目10'}, {value: 40, name: '项目11'}, {value: 40, name: '项目12'}, {value: 210, name: '项目13'}, {value: 120, name: '项目14'}, {value: 340, name: '项目15'}],
          'data2': [{value: 0.1, name: '项目1'}, {value: 0.2, name: '项目2'}, {value: 0.2, name: '项目3'}, {value: 0.15, name: '项目4'}, {value: 0.7, name: '项目5'}, {value: 0.42, name: '项目6'}, {value: 0.42, name: '项目7'}, {value: 0.43, name: '项目8'}, {value: 0.27, name: '项目9'}, {value: 0.12, name: '项目10'}, {value: 0.54, name: '项目11'}, {value: 0.56, name: '项目12'}, {value: 0.17, name: '项目13'}, {value: 0.12, name: '项目14'}, {value: 0.34, name: '项目15'}]}
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
    this.drawProfit()
  },
  methods: {
    drawTotal: function () {
      // to do fasong qingqiu
      let myChart = this.$echarts.init(document.getElementById('showTotal'))
      let colors = ['#5793f3', '#d14a61', '#675bba']

      let option = {
        title: {
          text: this.financialData.financialPart.year + '收支状况'
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
                  return '金额  ' + params.value +
                    (params.seriesData.length ? '：' + params.seriesData[0].data : '')
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
            data: this.financialData.financialPart.income
          },
          {
            name: '支出',
            type: 'line',
            smooth: true,
            data: this.financialData.financialPart.expenditure
          },
          {
            name: '利润',
            type: 'line',
            smooth: true,
            data: this.financialData.financialPart.profit
          }
        ]
      }
      myChart.setOption(option, true)
    },
    drawIncome: function () {
      // to do fasong qingqiu
      let showIncome = this.$echarts.init(document.getElementById('showIncome'))

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
        toolbox: {
          show: true,
          feature: {
            mark: {show: true},
            dataView: {show: true, readOnly: false},
            magicType: {
              show: true,
              type: ['pie']
            },
            restore: {show: true},
            saveAsImage: {show: true}
          }
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
      showIncome.setOption(option, true)
    },
    drawExpenditure: function () {
      // to do fasong qingqiu
      let showExpenditure = this.$echarts.init(document.getElementById('showExpenditure'))

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
        toolbox: {
          show: true,
          feature: {
            mark: {show: true},
            dataView: {show: true, readOnly: false},
            magicType: {
              show: true,
              type: ['pie']
            },
            restore: {show: true},
            saveAsImage: {show: true}
          }
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
      showExpenditure.setOption(option, true)
    },
    drawProfit: function () {
      // to do fasong qingqiu
      let showProfit = this.$echarts.init(document.getElementById('showProfit'))

      let option = {
        title: {
          text: '项目利润对比',
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
        toolbox: {
          show: true,
          feature: {
            mark: {show: true},
            dataView: {show: true, readOnly: false},
            magicType: {
              show: true,
              type: ['pie']
            },
            restore: {show: true},
            saveAsImage: {show: true}
          }
        },
        calculable: true,
        series: [
          {
            name: '利润',
            type: 'pie',
            radius: [10, 120],
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
            data: this.ProjectData.profitPart.data1
          },
          {
            name: '利润率',
            type: 'pie',
            radius: [10, 120],
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
            data: this.ProjectData.profitPart.data2
          }
        ]
      }
      showProfit.setOption(option, true)
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
