import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import OverallFramework from '@/components/superAdmin/OverallFramework'
import DepartmentManagement from '@/views/superAdmin/DepartmentManagement'
import ClosedProjectManagement from '@/views/superAdmin/ClosedProjectManagement'
import DoingProjectManagement from '@/views/superAdmin/DoingProjectManagement'
import SubDepartmentManagement from '@/views/superAdmin/SubDepartmentManagement'
import BusinessManagement from '@/views/superAdmin/BusinessManagement'
import OverallDeveloper from '@/components/developer/OverallDeveloper'
import FinancialPersonnelManagement from '@/views/superAdmin/FinancialPersonnelManagement'
import ViewFeedback from '@/views/developer/ViewFeedback'
import NewReceivable from '@/views/developer/NewReceivable'
import NewCost from '@/views/developer/NewCost'
import ShowDoingProject from '@/views/superAdmin/ShowDoingProject'
import ShowClosedProject from '@/views/superAdmin/ShowClosedProject'
import OverallDepartment from '@/components/departmentManager/OverallDepartment'
import ProjectManage from '@/views/departmentManager/ProjectManage'
import DataManage from '@/views/departmentManager/DataManage'
import ProjectFinanceManage from '@/views/departmentManager/ProjectFinanceManage'
import StaffEditor from '@/views/departmentManager/StaffEditor'
import EditingFinancialModel from '@/views/departmentManager/EditingFinancialModel'
import PersonnelUseRequest from '@/views/departmentManager/PersonnelUseRequest'
import OverallFinancial from '@/components/financial/OverallFinancial'
import FinancialManagement from '@/views/financial/FinancialManagement'
import ConfirmExpenditure from '@/views/financial/ConfirmExpenditure'
import ConfirmReceivable from '@/views/financial/ConfirmReceivable'
import RecordReceivable from '@/views/financial/RecordReceivable'
import LinkToRecordReceivable from '@/views/financial/LinkToRecordReceivable'
import LinkToConfirmReceivable from '@/views/financial/LinkToConfirmReceivable'
import LinkToConfirmExpenditure from '@/views/financial/LinkToConfirmExpenditure'
import LinkToRefuseExpenditure from '@/views/financial/LinkToRefuseExpenditure'
import Login from '@/components/Login'
import Register from '@/components/Register'
import DoingProjectDepartment from '@/views/superAdmin/DoingProjectDepartment'
import vuex from 'vuex'
import axios from 'axios'

Vue.use(Router)
Vue.use(vuex)
let store = new vuex.Store({ // store对象
  state: {
    token: '3423',
    permission: 15
  },
  mutations: {
    logout (state) {
      state.token = ''
      state.permission = 0
    }
  }
})

