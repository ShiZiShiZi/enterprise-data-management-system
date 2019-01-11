<template>
  <el-card class="box-card">
    <el-row>
      <el-col :span="2" class="text-left">搜索部门：</el-col>
      <el-col :span="3">
        <el-input v-model="departmentTitle" placeholder="请输入内容"></el-input>
      </el-col>
      <el-col :span="2" class="text-left">搜索项目：</el-col>
      <el-col :span="3">
        <el-input v-model="projectTitle" placeholder="请输入内容"></el-input>
      </el-col>
    </el-row>
    <el-table
      ref="singleTable"
      :data="doingProjectList"
      highlight-current-row>
      <el-table-column
        type="index"
        width="50">
      </el-table-column>
      <el-table-column
        property="id"
        label="项目代码"
        width="120">
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
  name: 'DoingProjectManagement',
  data: function () {
    return {
      departmentTitle: '',
      projectTitle: '',
      type: 'doing',
      doingProjectList: [],
      currentPage: 1,
      pageSize: 3,
      maxPage: 2
    }
  },
  created: function () {
    this.getDoingProjectList()
  },
  watch: {
    departmentTitle (val) {
      this.getDoingProjectList()
    },
    projectTitle (val) {
      this.getDoingProjectList()
    }
  },
  methods: {
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage
      this.getDoingProjectList()
    },
    handleClick: function (row) {
      this.$router.push('showDoingProject/' + row.id + '/' + row.name)
    },
    getDoingProjectList: function () {
      axios.get('http://localhost:8080/static/doingProjectList.json', {
        params: {
          currentPage: this.currentPage,
          pageSize: this.pageSize,
          departmentTitle: this.departmentTitle,
          projectTitle: this.projectTitle,
          type: this.type
        }
      }).then(res => {
        this.doingProjectList = res.data.doingProjectList
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
