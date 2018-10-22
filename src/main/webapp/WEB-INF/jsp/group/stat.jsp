<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>
        总投诉量
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <div style="height:400px" id="charts">

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
                text: '总投诉量图',
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
                boundaryGap: false,
                data: [
                    <c:forEach items="${data.keySet()}" var="key">
                        '${key}',
                    </c:forEach>
                ]
            },
            yAxis: {
                type: 'value',
                boundaryGap: [0, '100%']
            },
            series: [
                {
                    name:'数量',
                    type:'line',
                    smooth:true,
                    symbol: 'none',
                    sampling: 'average',
                    itemStyle: {
                        color: 'rgb(255, 70, 131)'
                    },
                    areaStyle: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgb(255, 158, 68)'
                        }, {
                            offset: 1,
                            color: 'rgb(255, 70, 131)'
                        }])
                    },
                    data: [
                        <c:forEach items="${data.keySet()}" var="key">
                        ${data.get(key)},
                        </c:forEach>
                    ]
                }
            ]
        });
    })
</script>
<%@ include file="../common/footer.jsp" %>