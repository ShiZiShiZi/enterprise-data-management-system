<template>
  <el-card class="box-card">
    <template>
      <div  class="text item">
        选择应收项：<el-select v-model="title" placeholder="请选择类别">
        <el-option
          v-for="costType in financialDetailList"
          :key="costType.id"
          :label="costType.title"
          :value="costType.id">
        </el-option>
      </el-select><br><br>
      </div>
    </template>
    <template>
      <el-upload
        class="upload-demo"
        action=""
        :http-request="fileList"
        :on-preview="handlePreview"
        :on-remove="handleRemove"
        :before-remove="beforeRemove"
        :on-change="setFileList"
        multiple
        :limit="3"
        :on-exceed="handleExceed">
        <el-button size="small" type="primary">选择文件</el-button>
        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
      </el-upload><br><br>
    </template>
    <template>
      <el-button type="success" @click="uploading">提交</el-button>
    </template>
  </el-card>
</template>

<script>
import axios from 'axios'
export default {
  name: 'LinkToConfirmExpenditure',
  data: function () {
    return {
      financialDetailId: '',
      contractList: [],
      projectId: '',
      financialDetailType: 1,
      financialDetailList: [],
      title: '',
      fileList: [],
      fileByteList: [],
      description: '',
      state: 1
    }
  },
  created: function () {
    this.projectId = this.$route.params.id
    axios.get('http://localhost:8080/static/costConfirm.json', {
      params: {
        projectId: this.projectId,
        financialDetailType: this.financialDetailType,
        financialDetailId: this.financialDetailId,
        description: this.description,
        contractList: this.contractList,
        state: this.state
      }
    }).then(res => {
      this.financialDetailList = res.data.financialDetailList
    }).catch(function (error) {
      alert(error)
    })
  },
  methods: {
    setFileList: function (file, fileList) {
      this.fileList = fileList
    },
    uploading: function () {
      let that = this
      for (let i = 0; i < this.fileList.length; i++) {
        var reader = new FileReader()
        reader.readAsArrayBuffer(this.fileList[i].raw)
        reader.onload = function (e) {
          let buffer = e.target.result
          that.fileByteList.push(conversionToBinaryStream(buffer))
        }
      }
      // 还需要校验填写的数据
      axios.get('/need to be done', {
        params: {
          financialDetailType: this.financialDetailType,
          contractList: this.fileByteList,
          description: this.description,
          state: this.state
        }
      }).then(function (response) {
        alert('需要添加弹窗和重定向')
      })
    },
    submit: function () {

    },
    handleExceed (files, fileList) {
      this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`)
    },
    beforeRemove (file) {
      return this.$confirm(`确定移除 ${file.name}？`)
    }
  }
}
function conversionToBinaryStream (buffer) {
  return Array.prototype.map.call(new Uint8Array(buffer), x => ('00' + x.toString(16)).slice(-2)).join('')
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
