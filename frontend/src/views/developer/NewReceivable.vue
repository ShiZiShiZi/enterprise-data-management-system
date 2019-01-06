<template>
  <el-card class="box-card">
  <div  class="text item">
    选择项目：<el-select v-model="projectID" @change="selectProject" placeholder="请选择项目">
      <el-option
        v-for="project in projectList"
        :key="project.id"
        :label="project.label"
        :value="project.id">
      </el-option>
    </el-select><br><br>
    选择类别：<el-select v-model="costTypeID" placeholder="请选择类别">
      <el-option
        v-for="costType in costTypeList"
        :key="costType.id"
        :label="costType.label"
        :value="costType.value">
      </el-option>
    </el-select><br><br>
    描述：<el-input v-model="content" placeholder="请输入描述"></el-input><br><br>
    填写金额：<el-input v-model="account" placeholder="请输入金额"></el-input><br><br>
  </div>
  <el-upload
          class="upload-demo"
          action=""
          :http-request="uploadContract"
          :before-remove="beforeRemove"
          multiple
          :limit="3"
          :on-exceed="handleExceed"
          :on-change="setFileList">
    <el-button size="small" type="primary">点击上传</el-button>
    <div slot="tip" class="el-upload__tip">只能上传pdf文件，且不超过500kb</div>
  </el-upload>
    <el-button type="primary" round @click="submit">提交</el-button>
  </el-card>
</template>

<script>
import axios from 'axios'
export default {
  name: 'NewReceivable',
  data () {
    return {
      projectList: [],
      costTypeList: [],
      fileList: [],
      projectID: '',
      costTypeID: '',
      content: '',
      account: ''
    }
  },
  created: function () {
    axios.get('http://localhost:8080/static/receivableList.json').then(res => {
      this.projectList = res.data.projectList
    }).catch(function (error) {
      alert(error)
    })
  },
  methods: {
    selectProject: function () {
      axios.get('http://localhost:8080/static/receivableList.json').then(res => {
        this.costTypeList = res.data.costTypeList
      }).catch(function (error) {
        alert(error)
      })
    },
    uploadContract: function () {
    },
    setFileList: function (file, fileList) {
      this.fileList = fileList
    },
    submit: function () {
      let formData = new FormData()
      formData.append('projectID', this.projectID)
      formData.append('costTypeID', this.costTypeID)
      formData.append('content', this.content)
      formData.append('account', this.account)
      formData.append('fileList', this.fileList)
      let config = {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      }
      this.$http.post('http://127.0.0.1:8081/upload', formData, config).then(function (response) {
        if (response.status === 200) {
          alert(response.data)
        }
      })
    },
    handleExceed (files, fileList) {
      this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`)
    },
    beforeRemove (file, fileList) {
      return this.$confirm(`确定移除 ${file.name}？`)
    }
  }
}
</script>

<style scoped>

</style>
