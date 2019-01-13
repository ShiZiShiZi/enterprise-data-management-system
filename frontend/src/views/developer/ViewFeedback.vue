<template>
  <el-card class="box-card">
    <div class="text" align="center">
      <el-table :data="feedbackList">
      <el-table-column prop="projectTitle" label="项目标题" width="100">
      </el-table-column>
      <el-table-column prop="title" label="费用名" width="120">
      </el-table-column>
      <el-table-column prop="requestTime" label="申请时间" width="100">
      </el-table-column>
      <el-table-column prop="state" label="状态" width="100">
        <template slot-scope="scope">
          <el-tag v-if="feedbackList[scope.$index].state === 0">待审核</el-tag>
          <el-tag type="success" v-if="feedbackList[scope.$index].state === 1">已通过</el-tag>
          <el-tag type="danger" v-if="feedbackList[scope.$index].state === 2">被拒绝</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="description" label="备注" width="300">
      </el-table-column>
    </el-table>
    </div>
    <el-pagination @current-change="handleCurrentChange" align="center"
            layout="prev, pager, next" :total="maxPage*10"></el-pagination>

  </el-card>

</template>

<script>
import axios from 'axios'
export default {
  data: function () {
    return {
      currentPage: 1,
      pageSize: 10,
      maxPage: '',
      feedbackList: []
    }
  },
  mounted: function () {
    this.getFeedBackList()
  },
  methods: {
    getFeedBackList: function () {
      axios.get('http://localhost:8080/static/feedbackList.json', { // URL: developer/getFeedbackList
        params: {
          currentPage: this.currentPage,
          pageSize: this.pageSize
        }
      }).then(res => {
        this.maxPage = res.data.maxPage
        this.feedbackList = res.data.feedbackList
      }).catch(function (error) {
        alert(error)
      })
    },
    handleCurrentChange: function (currentPage) {
      this.getFeedBackList()
    }
  }
}
</script>
<style scoped>
  .text {
    font-size: 14px;
  }
  .box-card {
    width: 900px;
  }

</style>
