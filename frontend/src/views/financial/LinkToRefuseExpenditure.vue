<template>
  <el-card class="box-card">
    <el-input
      type="textarea"
      :rows="2"
      placeholder="请输入内容"
      v-model="description">
    </el-input><br><br>
    <el-button type="success" @click="write">提交</el-button>
  </el-card>
</template>

<script>
import axios from 'axios'
export default {
  name: 'LinkToRecordReceivable',
  data: function () {
    return {
      description: '',
      financialDetailId: '',
      state: 0,
      msg: ''
    }
  },
  methods: {
    write: function () {
      axios.get('http://localhost:8080/static/costConfirm.json', {
        params: {
          financialDetailId: this.financialDetailId,
          description: this.description,
          state: 0
        }
      }).then(res => {
        this.msg = res.data.msg
        alert(this.msg)
      }).catch(function (error) {
        alert(error)
      })
    }
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
    width: 480px;
  }
</style>
