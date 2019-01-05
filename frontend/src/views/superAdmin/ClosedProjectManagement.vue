<template>
  <el-table
    ref="singleTable"
    :data="departmentList"
    highlight-current-row
    @current-change="handleCurrentChange"
    style="width: 100%">
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
      label="姓名"
      width="120">
    </el-table-column>
  </el-table>
</template>

<script>
import axios from 'axios'
export default {
  name: 'DepartmentManagement',
  data: function () {
    return {
      departmentList: []
    }
  },
  created: function () {
    axios.get('static/departmentList.json').then(res => {
      this.departmentList = res.data.departmentList
    }).catch(function (error) {
      alert(error)
    })
  }
}
</script>

<style scoped>

</style>
