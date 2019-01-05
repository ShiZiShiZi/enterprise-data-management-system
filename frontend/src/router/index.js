import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import OverallFramework from '@/components/superAdmin/OverallFramework'
import DepartmentManagement from '@/views/superAdmin/DepartmentManagement'
import ClosedProjectManagement from '@/views/superAdmin/ClosedProjectManagement'
import DoingProjectManagement from '@/views/superAdmin/DoingProjectManagement'
import SubDepartmentManagement from '@/views/superAdmin/SubDepartmentManagement'
import BusinessManagement from '@/views/superAdmin/BusinessManagement'
import FinancialPersonnelManagement from '@/views/superAdmin/FinancialPersonnelManagement'

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
        }
      ]
    }
  ]
})
