import { createStore } from 'vuex'
import goods from "@/request/goods.js"
import sale from '../request/sale'
import { ElMessage } from 'element-plus'
export default createStore({

  state: {
    _totalPrice: 0,//当前订单商品总价
    _allGoodsInfo: [],
    _selectedGoods: [],
    addSalesData: []
  },
  getters: {
    selectedGoods: state => {
      return state._selectedGoods
    },
    totalPrice:state=>{
      state._totalPrice=0;
        state._selectedGoods.forEach(item=>{
            state._totalPrice+=item.sumPrice;
        })
        return state._totalPrice
    },
    allGoodsInfo: state => {
      return state._allGoodsInfo
    }

  },
  mutations: {
    setGoodsInfo:(state,list)=>{
      state._allGoodsInfo =list
    },
    setAddSalesData: (state) => {
      state.addSalesData = state._selectedGoods.map(item => {
        return {
          goo_goodsNum: item.goodsNum,
          saleNum: item.count
        }
      })
    },
    clearAddSalesData: (state) => {
      state.addSalesData = [];
    },
    clearSelectedGoods: (state) => {
      state._selectedGoods = [];
      state._totalPrice = 0;
    },

    addSelectedGoods: (state, goodsItem) => {
      var index = state._selectedGoods.findIndex(item => item.goodsNum == goodsItem.goodsNum)
      if (index == -1) {
        goodsItem.sumPrice = goodsItem.goodsPrice;
        state._selectedGoods.push({ ...goodsItem })
      }
      else {
        state._selectedGoods[index].count = goodsItem.count;
        let sumPrice = goodsItem.count * goodsItem.goodsPrice;
        state._selectedGoods[index] = { ...goodsItem, sumPrice }
      }
    },

    //删除商品或数量减少
    deleteSelectedGood(state, { goodsNum, isDelete = false }) {
      //找到待删除商品的index
      var index = state._selectedGoods.findIndex(item => item.goodsNum == goodsNum)
      if (index != -1 && isDelete) {
        state._selectedGoods.splice(index, 1);

      } else if (index != -1 && !isDelete) {
        state._selectedGoods[index].count--;
        state._selectedGoods[index].sumPrice = state._selectedGoods[index].goodsPrice * state._selectedGoods[index].count;
      }
    },

  },
  actions: {
    async getAllGoodsInfo({ commit }) {
      const res = await goods.getAllGoodsInfo();
      if (!res.status) {
        commit("setGoodsInfo", res.data)
      } else {
        ElMessage.warning("请求数据失败！");
      }
    },
    async addSales({ commit, state }, date) {//批量
      commit('setAddSalesData')
      const res = await sale.addSales({ saleVOList:state.addSalesData,saleTime:date});
      if (!res.status) {
        ElMessage.success('结算成功！')
        commit("clearSelectedGoods");
        commit("clearAddSalesData");
      } else {
        ElMessage.warning("结算失败!")
      }
    }

  },
  modules: {
  }
})

