<template>
  <el-card class="box-card">
    <el-row>
      <el-col :span="3" class="text-left">项目关闭时间：</el-col>
      <el-col :span="9">
        <el-date-picker v-model="closeTime" type="daterange" range-separator="至" value-format="yyyy-MM-dd"
                        start-placeholder="开始日期"
                        end-placeholder="结束日期">
        </el-date-picker>
      </el-col>
      <el-col :span="2" class="text-left">搜索项目：</el-col>
      <el-col :span="3">
        <el-input v-model="projectTitle" placeholder="请输入内容"></el-input>
      </el-col>
    </el-row>
    <el-table ref="singleTable" :data="closedProjectList" highlight-current-row>
      <el-table-column type="index" width="50">
      </el-table-column>
      <el-table-column property="name" label="项目名称" width="120">
      </el-table-column>
      <el-table-column label="部门名称" width="120">
        <template slot-scope="scope">
          {{ departmentList[scope.$index].name }}
        </template>
      </el-table-column>
      <el-table-column property="startTime" label="开始时间" width="120">
      </el-table-column>
      <el-table-column property="finishTime" label="结束时间" width="120">
      </el-table-column>
      <el-table-column property="closeTime" label="关闭时间" width="120">
      </el-table-column>
      <el-table-column label=" " width="100">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
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
      currentPage: 1,
      pageSize: 10,
      maxPage: 2,
      closeTime: [],
      projectTitle: '',
      closedProjectList: [],
      departmentIdList: [],
      departmentList: []
    }
  },
  created: function () {
    this.getClosedProjectList()
  },
  watch: {
    closeTime (val) {
      this.currentPage = 1
      this.getClosedProjectList()
    },
    projectTitle (val) {
      this.currentPage = 1
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
      axios.get('http://localhost:8080/static/closedProjectList.json', { // URL:/projectSearch
        params: {
          currentPage: this.currentPage,
          pageSize: this.pageSize,
          closeTime: this.closeTime,
          active: 0,
          sortColumn: 'close_time',
          sortOrder: 1
        }
      }).then(res => {
        this.maxPage = res.data.maxPage
        this.closedProjectList = res.data.closedProjectList
        this.departmentIdList = []
        for (let i = 0; i < this.closedProjectList.length; i++) {
          this.departmentIdList.push(this.closedProjectList[i].departmentId)
        }
        this.getDepartmentList()
      }).catch(function (error) {
        alert(error)
      })
    },
    getDepartmentList: function () {
      axios.get('http://localhost:8080/static/departmentList.json', { // URL:/departmentSearch
        params: {
          currentPage: 1,
          pageSize: this.pageSize,
          departmentIdList: this.departmentIdList,
          sortColumn: 'id',
          sortOrder: 1
        }
      }).then(res => {
        this.departmentList = res.data.departmentList
      }).catch(function (error) {
        alert(error)
      })
    }
  }
}
</script>

<style scoped>

</style>
