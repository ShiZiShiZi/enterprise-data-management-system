<template>
    <el-card class="box-card">
        <el-table :data="requestList" stripe style="width: 100%">
            <el-table-column prop="departmentName" label="请求部门" width="180">
            </el-table-column>
            <el-table-column prop="projectPeople" label="人员" width="180">
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button size="mini" @click="handleAcceptRequest(scope.row.id)">同意</el-button>
                    <el-button size="mini" @click="handleRejectedRequest(scope.row.id)">拒绝</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-dialog title="填写拒绝理由" :visible.sync="dialogVisible" width="30%">
            <el-form :model="dynamicValidateForm" ref="rejectedRequest" label-width="100px" class="demo-dynamic">
                <el-form-item label="理由" prop="description" :rules="dynamicValidateForm.rules.description">
                    <el-input v-model="dynamicValidateForm.description"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitRejectReason('rejectedRequest')">提交</el-button>
                    <el-button @click="dialogVisible = false">取消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
    </el-card>
</template>

<script>import axios from 'axios'
export default {
  name: 'PersonnelUseRequest',
  data: function () {
    return {
      requestList: [],
      dialogVisible: false,
      dynamicValidateForm: {
        feedbackId: '',
        description: '',
        rules: {
          description: [{required: true, message: '拒绝理由不能为空', trigger: 'blur'}]
        }
      }
    }
  },
  created: function () {
    this.getRequest()
  },
  methods: {
    getRequest: function () {
      axios.get('http://localhost:8080/static/requestList.json', { // URL: 待定
        params: {
          departmentId: this.$store.state.person.departmentId
        }
      }).then(res => {
        this.requestList = res.data.requestList
      }).catch(function (error) {
        alert(error)
      })
    },
    handleAcceptRequest: function (id) {
      axios.get('http://localhost:8080/static/requestList.json', { // URL:/departmentManager/peopleAudit
        params: {
          feedbackId: id,
          state: 1
        }
      }).then(res => {
        this.getRequest()
      }).catch(function (error) {
        alert(error)
      })
    },
    handleRejectedRequest: function (id) {
      this.dynamicValidateForm.feedbackId = id
      this.dialogVisible = true
    },
    submitRejectReason: function (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.get('http://localhost:8080/static/projectPeopleList.json', { // URL:/departmentManager/changeProject
            params: {
              feedbackId: this.dynamicValidateForm.feedbackId,
              type: 2,
              description: this.dynamicValidateForm.description
            }
          }).then(res => {
            this.getRequest()
          }).catch(function (error) {
            alert(error)
          })
          this.dialogVisible = false
        } else {
          alert('请按照要求填写')
        }
      })
    }
  }
}
</script>

<style scoped>
.box-card {
    width: 1200px;
}
</style>
