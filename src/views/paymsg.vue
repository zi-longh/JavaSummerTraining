<template>
  <div>
    <el-card class="box-card">
      <template v-slot:header>
        <div class="clearfix">
          <h3>账单管理</h3>
          <el-icon> <Edit /></el-icon>

        </div>
      </template>
      <div class="text item">
        <!-- 模板内容 -->
        <!-- 搜索 -->
        <div class="contentHead">
          <el-form
            :inline="true"
            :model="formSearch"
            class="demo-form-inline"
            id="MsgInput"
          >
            <el-form-item label="关键字">
              <el-input
                v-model="formSearch.keywords"
                placeholder="请输入员工姓名"
                clearable
                @clear="clearSelect"
              ></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="success" @click="onSearch">查询</el-button>
            </el-form-item>
          </el-form>
          <el-button
            type="primary"
            @click="handleAdd"
            style=" margin-top: 1px"
            >添加销售信息</el-button
          >
        </div>
        <div id="searchBox"></div>
        <!-- 销售列表-->
        <div>
          <el-table
            :data="tableNewData"
            style="width: 100%"
            max-height="350"
            :header-cell-style="{ 'text-align': 'center' }"
            :cell-style="{ 'text-align': 'center' }"
            height="350"
          >
            <el-table-column label="序号">
              <template v-slot="scope">
                {{ scope.row.id }}
              </template>
            </el-table-column>
            <el-table-column label="员工编号">
              <template v-slot="scope">
                {{ scope.row.emp_workerNum }}
              </template>
            </el-table-column>
            <el-table-column label="员工姓名">
              <template v-slot="scope">
                {{ scope.row.name }}
              </template>
            </el-table-column>
            <el-table-column label="商品编号">
              <template v-slot="scope">
                {{ scope.row.goo_goodsNum }}
              </template>
            </el-table-column>
            <el-table-column label="商品名称">
              <template v-slot="scope">
                {{ scope.row.goodsName }}
              </template>
            </el-table-column>

            <el-table-column label="销售日期">
              <template v-slot="scope">
                {{ scope.row.saleTime }}
              </template>
            </el-table-column>
            <el-table-column label="销售量">
              <template v-slot="scope">
                {{ scope.row.saleNum }}
              </template>
            </el-table-column>

            <el-table-column label="操作" width="180">
              <template v-slot="scope">
                <el-button size="small" @click="handleEdit(scope.row)">
                  <el-icon> <Edit /></el-icon>
                  <el-icon><el-icon-edit /></el-icon> 编辑</el-button
                >
                <el-button
                  size="small"
                  type="danger"
                  @click="handleDelete(scope.row.id)"
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
            :page-sizes="[6, 20, 30, 40]"
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
      title="修改销售信息"
      v-model="dialogVisible"
      width="30%"
      @close="handleEditClose('ruleForm')"
      id="mydailog"
    >
      <el-form
        :model="ruleForm"
        :rules="rules"
        ref="ruleForm"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="员工编号" prop="emp_workerNum">
          <el-select v-model="ruleForm.emp_workerNum" placeholder="请选择">
            <el-option
              v-for="item in workerNumArr"
              :key="item"
              :label="item"
              :value="item"
            >
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="商品编号" prop="goo_goodsNum">
          <el-select v-model="ruleForm.goo_goodsNum" placeholder="请选择">
            <el-option
              v-for="item in goodsNumArr"
              :key="item"
              :label="item"
              :value="item"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="日期" prop="saleTime">
          <el-input v-model="ruleForm.saleTime"></el-input>
        </el-form-item>

        <el-form-item label="销售量" prop="saleNum">
          <el-input v-model="ruleForm.saleNum"></el-input>
        </el-form-item>
      </el-form>
      <template v-slot:footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="submitForm('ruleForm')"
            >确定修改</el-button
          >
        </span>
      </template>
    </el-dialog>
    <!-- 添加销售信息 -->
    <el-dialog
      title="添加销售信息"
      v-model="addDialogVisible"
      width="30%"
      close="handleClose"
      id="mydailog"
    >
      <el-form
        :model="addForm"
        :rules="rules"
        ref="addForm"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="员工编号" prop="emp_workerNum">
          <el-select v-model="addForm.emp_workerNum" placeholder="请选择">
            <el-option
              v-for="item in workerNumArr"
              :key="item"
              :label="item"
              :value="item"
            >
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="商品编号" prop="goo_goodsNum">
          <el-select v-model="addForm.goo_goodsNum" placeholder="请选择">
            <el-option
              v-for="item in goodsNumArr"
              :key="item"
              :label="item"
              :value="item"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="日期" prop="saleTime">
          <el-input v-model="addForm.saleTime"></el-input>
        </el-form-item>

        <el-form-item label="销售量" prop="saleNum">
          <el-input v-model="addForm.saleNum"></el-input>
        </el-form-item>
      </el-form>
      <template v-slot:footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="submitForm('addForm')"
            >确定修改</el-button
          >
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import { Edit  } from '@element-plus/icons'
import http from '../request/sale'
import worker from '../request/worker'
import goods from '../request/goods'
export default {
  components: {
 Edit
  },
  data() {
    var dateTime = (rule, str, callback) => {
      // console.log(str)
      // let arr =str.split("-")
      let d1 = new Date(str)
      let d2 = new Date()
      console.log(d1, d2)
      if (d1.getTime() > d2.getTime()) callback(new Error('请输入正确的日期'))
      else callback()
    }
    return {
      dialogVisible: false,
      addDialogVisible: false,
      tableData: [],
      tableNewData: [],
      // 查询的表单
      formSearch: {
        classname: '',
        keywords: '',
      },
      currentPage: 1, //当前在那页，默认值
      pageSize: 6, //每页大小，默认值
      total: 0, //总记录数量
      //数据对象
      ruleForm: {},
      // 添加仓库表单
      addForm: {},
      rules: {
        saleNum: [{ required: true, message: '请输入销售量', trigger: 'blur' }],
        goo_goodsNum: [
          { required: true, message: '请选择商品编号', trigger: 'blur' },
        ],
        emp_workerNum: [
          { required: true, message: '请选择员工编号', trigger: 'blur' },
        ],
        saleDate: [
          { required: true, message: '请输入日期', trigger: 'blur' },
          {
            pattern:
              /^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$/,
            message: '请输入正确的日期',
            trigger: 'blur',
          },
          {
            validator: dateTime,
            message: '请输入正确的日期',
          },
        ],
      },
      workerNumArr: [],
      goodsNumArr: [],
    }
  },
  created() {
    this.getAllInfo()
  },
  methods: {
    //  获取编号数组
    async getNumArr() {
      const res1 = await goods.getGoodsNum()
      // console.log(res1.data)
      if (!res1.status) this.goodsNumArr = res1.data
      const res2 = await worker.getWorkersNum()
      if (!res2.status) this.workerNumArr = res2.data
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
    onSearch() {
      //点击搜索按钮，把商品分类和关键字，发送到后端api
      this.tableNewData = this.tableData.filter((i) => {
        const rep = new RegExp(this.formSearch.keywords, 'gi')
        return rep.test(i.name)
      })
    },
    handleEdit(msg) {
      // 根据商品id来获取该商品信息数据，在弹出编辑商品模态框, 把数据渲染到模态框中
      //  for(var i in msg)
      //  this.ruleForm[i]=msg[i];
      // msg['office']
      this.getNumArr()
      const { id, emp_workerNum, goo_goodsNum, saleTime, saleNum } = JSON.parse(
        JSON.stringify(msg)
      )
      this.ruleForm = { id, emp_workerNum, goo_goodsNum, saleTime, saleNum }
      this.dialogVisible = true
    },
    handleDelete(saleNum) {
      this.$confirm('此操作将永久删除该信息, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      })
        .then(async () => {
          const res = await http.deleteSaleById(saleNum)
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
    handleAdd() {
      this.getNumArr()
      this.addDialogVisible = true
    },
    submitForm(formName) {
      this.$refs[formName].validate(async (valid) => {
        if (valid) {
          //表单验证通过
          if (formName == 'addForm') {
            // let { ProvideNum,...addObj} =this.addForm;
            // addObj.id = ProvideNum
            const res = await http.addSale(this.addForm)
            if (!res.status) {
              this.$message.success('添加销售信息成功！')
              this.currentPage = 1
              this.getAllInfo()
              this.addDialogVisible = false
              this.formSearch = {}
            } else {
              this.$message.error('添加销售信息失败！')
              this.dialogVisible = false
            }
          } else {
            const result = await http.updateSale(this.ruleForm)
            if (!result.status) {
              this.$message.success('修改销售信息成功！')
              this.dialogVisible = false
              this.currentPage = 1
              this.getAllInfo()
              this.formSearch = {}
            } else {
              this.$message.error('修改销售信息失败！')
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
    clearSelect() {
      this.getAllInfo()
    },
    //  获取所有信息
    async getAllInfo() {
      const res = await http.getAllSalesInfo()
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
}
</style>
