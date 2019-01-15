<template>
  <el-card class="box-card">
    <el-row>
      <el-col :span="3" class="text-left">搜索部门名称：</el-col>
      <el-col :span="7">
        <el-input v-model="name" placeholder="请输入内容"></el-input>
      </el-col>
    </el-row>
    <el-table ref="singleTable" :data="departmentList" highlight-current-row>
      <el-table-column type="index" width="50">
      </el-table-column>
      <el-table-column property="name" label="部门名称" width="120">
      </el-table-column>
      <el-table-column label="操作" width="120">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text">查看</el-button>
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
  name: 'DepartmentManagement',
  data: function () {
    return {
      departmentList: [],
      currentPage: 1,
      pageSize: 10,
      maxPage: 1,
      name: ''
    }
  },
  mounted: function () {
    this.getDepartmentList()
  },
  watch: {
    name (val) {
      this.currentPage = 1
      this.getDepartmentList()
    }
  },
  methods: {
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage
      this.getDepartmentList()
    },
    handleClick: function (row) {
      this.$router.push('doingProjectMng/' + row.id)
    },
    getDepartmentList: function () {
      axios.get('http://localhost:8080/static/departmentList.json', { // URL:/departmentSearch
        params: {
          currentPage: this.currentPage,
          pageSize: this.pageSize,
          name: this.name,
          sortColumn: 'id',
          sortOrder: 1
        }
      }).then(res => {
        this.departmentList = res.data.departmentList
        this.maxPage = res.data.maxPage
      }).catch(function (error) {
        alert(error)
      })
    }
  }
}
</script>

<style scoped>
.text-left {
  text-align: right;
}
</style>
