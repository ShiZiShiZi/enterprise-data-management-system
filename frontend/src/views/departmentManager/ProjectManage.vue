<template>
    <el-card class="box-card">
        <el-row>
            <el-col :span="2">项目名:</el-col>
            <el-col :span="3">
                <el-input placeholder="请输入内容" prefix-icon="el-icon-search" v-model="projectTitle">
                </el-input>
            </el-col>
            <el-col :span="9">
                <el-date-picker v-model="startTime" type="daterange" range-separator="至" value-format="yyyy-MM-dd"
                        start-placeholder="开始日期"
                        end-placeholder="结束日期">
                </el-date-picker>
            </el-col>
            <el-col :span="3">
                <el-button type="primary">新增项目</el-button>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="2"><div class="grid-content bg-purple">项目名</div></el-col>
            <el-col :span="6"><div class="grid-content bg-purple-light">描述</div></el-col>
            <el-col :span="2"><div class="grid-content bg-purple"></div>开始时间</el-col>
            <el-col :span="2"><div class="grid-content bg-purple-light">预计结束时间</div></el-col>
            <el-col :span="6"><div class="grid-content bg-purple">状态</div></el-col>
        </el-row>
        <el-collapse v-model="activeName" accordion v-for="(project, index) in projectList" v-bind:key="index">
            <el-collapse-item v-bind:name="index">
                <template slot="title">
                    <el-col :span="2"><div class="grid-content bg-purple">{{ project.title }}</div></el-col>
                    <el-col :span="6"><div class="grid-content bg-purple-light">{{ project.description }}</div></el-col>
                    <el-col :span="2"><div class="grid-content bg-purple"></div>{{ project.startTime }}</el-col>
                    <el-col :span="2"><div class="grid-content bg-purple-light">{{ project.finishTime }}</div></el-col>
                    <el-col :span="6">
                    </el-col>
                </template>
                <el-row>
                    <el-col :span="3">
                        <p v-if="projectStateList[project.id][0] === 1" class="danger">类别费用累计超出预算数</p>
                        <p v-if="projectStateList[project.id][1] === 1" class="success">类别收入超出目标数</p>
                        <p v-if="projectStateList[project.id][2] === 1" class="warning">类别费用累计超出预算数</p>
                    </el-col>
                    <el-col :span="2" :offset="1">
                        <el-button plain>编辑项目</el-button>
                    </el-col>
                    <el-col :span="2" :offset="1">
                        <el-button plain @click="jumpToStaffEditor(project.id, project.title)">人员编辑</el-button>
                    </el-col>
                    <el-col :span="2" :offset="1">
                        <el-button plain>财务模型</el-button>
                    </el-col>
                </el-row>
            </el-collapse-item>
        </el-collapse>
    </el-card>
</template>

<script>import axios from 'axios'
export default {
  name: 'ProjectManage',
  data: function () {
    return {
      activeName: 1,
      currentPage: 1,
      pageSize: 10,
      maxPage: 1,
      projectTitle: '',
      startTime: [],
      projectList: [],
      projectIdList: [],
      projectStateList: []
    }
  },
  created: function () {
    this.getProjectList()
    this.getProjectStateList()
  },
  watch: {
    startTime (val) {
      this.currentPage = 1
      this.getProjectList()
    },
    projectTitle (val) {
      this.currentPage = 1
      this.getProjectList()
    }
  },
  methods: {
    jumpToStaffEditor: function (id, title) {
      this.$router.push('staffEditor/' + id + '/' + title)
    },
    getProjectList: function () {
      axios.get('http://localhost:8080/static/projectList.json', { // URL:/projectSearch
        params: {
          currentPage: this.currentPage,
          pageSize: this.pageSize,
          departmentId: localStorage.getItem('departmentId'),
          sortColumn: 'start_time',
          sortOrder: 1,
          startTime: this.startTime,
          projectTitle: this.projectTitle
        }
      }).then(res => {
        this.projectList = res.data.projectList
        this.maxPage = res.data.maxPage
        for (let i = 0; i < this.projectList.length; i++) {
          this.projectIdList.push(this.projectList[i].id)
        }
      }).catch(function (error) {
        alert(error)
      })
    },
    getProjectStateList: function () {
      axios.get('http://localhost:8080/static/projectStateList.json', { // URL:/departmentManager/projectState
        params: {
          projectIdList: this.projectIdList
        }
      }).then(res => {
        this.projectStateList = res.data.projectStateMap
      }).catch(function (error) {
        alert(error)
      })
    }
  }
}

</script>

<style scoped>
    .box-card {
        width: 1270px;
        height: 600px;
    }
    .bg-purple {
        background: #d3dce6;
    }
    .bg-purple-light {
        background: #e5e9f2;
    }
    .danger {
        color: #F56C6C;
    }
    .success {
        color: #67C23A;
    }
    .warning {
        color: #E6A23C;
    }
</style>
