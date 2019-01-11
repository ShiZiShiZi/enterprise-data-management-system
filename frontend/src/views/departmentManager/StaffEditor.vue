<template>
    <el-row>
        <el-col :span="10">
            <el-card class="box-card">
                <span>项目已有人员</span>
                <el-table :data="projectPeopleList" style="width: 100%" :row-class-name="tableRowClassName">
                    <el-table-column prop="name" label="姓名" width="100"></el-table-column>
                    <el-table-column prop="departmentId" label="部门" width="100"></el-table-column>
                    <el-table-column label="职位" width="80">
                        <template slot-scope="scope">
                            <el-tag v-if="isProjectLeaderList[scope.$index] === '1'">负责人</el-tag>
                            <el-tag v-else type="success">成员</el-tag>
                        </template>
                    </el-table-column>
                    <el-table-column label="操作" width="120">
                        <template slot-scope="scope">
                            <el-button size="mini" type="warning"
                                       plain v-if="isProjectLeaderList[scope.$index] === '1'" @click="changeRoles(scope.$index)">贬为成员</el-button>
                            <el-button size="mini" plain v-else @click="changeRoles(scope.$index)">设为负责人</el-button>
                        </template>
                    </el-table-column>
                </el-table>
                <el-pagination
                        @size-change="handleSizeChange"
                        @current-change="handleCurrentChange"
                        layout="prev, pager, next"
                        :total="maxPage1*10">
                </el-pagination>
            </el-card>
        </el-col>
        <el-col :span="6">
            <el-card class="box-card1">
                <el-row>
                    <el-col :span="6">名字:</el-col>
                    <el-col :span="18">
                        <el-input placeholder="请输入内容" prefix-icon="el-icon-search" v-model="name">
                        </el-input>
                    </el-col>
                </el-row>
                <el-table :data="departmentPeopleList" style="width: 100%" :row-class-name="tableRowClassName">
                    <el-table-column prop="name" label="姓名" width="100"></el-table-column>
                    <el-table-column label="操作" width="100">
                        <template slot-scope="scope">
                            <el-button size="mini" @click="handleEdit(scope.$index)" v-if="departmentPeopleListState[scope.$index] === '0'">添加</el-button>
                        </template>
                    </el-table-column>
                </el-table>
                <el-pagination
                        @size-change="handleSizeChange"
                        @current-change="handleCurrentChange1"
                        layout="prev, pager, next"
                        :total="maxPage2*10">
                </el-pagination>
            </el-card>
        </el-col>
        <el-col :span="8">
            <el-card class="box-card2">
                <el-row>
                    <el-col :span="6">名字:</el-col>
                    <el-col :span="18">
                        <el-input placeholder="请输入内容" prefix-icon="el-icon-search" v-model="name">
                        </el-input>
                    </el-col>
                </el-row>
                <el-table :data="personNotInDepartmentList" style="width: 100%" :row-class-name="tableRowClassName">
                    <el-table-column prop="name" label="姓名" width="100"></el-table-column>
                    <el-table-column prop="departmentId" label="部门" width="100"></el-table-column>
                    <el-table-column label="操作" width="100">
                        <template slot-scope="scope">
                            <el-tag v-if="personNotInDepartmentStateList[scope.$index] === 0">待审核</el-tag>
                            <el-tag v-if="personNotInDepartmentStateList[scope.$index] === 1" type="danger">已拒绝</el-tag>
                            <el-button size="mini" @click="handleSenderInvitation(scope.$index)" v-if="personNotInDepartmentStateList[scope.$index] === 2">添加</el-button>
                        </template>
                    </el-table-column>
                </el-table>
                <el-pagination
                        @size-change="handleSizeChange"
                        @current-change="handleCurrentChange1"
                        layout="prev, pager, next"
                        :total="maxPage3*10">
                </el-pagination>
            </el-card>
        </el-col>
    </el-row>
</template>

