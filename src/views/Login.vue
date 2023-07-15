<template>
  <!-- 卡片组件： -->
  <div id="box">
    <div class="animate">
      <Animation></Animation>
    </div>
    
    <el-card class="box-card" id="login">
      <!-- <template v-slot:header>
        <div class="clearfix">
          <h2>登录/注册</h2>
        </div>
      </template> -->
      <el-tabs>
        <el-tab-pane>
          <template #label>
            <span class="titleStyle">

              <span>登录</span>
            </span>
          </template>
          <div class="text item">
        <!-- 表单内容：表单输入框 -->
        <el-form
          :model="loginForm"
          status-icon
          :rules="rules2"
          ref="loginForm"
          label-width="100px"
          class="demo-ruleForm"
          :size="large"
        >
          <el-form-item label="用户名" prop="userName">
            <el-input
              type="text"
              v-model="loginForm.userName"
              autocomplete="off"
            ></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input
              type="password"
              
              v-model="loginForm.password"
              autocomplete="off"
            ></el-input>
          </el-form-item>
          <el-form-item label="用户类型">
            <el-radio-group v-model="loginForm.office" >
              <el-radio label="0" >收银员</el-radio>
              <el-radio label="1" >管理员</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item style="margin-left:60px;margin-top:30px;">
            <el-button type="primary" @click="submitForm('loginForm')" 
              >登录</el-button
            >
            <el-button @click="resetForm('loginForm')" style="margin-left: 40px;">重置</el-button>
          </el-form-item>
        </el-form>
      </div>
        </el-tab-pane>
        <el-tab-pane >
          <template #label>
            <span class="titleStyle">

              <span>注册</span>
            </span>
          </template>
          <div class="text item">
        <!-- 表单内容：表单输入框 -->
        <el-form
          :model="registerForm"
          status-icon
          :rules="rules2"
          ref="registerForm"
          label-width="100px"
          class="demo-ruleForm"
          :size="large"
        >
          <el-form-item label="用户名" prop="userName">
            <el-input
              type="text"
              v-model="registerForm.userName"
              autocomplete="off"
            ></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input
              type="password"
              
              v-model="registerForm.password"
              autocomplete="off"
            ></el-input>
          </el-form-item>
          <el-form-item label="工号" prop="workerNum">
            <el-input
              type="text"
              
              v-model="registerForm.workerNum"
              autocomplete="off"
            ></el-input>
          </el-form-item>
            <el-form-item label="用户类型">
            <el-radio-group v-model="registerForm.office" >
              <el-radio label="0" >收银员</el-radio>
              <el-radio label="2" >管理员</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item style="margin-left:60px;margin-top:30px;">
            <el-button type="primary" @click="submitRegisterForm('registerForm')" 
              >注册</el-button
            >
            <el-button @click="resetForm('registerForm')" style="margin-left: 40px;">重置</el-button>
          </el-form-item>
        </el-form>
      </div>
        </el-tab-pane>
      </el-tabs>

    </el-card>
  </div>
</template>

<script>
import Animation from '../components/animation.vue'
import user  from '../request/user'
//暴露一个模块：登陆组件
export default {
  data() {
    //data是函数，所有需要将数据返回出去
    //返回数据
    return {
      loginForm: {
        password: '',
        userName: '',
        office:"0"
      },
      registerForm: {
        password: '',
        userName: '',
        office:"0",
        workerNum:''
      },
      //验证规则
      rules2: {
        userName: [
          // //required: true 必填     trigger: 'blur' 失去焦点的事件触发     message: "出错信息"
          { required: true, trigger: 'blur', message: '请输入用户名' }, //非空验证
          // { min: 6, max: 18, trigger: "blur", message: "用户长度在6到18个字符" } //验证长度值
        ],

        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          // { min: 6, max: 12, message: "密码长度不对", trigger: "blur" }
        ],
        workerNum: [
          { required: true, message: '请输入工号', trigger: 'blur' },
          // { min: 6, max: 12, message: "密码长度不对", trigger: "blur" }
        ],
      },
    }
  },
  components:{
    Animation
  },
  methods: {
    //提交表单的方法
    submitForm(formName) {
    
      this.$refs[formName].validate(async (valid) => {
        //   //valid参数表示验证的结果，true表示验证通过，false验证失败
        if (valid) {
          const res = await user.login(this.loginForm)
          if (!res.status ) {
            localStorage.setItem("token",res.data);
            if(this.loginForm.office == 0){
              this.$router.push('/checker')
            }else this.$router.push('/home')
          } else {
            this.$message.error(res.message)
          }
        } else return
      })
    },
    submitRegisterForm(formName){
      this.$refs[formName].validate(async (valid) => {
        //   //valid参数表示验证的结果，true表示验证通过，false验证失败
        if (valid) {
          const res = await user.register(this.registerForm)
          if (!res.status ) {
            this.$message.success("注册成功!");
            this.$router.push('/')
          } else {
            this.$message.error(res.message)
          }
        } else return
      })
    },
    //重置表单的方法
    resetForm(formName) {
      this.$refs[formName].resetFields()
    },
  },
}
</script>

<style scoped>
#box {
  background: url('../assets/images/bg.webp') no-repeat;
  background-size: 100%;
  position: relative;

}
#login {
  width: 500px;
  height: 460px;
  position: fixed;
  /* left: 400; */
  top:114px;
  right: 8%;
  bottom: 0;
  /* margin: auto; */
}
.animate{
   position:absolute;
   top:60px;
   left:-8%;
  width:80%;
  height:80%;

}
.el-card__header {
  padding: 0px 15px !important;
}
.el-input {
  width: 80%;
}
.item{
  padding-top:80px;
}
.titleStyle{
  font-size: 18px;
  font-weight: 800;
}
</style>
