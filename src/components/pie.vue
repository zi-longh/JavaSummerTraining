<template>
   <div id="pie"></div>
</template>

<script>
import * as echarts from 'echarts';
export default {
  mounted(){
    var chartDom = document.getElementById('pie');
var myChart = echarts.init(chartDom);
var option;

option = {
    title: {
    text: '各类商品销量',
    left: 'center',
    bottom:"30"
  },
  legend: {

  },
  tooltip: {},

  dataset: {
    source: [
      ['product', '2012'],
      ['日用品', 41.5],
      ['零食', 20.1],
      ['服装', 24.1],
      ['玩具', 5.0],
      ['鞋包', 15.1],
      ['其他', 5.2]
    ]
  },
  series: [
    {
      type: 'pie',
      radius: '50%',
      center: ['45%', '50%']
      // No encode specified, by default, it is '2012'.
    },
  ]
};

option && myChart.setOption(option);
  }



}
</script>

<style>
  #pie{
    width:500px;
    height:500px;
  }
</style>