Vue.use(Router)

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/superAdmin',
      name: 'OverallFramework',
      meta: {
        requireAuth: true,
        permission: 4
      },
      component: OverallFramework,
      children: [
        {
          path: 'departmentMng',
          name: 'DepartmentManagement',
          meta: {
            requireAuth: true,
            permission: 4
          },
          component: DepartmentManagement
        },
        {
          path: 'closedProjectMng',
          name: 'ClosedProjectManagement',
          meta: {
            requireAuth: true,
            permission: 4
          },
          component: ClosedProjectManagement
        },
        {
          path: 'doingProjectMng/:id',
          name: 'DoingProjectManagement',
          meta: {
            requireAuth: true,
            permission: 4
          },
          component: DoingProjectManagement
        },
        {
          path: 'subDepartment/:id/:name',
          name: 'SubDepartmentManagement',
          meta: {
            requireAuth: true,
            permission: 4
          },
          component: SubDepartmentManagement
        },
        {
          path: 'businessMng',
          name: 'BusinessManagement',
          meta: {
            requireAuth: true,
            permission: 4
          },
          component: BusinessManagement
        },
        {
          path: 'financialPersonnelMng',
          name: 'FinancialPersonnelManagement',
          meta: {
            requireAuth: true,
            permission: 4
          },
          component: FinancialPersonnelManagement
        },
        {
          path: 'showDoingProject/:id/:name',
          name: 'ShowDoingProject',
          meta: {
            requireAuth: true,
            permission: 4
          },
          component: ShowDoingProject
        },
        {
          path: 'showClosedProject/:id/:name',
          name: 'ShowClosedProject',
          meta: {
            requireAuth: true,
            permission: 4
          },
          component: ShowClosedProject
        },
        {
          path: 'doingProjectDepartment',
          name: 'DoingProjectDepartment',
          meta: {
            requireAuth: true,
            permission: 4
          },
          component: DoingProjectDepartment
        }
      ]
    },
    {
      path: '/developer',
      name: 'OverallDeveloper',
      meta: {
        requireAuth: true,
        permission: 1
      },
      component: OverallDeveloper,
      children: [
        {
          path: 'viewFeedback',
          name: 'ViewFeedback',
          meta: {
            requireAuth: true,
            permission: 1
          },
          component: ViewFeedback
        },
        {
          path: 'newReceivable',
          name: 'NewReceivable',
          meta: {
            requireAuth: true,
            permission: 1
          },
          component: NewReceivable
        },
        {
          path: 'newCost',
          name: 'NewCost',
          meta: {
            requireAuth: true,
            permission: 1
          },
          component: NewCost
        }
      ]
    },
    {
      path: '/departmentManager',
      name: 'OverallDepartment',
      meta: {
        requireAuth: true,
        permission: 2
      },
      component: OverallDepartment,
      children: [
        {
          path: 'projectManage',
          name: 'ProjectManage',
          meta: {
            requireAuth: true,
            permission: 2
          },
          component: ProjectManage
        },
        {
          path: 'dataManage',
          name: 'DataManage',
          meta: {
            requireAuth: true,
            permission: 2
          },
          component: DataManage
        },
        {
          path: 'projectFinanceManage/:id/:title',
          name: 'ProjectFinanceManage',
          meta: {
            requireAuth: true,
            permission: 2
          },
          component: ProjectFinanceManage
        },
        {
          path: 'staffEditor/:id/:name',
          name: 'StaffEditor',
          meta: {
            requireAuth: true,
            permission: 2
          },
          component: StaffEditor
        },
        {
          path: 'editingFinancialModel/:id/:title',
          name: 'editingFinancialModel',
          meta: {
            requireAuth: true,
            permission: 2
          },
          component: EditingFinancialModel
        },
        {
          path: 'personnelUseRequest',
          name: 'personnelUseRequest',
          meta: {
            requireAuth: true,
            permission: 2
          },
          component: PersonnelUseRequest
        }
      ]
    },
    {
      path: '/financial',
      name: 'OverallFinancial',
      meta: {
        requireAuth: true,
        permission: 8
      },
      component: OverallFinancial,
      children: [
        {
          path: 'financialMng',
          name: 'FinancialManagement',
          meta: {
            requireAuth: true,
            permission: 8
          },
          component: FinancialManagement
        },
        {
          path: 'recordReceivable/:id/:name',
          name: 'RecordReceivable',
          meta: {
            requireAuth: true,
            permission: 8
          },
          component: RecordReceivable
        },
        {
          path: 'confirmReceivable/:id/:name',
          name: 'ConfirmReceivable',
          meta: {
            requireAuth: true,
            permission: 8
          },
          component: ConfirmReceivable
        },
        {
          path: 'confirmExpenditure/:id/:name',
          name: 'ConfirmExpenditure',
          meta: {
            requireAuth: true,
            permission: 8
          },
          component: ConfirmExpenditure
        },
        {
          path: 'linkToRecordReceivable/:id',
          name: 'LinkToRecordReceivable',
          meta: {
            requireAuth: true,
            permission: 8
          },
          component: LinkToRecordReceivable
        },
        {
          path: 'linkToConfirmReceivable/:id',
          name: 'LinkToConfirmReceivable',
          meta: {
            requireAuth: true,
            permission: 8
          },
          component: LinkToConfirmReceivable
        },
        {
          path: 'linkToConfirmExpenditure/:id',
          name: 'LinkToConfirmExpenditure',
          meta: {
            requireAuth: true,
            permission: 8
          },
          component: LinkToConfirmExpenditure
        },
        {
          path: 'linkToRefuseExpenditure/:id',
          name: 'LinkToRefuseExpenditure',
          meta: {
            requireAuth: true,
            permission: 8
          },
          component: LinkToRefuseExpenditure
        }
      ]
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/register/:token',
      name: 'register',
      component: Register
    }
  ]
})
export default router

router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {
    if (store.state.token !== '' && (store.state.permission & to.meta.permission)) {
      next()
    } else {
      next({
        path: '/login',
        query: {redirect: to.fullPath}
      })
    }
  } else {
    next()
  }
})
axios.interceptors.request.use(
  config => {
    if (store.state.token) {
      config.headers.Authorization = `token ${store.state.token}`
    }
    return config
  },
  err => {
    return Promise.reject(err)
  })

axios.interceptors.response.use(
  response => {
    return response
  },
  error => {
    if (error.response) {
      switch (error.response.status) {
        case 401:
          // 返回 401 清除token信息并跳转到登录页面
          store.commit('logout')
          router.replace({
            path: '/login',
            query: {redirect: router.currentRoute.fullPath}
          })
      }
    }
    return Promise.reject(error.response.data) // 返回接口返回的错误信息
  })
