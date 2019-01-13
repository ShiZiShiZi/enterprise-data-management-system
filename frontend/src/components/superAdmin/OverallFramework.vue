<template>
  <el-container>
    <el-header>
      <el-row>
        <el-col :span="2">
          <div class="grid-content bg-purple">
            <img src="@/assets/logo.png" class="image" alt="logo">
          </div>
        </el-col>
        <el-col :span="8"><div class="grid-content bg-purple-light">企业项目信息管理系统</div></el-col>
      </el-row>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
          background-color="#303133"
          text-color="#fff"
          active-text-color="#ffd04b">
          <el-menu-item index="1">
            <i class="el-icon-menu"></i>
            <span slot="title" @click="jumpToBusiness">企业管理</span>
          </el-menu-item>
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>项目管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="2-1">
                <span slot="title" @click="jumpToCloseProject">已关闭项目</span>
              </el-menu-item>
              <el-menu-item index="2-2">
                <span slot="title" @click="jumpToDoingProject">进行中项目</span>
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-menu-item index="3">
            <i class="el-icon-document"></i>
            <span slot="title" @click="jumpToDepartment">部门管理</span>
          </el-menu-item>
          <el-menu-item index="4">
            <i class="el-icon-setting"></i>
            <span slot="title"  @click="jumpToFinancialPersonnel">财务人员管理</span>
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
  name: 'OverallFramework',
  methods: {
    jumpToBusiness: function () {
      this.$router.push('/superAdmin/businessMng')
    },
    jumpToCloseProject: function () {
      this.$router.push('/superAdmin/closedProjectMng')
    },
    jumpToDoingProject: function () {
      this.$router.push('/superAdmin/doingProjectDepartment')
    },
    jumpToDepartment: function () {
      this.$router.push('/superAdmin/departmentMng')
    },
    jumpToFinancialPersonnel: function () {
      this.$router.push('/superAdmin/financialPersonnelMng')
    }
  }

}
</script>

<style scoped>
  .image {
    width: 60px;
    border: 1px solid #09C;
    border-radius: 60px;
  }
  .el-header, .el-footer {
    background-color: #DCDFE6;
    color: #333;
    text-align: center;
    line-height: 60px;
  }
  .el-main {
    background-color: #E9EEF3;
    text-align: center;
    color: #333;
  }
  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
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
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 40px;
  }
</style>
