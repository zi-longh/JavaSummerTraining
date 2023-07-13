<template>
  <el-container id="home">
    <!--1. 左侧 -->
    <!-- 四、像标签一样使用组件 -->
    <LeftMenu></LeftMenu>

    <!--2. 右侧 -->
    <el-container>
      <!-- 2.1 头部-->
      <RightTop></RightTop>

      <!-- 2.2 内容 中间 -->
      <el-main>
        <!-- <keep-alive> -->
        <router-view />
        <!-- </keep-alive> -->
      </el-main>

      <!--  2.3 页脚-->
      <el-footer>
        <RightFoot></RightFoot>
      </el-footer>
    </el-container>
  </el-container>
</template>

<script>
//二.在需要使用此组件的父组件中引入 组件名必须大写
import LeftMenu from '../components/leftMenu'
import RightTop from '../components/rightTop'
import RightFoot from '../components/rightFoot'

export default {
  data() {
    return {}
  },
  //三、 父组件中注册子组件
  components: {
    LeftMenu,
    RightTop,
    RightFoot,
  },
  methods: {},
}
</script>

<style lang="less" scoped>
.el-main {
  overflow: hidden;
}
</style>
