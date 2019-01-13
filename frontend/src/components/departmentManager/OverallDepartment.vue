<template>
  <el-container>
    <el-header>
      <el-row>
        <div class="grid-content bg-purple-light">企业项目信息管理系统</div>
      </el-row>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
          background-color="#e5e9f2"
          text-color="#000000"
          active-text-color="#006014"
          heigth="500px">
          <el-menu-item index="1">
            <i class="el-icon-location"></i>
            <span slot="title" @click="jumpToProjectManage">项目管理</span>
          </el-menu-item>
          <el-menu-item index="2">
            <i class="el-icon-menu"></i>
            <span slot="title" @click="jumpToDataManage">部门数据分析</span>
          </el-menu-item>
          <el-menu-item index="4">
            <i class="el-icon-document"></i>
            <span slot="title" @click="jumpToPersonnelUseRequest">人员使用请求</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: 'OverallDeveloper',
  methods: {
    jumpToProjectManage: function () {
      this.$router.push('/departmentManager/projectManage')
    },
    jumpToDataManage: function () {
      this.$router.push('/departmentManager/dataManage')
    },
    jumpToPersonnelUseRequest: function () {
      this.$router.push('/departmentManager/personnelUseRequest')
    }
  }
}
</script>

<style scoped>
  .el-row {
    width: 1200px;
  }
  .el-header {
    background-color: #DCDFE6;
    color: #333;
    text-align: center;
    line-height: 60px;
  }
  .el-aside {
    background-color: #e5e9f2;
    color: #333;
    text-align: center;
    height: 700px
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
  .bg-purple {
    background: #DCDFE6;
  }
  .bg-purple-light {
    background: #DCDFE6;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 60px;
  }
</style>
