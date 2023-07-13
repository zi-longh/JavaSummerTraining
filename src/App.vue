<template>
  <div id="app">
    <!-- 添加路由插座（路由视图）  -->
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'app',
  components: {},
  data() {
    return {}
  },
  methods: {},
}
</script>

<style>
html,
body,
#app,
#box,
#home {
  height: 100%;
  margin: 0;
}
</style>
