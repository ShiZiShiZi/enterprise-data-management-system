<template>
<div class="login-picture" :style="background" ref="loginPicture">
    <el-card shadow="always" class="login-card">
        <h1>人员登录</h1>
        <el-form :model="dynamicValidateForm" ref="loginForm" label-width="100px" class="demo-dynamic">
            <el-form-item label="手机号" prop="phone" :rules="dynamicValidateForm.rules.phone">
                <el-input v-model.number="dynamicValidateForm.phone"></el-input>
            </el-form-item>
            <el-form-item prop="password" label="密码" :rules="dynamicValidateForm.rules.password">
                <el-input v-model="dynamicValidateForm.password" type="password"></el-input>
            </el-form-item>
            <el-form-item prop="" label="验证码">
                <el-input type="password"></el-input>
            </el-form-item>
            <el-button type="primary" @click="submitLoginForm('loginForm')" class="loginButton">登录</el-button>
        </el-form>
        <a href="#" @click="dialogVisible = true">没有账号？点击注册</a>
    </el-card>
    <el-dialog title="账号注册" :visible.sync="dialogVisible" width="30%">
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
            <el-form-item label="激活码" prop="activationCode">
                <el-input v-model="registerForm.activationCode"></el-input>
            </el-form-item>
            <el-button type="primary" @click="submitRegisterForm('registerForm')">注册</el-button>
            <el-button @click="dialogVisible = false">取消</el-button>
        </el-form>
    </el-dialog>
</div>
</template>

<script>
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
      dialogVisible: false,
      background: {
        backgroundImage: 'url("../../static/backgroundPicture.jpg")',
        backgroundRepeat: 'no-repeat',
        backgroundSize: '100% auto'
      },
      dynamicValidateForm: {
        password: '',
        phone: '',
        rules: {
          phone: [{required: true, message: '请输入手机号', trigger: 'blur'},
            { pattern: /^1[34578]\d{9}$/, message: '请输入正确的手机号', trigger: ['blur', 'change'] }
          ],
          password: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      },
      registerForm: {
        email: '',
        phone: '',
        password: '',
        checkPassword: '',
        activationCode: '',
        rules: {
          email: [
            { required: true, message: '请输入邮箱地址', trigger: 'blur' },
            { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
          ],
          phone: [{required: true, message: '请输入手机号', trigger: 'blur'},
            { pattern: /^1[34578]\d{9}$/, message: '请输入正确的手机号', trigger: ['blur', 'change'] }
          ],
          password: [
            { validator: validatePass, trigger: 'blur' }
          ],
          checkPassword: [
            { validator: validatePass2, trigger: 'blur' }
          ],
          activationCode: [
            { required: true, message: '激活码不能为空', trigger: 'blur' }
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
          alert('登录成功！')
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    submitRegisterForm: function (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.dialogVisible = false
          alert('注册成功！')
        } else {
          console.log('error submit!!')
          return false
        }
      })
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
