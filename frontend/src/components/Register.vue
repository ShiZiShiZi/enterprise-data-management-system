<template>
<div class="login-picture" :style="background" ref="loginPicture">
    <el-card shadow="always" class="login-card">
        <h1>用户注册</h1>
        <el-form :model="registerForm" ref="registerForm" :rules="registerForm.rules" label-width="100px" class="demo-ruleForm">
            <el-form-item label="邮箱" prop="email">
                <el-input v-model.number="registerForm.email"></el-input>
            </el-form-item>
            <el-form-item label="手机号" prop="phone">
                <el-input v-model="registerForm.phone"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input v-model="registerForm.password" type="password"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="checkPassword">
                <el-input v-model="registerForm.checkPassword" type="password"></el-input>
            </el-form-item>
            <el-button type="primary" @click="submitRegisterForm('registerForm')">注册</el-button>
            <el-button @click="resetForm('registerForm')">重置</el-button>
        </el-form>
    </el-card>
</div>
</template>

<script>import axios from 'axios'
export default {
  name: 'LoginRegister',
  data: function () {
    let validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'))
      } else {
        if (this.registerForm.checkPassword !== '') {
          this.$refs.registerForm.validateField('checkPassword')
        }
        callback()
      }
    }
    let validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'))
      } else if (value !== this.registerForm.password) {
        callback(new Error('两次输入密码不一致!'))
      } else {
        callback()
      }
    }
    return {
      token: '',
      id: '',
      background: {
        backgroundImage: 'url("../../static/backgroundPicture.jpg")',
        backgroundRepeat: 'no-repeat',
        backgroundSize: '100% auto'
      },
      registerForm: {
        email: '',
        phone: '',
        password: '',
        checkPassword: '',
        rules: {
          email: [
            { required: true, message: '请输入邮箱地址', trigger: 'blur' }
          ],
          phone: [{required: true, message: '请输入手机号', trigger: 'blur'},
            { pattern: /^1[34578]\d{9}$/, message: '请输入正确的手机号', trigger: ['blur', 'change'] }
          ],
          password: [
            { validator: validatePass, trigger: 'blur' }
          ],
          checkPassword: [
            { validator: validatePass2, trigger: 'blur' }
          ]
        }
      }
    }
  },
  created: function () {
    this.confirmationToken(this.$route.params.token)
  },
  mounted: function () {
    this.$refs.loginPicture.style.height = document.documentElement.clientHeight + 'px'
  },
  methods: {
    confirmationToken: function (token) {
      axios.get('http://localhost:8080/static/addProject.json', { // URL: /tokenConfirm
        params: {
          token: token
        }
      }).then(res => {
        if (res.data.isExpired === 1) {
          this.$router.push('/login')
        }
        this.id = res.data.id
      }).catch(function (error) {
        alert(error)
      })
    },
    submitRegisterForm: function (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.get('http://localhost:8080/static/addProject.json', { // URL: /register
            params: {
              id: this.id,
              phoneNum: this.registerForm.phoneNum,
              email: this.registerForm,
              password: this.password
            }
          }).then(res => {
            alert(res.data)
          }).catch(function (error) {
            alert(error)
          })
        } else {
          alert('请按照要求填写！')
        }
      })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    }
  }
}
</script>

<style scoped>
.login-picture {
    text-align: center;
}
.login-card {
    width: 400px;
    height: 450px;
    text-align: center;
    margin: auto;
    left:0;
    right:0;
    top: 0;
    bottom: 0;
    position: absolute;
    opacity: 0.85;
    border-radius: 10px;
}
.loginButton {
    width: 300px;
}
</style>
