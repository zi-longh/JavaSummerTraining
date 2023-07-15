<template>
  <el-card class="card" v-for="goodItem in selectedGoods" :key="goodItem.goodsNum" style="margin-bottom: 10px;">
    <!-- <template #header>
      <div class="card-header">
        <el-button class="button" text @click="deleteGoods">删除</el-button>
      </div>
    </template> -->
    <el-row :span="24">
        <el-col :span="10">
            <img :src="goodItem.goodsPictureUrl" alt="" class="goodsImg">
        </el-col>
        <el-col :span="14">
            <p>{{ goodItem.goodsName }}</p>
            <div>
                <span class="price">￥{{goodItem.goodsPrice  }}</span>
            <span style="margin-left:80px;font-size: 20px;">￥{{ goodItem.sumPrice }}</span>
            </div>
           
            <span style="margin-top: 20px;">商品数量：{{ goodItem.count }}</span>
           
        </el-col>
    </el-row>
  </el-card>
  
</template>

<script>
import {CirclePlus} from "@element-plus/icons"
export default {
  data(){
    return{
      
        count:0,
        isInCart:false
    }
  },
  computed:{
    selectedGoods(){
        return this.$store.getters.selectedGoods
    },
    isMinCount(){
        return this.count == 1? true : false;
    },
    deleteGoods(){
      
    }
    
  },
  components:{
    CirclePlus
  },
  methods:{
    add(){
        this.count++;
    },
    subtract(){
        if(this.count == 0){
            this.$message({
            type: 'warning',
            message: '已经不能再减了！',
          })
        }else{
            this.count--;
        }
    },
    addGoodsInCart(){
        this.add();
    }
  }
}
</script>

<style scoped>
.card{
    /* position: absolute; */
}
.price{
    color: red;
}
.goodsImg{
    width:80%;
    height:90%;
}
.box{
    margin-top:10% ;
}
.box ul li{
   list-style: none;
}
.box li{
      float: left;
    }
.box  input{
      text-align: center;
    }
.location{
    /* position: relative;
    bottom: 10;
    right:20; */
    margin-top:10%;
    margin-left:80%;
    }
</style>