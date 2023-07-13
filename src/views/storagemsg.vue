<template>
  <div>
    <el-card class="box-card">
      <template v-slot:header>
        <div class="clearfix">
          <h3>仓库管理</h3>
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
                placeholder="请输入仓库名称"
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
            @click="addDialogVisible = true"
            style="margin-top: 1px"
            >添加仓库</el-button
          >
        </div>
        <div id="searchBox"></div>
        <!-- 仓库列表-->
        <div>
          <el-table
            :data="tableNewData"
            style="width: 100%"
            :header-cell-style="{ 'text-align': 'center' }"
            :cell-style="{ 'text-align': 'center' }"
            max-height="350"
            height="350"
          >
            <el-table-column label="仓库编号">
              <template v-slot="scope">
                {{ scope.row.storageNum }}
              </template>
            </el-table-column>
            <el-table-column label="名称">
              <template v-slot="scope">
                {{ scope.row.storageName }}
              </template>
            </el-table-column>

            <el-table-column label="地址">
              <template v-slot="scope">
                {{ scope.row.storageAddress }}
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
                  @click="handleDelete(scope.row.storageNum)"
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
      title="修改仓库资料"
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
        <el-form-item label="仓库编号" prop="storageNum">
          <el-input v-model="ruleForm.storageNum" disabled></el-input>
        </el-form-item>

        <el-form-item label="仓库名称" prop="storageName">
          <el-input v-model="ruleForm.storageName"></el-input>
        </el-form-item>

        <el-form-item label="地址" prop="storageAddress">
          <el-input v-model="ruleForm.storageAddress"></el-input>
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
    <!--添加仓库  -->
    <el-dialog
      title="添加仓库"
      v-model="addDialogVisible"
      width="30%"
      @close="handleClose('addForm')"
      id="mydailog"
    >
      <el-form
        :model="addForm"
        :rules="rules"
        ref="addForm"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="仓库名称" prop="storageName">
          <el-input v-model="addForm.storageName"></el-input>
        </el-form-item>

        <el-form-item label="地址" prop="storageAddress">
          <el-input v-model="addForm.storageAddress"></el-input>
        </el-form-item>
      </el-form>
      <template v-slot:footer>
        <span class="dialog-footer">
          <el-button @click="addDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="submitForm('addForm')"
            >提交</el-button
          >
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import { Edit as ElIconEdit, Delete as ElIconDelete } from '@element-plus/icons'
import http from '../request/storage'
import { parse } from '@vue/compiler-sfc'
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
        storageName: [
          { required: true, message: '请输入仓库名称', trigger: 'blur' },
        ],
        storageAddress: [
          { required: true, message: '请输入仓库地址', trigger: 'blur' },
        ],
      },
    }
  },
  created() {
    this.getAllInfo()
  },
  methods: {
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
    },
    onSearch() {
      //点击搜索按钮，把商品分类和关键字，发送到后端api
      this.tableNewData = this.tableData.filter((i) => {
        const rep = new RegExp(this.formSearch.keywords, 'gi')
        return rep.test(i.storageName)
      })
    },
    handleEdit(msg) {
      // 根据商品id来获取该商品信息数据，在弹出编辑商品模态框, 把数据渲染到模态框中
      //  for(var i in msg)
      //  this.ruleForm[i]=msg[i];
      // msg['office']
      this.ruleForm = JSON.parse(JSON.stringify(msg))
      this.dialogVisible = true
    },
    handleDelete(storageNum) {
      this.$confirm('此操作将永久删除该信息, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      })
        .then(async () => {
          const res = await http.deleteStorageById(parseInt(storageNum))
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
          if (formName == 'addForm') {
            // let { storageNum,...addObj} =this.addForm;
            // addObj.id = storageNum
            const res = await http.addStorage(this.addForm)
            if (!res.status) {
              this.$message.success('添加仓库信息成功！')
              this.currentPage = 1
              this.getAllInfo()
              this.addDialogVisible = false
              this.formSearch = {}
            } else {
              this.$message.error('添加仓库信息失败！')
              this.dialogVisible = false
            }
          } else {
            const result = await http.updateStorageById(this.ruleForm)
            if (!result.status) {
              this.$message.success('修改仓库信息成功！')
              this.dialogVisible = false
              this.currentPage = 1
              this.getAllInfo()
              this.formSearch = {}
            } else {
              this.$message.error('修改仓库信息失败！')
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
      const res = await http.getAllStorageInfo()
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
