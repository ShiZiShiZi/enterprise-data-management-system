<template>
  <el-container>
    <el-main >
    企业名称：<el-input v-model="name"></el-input><br>
      上传新标志：<el-upload
        class="avatar-uploader"
        action="https://jsonplaceholder.typicode.com/posts/"
        :show-file-list="false"
        :on-success="handleAvatarSuccess"
        :before-upload="beforeAvatarUpload" @click="imageUpload">
        <img v-if="imageUrl" :src="imageUrl" class="avatar">
        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
      </el-upload>
      <el-button @click="businessAdd">确定</el-button>
    </el-main>
  </el-container>
</template>

<script>
import axios from 'axios'
export default {
  data:
    function () {
      return {
        name: '',
        businessList: [],
        imageUrl: ''
      }
    },
  created: function () {
    axios.get('static/businessList.json').then(res => {
      this.businessList = res.data.businessList
      this.name = this.businessList[0].name
    }).catch(function (error) {
      alert(error)
    })
  },
  methods: {
    businessAdd: function () {
      axios.post('', {
        name: this.name
      }, {
        headers: {
          token: 'name'
        }
      }).then(res => {

      })
    },
    imageUpload: function () {
      axios.post('', {
        imageUrl: this.imageUrl
      }).then(res => {

      }).catch(function (error) {
        alert(error)
      })
    },
    handleAvatarSuccess (res, file) {
      this.imageUrl = URL.createObjectURL(file.raw)
    },
    beforeAvatarUpload (file) {
      const isJPG = file.type === 'image/jpeg'
      const isLt2M = file.size / 1024 / 1024 < 2

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!')
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!')
      }
      return isJPG && isLt2M
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
