<template>
  <div>
    <el-card class="box-card">
      <template v-slot:header>
        <div class="clearfix">
          <h3>商品管理</h3>
        </div>
      </template>
      <div class="text item">
        <!-- 模板内容 -->
        <!-- 搜索 -->
        <div>
          <el-form
            :inline="true"
            :model-value="formSearch"
            class="demo-form-inline"
            id="goodsMsgInput"
          >
            <el-form-item label="选择分类">
              <el-select
               v-model="formSearch.goodsType"
                clearable
                placeholder="选择分类"
                @change="selectType"
                @clear="clearSelect"
              >
                <el-option label="日用品" value="0"></el-option>
                <el-option label="零食" value="1"></el-option>
                <el-option label="服装" value="2"></el-option>
                <el-option label="玩具" value="3"></el-option>
                <el-option label="鞋包" value="4"></el-option>
                <el-option label="其他" value="5"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="关键字">
              <el-input
                v-model="formSearch.keywords"
                placeholder="请输入商品名称"
                clearable
                @clear="clearSelect"
              ></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="success" @click="onSearch">查询</el-button>
              <el-button
                type="primary"
                @click="addDialogVisible = true"
                style="margin-top: 1px"
                >添加商品</el-button
              >
            </el-form-item>
          </el-form>
        </div>
        <div id="searchBox"></div>
        <!-- 商品列表-->
        <div>
          <el-table
            :data="tableNewData"
            style="width: 100%"
            :header-cell-style="{ 'text-align': 'center' }"
            :cell-style="{ 'text-align': 'center' }"
            max-height="350"
            height="350"
          >
            <el-table-column label="商品编号">
              <template v-slot="scope">
                {{ scope.row.goodsNum }}
              </template>
            </el-table-column>
            <el-table-column label="商品名称">
              <template v-slot="scope">
                {{ scope.row.goodsName }}
              </template>
            </el-table-column>

            <el-table-column label="所属分类">
              <template v-slot="scope">
                {{ $filters.filterGoodsType( scope.row.goodsType) }}
              </template>
            </el-table-column>

            <el-table-column label="售价">
              <template v-slot="scope">
                {{ scope.row.goodsPrice }}
              </template>
            </el-table-column>

            <el-table-column label="成本价">
              <template v-slot="scope">
                {{ scope.row.goodsCost }}
              </template>
            </el-table-column>
            <el-table-column label="操作" width="180">
              <template v-slot="scope">
                <el-button size="small" @click="handleEdit(scope.row)"
                  >
                  <el-icon><el-icon-edit /></el-icon> 编辑</el-button>
                <el-button
                  size="small"
                  type="danger"
                  @click="handleDelete(scope.row.goodsNum)"
                  ><el-icon><Delete /></el-icon>删除</el-button
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
      title="修改商品资料"
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
        <el-form-item label="所属分类" prop="goodsType">
          <el-select v-model="ruleForm.goodsType" placeholder="选择分类">
            <el-option label="日用品" value="0"></el-option>
            <el-option label="零食" value="1"></el-option>
            <el-option label="服装" value="2"></el-option>
            <el-option label="玩具" value="3"></el-option>
            <el-option label="鞋包" value="4"></el-option>
            <el-option label="其他" value="5"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="商品名称" prop="goodsName">
          <el-input v-model="ruleForm.goodsName"></el-input>
        </el-form-item>

        <el-form-item label="售价" prop="goodsPrice">
          <el-input v-model="ruleForm.goodsPrice"></el-input>
        </el-form-item>
        <el-form-item label="成本价" prop="goodsCost">
          <el-input v-model="ruleForm.goodsCost"></el-input>
        </el-form-item>
      </el-form>
      <template v-slot:footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="submitForm('ruleFormRef')"
            >确定修改</el-button
          >
        </span>
      </template>
    </el-dialog>
    <el-dialog
      title="添加商品"
      v-model="addDialogVisible"
 
      width="30%"
      @close="handleEditClose('addFormRef')"
      id="mydailog"
    >
      <el-form
        :model="addForm"
        :rules=" rules"
        ref="addFormRef"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="所属分类" prop="goodsType">
          <el-select v-model="addForm.goodsType" placeholder="选择分类">
            <el-option label="日用品" value="0"></el-option>
            <el-option label="零食" value="1"></el-option>
            <el-option label="服装" value="2"></el-option>
            <el-option label="玩具" value="3"></el-option>
            <el-option label="鞋包" value="4"></el-option>
            <el-option label="其他" value="5"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="商品名称" prop="goodsName">
          <el-input v-model="addForm.goodsName"></el-input>
        </el-form-item>
        <el-form-item label="售价" prop="goodsPrice">
          <el-input v-model="addForm.goodsPrice" @input="changeInput($event)"></el-input>
        </el-form-item>
        <el-form-item label="成本价" prop="goodsCost">
          <el-input v-model="addForm.goodsCost"></el-input>
        </el-form-item>
      </el-form>
      <template v-slot:footer>
        <span class="dialog-footer">
          <el-button @click="addDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="submitForm('addFormRef')"
            >提交</el-button
          >
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script >
import { Edit ,Delete  } from '@element-plus/icons'
import http from '../request/goods'

