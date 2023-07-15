<template>
    <div class="list">
        <el-card @click="addShoppingCart" class="card" >
            <el-row :span="24">
                <el-col :span="10">
                    <img :src="goodsItem.goodsPictureUrl" alt="" class="goodsImg">
                </el-col>
                <el-col :span="14">
                    <p>{{ goodsItem.goodsName }}</p>
                    <span class="price">￥{{ parseFloat(goodsItem.goodsPrice).toFixed(2) }}</span>
                    <div class="operation">
                        <el-icon class="location" :size="20" v-if="!count" @click="addGoodsInCart">
                            <CirclePlus />
                        </el-icon>
                        <div class="box" v-else>
                            <ul id="car">
                                <!-- <li>商品数量：</li> -->
                                <li><button @click="subtract()">-</button></li>
                                <li><input type="text" :size="1" v-model="count"  @blur="change()" ></li>
                                <li><button @click="add()">+</button></li>

                            </ul>
                        </div>
                    </div>
                </el-col>
            </el-row>
        </el-card>
    </div>
</template>

<script>
import goodsHttp from "@/request/goods.js"
import { CirclePlus } from "@element-plus/icons"
import { mapGetters } from 'vuex'
export default {
    props: {
        goodsItem: {
            type: Object,
            required: true,
        },
    },
    setup(props) {
        console.log(props.goodsItem)
    },
    mounted() {
        
        // this.getAllGoodsInfo();
    },
    data() {
        return {
            count: 0,
            isInCart: false,
        }
    },

    components: {
        CirclePlus
    },
    methods: {
      addGoodsInCart(){
        this.add();
        // this.isInCart=true;
    },
    addShoppingCart(){
      
    },
        async getAllGoodsInfo() {
            await this.$store.dispatch("getAllGoodsInfo");
        },
        add() {
            this.count++;  
            this.goodsItem.count =this.count;
            this.$store.commit("addSelectedGoods",this.goodsItem)
            console.log(this.selectedGoods,'goods')
            console.log(this.selectedGoodsLength)
        },
        subtract() {
            this.count--;
            let isDelete = this.count?false:true;
            let goodsNum =this.goodsItem.goodsNum
            this.$store.commit("deleteSelectedGood",{goodsNum,isDelete})
        },
        change(){
            this.goodsItem.count =Number(this.count);
            this.$store.commit("addSelectedGoods",this.goodsItem)
        },
        addGoodsInCart() {
            this.add();
            this.isInCart = true;
        }
    },
    computed:{
    selectedGoodsLength(){
        if(this.selectedGoods.length == 0) this.count =0;
        console.log(this.count,this.selectedGoods.length);
        return this.selectedGoods.length;
    },
    ...mapGetters([
      "selectedGoods","allGoodsInfo"
    ]),
    watch:{
        selectedGoodsLength(newValue,oldvalue){
                console.log(newValue,'new')
                // if(newValue.length ==0) this.isInCart= false;
            },
            // deep:true
        
    }
  }
}
</script>

<style scoped>

.card:hover{
background-color: aqua;
}
.price {
    color: red;
}

.goodsImg {
    width: 80%;
    height: 90%;
}

.box {
    margin-top: 10%;
}

.box ul li {
    list-style: none;
}

.box li {
    float: left;
}

.box input {
    text-align: center;
}

.location {

    margin-top: 10%;
    margin-left: 80%;
}


</style>