<script>import axios from 'axios'
export default {
  name: 'StaffEditor',
  data: function () {
    return {
      id: '',
      title: '',
      currentPage1: 1,
      currentPage2: 1,
      currentPage3: 1,
      pageSize: 10,
      maxPage1: 1,
      maxPage2: 1,
      maxPage3: 1,
      name: '',
      table2name: '',
      projectPeopleList: [],
      departmentPeopleList: [],
      departmentPeopleListState: [],
      projectLeaderList: [],
      isProjectLeaderList: [],
      personNotInDepartmentList: [],
      personNotInDepartmentIdList: [],
      personNotInDepartmentStateList: []
    }
  },
  created: function () {
    this.id = this.$route.params.id
    this.title = this.$route.params.title
    this.getProjectLeaderList()
    this.getProjectPeopleList()
    this.getDepartmentPeopleList()
    this.getPersonNotInDepartmentList()
  },
  watch: {
    name (val) {
      this.getDepartmentPeopleList()
    },
    table2name (val) {
      this.getPersonNotInDepartmentList()
    }
  },
  methods: {
    getProjectLeaderList: function () {
      axios.get('http://localhost:8080/static/projectLeaderList.json', { // URL:/departmentManager/getProjectManager
        params: {
          projectID: this.id
        }
      }).then(res => {
        this.projectLeaderList = res.data.projectManagerList
      }).catch(function (error) {
        alert(error)
      })
    },
    getProjectPeopleList: function () {
      axios.get('http://localhost:8080/static/projectPeopleList.json', { // URL: /getProjectMember
        params: {
          currentPage: this.currentPage1,
          pageSize: this.pageSize,
          sortColumn: 'start_time',
          sortOrder: 1,
          startTime: this.startTime,
          projectTitle: this.projectTitle
        }
      }).then(res => {
        this.projectPeopleList = res.data.projectPeopleList
        this.maxPage1 = res.data.maxPage
        for (let i = 0; i < this.projectPeopleList.length; i++) {
          let flag = true
          for (let j = 0; j < this.projectLeaderList.length; j++) {
            if (this.projectLeaderList[j] === this.projectPeopleList[i].id) {
              this.isProjectLeaderList.push('1')
              flag = false
            }
          }
          if (flag === true) { this.isProjectLeaderList.push('0') }
        }
      }).catch(function (error) {
        alert(error)
      })
    },
    getDepartmentPeopleList: function () {
      axios.get('http://localhost:8080/static/departmentPeopleList.json', { // URL:/projectPeopleSearch
        params: {
          currentPage: this.currentPage2,
          pageSize: this.pageSize,
          departmentId: localStorage.getItem('departmentId'),
          sortColumn: 'id',
          sortOrder: 1,
          name: this.name
        }
      }).then(res => {
        this.departmentPeopleList = res.data.projectPeopleList
        this.maxPage2 = res.data.maxPage
        for (let i = 0; i < this.departmentPeopleList.length; i++) {
          let flag = true
          for (let j = 0; j < this.projectPeopleList.length; j++) {
            if (this.departmentPeopleList[i].id === this.projectPeopleList[j].id) {
              this.departmentPeopleListState.push('1')
              flag = false
            }
          }
          if (flag === true) { this.departmentPeopleListState.push('0') }
        }
      }).catch(function (error) {
        alert(error)
      })
    },
    getPersonNotInDepartmentList: function () {
      axios.get('http://localhost:8080/static/departmentPeopleList.json', { // URL:/projectPeopleSearch
        params: {
          currentPage: this.currentPage3,
          pageSize: this.pageSize,
          departmentId: localStorage.getItem('departmentId'),
          sortColumn: 'id',
          isDepartmentIdIn: 0,
          sortOrder: 1,
          name: this.table2name
        }
      }).then(res => {
        this.personNotInDepartmentList = res.data.projectPeopleList
        this.maxPage3 = res.data.maxPage
        this.personNotInDepartmentIdList = []
        for (let i = 0; i < this.personNotInDepartmentList.length; i++) {
          this.personNotInDepartmentIdList.push(this.personNotInDepartmentList[i].id)
        }
        this.getPersonNotInDepartmentStateList()
      }).catch(function (error) {
        alert(error)
      })
    },
    getPersonNotInDepartmentStateList: function () {
      axios.get('http://localhost:8080/static/personNotInDepartmentStateList.json', { // URL:/projectPeopleSearch
        params: {
          projectId: this.id,
          personNotInDepartmentIdList: this.personNotInDepartmentIdList
        }
      }).then(res => {
        this.personNotInDepartmentStateList = res.data.personNotInDepartmentStateList
      }).catch(function (error) {
        alert(error)
      })
    },
    tableRowClassName ({row, rowIndex}) {
      if (rowIndex === 1) {
        return 'warning-row'
      } else if (rowIndex === 3) {
        return 'success-row'
      }
      return ''
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage1 = currentPage
      this.getProjectPeopleList()
    },
    handleCurrentChange1: function (currentPage) {
      this.currentPage2 = currentPage
      this.getDepartmentPeopleList()
    },
    handleEdit: function (index) { // 为项目添加人员
      alert('que ren tian jia ?')
      let list = []
      list.push(this.departmentPeopleList[index].id)
      axios.get('http://localhost:8080/static/projectPeopleList.json', { // URL:/departmentManager/addProjectPeople
        params: {
          projectId: this.id,
          projectPeopleList: list
        }
      }).then(res => {
        this.getProjectPeopleList()
        this.getDepartmentPeopleList()
      }).catch(function (error) {
        alert(error)
      })
    },
    changeRoles: function (index) { // 设置为部门负责人和撤销
      if (this.isProjectLeaderList[index] === '0') {
        this.projectLeaderList.push(this.projectPeopleList[index].id)
      } else {
        for (let i = 0; i < this.projectLeaderList.length; i++) {
          if (this.projectLeaderList[i] === this.projectPeopleList[index].id) {
            this.projectLeaderList.splice(i, 1)
          }
        }
      }
      axios.get('http://localhost:8080/static/projectPeopleList.json', { // URL:/departmentManager/addProjectManager
        params: {
          projectId: this.id,
          projectPeopleId: this.projectLeaderList
        }
      }).then(res => {
        this.isProjectLeaderList = []
        this.getProjectPeopleList()
      }).catch(function (error) {
        alert(error)
      })
    },
    handleSenderInvitation: function (index) { // 添加跨部门人员请求
      let peopleIdList = []
      peopleIdList.push(this.personNotInDepartmentIdList[index])
      axios.get('http://localhost:8080/static/projectPeopleList.json', { // URL:/departmentManager/addAcrossDepartmentPeople
        params: {
          projectId: this.id,
          peopleIdList: peopleIdList,
          departmentId: localStorage.getItem('departmentId')
        }
      }).then(res => {
        alert('添加成功')
        this.getPersonNotInDepartmentList()
      }).catch(function (error) {
        alert(error)
      })
    }
  }
}
</script>

<style scoped>
    .box-card {
        width: 500px;
    }
    .box-card1 {
        width: 300px;
    }
    .box-card2 {
        width: 400px;
    }
    .el-table .warning-row {
        background: oldlace;
    }

    .el-table .success-row {
        background: #f0f9eb;
    }
</style>
