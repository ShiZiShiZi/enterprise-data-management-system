<template>
  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="部门设置"><el-col :span="10">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>修改部门名称</span>
        </div>
        <el-form :inline="true" :model="formInline" class="demo-form-inline">
          <el-form-item label="部门名称">
            <el-input v-model="name"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">修改</el-button>
          </el-form-item>
        </el-form>
      </el-card>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>设置部门管理员</span>
        </div>
        <el-form :model="dynamicValidateForm" label-width="100px" class="demo-dynamic">
          <el-form-item label="姓名" prop="dname" :rules="[{required: true, message: '请输入姓名',trigger: 'blur'}]"
          >
            <el-input v-model.number="dynamicValidateForm.dname"></el-input>
          </el-form-item>
          <el-form-item
            prop="email"
            label="邮箱"
            :rules="[
                      { required: true, message: '请输入邮箱地址', trigger: 'blur' },
                      { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
                    ]">
            <el-input v-model="dynamicValidateForm.email"></el-input>
          </el-form-item>
          <el-form-item label="手机号" prop="phone" :rules="[{required: true, message: '请输入手机号',trigger: 'blur'},
          { type: 'number', message: '请输入正确的手机号', trigger: ['blur', 'change'] }]"
          >
            <el-input v-model.number="dynamicValidateForm.phone"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="addDepartmentManagement()">提交</el-button>
            <el-button @click="resetForm()">重置</el-button>
          </el-form-item>
        </el-form>
      </el-card>
    </el-col></el-tab-pane>
    <el-tab-pane label="人员信息"><el-col :span="11">
      <el-card class="box-card">
        <el-table
          ref="singleTable"
          :data="developerList"
          highlight-current-row>
          <el-table-column
            type="index"
            width="50">
          </el-table-column>
          <el-table-column
            property="id"
            label="人员id"
            width="120">
          </el-table-column>
          <el-table-column
            property="name"
            label="姓名"
            width="120">
          </el-table-column>
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
      dynamicValidateForm: {
        dname: '',
        email: '',
        phone: ''
      },
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
          'expenditure': [120, 132, 101, 134, 90, 230, 210, 110, 20, 23, 220, 219]}
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
    this.drawLine()
  },
  methods: {
    onSubmit: function () {
      alert('这里需要添加修改部门名称的请求')
    },
    addDepartmentManagement: function () {
      alert('这里需要添加添加部门管理员的请求')
    },
    resetForm: function () {
      this.dynamicValidateForm.dname = ''
      this.dynamicValidateForm.email = ''
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage
      axios.get('http://localhost:8080/static/departmentList2.json', {
        params: {
          currentPage: this.currentPage,
          pageSize: this.pageSize
        }
      }).then(res => {
        this.departmentList = res.data.departmentList
      }).catch(function (error) {
        alert(error)
      })
    },
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
          data: ['收入', '支出']
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
          }
        ]
      }
      myChart.setOption(option, true)
    }
  }
}
</script>

<style scoped>
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: ""
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 480px;
    text-align: left;
    margin-top: 20px;
  }
  .finance .box-card {
    width: 1200px;
  }
</style>
