<template>
  <el-card class="box-card">
    <el-row>
      <el-col :span="3" class="text-left">项目开始时间：</el-col>
      <el-col :span="9">
        <el-date-picker v-model="startTime" type="daterange" range-separator="至" value-format="yyyy-MM-dd"
                        start-placeholder="开始日期"
                        end-placeholder="结束日期">
        </el-date-picker>
      </el-col>
      <el-col :span="2" class="text-left">搜索项目：</el-col>
      <el-col :span="3">
        <el-input v-model="projectTitle" placeholder="请输入内容"></el-input>
      </el-col>
    </el-row>
    <el-table ref="singleTable" :data="doingProjectList" highlight-current-row>
      <el-table-column type="index" width="50">
      </el-table-column>
      <el-table-column property="title" label="项目名称" width="120">
      </el-table-column>
      <el-table-column property="description" label="项目描述" width="240">
      </el-table-column>
      <el-table-column property="startTime" label="开始时间" width="120">
      </el-table-column>
      <el-table-column property="finishTime" label="预计结束时间" width="120">
      </el-table-column>
      <el-table-column label=" " width="100">
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
      departmentId: '',
      projectTitle: '',
      startTime: '',
      doingProjectList: [],
      currentPage: 1,
      pageSize: 10,
      maxPage: 2
    }
  },
  created: function () {
    this.departmentId = this.$route.params.id
    this.getDoingProjectList()
  },
  watch: {
    startTime (val) {
      this.currentPage = 1
      this.getDoingProjectList()
    },
    projectTitle (val) {
      this.currentPage = 1
      this.getDoingProjectList()
    }
  },
  methods: {
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage
      this.getDoingProjectList()
    },
    handleClick: function (row) {
      this.$router.push('../showDoingProject/' + row.id + '/' + row.name)
    },
    getDoingProjectList: function () {
      axios.get('http://localhost:8080/static/projectList.json', { // URL:/projectSearch
        params: {
          currentPage: this.currentPage,
          pageSize: this.pageSize,
          departmentId: this.departmentId,
          active: 1,
          startTime: this.startTime,
          projectTitle: this.projectTitle,
          sortColumn: 'start_time',
          sortOrder: 1
        }
      }).then(res => {
        this.doingProjectList = res.data.projectList
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
