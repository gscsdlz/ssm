<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp"%>
<div class="row">
    <div class="space-6"></div>
    <div class="col-sm-8 col-sm-offset-2">
        <div id="main" style="width:100%;height: 600px;"></div>
    </div>
</div>
<script src="/assets/js/echarts.min.js"></script>
<script>
    $(document).ready(function() {
        var chart = echarts.init(document.getElementById("main"));
        var option = {
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            legend: {
                data:['舒张压','收缩压','脉搏']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis : [
                {
                    type : 'category',
                    data : ['周一','周二','周三','周四','周五','周六','周日']
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'舒张压',
                    type:'bar',
                    data:[320, 332, 301, 334, 390, 330, 320]
                },
                {
                    name:'收缩压',
                    type:'bar',
                    data:[120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name:'脉搏',
                    type:'bar',
                    data:[220, 182, 191, 234, 290, 330, 310]
                }
            ]
        };
        chart.setOption(option)
    })
</script>
<%@ include file="../common/footer.jsp"%>
