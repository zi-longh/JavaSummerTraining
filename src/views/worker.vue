<template>
  <div>
    <el-card class="box-card">
      <template v-slot:header>
        <div class="clearfix">
          <h3>员工管理</h3>
        </div>
      </template>
      <div class="text item">
        <!-- 模板内容 -->
        <!-- 搜索 -->
        <div>
          <el-form
            :inline="true"
            :model="formSearch"
            class="demo-form-inline"
            id="workerMsgInput"
          >
            <el-form-item label="选择职务">
              <el-select
                v-model="formSearch.office"
                placeholder="选择职务"
                clearable
                @change="selectOffice"
                @clear="clearSelect"
                :popper-append-to-body="false"
              >
                <el-option label="经理" value="0"></el-option>
                <el-option label="销售员" value="1"></el-option>
                <el-option label="收银员" value="2"></el-option>
                <el-option label="理货员" value="3"></el-option>
                <el-option label="安保" value="4"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="关键字">
              <el-input
                v-model="formSearch.keywords"
                placeholder="请输入员工姓名"
                clearable
                @input="change($event)" 
                @clear="clearSelect"
                style="width: 90%"
              ></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="success" @click="onSearch">查询</el-button>
              <el-button
                type="primary"
                @click="addDialogVisible = true"
              
                >添加员工</el-button
              >
            </el-form-item>
          </el-form>
        </div>
        <div id="searchBox"></div>
        <!-- 员工列表-->
        <div>
          <el-table
            :data="tableNewData"
            style="width: 100%"
            max-height="350"
            :header-cell-style="{ 'text-align': 'center' }"
            :cell-style="{ 'text-align': 'center' }"
            height="350"
          >
            <el-table-column label="员工编号">
              <template v-slot="scope">
                {{ scope.row.workerNum }}
              </template>
            </el-table-column>
            <el-table-column label="姓名">
              <template v-slot="scope">
                {{ scope.row.name }}
              </template>
            </el-table-column>

            <el-table-column label="年龄">
              <template v-slot="scope">
                {{ scope.row.age }}
              </template>
            </el-table-column>

            <el-table-column label="性别">
              <template v-slot="scope">
                {{ scope.row.sex }}
              </template>
            </el-table-column>

            <el-table-column label="电话">
              <template v-slot="scope">
                {{ scope.row.phoneNum }}
              </template>
            </el-table-column>

            <el-table-column label="工龄">
              <template v-slot="scope">
                {{ scope.row.workTime }}
              </template>
            </el-table-column>

            <el-table-column label="职务">
              <template v-slot="scope">
                {{$filters.filterOffice(scope.row.office)  }}
              </template>
            </el-table-column>

            <el-table-column label="工资">
              <template v-slot="scope">
                {{ scope.row.salary }}
              </template>
            </el-table-column>

            <el-table-column label="操作" width="180">
              <template v-slot="scope">
                <el-button size="small" @click="handleEdit(scope.row)"
                  ><el-icon><el-icon-edit /></el-icon> 编辑</el-button
                >
                <el-button
                  size="small"
                  type="danger"
                  @click="handleDelete(scope.row.workerNum)"
                  ><el-icon><el-icon-delete /></el-icon>删除</el-button
                >
              </template>
            </el-table-column>
          </el-table>
        </div>
        <!--分页 -->
        <!--:page-sizes 	每页显示个数选择器的选项设置
                      page-size    每页显示条目个数，
                     -->
        <div class="pagerBox">
          <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage"
            :page-sizes="[6, 10, 20, 30]"
            :page-size="pageSize"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total"
          >
          </el-pagination>
        </div>
      </div>
    </el-card>

    <!-- 模态框 -->
    <el-dialog
      title="修改员工资料"
      v-model="dialogVisible"
      width="30%"
      @close="handleEditClose('ruleFormRef')"
      id="mydailog"
    >
      <el-form
        :model="ruleForm"
        :rules="rules"
        ref="ruleFormRef"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="姓名" prop="name">
          <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>

        <el-form-item label="年龄" prop="age">
          <el-input v-model="ruleForm.age"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-input v-model="ruleForm.sex"></el-input>
        </el-form-item>
        <el-form-item label="电话" prop="phoneNum">
          <el-input v-model="ruleForm.phoneNum"></el-input>
        </el-form-item>
        <el-form-item label="工龄" prop="workTime">
          <el-input v-model="ruleForm.workTime"></el-input>
        </el-form-item>
        <el-form-item label="职务" prop="office">
          <el-select
            v-model="ruleForm.office"
            :popper-append-to-body="false"
          >
            <el-option label="经理" value="0"></el-option>
            <el-option label="销售员" value="1"></el-option>
            <el-option label="收银员" value="2"></el-option>
            <el-option label="理货员" value="3"></el-option>
            <el-option label="安保" value="4"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="工资" prop="salary">
          <el-input v-model="ruleForm.salary"></el-input>
        </el-form-item>
      </el-form>

      <template v-slot:footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="submitForm('ruleFormRef', ruleForm)"
            >确定修改</el-button
          >
        </span>
      </template>
    </el-dialog>
    <!-- 添加员工 -->
    <el-dialog
      title="添加员工"
      v-model="addDialogVisible"
      width="30%"
      @close="handleClose('addFormRef')"
      id="mydailog"
    >
      <el-form
        :model="addForm"
        :rules="rules"
        ref="addFormRef"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="姓名" prop="name">
          <el-input v-model="addForm.name"></el-input>
        </el-form-item>

        <el-form-item label="年龄" prop="age">
          <el-input v-model="addForm.age"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-input v-model="addForm.sex"></el-input>
        </el-form-item>
        <el-form-item label="电话" prop="phoneNum">
          <el-input v-model="addForm.phoneNum"></el-input>
        </el-form-item>
        <el-form-item label="工龄" prop="workTime">
          <el-input v-model="addForm.workTime"></el-input>
        </el-form-item>
        <el-form-item label="职务" prop="office">
          <el-select
            v-model="addForm.office"
            popper-class="setSelect"
            :popper-append-to-body="false"
          >
            <el-option label="经理" value="0"></el-option>
            <el-option label="销售员" value="1"></el-option>
            <el-option label="收银员" value="2"></el-option>
            <el-option label="理货员" value="3"></el-option>
            <el-option label="安保" value="4"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="工资" prop="salary">
          <el-input v-model="addForm.salary"></el-input>
        </el-form-item>
      </el-form>
      <template v-slot:footer>
        <span class="dialog-footer">
          <el-button @click="addDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="submitForm('addFormRef', addForm)"
            >添加</el-button
          >
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import { Edit as ElIconEdit, Delete as ElIconDelete } from '@element-plus/icons'
import filter from "@/config/filter.js"
import http from '../request/worker'
export default {
  components: {
    ElIconEdit,
    ElIconDelete,
  },
  data() {
    return {
      dialogVisible: false,
      addDialogVisible: false,
      tableData: [],
      tableNewData: [],
      // 查询的表单
      formSearch: {
        office: '',
        keywords: '',
      },
      currentPage: 1, //当前在那页，默认值
      pageSize: 6, //每页大小，默认值
      total: 20, //总记录数量
      //数据对象
      ruleForm: {},
      //  添加员工
      addForm: {},
      rules: {
        name: [{ required: true, message: '请输入姓名', trigger: 'blur' }],
        sex: [{ required: true, message: '请输入性别', trigger: 'blur' }],
        age: [{ required: true, message: '请输入年龄', trigger: 'blur' }],
        phoneNum: [
          { required: true, message: '请输入电话号码', trigger: 'blur' },
          {
            pattern:
              /^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(16[5,6])|(17[0-8])|(18[0-9])|(19[1、5、8、9]))[0-9]{8}$/,
            message: '请输入正确的电话号码',
            trigger: 'blur',
          },
        ],
        workTime: [{ required: true, message: '请输入工龄', trigger: 'blur' }],
        salary: [{ required: true, message: '请输入工资', trigger: 'blur' }],
        office: [{ required: true, message: '请输入职务', trigger: 'blur' }],
      },
    }
  },
  created() {
    this.getAllInfo()
  },
  // 功能：获取数据到全表
  //1）前端——created钩子函数中发起ajax请求去获取商品数据信息
  methods: {
    change(){
      console.log(this.formSearch.keywords);
	// this.$forceUpdate();  //强制刷新
},
    //改变每页大小的方法
    handleSizeChange(val) {
      //把改变后的值赋值给数据属性
      this.pageSize = val
      this.currentPage = 0
      this.tableNewData = this.tableData.slice(0, this.pageSize)
    },
    //改变当前页
    handleCurrentChange(val) {
      //把改变后的值赋值给数据属性
      this.currentPage = val
      const start = (this.currentPage - 1) * this.pageSize
      const end = start + this.pageSize
      this.tableNewData = this.tableData.slice(start, end)
      console.log(this.tableData)
    },
    async onSearch() {
      //点击搜索按钮，把商品分类和关键字，发送到后端api
      await this.getAllInfo()
      this.tableData = this.tableNewData = this.tableData.filter((i) => {
        const rep = new RegExp(this.formSearch.keywords, 'gi')
        return rep.test(i.name)
      })
      if (this.formSearch.office)
        this.tableData = this.tableNewData = this.tableData.filter((i) => {
          const rep = new RegExp(this.formSearch.office, 'gi')
        })
    },
    handleEdit(msg) {
      // 根据商品id来获取该商品信息数据，在弹出编辑商品模态框, 把数据渲染到模态框中
      this.ruleForm = JSON.parse(JSON.stringify(msg))
      this.dialogVisible = true
    },
    handleDelete(workerNum) {
      this.$confirm('此操作将永久删除该信息, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      })
        .then(async () => {
          const res = await http.deleteWorkerById(workerNum)
          if (!res.status) {
            this.$message.success('删除成功!')
            this.currentPage = 1
            this.getAllInfo()
            this.formSearch = {}
          } else {
            this.$message.error(res.message)
          }
        })
        .catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除',
          })
        })
    },
    submitForm(formName) {
      this.$refs[formName].validate(async (valid) => {
        if (valid) {
          //表单验证通过
          if (formName == 'addFormRef') {
            let { workerNum, ...addObj } = this.addForm
            addObj.id = workerNum
            const res = await http.addWorker(addObj)
            if (!res.status) {
              this.$message.success('添加员工信息成功！')
              this.currentPage = 1
              this.getAllInfo()
              this.addDialogVisible = false
              this.formSearch = {}
            } else {
              this.$message.error('添加员工信息失败！')
              this.dialogVisible = false
            }
          } else {
            const result = await http.updateWorkerById(this.ruleForm)
            if (!result.status) {
              this.$message.success('修改员工信息成功！')
              this.dialogVisible = false
              this.currentPage = 1
              this.getAllInfo()
              this.formSearch = {}
            } else {
              this.$message.error('修改员工信息失败！')
              this.dialogVisible = false
            }
          }
        } else {
          return
        }
      })
    },
    handleClose(formName) {
      this.$refs[formName].resetFields()
      this.$refs[formName].clearValidate()
    },
    handleEditClose(formName) {
      this.$refs[formName].clearValidate()
    },
    //筛选职务
    async selectOffice(val) {
      this.change();
      // await this.getAllInfo()
      // this.tableData = this.tableNewData = this.tableData.filter(
      //   (i) => i.office == val
      // )
      // if (this.formSearch.keywords) {
      //   this.tableData = this.tableNewData = this.tableData.filter((i) => {
      //     const rep = new RegExp(this.formSearch.keywords, 'gi')
      //     return rep.test(i.name)
      //   })
      // }
      this.tableNewData = this.tableData.slice(0, this.pageSize)
      this.total = this.tableData.length
    },
    async clearSelect() {
      await this.getAllInfo()
      if (this.formSearch.office) {
        this.selectOffice(this.formSearch.office)
      } else if (this.formSearch.keywords) {
        this.onSearch()
      }
    },
    //  获取所有信息
    async getAllInfo() {
      const res = await http.getAllWorkersInfo()
      if (!res.status) {
        this.tableNewData = this.tableData = res.data
        this.tableNewData = this.tableData.slice(0, this.pageSize)
        this.total = this.tableData.length
      } else {
        this.$message.error(res.message)
      }
    },
  },
}
</script>

<style lang="less" scoped>
.contentHead {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
}
.pagerBox {
  margin-top: 10px;
}
.setSelect {
  min-width: 210px !important;
}
</style>
