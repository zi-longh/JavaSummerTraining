import * as Vue from 'vue'
import * as VueRouter from 'vue-router'
import Home from './views/Home.vue'
//引入组件  //引入的第一种方式 要使用组件，在js中就要引入组件
import Login from './views/Login.vue'

export default VueRouter.createRouter({
  history: VueRouter.createWebHashHistory(),
  routes: [
    //配置路由
    {
      path: '/', //路径，地址
      component: Login, //这个地方的login是上面引入登陆组件的Login 登陆页
    },
    {
      path: '/home',
      name: 'home', //name可不要  首页
      component: Home,
      children: [
        {
          path:"/home",
          component:()=>import("./views/dashboard.vue")
        },
        {
          //商品管理
          path: '/goodsmsg',
          component: 
            () => import('./views/GoodsMsg.vue'), //动态导入组件
        },
        {
          //供货商管理
          path: '/suppliermsg',
          component: 
            () => import('./views/suppliersManage.vue'), //动态导入组件
        },
        {
          //供货商管理
          path: '/supplierIn',
          component: 
            () => import('./views/supplierIn.vue'), //动态导入组件
        },
        {
          //账单管理
          path: '/paymsg',
          component: 
            () => import('./views/paymsg.vue'), //动态导入组件
        },
        {
          //仓库管理
          path: '/storagemsg',
          component: 
            () => import('./views/storagemsg.vue'), //动态导入组件
        },
        {
          //添加库存
          path: '/storageadd',
          component: 
            () => import('./views/store.vue'), //动态导入组件
        },
        {
          //员工
          path: '/worker',
          component: 
            () => import('./views/worker.vue'), //动态导入组件
        },
      ],
    },
    {
      path:'/checker',
      component:() => import("./views/checker/index.vue")
    }
  ],
})
