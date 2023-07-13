<template>
  <!--1. 左侧 -->
  <el-aside width="240px">
    <!--1.1 左侧导航顶部 -->
    <div id="asideTop">
      <h2>超市后台信息管理系统</h2>
      <p><span>您好</span>,admin</p>
      <p>
        <a href="#">管理首页</a> |
        <a href="javascript:void(0)" @click="loginOut()">退出系统</a>
      </p>
    </div>
    <!--1.2 左侧导航菜单  -->
    
    <el-col :span="12">
      <el-menu
      class="el-menu-vertical-demo"
      text-color="#fff"
      default-active="1"
      background-color="#545c64"
      @open="handleOpen"
      @close="handleClose"
      :unique-opened="onlyOne"
      router
    >
      <!-- 菜单一 -->
      <el-menu-item index="1" :route="{ path: '/worker' }">
        <!-- <template v-slot:title> -->
          <el-icon><User /></el-icon>
          <span>员工管理</span>
        <!-- </template> -->
      </el-menu-item>
      <!-- 菜单二 -->
      <el-menu-item index="2" :route="{ path: '/goodsmsg' }">
        <template v-slot:title>
          <el-icon><Goods /></el-icon>
          <span>商品管理</span>
        </template>
      </el-menu-item>
      <!-- 菜单三 -->
      <el-sub-menu index="3">
        <template v-slot:title>
          <el-icon><Menu /></el-icon>
          <span>仓库管理</span>
        </template>
        <el-menu-item-group>
          <!-- 获取仓库信息 -->
          <el-menu-item index="3-1" :route="{ path: '/storagemsg' }"
            >
            <el-icon><House /></el-icon>
            <span>仓库信息</span></el-menu-item
          >
          <el-menu-item index="3-2" :route="{ path: '/storageadd' }"
            >
            <el-icon><Management /></el-icon>
            <span>库存管理</span></el-menu-item
          >
        </el-menu-item-group>
      </el-sub-menu>
      <!-- 菜单四 -->
      <el-menu-item index="4" class="menuItem" :route="{ path: '/paymsg' }">
        <template v-slot:title>
          <!-- 获取销售信息 -->
          <el-icon><List /></el-icon>
          <span>账单管理</span>
        </template>
      </el-menu-item>
      <el-sub-menu index="5">
        <template v-slot:title>
          <!-- 获取供货商信息 -->
          <el-icon><Management /></el-icon>
          <span>供货商管理</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="7-1" :route="{ path: '/suppliermsg' }"
            >
            <el-icon><Document /></el-icon>
            <span>获取供货商信息</span>
            </el-menu-item
          >
          <el-menu-item index="7-2" :route="{ path: '/supplierIn' }"
            >
            <el-icon><Van /></el-icon>
            <span>进货管理</span></el-menu-item
          >
        </el-menu-item-group>
      </el-sub-menu>
    </el-menu></el-col>

    
  </el-aside>
</template>

<script>
import {
  User,
  Goods,
  House,
  Van,
  Menu,
  Management,
  Document,
  List
} from '@element-plus/icons-vue'
export default {
  data() {
    return {
      onlyOne: true,
    }
  },
  components: {
    User,
    Goods,
    House,
    Van,
    Menu,
    Management,
    Document,
    List
  },
  methods: {
    handleOpen(key, keyPath) {
      // console.log(key, keyPath)
    },
    handleClose(key, keyPath) {
      // console.log(key, keyPath)
    },
    loginOut() {
      //发起ajax到后端路由去执行清除cookie的操作
      // this.axios.get("http://127.0.0.1:3000/user/loginOut").then(result=>{
      //     //根据是否清除成功处理业务逻辑
      this.$message({
        message: '退出成功！ 欢迎下次登录!',
        type: 'success',
      })
      //跳转到登录页面
      this.$router.push('/')
    },
  },
}
</script>

<style>
.el-menu-item {
  /* display: block !important; */
}
.menuItem {
  /* */height: 33px;
  line-height: 33px;
  color: #fff; 
  /* text-align: center;
  margin-bottom: 10px; */
}
</style>
