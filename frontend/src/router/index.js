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
import LoginRegister from '@/components/LoginRegister'

Vue.use(Router)

export default new Router({
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
      component: OverallFramework,
      children: [
        {
          path: 'departmentMng',
          name: 'DepartmentManagement',
          component: DepartmentManagement
        },
        {
          path: 'closedProjectMng',
          name: 'ClosedProjectManagement',
          component: ClosedProjectManagement
        },
        {
          path: 'doingProjectMng',
          name: 'DoingProjectManagement',
          component: DoingProjectManagement
        },
        {
          path: 'subDepartment/:id/:name',
          name: 'SubDepartmentManagement',
          component: SubDepartmentManagement
        },
        {
          path: 'businessMng',
          name: 'BusinessManagement',
          component: BusinessManagement
        },
        {
          path: 'financialPersonnelMng',
          name: 'FinancialPersonnelManagement',
          component: FinancialPersonnelManagement
        },
        {
          path: 'showDoingProject/:id/:name',
          name: 'ShowDoingProject',
          component: ShowDoingProject
        },
        {
          path: 'showClosedProject/:id/:name',
          name: 'ShowClosedProject',
          component: ShowClosedProject
        }
      ]
    },
    {
      path: '/developer',
      name: 'OverallDeveloper',
      component: OverallDeveloper,
      children: [
        {
          path: 'viewFeedback',
          name: 'ViewFeedback',
          component: ViewFeedback
        },
        {
          path: 'newReceivable',
          name: 'NewReceivable',
          component: NewReceivable
        },
        {
          path: 'newCost',
          name: 'NewCost',
          component: NewCost
        }
      ]
    },
    {
      path: '/departmentManager',
      name: 'OverallDepartment',
      component: OverallDepartment,
      children: [
        {
          path: 'projectManage',
          name: 'ProjectManage',
          component: ProjectManage
        },
        {
          path: 'dataManage',
          name: 'DataManage',
          component: DataManage
        },
        {
          path: 'projectFinanceManage/:id/:title',
          name: 'ProjectFinanceManage',
          component: ProjectFinanceManage
        },
        {
          path: 'staffEditor/:id/:name',
          name: 'StaffEditor',
          component: StaffEditor
        },
        {
          path: 'editingFinancialModel/:id/:title',
          name: 'editingFinancialModel',
          component: EditingFinancialModel
        },
        {
          path: 'personnelUseRequest',
          name: 'personnelUseRequest',
          component: PersonnelUseRequest
        }
      ]
    },
    {
      path: '/financial',
      name: 'OverallFinancial',
      component: OverallFinancial,
      children: [
        {
          path: 'financialMng',
          name: 'FinancialManagement',
          component: FinancialManagement
        },
        {
          path: 'recordReceivable/:id/:name',
          name: 'RecordReceivable',
          component: RecordReceivable
        },
        {
          path: 'confirmReceivable/:id/:name',
          name: 'ConfirmReceivable',
          component: ConfirmReceivable
        },
        {
          path: 'confirmExpenditure/:id/:name',
          name: 'ConfirmExpenditure',
          component: ConfirmExpenditure
        },
        {
          path: 'linkToRecordReceivable/:id',
          name: 'LinkToRecordReceivable',
          component: LinkToRecordReceivable
        },
        {
          path: 'linkToConfirmReceivable/:id',
          name: 'LinkToConfirmReceivable',
          component: LinkToConfirmReceivable
        },
        {
          path: 'linkToConfirmExpenditure/:id',
          name: 'LinkToConfirmExpenditure',
          component: LinkToConfirmExpenditure
        },
        {
          path: 'linkToRefuseExpenditure/:id',
          name: 'LinkToRefuseExpenditure',
          component: LinkToRefuseExpenditure
        }
      ]
    },
    {
      path: '/login',
      name: 'loginRegister',
      component: LoginRegister
    }
  ]
})
