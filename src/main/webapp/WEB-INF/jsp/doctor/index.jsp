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
                        <h5 class="widget-title"><i class="ace-icon fa fa-signal"></i>关注我的病人</h5>
                    </div>
                    <div class="widget-body">
                        <div class="widget-main">
                            <div id="total" style="width:100%;height: 400px;"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-5">
                <div class="widget-box">
                    <div class="widget-header widget-header-flat widget-header-small">
                        <h5 class="widget-title"><i class="ace-icon fa fa-signal"></i>异常报警</h5>
                    </div>
                    <div class="widget-body">
                        <div class="widget-main">
                            <table class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>姓名</th>
                                        <th>老人住址</th>
                                        <th>老人电话</th>
                                        <th>报警类型</th>
                                        <th>异常值</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${alarms}" var="alarm">
                                    <tr>
                                        <c:forEach items="${elderUsers}" var="elder">
                                            <c:if test="${alarm.accountId == elder.accountId}">
                                                <td>${elder.realname}</td>
                                                <td>${elder.address}</td>
                                                <td>${elder.phone}</td>
                                                <td>${keyNameMap.get(alarm.keyName)}</td>
                                                <td class="text-danger">${alarm.healthValue}</td>
                                            </c:if>
                                        </c:forEach>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
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
        var total = echarts.init(document.getElementById("total"));
        total.setOption({
            tooltip: {
                trigger: 'axis',
                position: function (pt) {
                    return [pt[0], '10%'];
                }
            },
            xAxis: {
                type: 'category',
                data: [
                    <c:forEach items="${groupData.keySet()}" var="row">
                        '${row}',
                    </c:forEach>
                ]
            },
            yAxis: {
                type: 'value',
            },
            series: [
                {
                    name:'被关注人数',
                    type:'bar',
                    data: [
                        <c:forEach items="${groupData.keySet()}" var="row">
                            ${groupData.get(row)},
                        </c:forEach>
                    ]
                }
            ]
        });

    })
</script>
<%@ include file="../common/footer.jsp" %>