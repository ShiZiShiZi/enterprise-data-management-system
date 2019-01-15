<template>
    <el-card class="box-card">
        <el-table ref="singleTable" :data="financialDetailList" highlight-current-row>
            <el-table-column type="index" width="50">
            </el-table-column>
            <el-table-column property="title" label="费用标题" width="120">
            </el-table-column>
            <el-table-column property="num" label="数额" width="120">
            </el-table-column>
            <el-table-column property="time" label="发起时间" width="120">
            </el-table-column>
            <el-table-column label="发起人" width="120">
                <template slot-scope="scope">
                    {{projectPeopleList[scope.$index].name}}
                </template>
            </el-table-column>
            <el-table-column label="操作" width="360" align="center">
                <template slot-scope="scope">
                    <el-button type="primary" plain @click="confirm(scope.row)">确认</el-button>
                    <el-button type="primary" plain @click="reject(scope.row)">质疑</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
                @current-change="handleCurrentChange"
                layout="prev, pager, next"
                :total="maxPage*10">
        </el-pagination>
        <el-dialog title="确认费用" :visible.sync="dialogVisible" width="30%">
            <el-upload
                    class="upload-demo"
                    action=""
                    :http-request="handleHttp"
                    :before-remove="beforeRemove"
                    :on-change="setFileList"
                    multiple
                    :limit="3"
                    :on-exceed="handleExceed">
                <el-button size="small" type="primary">选择文件</el-button>
                <div slot="tip" class="el-upload__tip">只能上传pdf文件，且不超过500kb</div>
            </el-upload>
            <el-button type="primary" @click="submitForm">提交</el-button>
            <el-button @click="dialogVisible = false">取消</el-button>
        </el-dialog>
        <el-dialog title="驳回理由" :visible.sync="dialogVisible1" width="30%">
            <el-input
                    type="textarea"
                    :rows="2"
                    placeholder="请输入内容"
                    v-model="description">
            </el-input>
            <el-button type="primary" @click="submitReject">提交</el-button>
            <el-button @click="dialogVisible1 = false">取消</el-button>
        </el-dialog>
    </el-card>
</template>

<script>import axios from 'axios'
export default {
  name: 'OutcomeConfirmation',
  data: function () {
    return {
      currentPage: 1,
      pageSize: 10,
      maxPage: 1,
      dialogVisible: false,
      dialogVisible1: false,
      description: '',
      selectedProjectID: '',
      financialDetailList: [],
      projectPeopleIdList: [],
      projectPeopleList: [],
      selectedFinancialDetailId: '',
      fileList: [],
      fileByteList: [],
      fileNameList: []
    }
  },
  created: function () {
    this.selectedProjectID = this.$route.params.id
    this.getFinancialDetailList()
  },
  methods: {
    getFinancialDetailList: function () {
      axios.get('http://localhost:8080/static/receivableList.json', { // URL:/financial/getNotConfirmCosts
        params: {
          projectId: this.selectedProjectID,
          currentPage: this.currentPage,
          pageSize: this.pageSize
        }
      }).then(res => {
        this.financialDetailList = res.data.financialDetailList
        this.maxPage = res.data.maxPage
        this.projectPeopleIdList = []
        for (let i = 0; i < this.financialDetailList.length; i++) {
          this.projectPeopleIdList.push(this.financialDetailList[i].projectPeopleId)
        }
        this.getProjectPeopleList()
      }).catch(function (error) {
        alert(error)
      })
    },
    getProjectPeopleList: function () {
      axios.get('http://localhost:8080/static/departmentPeopleList.json', { // URL:/projectPeopleSearch
        params: {
          currentPage: this.currentPage,
          pageSize: this.pageSize,
          projectId: this.projectPeopleIdList,
          sortColumn: 'id',
          sortOrder: 1,
          name: this.name
        }
      }).then(res => {
        this.projectPeopleList = res.data.projectPeopleList
      }).catch(function (error) {
        alert(error)
      })
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
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage
      this.getFinancialDetailList()
    },
    handleExceed (files, fileList) {
      this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`)
    },
    beforeRemove (file) {
      return this.$confirm(`确定移除 ${file.name}？`)
    },
    submitForm: function () {
      if (this.fileList.length !== 0) {
        this.uploading()
        axios.post('http://localhost:8080/static/departmentPeopleList.json', { // URL:/financial/insertFinancialLog
          financialModelId: this.selectedModelId,
          state: 1,
          contractList: this.fileByteList,
          fileNameList: this.fileNameList
        }).then(res => {
          this.dialogVisible = false
          this.getFinancialDetailList()
          alert(res.data.msg)
        })
      } else {
        alert('请完成完整的上传流程')
      }
    },
    confirm: function (id) {
      this.selectedFinancialDetailId = id
      this.dialogVisible = true
    },
    reject: function (id) {
      this.selectedFinancialDetailId = id
      this.dialogVisible1 = true
    },
    submitReject: function () {
      if (this.description !== '') {
        axios.post('http://localhost:8080/static/departmentPeopleList.json', { // URL:/financial/insertFinancialLog
          financialModelId: this.selectedModelId,
          state: 0,
          description: this.description
        }).then(res => {
          this.dialogVisible1 = false
          this.getFinancialDetailList()
          alert(res.data.msg)
        })
      } else {
        alert('理由不能为空')
      }
    },
    handleHttp: function () {
    }
  }
}
function conversionToBinaryStream (buffer) {
  return Array.prototype.map.call(new Uint8Array(buffer), x => ('00' + x.toString(16)).slice(-2)).join('')
}
</script>

<style scoped>

</style>
