<template>
  <el-card class="box-card">
    <el-row>
      <el-col :span="20">
        <div id="myChart" :style="{width: '1000px', height: '400px'}"></div>
      </el-col>
      <el-col :span="3">
        <el-input-number v-model="financialData.financialPart.year" @change="drawLine" :min="2016" :max="2100" label="描述文字"></el-input-number>
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
</template>

<script>import axios from 'axios'
export default {
  name: 'SubDepartmentManagement',
  data: function () {
    return {
      id: 0,
      name: '',
      financialData: {
        totalInput: 0,
        totalOutput: 0,
        grossProfit: 0,
        financialPart: {'year': '2018',
          'income': [122, 123, 200, 120, 132, 400, 134, 90, 230, 210, 120, 340],
          'expenditure': [120, 132, 101, 134, 90, 230, 210, 110, 20, 23, 220, 219],
          'grossprofit': [120, 132, 101, 134, 90, 230, 134, 90, 230, 210, 120, 340]}
      }
    }
  },
  created: function () {
    this.id = this.$route.params.id
    this.name = this.$route.params.name
    axios.get('static/developerList.json', {
      params: {
        id: this.id,
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
    this.drawLine()
  },
  methods: {
    drawLine: function () {
      // to do fasong qingqiu
      let myChart = this.$echarts.init(document.getElementById('myChart'))
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
          data: ['收入', '支出', '毛利润']
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
            name: '毛利润',
            type: 'line',
            smooth: true,
            data: this.financialData.financialPart.grossprofit
          }
        ]
      }
      myChart.setOption(option, true)
    }
  }
}
</script>

<style scoped>
  .box-card {
    width: 1200px;
    text-align: left;
    margin-top: 20px;
  }
</style>
