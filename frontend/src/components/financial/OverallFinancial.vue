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
          background-color="#303133"
          text-color="#fff"
          active-text-color="#ffd04b">
          <el-menu-item index="3">
            <i class="el-icon-document"></i>
            <span slot="title" @click="jumpToFinancial">财务人员</span>
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
  name: 'OverallFinancial',
  methods: {
    jumpToFinancial: function () {
      this.$router.push('/financial/financialMng')
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
