<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>
        异常指标
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="row">
            <div class="space-6"></div>
            <div class="col-sm-8 col-sm-offset-2">
                <div class="row">
                    <div class="col-sm-12 text-left">
                        <form class="form-horizontal" style="margin: 0px 10px">
                            <div class="form-group">
                                <label class="control-label col-xs-2" style="padding-top: 0px">显示已处理数据</label>
                                <div class="col-xs-8">
                                    <c:if test="${handle == 0}">
                                        <input name="handle" class="ace ace-switch ace-switch-4 btn-empty" type="checkbox" id="handleSwitch">
                                    </c:if>
                                    <c:if test="${handle == 1}">
                                        <input name="handle" class="ace ace-switch ace-switch-4 btn-empty" type="checkbox" id="handleSwitch" checked>
                                    </c:if>
                                    <span class="lbl"></span>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <hr/>
                <div class="row">
                    <div class="col-sm-12">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>异常编号</th>
                                <th>选项</th>
                                <th>设置的最大值</th>
                                <th>设置的最小值</th>
                                <th>当前值</th>
                                <th>时间</th>
                                <th>状态</th>
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
