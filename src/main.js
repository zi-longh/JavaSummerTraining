import * as Vue from 'vue'
import App from './App.vue'
import router from './router.js'
// import 'element-plus'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import filter from "@/config/filter"
//在elementUI后面引入公用样式
import './assets/style/public.css'
import store from './store/index'

//引入axios
import axios from 'axios'

//引入qs处理axios的post参数(是否需要下载？属于前端)
import qs from 'qs'

window.$vueApp = Vue.createApp(App)
window.$vueApp.use(ElementPlus)

window.$vueApp.config.globalProperties.routerAppend = (path, pathToAppend) => {
  return path + (path.endsWith('/') ? '' : '/') + pathToAppend
}
//挂在原型方便后期的vue实例使用
window.$vueApp.config.globalProperties.qs = qs

//构造全局守卫
//进入其他路由前都要进行守卫
router.beforeEach((to, from, next) => {
  // alert("全局守卫")
  next() //放行:只要登录成功的才放行
  //前端到后端拿cookie需要携带cookie证书
  //************************ 让ajax携带cookie证书********************************
  axios.defaults.withCredentials = true

  //去服务器端看是否登录成功：发起ajax到后端路由获取cookie，cookie存在就放行，否则去登录页面
  // axios.get(serverApi+"/user/getCookie").then(result=>{
  //    console.log("成功",result);
  //     //如果登录成或者是访问的页面时登录页面就放行
  //     if(result.data.isOK ||to.path=="/"){
  //       next();//进入下一个
  //     }else{  //否则就跳转到登录页面
  //       //console.log(to)打印不出来？
  //       next('/')
  //     }
  // }).catch(err=>{
  //   console.log("错误"+err.message)
  // })
})

window.$vueApp.config.globalProperties.$filters = filter;
;


window.$vueApp.use(router)
window.$vueApp.use(store)
window.$vueApp.mount('#app')
