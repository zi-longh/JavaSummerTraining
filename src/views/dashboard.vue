<template>
    <div>
        <div id="main"></div>
        <e-row :span="24">
            <el-col :span="14">
                <LineChart />
            </el-col>
            <el-col :span="10">
                <Pie />
            </el-col>
        </e-row>
    </div>
</template>

<script>
import * as echarts from 'echarts';
import LineChart from '@/components/lineChart.vue'
import Pie from "@/components/pie.vue"
export default {

    mounted() {
        var chartDom = document.getElementById('main');
        var myChart = echarts.init(chartDom);
        var option;
        option = {
            graphic: {
                elements: [
                    {
                        type: 'text',
                        left: 'center',
                        top: 'center',
                        style: {
                            text: '超市后台管理系统',
                            fontSize: 80,
                            fontWeight: 'bold',
                            lineDash: [0, 200],
                            lineDashOffset: 0,
                            fill: 'transparent',
                            stroke: '#000',
                            lineWidth: 1
                        },
                        keyframeAnimation: {
                            duration: 3000,
                            loop: true,
                            keyframes: [
                                {
                                    percent: 0.7,
                                    style: {
                                        fill: 'transparent',
                                        lineDashOffset: 200,
                                        lineDash: [200, 0]
                                    }
                                },
                                {
                                    // Stop for a while.
                                    percent: 0.8,
                                    style: {
                                        fill: 'transparent'
                                    }
                                },
                                {
                                    percent: 1,
                                    style: {
                                        fill: 'black'
                                    }
                                }
                            ]
                        }
                    }
                ]
            }
        };
        option && myChart.setOption(option);
    },
    components: {
        LineChart,
        Pie
    }

}
</script>

<style scoped >
#main {
    width: 700px;
    height: 100px;
    /* position: relative;
    left:8%;
    top:10%; */
}
</style>