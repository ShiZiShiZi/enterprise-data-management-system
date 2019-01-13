<template>
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
    <el-form-item label="填写姓名" prop="name">
      <el-input v-model="ruleForm.name"></el-input>
    </el-form-item>
    <el-form-item label="修改邮箱" prop="mail">
      <el-input v-model="ruleForm.mail"></el-input>
    </el-form-item>
    <el-form-item label="联系方式" prop="phoneNum">
      <el-input v-model="ruleForm.phoneNum"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">立即添加</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      ruleForm: {
        name: '',
        mail: '',
        phoneNum: ''
      },
      rules: {
        name: [
          { required: true, message: '请输入姓名', trigger: 'blur' },
          { min: 1, max: 12, message: '请输入有效的姓名', trigger: 'blur' }
        ],
        mail: [
          { required: true, message: '请输入邮箱地址', trigger: 'blur' },
          { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
        ],
        phoneNum: [
          { required: true, message: '请输入电话号码', trigger: 'blur' },
          { min: 7, max: 11, message: '请输入正确的电话号码', trigger: 'blur' }
        ]
      },
      msg: ''
    }
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.get('http://localhost:8080/static/projectList.json', { // URL: /addUser
            name: this.ruleForm.name,
            email: this.ruleForm.mail,
            phoneNum: this.ruleForm.phoneNum,
            type: 3
          }).then(res => {
            this.msg = res.data.msg
            alert(this.msg)
          })
        } else {
          alert('请按照要求填写')
        }
      })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    }
  }
}
</script>
