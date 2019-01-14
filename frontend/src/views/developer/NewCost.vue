<template>
  <el-card class="box-card">
    <el-row>
      <el-col :span="2">选择部门：</el-col>
      <el-col :span="4">
        <el-select v-model="selectedDepartmentId" @change="handleSelectDepartment" placeholder="请选择部门">
          <el-option v-for="department in departmentList"
                     :key="department.id"
                     :label="department.name"
                     :value="department.id">
          </el-option>
        </el-select>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="2">选择项目：</el-col>
      <el-col :span="4">
        <el-select v-model="selectedProjectID" @change="handleSelectProject" placeholder="请选择项目">
          <el-option v-for="project in projectList"
                     :key="project.id"
                     :label="project.title"
                     :value="project.id">
          </el-option>
        </el-select>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="2">选择类别：</el-col>
      <el-col :span="4">
        <el-select v-model="selectedModelId" placeholder="请选择类别">
          <el-option v-for="financial in financialModelList"
                     :key="financial.id"
                     :label="financial.name"
                     :value="financial.id">
          </el-option>
        </el-select>
      </el-col>
    </el-row>
    <el-form :model="addReceivableForm" ref="addReceivableForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="费用项标题" prop="title" :rules= addReceivableForm.rules.title>
        <el-input v-model.number="addReceivableForm.title"></el-input>
      </el-form-item>
      <el-form-item label="金额" prop="num" :rules= addReceivableForm.rules.num>
        <el-input v-model="addReceivableForm.num"></el-input>
      </el-form-item>合同凭证
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
        <div slot="tip" class="el-upload__tip">只能上传pdf文件，且不超过500kb</div>
      </el-upload>
      <el-button type="primary" @click="submitForm('addReceivableForm')">提交</el-button>
    </el-form>
  </el-card>
</template>

<script>
import axios from 'axios'
export default {
  name: 'NewReceivable',
  data () {
    return {
      departmentList: [],
      selectedDepartmentId: '',
      projectList: [],
      selectedProjectID: '',
      financialModelList: [],
      selectedModelId: '',
      addReceivableForm: {
        title: '',
        num: '',
        rules: {
          title: [{required: true, message: '不能为空', trigger: 'blur'}],
          num: [{required: true, message: '请输入数额', trigger: 'blur'},
            { pattern: /^\d{1,10}$/, message: '请正确填写数额' }]
        }
      },
      fileList: [],
      fileByteList: [],
      fileNameList: []
    }
  },
  mounted: function () {
    this.getDepartmentList()
  },
  methods: {
    getDepartmentList: function () {
      // url: developer/getDepartmentList
      axios.get('http://localhost:8080/static/receivableList.json').then(res => {
        this.departmentList = res.data.departmentList
      }).catch(function (error) {
        alert(error)
      })
    },
    getProjectList: function () {
      axios.get('http://localhost:8080/static/receivableList.json', { // URL:/projectSearch
        params: {
          departmentId: this.selectedDepartmentId,
          currentPage: 1,
          PageSize: 100,
          active: 1,
          sortColumn: 'start_time',
          sortOrder: 1
        }
      }).then(res => {
        this.projectList = res.data.projectList
      }).catch(function (error) {
        alert(error)
      })
    },
    getFinancialModelList: function () {
      axios.get('http://localhost:8080/static/receivableList.json', { // URL:/financialModelSearch
        params: {
          projectId: this.selectedProjectID,
          type: 1,
          isActive: 1
        }
      }).then(res => {
        this.financialModelList = res.data.financialModelList
      }).catch(function (error) {
        alert(error)
      })
    },
    handleSelectDepartment: function () {
      this.getProjectList()
    },
    handleSelectProject: function () {
      this.getFinancialModelList()
    },
    setFileList: function (file, fileList) {
      this.fileList = fileList
    },
    uploading: function () {
      let that = this
      this.fileNameList = []
      this.fileByteList = []
      for (let i = 0; i < this.fileList.length; i++) {
        let reader = new FileReader()
        reader.readAsArrayBuffer(this.fileList[i].raw)
        this.fileNameList.push(this.fileList[i].name)
        reader.onload = function (e) {
          let buffer = e.target.result
          that.fileByteList.push(conversionToBinaryStream(buffer))
        }
      }
    },
    handleExceed (files, fileList) {
      this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`)
    },
    beforeRemove (file) {
      return this.$confirm(`确定移除 ${file.name}？`)
    },
    submitForm: function (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid && this.selectedModelId !== '' && this.fileList.length !== 0) {
          this.uploading()
          axios.post('/need to be done', { // URL:/developer/addFinancialDetail
            financialModelId: this.selectedModelId,
            type: 0,
            title: this.addReceivableForm.title,
            num: this.addReceivableForm.num,
            fileByteList: this.fileByteList,
            fileNameList: this.fileNameList
          }).then(res => {
            alert(res.data.msg)
          })
        } else {
          alert('请完成完整的上传流程')
        }
      })
    }
  }
}
function conversionToBinaryStream (buffer) {
  return Array.prototype.map.call(new Uint8Array(buffer), x => ('00' + x.toString(16)).slice(-2)).join('')
}
</script>

<style scoped>

</style>
