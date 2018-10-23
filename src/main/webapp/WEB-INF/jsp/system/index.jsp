<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>
        用户数据
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="row">
            <div class="col-md-6">
                <div style="height:400px" id="charts">

                </div>
            </div>
            <div class="col-md-6">
                <div style="height:400px" id="gender">

                </div>
            </div>
        </div>

    </div>
</div>
<script src="/assets/js/echarts.min.js"></script>
<script>
    $(document).ready(function () {
        let charts = echarts.init(document.getElementById("charts"));
        charts.setOption({
            tooltip: {
                trigger: 'axis',
                position: function (pt) {
                    return [pt[0], '10%'];
                }
            },
            title: {
                left: 'center',
                text: '老人年龄分布',
            },
            toolbox: {
                feature: {
                    dataZoom: {
                        yAxisIndex: 'none'
                    },
                    restore: {},
                    saveAsImage: {}
                }
            },
            xAxis: {
                type: 'category',
                data: [
                    <c:forEach items="${data.keySet()}" var="key">
                    '${key}',
                    </c:forEach>
                ]
            },
            yAxis: {
                type: 'value',
            },
            series: [
                {
                    name:'数量',
                    type:'bar',
                    data: [
                        <c:forEach items="${data.keySet()}" var="key">
                        ${data.get(key)},
                        </c:forEach>
                    ]
                }
            ]
        });

        let c2 = echarts.init(document.getElementById("gender"));
        c2.setOption({
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                data:['男','女']
            },
            series: [
                {
                    name:'统计',
                    type:'pie',
                    radius: ['50%', '70%'],
                    avoidLabelOverlap: false,
                    label: {
                        normal: {
                            show: false,
                            position: 'center'
                        },
                        emphasis: {
                            show: true,
                            textStyle: {
                                fontSize: '30',
                                fontWeight: 'bold'
                            }
                        }
                    },
                    labelLine: {
                        normal: {
                            show: false
                        }
                    },
                    data:[
                        {value:${gender.get(1)}, name:'男'},
                        {value:${gender.get(0)}, name:'女'},

                    ]
                }
            ]
        })

    })
</script>
<%@ include file="../common/footer.jsp" %>