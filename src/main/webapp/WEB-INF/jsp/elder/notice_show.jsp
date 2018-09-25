<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>
        提醒设置
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="row">
            <div class="space-6"></div>
            <div class="col-sm-8 col-sm-offset-2">
                <div class="row">
                    <div class="col-sm-12 text-left">
                        <form class="form-inline" style="margin: 0px 10px">
                            <select class="form-control">
                                <option value="0">选择显示的提醒类型</option>
                                <option value="-1">全部显示</option>
                            </select>
                            <select class="form-control">
                                <option value="0">选择时间状态</option>
                                <option value="-1">全部显示</option>
                                <option value="0">正在进行中</option>
                                <option value="1">已过期</option>
                                <option value="-1">未开始</option>
                            </select>
                            <button class="btn btn-default btn-sm" type="button">筛选</button>
                        </form>
                    </div>
                </div>
                <hr/>
                <div class="row">
                    <div class="col-sm-12">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>提醒编号</th>
                                <th>提醒内容</th>
                                <th>提醒时间</th>
                                <th>提醒频率</th>
                                <th>开始时间</th>
                                <th>结束时间</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${data}" var="row">
                                <tr>
                                    <td>${row.alarmId}</td>
                                    <td>${keyNameMap.get(row.keyName)}</td>
                                    <td>${row.maxVal}</td>
                                    <td>${row.minVal}</td>
                                    <td>${row.healthValue}</td>
                                    <td>${row.createdAt}</td>
                                    <td>
                                        <c:if test="${row.handle == 0}">
                                            <span class="text-danger">未处理</span>
                                        </c:if>
                                        <c:if test="${row.handle == 1}">
                                            已处理
                                        </c:if>
                                    </td>
                                    <td><c:if test="${row.handle == 0}">
                                        <button class="btn btn-white btn-default btn-bold do-handle">
                                            <i class="ace-icon fa fa-eye bigger-120 blue"></i>
                                            设为已读
                                        </button>
                                    </c:if></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <script>
            $(document).ready(function () {
                $("#handleSwitch").click(function() {
                    if ($(this).prop("checked")) {
                        window.location.href = "?handle=1"
                    } else {
                        window.location.href = "?handle=0"
                    }
                });

                $(".do-handle").click(function() {
                    var alarmId = $(this).parent().parent().children().eq(0).html();
                    var that = $(this).parent().parent().children().eq(6);
                    $.post("/health_monitor/do_handle", {
                        alarmId:alarmId,
                        handle:1,
                    }, function(response) {
                        if (response.status) {
                            $(that).html("已处理")
                        } else {
                            alert(response.info)
                        }
                    })
                })
            })
        </script>
    </div>
</div>
<%@ include file="../common/footer.jsp" %>
