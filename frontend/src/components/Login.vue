<template>
<div class="login-picture" :style="background" ref="loginPicture">
    <el-card shadow="always" class="login-card">
        <h1>人员登录</h1>
        <el-form :model="dynamicValidateForm" ref="loginForm" label-width="100px" class="demo-dynamic">
            <el-form-item label="账号" prop="account" :rules="dynamicValidateForm.rules.account">
                <el-input v-model.number="dynamicValidateForm.account"></el-input>
            </el-form-item>
            <el-form-item prop="password" label="密码" :rules="dynamicValidateForm.rules.password">
                <el-input v-model="dynamicValidateForm.password" type="password"></el-input>
            </el-form-item>
            <el-form-item prop="" label="验证码">
                <el-input type="password"></el-input>
            </el-form-item>
            <el-button type="primary" @click="submitLoginForm('loginForm')" class="loginButton">登录</el-button>
        </el-form>
    </el-card>
</div>
</template>

<script>import axios from 'axios'
export default {
  name: 'LoginRegister',
  data: function () {
    return {
      dialogVisible: false,
      background: {
        backgroundImage: 'url("../../static/backgroundPicture.jpg")',
        backgroundRepeat: 'no-repeat',
        backgroundSize: '100% auto'
      },
      dynamicValidateForm: {
        password: '',
        account: '',
        rules: {
          account: [{required: true, message: '请输入账号', trigger: 'blur'}
          ],
          password: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    }
  },
  mounted: function () {
    this.$refs.loginPicture.style.height = document.documentElement.clientHeight + 'px'
  },
  methods: {
    submitLoginForm: function (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.get('http://localhost:8080/static/userMessage.json', { // URL: /login
            params: {
              account: this.dynamicValidateForm.account,
              password: this.dynamicValidateForm.password
            }
          }).then(res => {
            if (res.data.token === '') {
              alert('账号或密码错误！')
            } else {
              this.$store.commit('setToken', res.data.token)
              this.$store.commit('setPermission', res.data.person.permissions)
              this.jumpToFunctionPage()
            }
          }).catch(function (error) {
            alert(error)
          })
        } else {
          alert('请按照要求填写')
          return false
        }
      })
    },
    jumpToFunctionPage: function () {
      alert(this.$store.state.permission)
      if ((this.$store.state.permission & 2) > 0) {
        this.$router.push('../departmentManager/projectManage')
        return ''
      }
      if ((this.$store.state.permission & 1) > 0) {
        this.$router.push('../developer/newReceivable')
        return ''
      }
      if ((this.$store.state.permission & 4) > 0) {
        this.$router.push('../superAdmin/departmentMng')
        return ''
      }
      if ((this.$store.state.permission & 8) > 0) {
        this.$router.push('../financial/financialMng')
      }
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
