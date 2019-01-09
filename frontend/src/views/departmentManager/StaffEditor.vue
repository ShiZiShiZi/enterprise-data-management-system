<template>
<el-row>
    <el-col :span="12">
        <el-card class="box-card">
            <span>项目已有人员</span>
            <el-table :data="projectPeopleList" style="width: 100%" :row-class-name="tableRowClassName">
                <el-table-column prop="id" label="工号" width="180"></el-table-column>
                <el-table-column prop="name" label="姓名" width="180"></el-table-column>
                <el-table-column prop="departmentId" label="部门"></el-table-column>
            </el-table>
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    layout="prev, pager, next"
                    :total="maxPage1*10">
            </el-pagination>
        </el-card>
    </el-col>
    <el-col :span="10">
        <el-card class="box-card">
            <el-row>
                <el-col :span="3">名字:</el-col>
                <el-col :span="4">
                    <el-input placeholder="请输入内容" prefix-icon="el-icon-search" v-model="name">
                    </el-input>
                </el-col>
            </el-row>
            <el-table :data="departmentPeopleList" style="width: 100%" :row-class-name="tableRowClassName">
                <el-table-column prop="id" label="工号" width="180"></el-table-column>
                <el-table-column prop="name" label="姓名" width="180"></el-table-column>
                <el-table-column prop="departmentId" label="部门"></el-table-column>
                <el-table-column label="操作">
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
      pageSize: 10,
      maxPage1: 1,
      maxPage2: 1,
      name: '',
      projectPeopleList: [],
      departmentPeopleList: [],
      departmentPeopleListState: []
    }
  },
  created: function () {
    this.id = this.$route.params.id
    this.title = this.$route.params.title
    this.getProjectPeopleList()
    this.getDepartmentPeopleList()
  },
  watch: {
    name (val) {
      this.getDepartmentPeopleList()
    }
  },
  methods: {
    getProjectPeopleList: function () {
      axios.get('http://localhost:8080/static/projectPeopleList.json', { // URL: 待定
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
    }
  }
}
</script>

<style scoped>
.box-card {
    width: 600px;
}
.el-table .warning-row {
    background: oldlace;
}

.el-table .success-row {
    background: #f0f9eb;
}
</style>
