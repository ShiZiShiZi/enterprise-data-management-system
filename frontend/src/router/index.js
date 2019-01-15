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
import SelectDepartment from '@/views/financial/SelectDepartment'
import IncomeConfirmation from '@/views/financial/IncomeConfirmation'
import ReceiveInAdvance from '@/views/financial/ReceiveInAdvance'
import SelectProject from '@/views/financial/SelectProject'
import OutcomeConfirmation from '@/views/financial/OutcomeConfirmation'
import Login from '@/components/Login'
import Register from '@/components/Register'
import DoingProjectDepartment from '@/views/superAdmin/DoingProjectDepartment'

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
          path: 'selectDepartment',
          name: 'selectDepartment',
          meta: {
            requireAuth: true,
            permission: 8
          },
          component: SelectDepartment
        },
        {
          path: 'selectProject/:id',
          name: 'selectProject',
          meta: {
            requireAuth: true,
            permission: 8
          },
          component: SelectProject
        },
        {
          path: 'receiveInAdvance/:id',
          name: 'receiveInAdvance',
          meta: {
            requireAuth: true,
            permission: 8
          },
          component: ReceiveInAdvance
        },
        {
          path: 'incomeConfirmation/:id',
          name: 'IncomeConfirmation',
          meta: {
            requireAuth: true,
            permission: 8
          },
          component: IncomeConfirmation
        },
        {
          path: 'outcomeConfirmation/:id',
          name: 'outcomeConfirmation',
          meta: {
            requireAuth: true,
            permission: 8
          },
          component: OutcomeConfirmation
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
