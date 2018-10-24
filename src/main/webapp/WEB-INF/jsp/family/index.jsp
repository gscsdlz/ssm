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
                        <h5 class="widget-title"><i class="ace-icon fa fa-signal"></i>异常信息分类统计</h5>
                    </div>
                    <div class="widget-body">
                        <div class="widget-main">
                            <div id="alarmBar" style="width:100%;height: 400px;"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-5">
                <div class="widget-box">
                    <div class="widget-header widget-header-flat widget-header-small">
                        <h5 class="widget-title"><i class="ace-icon fa fa-signal"></i>异常信息指标</h5>
                    </div>
                    <div class="widget-body">
                        <div class="widget-main">
                            <div id="alarmLine" style="width:100%;height: 400px;"></div>
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
        var bar = echarts.init(document.getElementById("alarmBar"));
        var line = echarts.init(document.getElementById("alarmLine"));
        bar.setOption({
            tooltip: {
                trigger: 'axis',
                axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                    type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            legend: {
                data: []
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
                    data: ["收缩压（mmHg）", "舒张压（mmHg）", "脉搏", "血糖", "身高（cm）", "体重（kg）", "BMI指数"]
                }
            ],
            yAxis: [
                {
                    type: 'value'
                }
            ],
            series: []
        });
        line.setOption( {
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data:[]
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: []
            },
            yAxis: {
                type: 'value'
            },
            series: []
        });

        let barX = [];
        let barY = [];
        let lineX = [];
        let lineY = [];

        $.get("/family_user/get_data", function (alarmData) {
            $.get("/family_user/get_user_data", function (userData) {

                for (let i = 0; i < alarmData.data.length; i++) {
                    let key = alarmData.data[i].createdAt.substr(0, 10);
                    let find = false;
                    for (let j = 0; j < lineX.length; j++) {
                        if (lineX[j] === key) {
                            find = true;
                            break;
                        }
                    }
                    if (!find)
                        lineX.push(key)
                }

                for (let i = 0; i < userData.data.length; i++) {
                    barX.push(userData.data[i].realname);
                }
                for (let i = 0; i < barX.length; i++) {
                    barY.push({
                        name: barX[i],
                        type: 'bar',
                        stack: 'health',
                        data: [0, 0, 0, 0, 0, 0, 0]
                    });
                    let tmp = {
                        name: barX[i],
                        type: 'line',
                        data: []
                    };
                    for (let j = 0; j < lineX.length; j++) {
                        tmp.data.push(0)
                    }
                    lineY.push(tmp);
                }
                let dataMap = {
                    systolic: 0,
                    diastolic: 1,
                    pulse: 2,
                    value: 3,
                    height: 4,
                    weight: 5,
                    bmi: 6,
                };
                for (let i = 0; i < alarmData.data.length; i++) {
                    for (let j = 0; j < userData.data.length; j++) {
                        if (userData.data[j].accountId === alarmData.data[i].accountId) {
                            for(let k = 0; k < barX.length; k++) {
                                if (barX[k] === userData.data[j].realname) {
                                    barY[k].data[dataMap[alarmData.data[i].keyName]]++;

                                    let key = alarmData.data[i].createdAt.substr(0, 10);
                                    for (let x = 0; x < lineX.length; x++) {
                                        if (lineX[x] === key) {
                                            lineY[k].data[x]++;
                                            break;
                                        }
                                    }

                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
                bar.setOption({
                    series: barY,
                    legend: {
                        data: barX
                    }
                });
                line.setOption({
                    legend: {
                        data: barX
                    },
                    series: lineY,
                    xAxis: {
                        data: lineX
                    }
                })
            });
        });


    })
</script>
<%@ include file="../common/footer.jsp" %>