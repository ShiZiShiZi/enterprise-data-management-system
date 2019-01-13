<template>
  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="部门设置"><el-col :span="10">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>修改部门名称</span>
        </div>
        <el-form :inline="true" class="demo-form-inline">
          <el-form-item label="部门名称">
            <el-input v-model="name"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="handleRenameDepartment">修改</el-button>
          </el-form-item>
        </el-form>
      </el-card>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>设置部门管理员</span>
        </div>
        <el-form :model="dynamicValidateForm" ref="addDepartmentMngForm" label-width="100px" class="demo-dynamic">
          <el-form-item label="姓名" prop="name" :rules="dynamicValidateForm.rules.name">
            <el-input v-model.number="dynamicValidateForm.name"></el-input>
          </el-form-item>
          <el-form-item prop="email" label="邮箱" :rules="dynamicValidateForm.rules.email">
            <el-input v-model="dynamicValidateForm.email"></el-input>
          </el-form-item>
          <el-form-item label="手机号" prop="phone" :rules="dynamicValidateForm.rules.phone">
            <el-input v-model.number="dynamicValidateForm.phone"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="addDepartmentManagement('addDepartmentMngForm')">提交</el-button>
            <el-button @click="resetForm('addDepartmentMngForm')">重置</el-button>
          </el-form-item>
        </el-form>
      </el-card>
    </el-col></el-tab-pane>
    <el-tab-pane label="人员信息"><el-col :span="11">
      <el-card class="box-card">
        <el-table ref="singleTable" :data="developerList" highlight-current-row>
          <el-table-column property="id" label="工号" width="120"></el-table-column>
          <el-table-column property="name" label="姓名" width="120"></el-table-column>
          <el-table-column property="phoneNum" label="电话" width="200"></el-table-column>
          <el-table-column property="email" label="邮箱" width="200"></el-table-column>
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
            <el-input-number v-model="year" @change="drawTotal" :min="2000" :max="new Date().getFullYear()" label="描述文字"></el-input-number>
            <el-alert type="success" :closable="false">
              总收入: {{totalInput}}
            </el-alert>
            <el-alert type="warning" :closable="false">
              总支出: {{totalOutput}}
            </el-alert>
            <el-alert type="success" :closable="false">
              毛利润: {{grossProfit}}
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
              v-model="projectData.chooseDate" type="daterange" range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期" @change="drawIncome" unlink-panels format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd">
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
              v-model="projectData.chooseDate" type="daterange" range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期" @change="drawExpenditure" unlink-panels format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd">
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
              v-model="projectData.chooseDate" type="daterange" range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期" @change="drawProfit" unlink-panels format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd">
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
      msg: '',
      dynamicValidateForm: {
        name: '',
        email: '',
        phone: '',
        type: 2,
        rules: {
          name: [{required: true, message: '请输入姓名', trigger: 'blur'}],
          email: [
            { required: true, message: '请输入邮箱地址', trigger: 'blur' },
            { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
          ],
          phone: [{required: true, message: '请输入手机号', trigger: 'blur'},
            { type: 'number', message: '请输入正确的手机号', trigger: ['blur', 'change'] }]
        }
      },
      developerList: [],
      currentPage: 1,
      pageSize: 10,
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
    this.id = this.$route.params.id
    this.name = this.$route.params.name
    this.getDeveloperList()
    let myDate = new Date()
    this.year = myDate.getFullYear().toString()
    this.getProjectPeopleList()
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
    handleRenameDepartment: function () {
      axios.get('http://localhost:8080/static/changeDepartmentTitle.json', { // URL: /superAdmin/renameDepartment
        params: {
          id: this.id,
          name: this.name
        }
      }).then(res => {
        this.msg = res.data.msg
        alert(this.msg)
      }).catch(function (error) {
        alert(error)
      })
    },
    addDepartmentManagement: function (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.get('http://localhost:8080/static/newDaepartmentManager.json', { // URL: /addUser
            params: {
              departmentId: this.id,
              name: this.dynamicValidateForm.name,
              email: this.dynamicValidateForm.mail,
              phoneNum: this.dynamicValidateForm.phoneNum,
              type: this.dynamicValidateForm.type
            }
          }).then(res => {
            this.msg = res.data.msg
            alert(this.msg)
          }).catch(function (error) {
            alert(error)
          })
        } else {
          alert('请按照要求填写')
        }
      })
    },
    resetForm: function (formName) {
      this.$refs[formName].resetFields()
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
    },
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
      let colors = ['#5793f3', '#d14a61', '#675bba']
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
            data: this.projectData.profitPart.profit
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
            data: this.projectData.profitPart.profitRate
          }
        ]
      }
      showProfit.setOption(option, true)
    }
  }
}
</script>

<style scoped>
  .clearfix:before,
  .clearfix:after {
    display: table;
    content: ""
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 1000px;
    text-align: left;
    margin-top: 20px;
  }
  .finance .box-card {
    width: 1200px;
  }
</style>
