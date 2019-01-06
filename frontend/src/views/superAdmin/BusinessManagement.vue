<template>
  <el-card class="box-card">
    <img :src=msg alt="">
    <el-form label-width="100px" class="demo-dynamic">
      <el-row>
        <el-col :span="6" :offset="7">
          <el-form-item label="企业名">
            <el-input v-model="name"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="4">
          <el-form-item>
            <el-button type="primary" @click="submitForm">修改</el-button>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <el-upload
            class="upload-demo"
            :http-request="uploadLogoMethod"
            :file-list="logoList"
            :limit="1"
            list-type="picture">
      <el-button size="small" slot="trigger" type="primary">选择图片</el-button>
      <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">更换图标</el-button>
      <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
    </el-upload>
  </el-card>
</template>

<script>
import axios from 'axios'
export default {
  data:
    function () {
      return {
        name: '',
        businessList: [],
        msg: '',
        logoList: '',
        logo: ''
      }
    },
  created: function () {
    axios.get('http://localhost:8080/static/businessList.json').then(res => {
      this.businessList = res.data.businessList
      this.name = this.businessList[0].name
    }).catch(function (error) {
      alert(error)
    })
    axios.get('http://localhost:8080/static/logo.png', {responseType: 'arraybuffer'}).then(res => {
      return 'data:image/png;base64,' + btoa(
        new Uint8Array(res.data)
          .reduce((data, byte) => data + String.fromCharCode(byte), '')
      )
    }).then(data => { this.msg = data }).catch(ex => { alert(ex) })
  },
  methods: {
    submitUpload () {
      let param = new FormData()
      param.append('file', this.logo)
      this.logoList = ''
      this.redirectToBusinessMng()
      let config = {
        headers: {'Content-Type': 'multipart/form-data'}
      }
      this.$http.post('http://127.0.0.1:8081/upload', param, config)
        .then(response => {
          // 这里的返回值是修改成功或者是失败
        })
    },
    uploadLogoMethod (param) {
      this.logo = param.file
    },
    redirectToBusinessMng () {
      this.$alert('修改成功', '提示信息', {
        confirmButtonText: '确定',
        callback: action => {
          // to do 跳转路由
        }
      })
    }
  }
}
</script>

<style>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>