export default {

  data() {
    return {
      dialogVisible: false,
      addDialogVisible: false,
      tableNewData: [],
      tableData: [],
      // 查询的表单
      formSearch:{
        goodsType: '',
        keywords: '',
      },
      currentPage: 1, //当前在那页，默认值
      pageSize: 6, //每页大小，默认值
      total: 0, //总记录数量
      //数据对象
      ruleForm: {},
      addForm: {},
      rules: {
        goodsType: [
          { required: true, message: '请选择分类', trigger: 'change' },
        ],
        goodsName: [
          { required: true, message: '请输入商品名称', trigger: 'blur' },
        ],
        goodsCost: [
          { required: true, message: '请输入成本价', trigger: 'blur' },
        ],
        goodsPrice: [
          { required: true, message: '请输入售价', trigger: 'blur' },
        ],
      },
    }
  },
  components:{
    Edit,
    Delete
  },
  created() {
    this.getAllInfo()
    // console.log(  getInfo('getGoodsInfo',{currentPage:this.currentPage,pageSize:this.pageSize}))
  },
  methods: {
    changeInput(){
      this.$forceUpdate();
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

        return rep.test(i.goodsName)
      })
      if (this.formSearch.goodsType)
        this.tableNewData = this.tableData = this.tableData.filter(
          (i) => i.goodsType == this.formSearch.goodsType
        )
    },
    handleEdit(msg) {
      // 根据商品id来获取该商品信息数据，在弹出编辑商品模态框, 把数据渲染到模态框中
      this.ruleForm = JSON.parse(JSON.stringify(msg))
      this.dialogVisible = true
      // }).catch(err => {

      // });
    },
    handleDelete(goodsNum) {
      this.$confirm('此操作将永久删除该信息, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      })
        .then(async () => {
          const res = await http.deleteGoodById(goodsNum)
          console.log(res)
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
          if (formName == 'ruleFormRef') {
            const result = await http.updateGoodById(this.ruleForm)
            if (!result.status) {
              this.$message.success('修改商品信息成功！')
              this.currentPage = 1
              await this.getAllInfo()
              this.dialogVisible = false
              this.formSearch = {}
            } else {
              this.$message.error('修改商品信息失败！')
              this.dialogVisible = false
            }
          } else {
            const res = await http.addGood(this.addForm)
            if (!res.status) {
              this.$message.success('添加商品信息成功！')
              this.currentPage = 1
              this.getAllInfo()
              this.addDialogVisible.value = false
              this.formSearch = {}
            } else {
              this.$message.error('添加商品信息失败！')
              this.addDialogVisible.value = false
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
      this.$refs[formName].resetFields();
      this.$refs[formName].clearValidate()
    },
    //  获取所有信息
    async getAllInfo() {
      const res = await http.getAllGoodsInfo()
      if (!res.status) {
        this.tableNewData = this.tableData = res.data
        this.tableNewData = this.tableData.slice(0, this.pageSize)
        this.total = this.tableData.length
      } else {
        this.$message.error(res.message)
      }
    },
    async selectType(val) {
      await this.getAllInfo()
      this.tableNewData = this.tableData = this.tableData.filter(
        (i) => i.goodsType == val
      )
      if (this.formSearch.keywords)
        this.tableData = this.tableNewData = this.tableData.filter((i) => {
          const rep = new RegExp(this.formSearch.keywords, 'gi')
          return rep.test(i.goodsName)
        })
      this.tableNewData = this.tableData.slice(0, this.pageSize)
      this.total = this.tableData.length
      console.log(this.tableNewData)
    },
    async clearSelect() {
      await this.getAllInfo()
      if (this.formSearch.goodsType) {
        this.selectType(this.formSearch.goodsType)
      } else if (this.formSearch.keywords) {
        this.onSearch()
      }
    },
  },
}
</script>

<style lang="less" scoped>
.pagerBox {
  margin-top: 10px;
}
</style>
