<template>
  <div class="common-layout" style="background-color: #c8c9cc;height:100%">
    <el-container style="height:800px">
      <el-aside
        width="400px"
        class="box-radius"
        style="background: none; backgrounds-color: #e4e7ed"
      > 
        <el-row class="el-aside menu-top">
          <el-col :span="24">
            <div>广州店铺</div>
            <div>
              <span style="color: #b1b3b8; font-size: 14px; margin-right: 5px"
                >收银员</span
              ><span style="font-size: 14px">{{ userName }}</span>
            </div>
          </el-col>
        </el-row>
        <el-scrollbar height="100%">
        <el-row>
          <el-col :span="24">
            <order />
          </el-col>
        </el-row>
      </el-scrollbar>
        <el-row class="el-aside menu-bottom">
          <el-col :span="12" class="menu-bottom-font">
            <div>总计</div>
          </el-col>
          <el-col :span="12" class="menu-bottom-font">
            <div>￥{{ parseFloat(totalPrice).toFixed(2) }}</div>
          </el-col>
        </el-row>
    
      </el-aside>
      <el-aside width="100px" style="margin-left: 20px;" class="box-radius">
        <!-- <el-space wrap> -->
          <div style="height: 100px">

          <el-card
            class="box-card preview-card"
            @click="clearGoods"
            style="background: #c8c9cc;margin:100px 0"
          >
            <div class="aside-font">
              <!-- <el-icon class="delete"></el-icon> -->
              清空</div>
          </el-card>
        
          <el-card
            class="box-card preview-card"
            style="
              height: 80px;
              padding-top: 15px;
              background-color: red;
              color: #fff;
              font-weight: 900;


            "
            @click="addSales"
          >
            <div class="aside-font">结算</div>
          </el-card>
          <el-card
            class="box-card preview-card"
            style="
              position:absolute;
              bottom:10px;
              height: 50px;
              padding-top: 15px;
              background-color: #fff;
              color: #333;
              font-weight: 900;
              line-height: 2px;


            "
            @click="logout"
          >
            <div class="aside-font">退出</div>
          </el-card>
         </div>
      </el-aside>
      <el-main
        > <div>
    <div> </div>
    <div class="goodsDisplay">
        <el-tabs type="border-card">
         
        <el-tab-pane label="日用品">
       
            <div class="goodsList">
                <template  v-for="goodsItem in filtersGoods('0')" :key="goodsItem.goodsNum">
                    <goods class="goodsCard" :goodsItem="goodsItem"></goods>
                 
                </template>
            </div>
        </el-tab-pane>
        <el-tab-pane label="零食">
          <el-scrollbar height="100%">
            <div class="goodsList" >
              <template  v-for="goodsItem in filtersGoods('1')" :key="goodsItem.goodsNum">
                    <goods class="goodsCard" :goodsItem="goodsItem"></goods>
                 
                </template>
            </div>
          </el-scrollbar>
        </el-tab-pane>
        <el-tab-pane label="服装">
            <div class="goodsList" >
              <template  v-for="goodsItem in filtersGoods('2')" :key="goodsItem.goodsNum">
                    <goods class="goodsCard" :goodsItem="goodsItem"></goods>
                 
                </template>
            </div>
        </el-tab-pane>
        <el-tab-pane label="玩具">
            <div class="goodsList" >
              <template  v-for="goodsItem in filtersGoods(3)" :key="goodsItem.goodsNum">
                    <goods class="goodsCard" :goodsItem="goodsItem"></goods>
                 
                </template>
            </div>
        </el-tab-pane>
        <el-tab-pane label="鞋包">
            <div class="goodsList" >
              <template  v-for="goodsItem in filtersGoods(4)" :key="goodsItem.goodsNum">
                    <goods class="goodsCard" :goodsItem="goodsItem"></goods>
                 
                </template>
            </div>
        </el-tab-pane>
        <el-tab-pane label="其它">
            <div class="goodsList" >
              <template  v-for="goodsItem in filtersGoods(-1)" :key="goodsItem.goodsNum">
                    <goods class="goodsCard" :goodsItem="goodsItem"></goods>
                 
                </template>
            </div>
        </el-tab-pane>
     
        </el-tabs>
    </div>
  </div></el-main>
    </el-container>
  </div>
</template>

<script>
import goods from "./components/goods.vue";
import order from "./components/order.vue";
import { mapGetters } from 'vuex'
export default {
    mounted() {
       this.getAllGoodsInfo(); 
    },
  components: {
    goods,
    order,
  },
  data() {
    return {
      userName: "user",
      goodsList:[],
    }
  },
  computed: {
    ...mapGetters([
      "selectedGoods","allGoodsInfo","totalPrice"
    ])
  },
  methods: {
    logout(){
      window.localStorage.removeItem("token");
      this.$message({
        message: '退出成功！ 欢迎下次登录!',
        type: 'success',
      })
      //跳转到登录页面
      this.$router.push('/')
    },
    async getAllGoodsInfo(){
        await this.$store.dispatch("getAllGoodsInfo");
        // console.log(this.allGoodsInfo);
    },
    addSales(){
      
    },
    filtersGoods(type){
        return  this.allGoodsInfo.filter((item) => {
          if(type=="-1") return parseInt(item.goodsType) > 4;
          else  return item.goodsType == type
        })
    },
    clearGoods() {
      if(this.selectedGoods.length > 0){
        this.$confirm('确定清空所有商品？, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      })
        .then(()=>{
          this.$store.commit("clearSelectedGoods")
          window.location.reload()
          
        })
      }else{
        this.$message({
            type: 'warning',
            message: '当前无选择商品',
          })
      }
        
    },
    addSales() {
      if(this.selectedGoods.length > 0){
        this.$confirm(`确定结算所有商品？总计: ￥${parseFloat(this.totalPrice).toFixed(2)}元, 是否继续?`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      })
        .then(()=>{
          var date = new Date()
           date.toLocaleDateString().replaceAll('/','-')
           console.log(date);
           date = "2023-07-15"
          this.$store.dispatch("addSales",date)
        })
      }else{
        this.$message({
            type: 'warning',
            message: '当前无选择商品',
          })
      }
    },
  },
};
</script>

<style scoped>
/* .common-layout{
  height: inherit;
} */
.goodsList{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    align-content: space-around;
    flex-wrap: wrap;
    /* min-height: 90%; */
    width:100%;
}
.box-radius {
height: 800px;
  border-radius: 7px;

}
.el-row {
  margin-bottom: 20px;
}
.el-row:last-child {
  margin-bottom: 0;
}
.el-col {
  border-radius: 4px;

}

.menu-top {
  height: 60px;
  font-size: 18px;
  color: #fff;
  /* line-height: 40px; */
  padding: 10px;
}
.menu-bottom {
  position: absolute;
  bottom: 2px;
  height: 80px;
}
.menu-bottom-font {
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 20px;
  color: #fff;
}
.aside-font {
  font-size: 18px;
  text-align: center;
}
.preview-card {
  width: 98px;
  height: 70px;
  padding-top: 5px;
  cursor: pointer;
}
.goodsList {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-content: space-around;
  flex-wrap: wrap;
  min-height: 90%;
}
.goodsCard {
  width: 30%;
  height: 20%;
}
.goodsCard:hover {
  background-color: aqua;
}
.goodsCard{
    width:30%;
    height:20%;
    margin:5px;
}.goodsCard:hover{
    background-color: aqua;
}

.dire-align {
  height: 100%;
}
.goodsDisplay {
  height: 800px;
}

</style>