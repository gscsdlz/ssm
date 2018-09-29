<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>
        主页
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="row">
            <div class="col-sm-5 col-sm-offset-1">
                <div class="widget-box">
                    <div class="widget-header widget-header-flat widget-header-small">
                        <h5 class="widget-title"><i class="ace-icon fa fa-signal"></i>血压指标</h5>
                    </div>
                    <div class="widget-body">
                        <div class="widget-main">
                            <div id="blood_pressure" style="width:100%;height: 400px;"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-5">
                <div class="widget-box">
                    <div class="widget-header widget-header-flat widget-header-small">
                        <h5 class="widget-title"><i class="ace-icon fa fa-signal"></i>血糖指标</h5>
                    </div>
                    <div class="widget-body">
                        <div class="widget-main">
                            <div id="blood_sugar" style="width:100%;height: 400px;"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/assets/js/echarts.min.js"></script>
<script>
    $(document).ready(function () {
        var bpChart = echarts.init(document.getElementById("blood_pressure"));
        bpChart.setOption({
            tooltip: {
                trigger: 'axis',
                axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                    type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            legend: {
                data: ['舒张压', '收缩压', '脉搏']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: [
                {
                    type: 'category',
                    data: [
                        <c:forEach items="${bpData}" var="row" >
                        '${row.date}',
                        </c:forEach>
                    ]
                }
            ],
            yAxis: [
                {
                    type: 'value'
                }
            ],
            series: [
                {
                    name: '舒张压',
                    type: 'bar',
                    data: [
                        <c:forEach items="${bpData}" var="row" >
                        ${row.systolic},
                        </c:forEach>
                    ]
                },
                {
                    name: '收缩压',
                    type: 'bar',
                    data: [
                        <c:forEach items="${bpData}" var="row" >
                        ${row.diastolic},
                        </c:forEach>
                    ]
                },
                {
                    name: '脉搏',
                    type: 'bar',
                    data: [
                        <c:forEach items="${bpData}" var="row" >
                        ${row.pulse},
                        </c:forEach>
                    ]
                }
            ]
        });

        var bsChart = echarts.init(document.getElementById("blood_sugar"));
        bsChart.setOption({
            xAxis: {
                type: 'category',
                data: [
                    <c:forEach items="${bsData}" var="row" >
                    '${row.date}',
                    </c:forEach>
                ]
            },
            yAxis: {
                type: 'value'
            },
            series: [{
                data: [
                    <c:forEach items="${bsData}" var="row" >
                    ${row.value},
                    </c:forEach>
                ],
                type: 'line',
                smooth: true
            }]
        });
    })
</script>
<%@ include file="../common/footer.jsp" %>