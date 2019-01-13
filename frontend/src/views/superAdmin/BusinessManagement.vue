<template>
  <el-card class="box-card">
    <img :src=logoSource alt="" class="logo-size">
    <el-form label-width="100px" class="demo-dynamic">
      <el-row>
        <el-col :span="6" :offset="7">
          <el-form-item label="企业名">
            <el-input v-model="companyName"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="4">
          <el-form-item>
            <el-button type="primary" @click="handleRenameCompany">修改</el-button>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <el-upload
            class="upload-demo"
            :http-request="uploadLogoMethod"
            :on-change="setLogo"
            multiple
            :limit="1"
            :on-exceed="handleExceed"
            list-type="picture">
      <el-button size="small" slot="trigger" type="primary">选择图片</el-button>
      <el-button style="margin-left: 10px;" size="small" type="success" @click="handleSubmitUpload">更换图标</el-button>
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
        companyName: '',
        logoSource: '',
        logo: ''
      }
    },
  created: function () {
    this.getCompanyName()
    this.getLogoSource()
  },
  methods: {
    getCompanyName: function () {
      axios.get('http://localhost:8080/static/businessList.json').then(res => { // url: /getCompanyName
        this.companyName = res.data.companyName
      }).catch(function (error) {
        alert(error)
      })
    },
    getLogoSource: function () {
      axios.get('http://localhost:8080/static/logo.json').then(res => {
        this.conversionLogoToStringStream(res.data.logo)
      }).catch(function (error) {
        alert(error)
      })
    },
    handleRenameCompany: function () {
      axios.get('http://localhost:8080/static/businessList.json', { // url: /renameCompany
        params: {
          companyName: this.companyName
        }
      }).then(res => {
        alert(res.data)
      }).catch(function (error) {
        alert(error)
      })
    },
    setLogo: function (file, fileList) {
      this.logo = file
    },
    handleExceed () {
      this.$message.warning(`一次只能上传一张图片`)
    },
    handleSubmitUpload () {
      if (this.logo === '') {
        alert('请先选择图片')
        return ''
      }
      let reader = new FileReader()
      reader.readAsArrayBuffer(this.logo.raw)
      reader.onload = function (e) {
        let buffer = e.target.result
        let companyLogoByte = conversionToBinaryStream(buffer)
        axios.post('http://localhost:8080/static/businessList.json', { // URL: /renewLogo
          companyLogo: companyLogoByte
        }).then(res => {
          this.getLogoSource()
          alert(res.data)
        }).catch(function (error) {
          alert(error)
        })
      }
    },
    conversionLogoToStringStream: function (str) {
      let buffer1 = conversionToStringStream(str)
      let logoSource = 'data:image/png;base64,' + btoa(new Uint8Array(buffer1)
        .reduce((data, byte) => data + String.fromCharCode(byte), ''))
      this.logoSource = logoSource
    },
    uploadLogoMethod () {
    }
  }
}
function conversionToBinaryStream (buffer) {
  return Array.prototype.map.call(new Uint8Array(buffer), x => ('00' + x.toString(16)).slice(-2)).join('')
}
function conversionToStringStream (hex) {
  return new Uint8Array(hex.match(/[\da-f]{2}/gi).map(function (h) {
    return parseInt(h, 16)
  }))
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
  .logo-size {
    width: 200px;
    height: 200px;
    border-radius: 200px;
  }
</style>
