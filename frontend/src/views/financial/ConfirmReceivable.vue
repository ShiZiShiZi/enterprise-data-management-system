<template>
  <el-card class="box-card" align="center">
    <el-table
      ref="singleTable"
      :data="projectList"
      highlight-current-row>
      <el-table-column
        type="index"
        width="50">
      </el-table-column>
      <el-table-column
        property="title"
        label="项目名"
        width="120" align="center">
      </el-table-column>
      <el-table-column
        property="description"
        label="项目描述"
        width="150" align="center">
      </el-table-column>
      <el-table-column
        width="120" align="center">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-share" @click="toRecord(scope.row)"></el-button>
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
  name: 'ConfirmReceivable',
  data: function () {
    return {
      id: '',
      title: '',
      description: '',
      departmentId: '',
      projectList: [],
      currentPage: 1,
      pageSize: 2,
      maxPage: 1,
      sortColumn: 'id',
      sortOrder: 1
    }
  },
  created: function () {
    this.departmentId = this.$route.params.id
    axios.get('http://localhost:8080/static/projectSearch.json', {
      params: {
        currentPage: this.currentPage,
        pageSize: this.pageSize,
        sortColumn: this.sortColumn,
        sortOrder: this.sortOrder,
        active: this.active
      }
    }).then(res => {
      this.projectList = res.data.projectList
    }).catch(function (error) {
      alert(error)
    })
  },
  methods: {
    toRecord: function (row) {
      this.$router.push('../../linkToConfirmReceivable/' + row.id)
    }
  }
}
</script>

<style scoped>
  .text-left {
    text-align: right;
  }
</style>
