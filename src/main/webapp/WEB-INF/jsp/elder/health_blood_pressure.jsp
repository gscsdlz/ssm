<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>
        血压指标
        <small>2018-10-1 ~ 2018-10-7</small>
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
                            <input class="form-control date-picker" data-date-format="yyyy-mm-dd" type="text" placeholder="开始时间">
                            <input class="form-control date-picker" data-date-format="yyyy-mm-dd" type="text" placeholder="结束时间">
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
                                <th>收缩压（mmHg）</th>
                                <th>舒张压（mmHg）</th>
                                <th>脉搏（次/分）</th>
                            </tr>
                            </thead>
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

                })

                $('.date-picker').datepicker({
                    autoclose: true,
                    todayHighlight: true
                })
                var chart = echarts.init(document.getElementById("main"));
                var option = {
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
                            data: ['2018-9-21', '2018-9-22', '2018-9-23', '2018-9-24', '2018-9-25', '2018-9-26', '2018-9-27']
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
                            data: [320, 332, 301, 334, 390, 330, 320]
                        },
                        {
                            name: '收缩压',
                            type: 'bar',
                            data: [120, 132, 101, 134, 90, 230, 210]
                        },
                        {
                            name: '脉搏',
                            type: 'bar',
                            data: [220, 182, 191, 234, 290, 330, 310]
                        }
                    ]
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
