<template>
  <el-card class="box-card">
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
        label="部门id"
        width="120">
      </el-table-column>
      <el-table-column
        property="name"
        label="部门名"
        width="120">
      </el-table-column>
      <el-table-column
        label="操作"
        width="120">
        <template slot-scope="scope">
          <el-button @click="firstClick(scope.row)" type="text">记录预收</el-button>
          <el-button @click="secondClick(scope.row)" type="text">确认收入</el-button>
          <el-button @click="thirdClick(scope.row)" type="text">确认费用支出</el-button>
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
      maxPage: 1,
      sortColumn: '部门id',
      sortOrder: 1
    }
  },
  created: function () {
    axios.get('http://localhost:8080/static/departmentList.json', {
      params: {
        currentPage: this.currentPage,
        pageSize: this.pageSize,
        sortColumn: this.sortColumn,
        sortOrder: this.sortOrder
      }
    }).then(res => {
      this.departmentList = res.data.departmentList
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
    firstClick: function (row) {
      this.$router.push('recordReceivable/' + row.id + '/' + row.name)
    },
    secondClick: function (row) {
      this.$router.push('confirmReceivable/' + row.id + '/' + row.name)
    },
    thirdClick: function (row) {
      this.$router.push('confirmExpenditure/' + row.id + '/' + row.name)
    }
  }
}
</script>

<style scoped>
  .text-left {
    text-align: right;
  }
</style>
