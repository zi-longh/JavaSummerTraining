<template>
  <div id="line"></div>
</template>

<script>
import * as echarts from 'echarts';
export default {
    mounted(){
        var chartDom = document.getElementById('line');
var myChart = echarts.init(chartDom,null,{
    width:600,height:400
});
var option;

option = {
    title: {
    text: '销售数据折线图',
    left:"center",
    bottom: 'bottom'
  },
  xAxis: {
    type: 'category',
    data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
  },
  yAxis: {
    type: 'value'
  },
  series: [
    {
      data: [150, 230, 224, 218, 135, 147, 260],
      type: 'line'
    }
  ]
};

option && myChart.setOption(option);
    }
 
}
</script>

<style>
#line{
    width:600px;
    height:600px;
}
</style>