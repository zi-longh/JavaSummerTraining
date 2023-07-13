<template>
  <!-- 卡片组件： -->
  <div id="box">
    <el-card class="box-card" id="login">
      <template v-slot:header>
        <div class="clearfix">
          <h2>用户登录</h2>
        </div>
      </template>
      <div class="text item">
        <!-- 表单内容：表单输入框 -->
        <el-form
          :model="ruleForm2"
          status-icon
          :rules="rules2"
          ref="ruleForm2"
          label-width="100px"
          class="demo-ruleForm"
        >
          <el-form-item label="用户名" prop="id">
            <el-input
              type="text"
              :value="ruleForm2.id"
              autocomplete="off"
            ></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input
              type="password"
              
              v-model="ruleForm2.password"
              autocomplete="off"
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm2')"
              >登录</el-button
            >
            <el-button @click="resetForm('ruleForm2')">重置</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
  </div>
</template>

<script>
import http from '../request/worker'
//暴露一个模块：登陆组件
export default {
  data() {
    //data是函数，所有需要将数据返回出去
    //返回数据
    return {
      //数据对象
      ruleForm2: {
        password: '',
        id: '',
      },
      //验证规则
      rules2: {
        id: [
          // //required: true 必填     trigger: 'blur' 失去焦点的事件触发     message: "出错信息"
          { required: true, trigger: 'blur', message: '请输入用户名' }, //非空验证
          // { min: 6, max: 18, trigger: "blur", message: "用户长度在6到18个字符" } //验证长度值
        ],

        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          // { min: 6, max: 12, message: "密码长度不对", trigger: "blur" }
        ],
      },
    }
  },
  methods: {
    //提交表单的方法
    submitForm(formName) {
      // if(res.status == 200)
        this.$router.push('/home')
      this.$refs[formName].validate(async (valid) => {
        //   //valid参数表示验证的结果，true表示验证通过，false验证失败
        if (valid) {
          // const res = await http.login(this.ruleForm2)
          // console.log(res, 'res')
          // if (res.status == 0) {
            this.$router.push('/home')
          // } else {
            // this.$message.error(res.message)
          // }
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
}
#login {
  width: 500px;
  height: 300px;
  position: fixed;
  left: 0;
  top: 0;
  right: 0;
  bottom: 0;
  margin: auto;
}
.el-card__header {
  padding: 0px 15px !important;
}
.el-input {
  width: 80%;
}
</style>
