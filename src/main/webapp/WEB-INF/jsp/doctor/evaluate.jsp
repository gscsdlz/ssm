<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>
        医生评估
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="row">
            <div class="col-md-5">
                <div class="page-header"><h3>关注我的老人</h3></div>
                <table class="table table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>老人编号</th>
                        <th>老人姓名</th>
                        <th>住址</th>
                        <th>联系方式</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${elders}" var="d">
                        <tr>
                            <td>${d.accountId}</td>
                            <td>${d.realname}</td>
                            <td>${d.address}</td>
                            <td>${d.phone}</td>
                            <td>
                                <button class="btn btn-danger btn-sm" type="button" showEvaluate="${d.accountId}">评估</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-md-7">
                <div class="page-header">
                    <h3>评估<small>从左侧列表中选择老人</small></h3>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="page-header">
                                <p>测量数据</p>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <div class="widget-box">
                                                <div class="widget-header">
                                                    <h4 class="small">血压指标
                                                    </h4>
                                                </div>
                                                <div class="widget-body">
                                                    <div class="profile-user-info profile-user-info-striped">
                                                        <div class="profile-info-row">
                                                            <div class="profile-info-name">收缩压</div>
                                                            <div class="profile-info-value">
                                                                <span class="editable editable-click" id="systolic">mmHg</span>
                                                            </div>
                                                        </div>
                                                        <div class="profile-info-row">
                                                            <div class="profile-info-name">舒张压</div>
                                                            <div class="profile-info-value">
                                                                <span class="editable editable-click" id="diastolic">mmHg</span>
                                                            </div>
                                                        </div>
                                                        <div class="profile-info-row">
                                                            <div class="profile-info-name">脉搏</div>
                                                            <div class="profile-info-value">
                                                                <span class="editable editable-click" id="pulse"></span>
                                                            </div>
                                                        </div>
                                                        <div class="profile-info-row">
                                                            <div class="profile-info-name">测量时间</div>
                                                            <div class="profile-info-value">
                                                                <span class="editable editable-click" id="date1"></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-4">
                                            <div class="widget-box">
                                                <div class="widget-header">
                                                    <h4 class="small">血糖
                                                    </h4>
                                                </div>
                                                <div class="widget-body">
                                                    <div class="profile-user-info profile-user-info-striped">
                                                        <div class="profile-info-row">
                                                            <div class="profile-info-name">血糖值</div>
                                                            <div class="profile-info-value">
                                                                <span class="editable editable-click" id="value"></span>
                                                            </div>
                                                        </div>
                                                        <div class="profile-info-row">
                                                            <div class="profile-info-name">与上次用餐时间差</div>
                                                            <div class="profile-info-value">
                                                                <span class="editable editable-click" id="duration"></span>
                                                            </div>
                                                        </div>
                                                        <div class="profile-info-row">
                                                            <div class="profile-info-name">测量时间</div>
                                                            <div class="profile-info-value">
                                                                <span class="editable editable-click" id="date2"></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-4">
                                            <div class="widget-box">
                                                <div class="widget-header">
                                                    <h4 class="small">身高体重指标
                                                    </h4>
                                                </div>
                                                <div class="widget-body">
                                                    <div class="profile-user-info profile-user-info-striped">
                                                        <div class="profile-info-row">
                                                            <div class="profile-info-name">身高</div>
                                                            <div class="profile-info-value">
                                                                <span class="editable editable-click" id="height">cm</span>
                                                            </div>
                                                        </div>
                                                        <div class="profile-info-row">
                                                            <div class="profile-info-name">体重</div>
                                                            <div class="profile-info-value">
                                                                <span class="editable editable-click" id="weight">kg</span>
                                                            </div>
                                                        </div>
                                                        <div class="profile-info-row">
                                                            <div class="profile-info-name">BMI</div>
                                                            <div class="profile-info-value">
                                                                <span class="editable editable-click" id="bmi"></span>
                                                            </div>
                                                        </div>
                                                        <div class="profile-info-row">
                                                            <div class="profile-info-name">测量时间</div>
                                                            <div class="profile-info-value">
                                                                <span class="editable editable-click" id="date3"></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <hr/>
                    <div class="page-header">
                        <p>统计数据</p>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="center">
                        <span class="btn btn-app btn-sm btn-light no-hover">
                            <span class="line-height-1 bigger-170 blue" id="healthDataCount"> 0 </span>
                            <br>
                            <span class="line-height-1 smaller-90"> 总测量次数 </span>
                        </span>
                                <span class="btn btn-app btn-sm btn-yellow no-hover">
                                <span class="line-height-1 bigger-170" id="join"> 0 </span>
                                <br>
                                <span class="line-height-1 smaller-90"> 累积加入 </span>
                        </span>
                                <span class="btn btn-app btn-sm btn-pink no-hover">
                            <span class="line-height-1 bigger-170" id="sicks"> 0 </span>
                            <br>
                            <span class="line-height-1 smaller-90"> 病历记录数 </span>
                        </span>
                                <span class="btn btn-app btn-sm btn-grey no-hover">
                            <span class="line-height-1 bigger-170" id="checks"> 0 </span>
                            <br>
                            <span class="line-height-1 smaller-90" > 检验记录数 </span>
                        </span>
                                <span class="btn btn-app btn-sm btn-success no-hover">
                            <span class="line-height-1 bigger-170" id="drugs"> 0 </span>
                            <br>
                            <span class="line-height-1 smaller-90"> 用药记录数 </span>
                        </span>
                                <span class="btn btn-app btn-sm btn-primary no-hover">
                            <span class="line-height-1 bigger-170" id="doctor"> 0 </span>
                            <br>
                            <span class="line-height-1 smaller-90"> 家庭医生数 </span>
                        </span>
                            </div>
                        </div>
                    </div>
                    <hr/>
                    <div class="page-header">
                        <p>医生评估</p>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table table-hover table-bordered" id="tables">
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        let data;
        $("#tables").dynamicTables({
            'title': ['编号', '健康状态', '意见', '评估时间'],
            'data' : [],
            'delsURL' : '/evaluate_api/del',
            'saveURL' : '/evaluate_api/update',
            'addURL' : '/evaluate_api/add',
            'typeConfig' : [
                {'edit': false},
                {
                    'type': 'select',
                    'options': [
                        [1, '健康'],
                        [2, '亚健康'],
                        [3, '差'],
                        [4, '危险'],
                    ]
                },
                {'type': 'text'},
                {'edit': false}
            ],
            'dataKeys': [
                "evaluateId", "evaluate", "suggest", "createdAt"
            ],
            'userHandle': {
                'loadData': function() {
                    return data;
                }
            }
        });

        $("[showEvaluate]").click(function() {
            let id = $(this).attr("showEvaluate");
            $.get("/evaluate_api/get_all", {elder_id: id}, function(response) {
                if (response.status) {
                    data = response.data;
                    window.dispatchEvent(new Event('loadData'));
                }
            });
            getRecord(id, id)
        });
        function getRecord(id, fromId) {
            $.get("/record_auth/get_record", {id:id}, function(response) {
                if (response.status) {
                    $("#systolic").html(response.bloodPressure.systolic + "mmHg");
                    $("#diastolic").html(response.bloodPressure.diastolic + "mmHg");
                    $("#pulse").html(response.bloodPressure.pulse);
                    $("#date1").html(response.bloodPressure.date);

                    $("#value").html(response.bloodSugar.value);
                    $("#duration").html(response.bloodSugar.duration);
                    $("#date2").html(response.bloodSugar.date);

                    $("#height").html(response.heightWeight.height);
                    $("#weight").html(response.heightWeight.weight);
                    $("#bmi").html(response.heightWeight.bmi);
                    $("#date3").html(response.heightWeight.date);

                } else {
                    alert(response.info)
                }
            });
            $.get("/user_count/elder", {id:fromId}, function (response) {
                if (response.status) {
                    $("#healthDataCount").html(response.healthDataCount);
                    $("#join").html(response.join);
                    $("#sicks").html(response.sicks);
                    $("#checks").html(response.checks);
                    $("#drugs").html(response.drugs);
                    $("#doctor").html(response.doctor);
                } else {
                    alert(response.info);
                }
            })
        }
    });
</script>
<%@ include file="../common/footer.jsp" %>