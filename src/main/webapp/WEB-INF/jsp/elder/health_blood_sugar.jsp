<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>
        血糖指标
        <small>${l} ~ ${r}</small>
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="row">
            <div class="space-6"></div>
            <div class="col-sm-8 col-sm-offset-2">
                <div class="row">
                    <div class="col-sm-12 text-center">
                        <form class="form-inline" style="margin: 0px 10px">
                            <button class="btn btn-success btn-sm" type="button" id="last7">最近7天</button>
                            <button class="btn btn-success btn-sm" type="button" id="last30">最近30天</button>
                            <input class="form-control date-picker" id="startDate" data-date-format="yyyy-mm-dd" type="text" placeholder="开始时间">
                            <input class="form-control date-picker" id="endDate" data-date-format="yyyy-mm-dd" type="text" placeholder="结束时间">
                            <button class="btn btn-success btn-sm" type="button" id="find">查询</button>
                        </form>
                    </div>
                </div>
                <hr/>
                <div id="main" style="width:100%;height: 400px;"></div>
                <div class="row">
                    <div class="col-sm-12">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>时间</th>
                                <th>血糖值</th>
                                <th>与上次用餐的时间差</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${data}" var="row">
                                <tr>
                                    <td>${row.date}</td>
                                    <td>${row.value}</td>
                                    <td>${row.duration}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <script src="/assets/js/echarts.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#last7").click(function() {
                    var arr = lastDay(7);
                    window.location.href = "?l=" + arr[0] + "&r=" + arr[1];
                })

                $("#last30").click(function() {
                    var arr = lastDay(30);
                    window.location.href = "?l=" + arr[0] + "&r=" + arr[1];
                })

                $("#find").click(function () {
                    var t1 = $("#startDate").val();
                    var t2 = $("#endDate").val();

                    if (t1.length === 0) {
                        alert("开始时间不能为空");
                    } else if (t2.length === 0) {
                        alert("结束时间不能为空");
                    } else if (t1 > t2) {
                        alert("开始时间不能大于结束时间");
                    } else {
                        window.location.href = "?l=" + t1 + "&r=" + t2;
                    }
                })

                $('.date-picker').datepicker({
                    autoclose: true,
                    todayHighlight: true
                })
                var chart = echarts.init(document.getElementById("main"));
                var option = {
                    xAxis: {
                        type: 'category',
                        data: [
                            <c:forEach items="${data}" var="row" >
                            '${row.date}',
                            </c:forEach>
                        ]
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: [
                            <c:forEach items="${data}" var="row" >
                                ${row.value},
                            </c:forEach>
                        ],
                        type: 'line',
                        smooth: true
                    }]
                };
                chart.setOption(option)
            })

            function lastDay(day) {
                var d1 = new Date();
                var t1 = d1.getTime();
                var t2 = t1 - day * 24 * 60 * 60 * 1000;
                var d2 = new Date();
                d2.setTime(t2);
                return [
                    d2.getFullYear() + "-" + (d2.getMonth() + 1) + "-" + d2.getDate(),
                    d1.getFullYear() + "-" + (d1.getMonth() + 1) + "-" + d1.getDate(),
                ];
            }
        </script>
    </div>
</div>
<%@ include file="../common/footer.jsp" %>
