<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>
        个人档案
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="space-6"></div>
        <div class="page-header">
            <h3>测量数据</h3>
        </div>
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="widget-box">
                            <div class="widget-header">
                                <h4 class="small">血压指标
                                    <small>最近一组测量数据</small>
                                </h4>
                            </div>
                            <div class="widget-body">
                                <div class="profile-user-info profile-user-info-striped">
                                    <div class="profile-info-row">
                                        <div class="profile-info-name">收缩压</div>
                                        <div class="profile-info-value">
                                            <span class="editable editable-click">${bpData.systolic}mmHg</span>
                                        </div>
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name">舒张压</div>
                                        <div class="profile-info-value">
                                            <span class="editable editable-click">${bpData.diastolic}mmHg</span>
                                        </div>
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name">脉搏</div>
                                        <div class="profile-info-value">
                                            <span class="editable editable-click">${bpData.pulse}</span>
                                        </div>
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name">测量时间</div>
                                        <div class="profile-info-value">
                                            <span class="editable editable-click">${bpData.date}</span>
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
                                    <small>最近一组测量数据</small>
                                </h4>
                            </div>
                            <div class="widget-body">
                                <div class="profile-user-info profile-user-info-striped">
                                    <div class="profile-info-row">
                                        <div class="profile-info-name">血糖值</div>
                                        <div class="profile-info-value">
                                            <span class="editable editable-click">${bsData.value}</span>
                                        </div>
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name">与上次用餐时间差</div>
                                        <div class="profile-info-value">
                                            <span class="editable editable-click">${bsData.duration}</span>
                                        </div>
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name">测量时间</div>
                                        <div class="profile-info-value">
                                            <span class="editable editable-click">${bsData.date}</span>
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
                                    <small>最近一组测量数据</small>
                                </h4>
                            </div>
                            <div class="widget-body">
                                <div class="profile-user-info profile-user-info-striped">
                                    <div class="profile-info-row">
                                        <div class="profile-info-name">身高</div>
                                        <div class="profile-info-value">
                                            <span class="editable editable-click">${hwData.height}cm</span>
                                        </div>
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name">体重</div>
                                        <div class="profile-info-value">
                                            <span class="editable editable-click">${hwData.weight}kg</span>
                                        </div>
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name">BMI</div>
                                        <div class="profile-info-value">
                                            <span class="editable editable-click">${hwData.bmi}</span>
                                        </div>
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name">测量时间</div>
                                        <div class="profile-info-value">
                                            <span class="editable editable-click">${hwData.date}</span>
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
            <h3>统计数据</h3>
            <div class="row">
                <div class="col-md-6 col-md-offset-3">

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
                            <span class="line-height-1 smaller-90"> 检验记录数 </span>
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
        </div>
        <hr/>
        <div class="page-header"><h3></h3></div>
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <table class="table table-bordered table-hover" id="table">
                    <thead>
                        <tr>
                            <th>编号</th>
                            <th>评估医生</th>
                            <th>健康状态</th>
                            <th>建议</th>
                            <th>评估时间</th>
                        </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $.get("/user_count/elder", function (response) {
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
        });

        $("#table").dynamicTableView({
            pagination: false,
            autoLoadURL: '/evaluate_api/get_my',
            currPage: 1,
            totalPage: 1,
            pageSize: 15,
            initURL: '/evaluate_api/get_my',
            keysMap: ['evaluateId', 'doctorName', 'evaluateS', 'suggest', 'createdAt'],
        })
    })
</script>
<%@ include file="../common/footer.jsp" %>