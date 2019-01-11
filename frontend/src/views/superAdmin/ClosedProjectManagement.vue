<template>
  <el-card class="box-card">
    <el-row>
      <el-col :span="2" class="text-left">搜索日期：</el-col>
      <el-col :span="3">
        <el-date-picker
          v-model="month"
          type="month"
          placeholder="选择月"
          format="yyyy 年 MM 月"
          value-format="yyyy-MM">
        </el-date-picker>
      </el-col>
      <el-col :span="2" class="text-left">搜索项目：</el-col>
      <el-col :span="3">
        <el-input v-model="projectTitle" placeholder="请输入内容"></el-input>
      </el-col>
    </el-row>
    <el-table
      ref="singleTable"
      :data="closedProjectList"
      highlight-current-row>
      <el-table-column
        type="index"
        width="50">
      </el-table-column>
      <el-table-column
        property="name"
        label="项目名称"
        width="120">
      </el-table-column>
      <el-table-column
        property="department"
        label="部门名称"
        width="120">
      </el-table-column>
      <el-table-column
        property="closedtime"
        label="关闭时间"
        width="120">
      </el-table-column>
      <el-table-column
        label=" "
        width="100">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      layout="prev, pager, next"
      :total="maxPage*10">
    </el-pagination>
  </el-card>
</template>

<script>
import axios from 'axios'

export default {
  name: 'ClosedProjectManagement',
  data: function () {
    return {
      month: '',
      projectTitle: '',
      type: 'closed',
      closedProjectList: [],
      currentPage: 1,
      pageSize: 3,
      maxPage: 2
    }
  },
  created: function () {
    this.getClosedProjectList()
  },
  watch: {
    month (val) {
      this.getClosedProjectList()
    },
    projectTitle (val) {
      this.getClosedProjectList()
    }
  },
  methods: {
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage
      this.getClosedProjectList()
    },
    handleClick: function (row) {
      this.$router.push('showClosedProject/' + row.id + '/' + row.name)
    },
    getClosedProjectList: function () {
      axios.get('http://localhost:8080/static/closedProjectList.json', {
        params: {
          currentPage: this.currentPage,
          pageSize: this.pageSize,
          month: this.month,
          projectTitle: this.projectTitle,
          type: this.type
        }
      }).then(res => {
        this.closedProjectList = res.data.closedProjectList
        this.maxPage = res.data.maxPage
      }).catch(function (error) {
        alert(error)
      })
    }
  }
}
</script>

<style scoped>

</style>
