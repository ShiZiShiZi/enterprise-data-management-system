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
    <el-button type="success" @click="uploading">提交</el-button>
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
      fileByteList: [],
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
      axios.post('/need to be done', {
        projectID: this.projectID,
        costTypeID: this.costTypeID,
        content: this.content,
        account: this.account,
        fileByteList: this.fileByteList
      })
        .then(function (response) {
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

</style>
