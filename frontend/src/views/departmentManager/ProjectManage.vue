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
                <el-button type="primary" @click="addProjectVisible = true">新增项目</el-button>
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
                        <el-button plain @click="editProject(index)">编辑项目</el-button>
                    </el-col>
                    <el-col :span="2" :offset="1">
                        <el-button plain @click="jumpToStaffEditor(project.id, project.title)">人员编辑</el-button>
                    </el-col>
                    <el-col :span="2" :offset="1">
                        <el-button plain @click="jumpToEditingFinancialModel(project.id, project.title)">财务模型</el-button>
                    </el-col>
                </el-row>
            </el-collapse-item>
        </el-collapse>
        <el-dialog title="编辑项目" :visible.sync="dialogVisible" width="30%">
            <el-form :model="dynamicValidateForm" ref="editProject" label-width="100px" class="demo-dynamic">
                <el-form-item label="标题" prop="newTitle" :rules="dynamicValidateForm.rules.newTitle">
                    <el-input v-model.number="dynamicValidateForm.newTitle"></el-input>
                </el-form-item>
                <el-form-item label="描述" prop="newDescription" :rules="dynamicValidateForm.rules.newDescription">
                    <el-input v-model="dynamicValidateForm.newDescription"></el-input>
                </el-form-item>
                <el-form-item label="截至时间" prop="newFinishTime" :rules="dynamicValidateForm.rules.newFinishTime">
                    <el-date-picker v-model="dynamicValidateForm.newFinishTime"
                            value-format="yyyy-MM-dd" type="date" placeholder="选择日期">
                    </el-date-picker>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitEditProject('editProject')">提交</el-button>
                    <el-button @click="dialogVisible = false">取消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
        <el-dialog title="添加项目" :visible.sync="addProjectVisible" width="30%">
            <el-form :model="addProjectForm" ref="addProject" label-width="100px" class="demo-dynamic">
                <el-form-item label="标题" prop="title" :rules="addProjectForm.rules.title">
                    <el-input v-model.number="addProjectForm.title"></el-input>
                </el-form-item>
                <el-form-item label="描述" prop="description" :rules="addProjectForm.rules.description">
                    <el-input v-model="addProjectForm.description"></el-input>
                </el-form-item>
                <el-form-item label="开始时间" prop="startTime" :rules="addProjectForm.rules.startTime">
                    <el-date-picker v-model="addProjectForm.startTime"
                                    value-format="yyyy-MM-dd" type="date" placeholder="选择日期">
                    </el-date-picker>
                </el-form-item>
                <el-form-item label="截至时间" prop="finishTime" :rules="addProjectForm.rules.finishTime">
                    <el-date-picker v-model="addProjectForm.finishTime"
                                    value-format="yyyy-MM-dd" type="date" placeholder="选择日期">
                    </el-date-picker>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitAddProject('addProject')">提交</el-button>
                    <el-button @click="addProjectVisible = false">取消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
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
      dialogVisible: false,
      addProjectVisible: false,
      startTime: [],
      projectList: [],
      projectIdList: [],
      projectStateList: [],
      dynamicValidateForm: {
        id: '',
        newTitle: '',
        newFinishTime: '',
        newDescription: '',
        rules: {
          newTitle: [{required: true, message: '请输入项目名称', trigger: 'blur'}],
          newDescription: [{required: true, message: '请输入项目描述', trigger: 'blur'}],
          newFinishTime: [{required: true, message: '请输入项目截至日期', trigger: 'blur'}]
        }
      },
      addProjectForm: {
        title: '',
        finishTime: '',
        startTime: '',
        description: '',
        rules: {
          title: [{required: true, message: '请输入项目名称', trigger: 'blur'}],
          description: [{required: true, message: '请输入项目描述', trigger: 'blur'}],
          finishTime: [{required: true, message: '请输入项目截至日期', trigger: 'blur'}],
          startTime: [{required: true, message: '请输入项目截至日期', trigger: 'blur'}]
        }
      }
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
    jumpToEditingFinancialModel: function (id, title) {
      this.$router.push('editingFinancialModel/' + id + '/' + title)
    },
    editProject: function (index) {
      this.dialogVisible = true
      this.dynamicValidateForm.newFinishTime = this.projectList[index].finishTime
      this.dynamicValidateForm.id = this.projectList[index].id
      this.dynamicValidateForm.newDescription = this.projectList[index].description
      this.dynamicValidateForm.newTitle = this.projectList[index].title
    },
    submitEditProject: function (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.get('http://localhost:8080/static/projectPeopleList.json', { // URL:/departmentManager/changeProject
            params: {
              projectId: this.dynamicValidateForm.id,
              newTitle: this.dynamicValidateForm.newTitle,
              newDescription: this.dynamicValidateForm.newDescription,
              newFinishTime: this.dynamicValidateForm.newFinishTime
            }
          }).then(res => {
          }).catch(function (error) {
            alert(error)
          })
          this.getProjectList()
          this.dialogVisible = false
        } else {
          alert('请按照要求填写')
        }
      })
    },
    submitAddProject: function (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.get('http://localhost:8080/static/addProject.json', { // URL:/departmentManager/insertProject
            params: {
              title: this.addProjectForm.title,
              description: this.addProjectForm.description,
              startTime: this.addProjectForm.startTime,
              finishTime: this.addProjectForm.finishTime
            }
          }).then(res => {
            this.$router.push('staffEditor/' + res.data.id + '/' + this.addProjectForm.title)
          }).catch(function (error) {
            alert(error)
          })
        } else {
          alert('请按照要求填写')
        }
      })
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
    },
    handleAddProject: function () {
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
