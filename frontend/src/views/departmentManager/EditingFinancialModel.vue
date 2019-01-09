<template>
    <el-row>
        <el-card class="box-card">
            <div slot="header"><span>费用管理</span></div>
            <el-table :data="costFinancialModelList" stripe style="width: 100%">
                <el-table-column prop="name" label="类别" width="180"></el-table-column>
                <el-table-column prop="num" label="金额" width="180"></el-table-column>
                <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button size="mini" type="primary" icon="el-icon-edit" circle @click="editCostModel(scope.$index)"></el-button>
                        <el-button size="mini" type="danger" icon="el-icon-delete" circle @click="deleteCostModel(scope.$index)"></el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-card>
        <el-card class="box-card">
            <div slot="header"><span>收入类别</span></div>
        </el-card>
        <el-dialog title="修改模型" :visible.sync="dialogVisible" width="30%">
            <el-form :model="dynamicValidateForm" ref="financialModel" label-width="100px" class="demo-dynamic">
                <el-form-item label="类别名" prop="name" :rules="dynamicValidateForm.rules.name">
                    <el-input v-model.number="dynamicValidateForm.name"></el-input>
                </el-form-item>
                <el-form-item label="数额" prop="amount" :rules="dynamicValidateForm.rules.amount">
                    <el-input v-model="dynamicValidateForm.amount"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitFinancialModel('financialModel')">提交</el-button>
                    <el-button @click="dialogVisible = false">取消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
    </el-row>
</template>

<script>import axios from 'axios'
export default {
  name: 'EditingFinancialModel',
  data: function () {
    return {
      id: '',
      title: '',
      costFinancialModelList: [],
      revenueFinancialModelList: [],
      dialogVisible: false,
      dynamicValidateForm: {
        name: '',
        amount: '',
        type: '',
        rules: {
          name: [{required: true, message: '请输入姓名', trigger: 'blur'}],
          amount: [{required: true, message: '请输入数额', trigger: 'blur'},
            { pattern: /^[1-9]\d{0,10}$/, message: '请正确填写数额' }]
        }
      }
    }
  },
  created: function () {
    this.id = this.$route.params.id
    this.title = this.$route.params.title
    this.getCostFinancialModelList()
    this.getRevenueFinancialModelList()
  },
  methods: {
    getCostFinancialModelList: function () {
      axios.get('http://localhost:8080/static/financialModelList.json', { // URL:/financialModelSearch
        params: {
          projectId: this.id,
          type: '0',
          isActive: '1'
        }
      }).then(res => {
        this.costFinancialModelList = res.data.financialModelList
      }).catch(function (error) {
        alert(error)
      })
    },
    getRevenueFinancialModelList: function () {
      axios.get('http://localhost:8080/static/financialModelList.json', { // URL:/financialModelSearch
        params: {
          projectId: this.id,
          type: '1',
          isActive: '1'
        }
      }).then(res => {
        this.revenueFinancialModelList = res.data.financialModelList
      }).catch(function (error) {
        alert(error)
      })
    },
    editCostModel: function (index) {
      this.dynamicValidateForm.name = this.costFinancialModelList[index].name
      this.dynamicValidateForm.amount = this.costFinancialModelList[index].num
      this.dynamicValidateForm.type = 0
      this.dialogVisible = true
    },
    deleteCostModel: function (index) {
      axios.get('http://localhost:8080/static/projectPeopleList.json', { // URL：/departmentManager/changeFinancialModel
        params: {
          modelId: this.costFinancialModelList[index].id,
          isClose: 0
        }
      }).then(res => {
        this.costFinancialModelList.splice(index, 1)
      }).catch(function (error) {
        alert(error)
      })
    },
    submitFinancialModel: function (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('发送修改请求！')
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

</style>
