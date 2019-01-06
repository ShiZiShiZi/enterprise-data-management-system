<template>
  <el-card class="box-card">
    <div class="text item" align="center">
      <el-table
      :data="feedbackList"
      style="width: 100%">
      <el-table-column
        prop="projectName"
        label="项目名称"
        width="240">
      </el-table-column>
      <el-table-column
        prop="type"
        label="类型"
        width="150">
      </el-table-column>
      <el-table-column
        prop="name"
        label="名称"
        width="60">
      </el-table-column>
      <el-table-column
        prop="time"
        label="时间"
        width="60">
      </el-table-column>
      <el-table-column
        prop="status"
        label="状态"
        width="60">
      </el-table-column>
      <el-table-column
        prop="remark"
        label="备注"
        width="90">
      </el-table-column>
    </el-table>
    </div>
    <div class="block" align="center">
      <span class="demonstration"></span>
      <el-pagination
        layout="prev, pager, next"
        :total="50">
      </el-pagination>
    </div>
  </el-card>

</template>

<script>
import axios from 'axios'
export default {
  methods: {

  },
  data () {
    return {
      feedbackList: []
    }
  },
  created () {
    axios.get('http://localhost:8080/static/feedbackList.json').then(res => {
      this.feedbackList = res.data.feedbackList
    }).catch(function (error) {
      alert(error)
    })
  }
}
</script>

<style scoped>
  .text {
    font-size: 14px;
  }

  .item {
    padding: 18px 0;
  }

  .box-card {
    width: 900px;
  }

</style>
