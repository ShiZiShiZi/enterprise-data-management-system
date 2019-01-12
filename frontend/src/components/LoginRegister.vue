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
            <el-button type="primary" @click="addDepartmentManagement('loginForm')" class="loginButton">登录</el-button>
        </el-form>
        <a href="./">没有账号？点击注册</a>
    </el-card>
</div>
</template>

<script>
export default {
  name: 'LoginRegister',
  data: function () {
    return {
      background: {
        backgroundImage: 'url("../../static/backgroundPicture.jpg")',
        backgroundRepeat: 'no-repeat',
        backgroundSize: '100% auto'
      },
      dynamicValidateForm: {
        password: '',
        phone: '',
        rules: {
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' }
          ],
          phone: [{required: true, message: '请输入手机号', trigger: 'blur'},
            { type: 'number', message: '请输入正确的手机号', trigger: ['blur', 'change'] }]
        }
      }
    }
  },
  mounted: function () {
    this.$refs.loginPicture.style.height = document.documentElement.clientHeight + 'px'
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
