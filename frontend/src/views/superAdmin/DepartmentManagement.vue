<template>
  <el-card class="box-card">
    <el-row>
      <el-col :span="3" class="text-left">搜索部门名称：</el-col>
      <el-col :span="7">
        <el-input v-model="name" placeholder="请输入内容"></el-input>
      </el-col>
    </el-row>
    <el-table
      ref="singleTable"
      :data="departmentList"
      highlight-current-row>
      <el-table-column
        type="index"
        width="50">
      </el-table-column>
      <el-table-column
        property="id"
        label="部门代码"
        width="120">
      </el-table-column>
      <el-table-column
        property="name"
        label="部门名称"
        width="120">
      </el-table-column>
      <el-table-column
        label="操作"
        width="120">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text">查看</el-button>
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
  name: 'DepartmentManagement',
  data: function () {
    return {
      departmentList: [],
      currentPage: 1,
      pageSize: 2,
      maxPage: 2,
      name: ''
    }
  },
  created: function () {
    this.getDepartmentList()
  },
  watch: {
    name (val) {
      this.currentPage = 1
      this.getDepartmentList()
    }
  },
  methods: {
    handleSizeChange: function (size) {
      this.pageSize = size
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
        this.maxPage = res.data.maxPage
      }).catch(function (error) {
        alert(error)
      })
    },
    handleClick: function (row) {
      this.$router.push('subDepartment/' + row.id + '/' + row.name)
    },
    getDepartmentList: function () {
      axios.get('http://localhost:8080/static/departmentList.json', {
        params: {
          currentPage: this.currentPage,
          pageSize: this.pageSize,
          departmentTitle: this.name
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
