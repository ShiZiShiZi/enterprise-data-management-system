<template>
  <el-card class="box-card">
    <el-row>
      <el-col :span="2" class="text-left">搜索日期：</el-col>
      <el-col :span="3">
        <el-input v-model="input" placeholder="请输入内容"></el-input>
      </el-col>
      <el-col :span="2" class="text-left">搜索项目：</el-col>
      <el-col :span="3">
        <el-input v-model="input" placeholder="请输入内容"></el-input>
      </el-col>
    </el-row>
    <el-table
      ref="singleTable"
      :data="closedProjectList.slice((currentPage-1)*pageSize,currentPage*pageSize)"
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
      :total="closedProjectList.length*10">
    </el-pagination>
  </el-card>
</template>

<script>
import axios from 'axios'

export default {
  name: 'ClosedProjectManagement',
  data: function () {
    return {
      closedProjectList: [],
      currentPage: 1,
      pageSize: 3
    }
  },
  created: function () {
    axios.get('http://localhost:8080/static/closedProjectList.json').then(res => {
      this.closedProjectList = res.data.closedProjectList
    }).catch(function (error) {
      alert(error)
    })
  },
  methods: {
    handleSizeChange: function (size) {
      this.pageSize = size
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage
    },
    handleClick: function (row) {
      this.$router.push('showClosedProject/' + row.id + '/' + row.name)
    }
  }
}
</script>

<style scoped>

</style>
