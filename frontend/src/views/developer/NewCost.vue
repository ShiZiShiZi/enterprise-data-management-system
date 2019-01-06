<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span></span>
      <el-button style="float: right; padding: 3px 0" type="text"></el-button>
    </div>
    <div  class="text item">
      选择项目：<el-select v-model="value" @change="change(value)" placeholder="请选择项目">
      <el-option
        v-for="item in options"
        :key="item.value"
        :label="item.label"
        :value="item.value">
      </el-option>
    </el-select><br><br>
      选择类别：<el-select v-model="value1" placeholder="请选择类别">
      <el-option
        v-for="item in options"
        :key="item.value"
        :label="item.label"
        :value="item.value">
      </el-option>
    </el-select><br><br>
      填写名称：<el-input v-model="inputName" placeholder="请输入名称"></el-input><br><br>
      填写金额：<el-input v-model="inputAccount" placeholder="请输入金额"></el-input><br><br>
      <el-upload
        class="upload-demo"
        action="https://jsonplaceholder.typicode.com/posts/"
        :on-preview="handlePreview"
        :on-remove="handleRemove"
        :before-remove="beforeRemove"
        multiple
        :limit="3"
        :on-exceed="handleExceed"
        :file-list="fileList">
        <el-button size="small" type="primary" @click="fileUpload">点击上传</el-button>
        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
      </el-upload><br><br>
      <el-button type="success" @click="submit">提交</el-button>
    </div>
  </el-card>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      options: [],
      options1: [],
      fileList: [],
      value: '',
      value1: '',
      inputName: '',
      inputAccount: ''
    }
  },
  created: function () {
    axios.get('http://localhost:8080/static/costList.json').then(res => {
      this.options = res.data.options
      this.options1 = res.data.options1
    }).catch(function (error) {
      alert(error)
    })
  },
  methods: {
    fileUpload: function () {
      axios.get('http://localhost:8080/static/costList.json').then(res => {
        this.fileList = res.data.fileList
      }).catch(function (error) {
        alert(error)
      })
    },
    change: function (val) {
      alert(val)
      axios.get('http://localhost:8080/static/receivableList.json').then(res => {
        this.options1 = res.data.options1
      }).catch(function (error) {
        alert(error)
      })
    },
    submit: function () {
      axios.post('', {
        options: this.options,
        options1: this.options1,
        fileList: this.fileList,
        value: this.value,
        value1: this.value1,
        inputName: this.inputName,
        inputAccount: this.inputAccount
      }).then(res => {
        alert('添加待定')
      }).catch(function (error) {
        alert(error)
      })
    },
    handleRemove (file, fileList) {
      console.log(file, fileList)
    },
    handlePreview (file) {
      console.log(file)
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
