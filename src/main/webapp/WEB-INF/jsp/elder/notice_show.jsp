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
                            <select class="form-control" id="type">
                                <option value="-2">显示全部提醒类型</option>
                                <c:forEach items="${noticeTypes}" var="row">
                                    <option value="${row}" noticeTypes></option>
                                </c:forEach>
                            </select>
                            <select class="form-control" id="status">
                                <option value="-2">显示全部状态</option>
                                <option value="0">正在进行中</option>
                                <option value="1">已过期</option>
                                <option value="-1">未开始</option>
                            </select>
                            <button class="btn btn-default btn-sm" type="button" id="fetch">筛选</button>
                            <button class="btn btn-danger btn-sm" type="button" id="add" data-toggle="modal" data-target="#myModal">新增</button>
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
                                <th>提醒频率</th>
                                <th>开始时间</th>
                                <th>结束时间</th>
                                <th>状态</th>
                                <th>上次提醒时间</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${data}" var="row">
                                <tr>
                                    <td>${row.noticeId}</td>
                                    <td>${noticeTypes.get(row.noticeType)}</td>
                                    <td>
                                        <span></span>
                                        <input type="hidden" frequency value="${row.frequency}">
                                    </td>
                                    <td>${row.start}</td>
                                    <td>${row.end}</td>
                                    <td>
                                        <c:if test="${row.status == -1}">
                                            <span class="text-success">还未开始</span>
                                        </c:if>
                                        <c:if test="${row.status == 0}">
                                            <span>进行中</span>
                                        </c:if>
                                        <c:if test="${row.status == 1}">
                                            <span class="text-danger">已过期</span>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${row.status == 0}">
                                            ${row.last}
                                        </c:if>
                                    </td>
                                    <td>
                                        <button class="btn btn-white btn-default btn-bold do-handle btn-sm" edit data-toggle="modal" data-target="#myModal"><i class="ace-icon fa fa-edit bigger-120 blue"></i></button>
                                        <button del class="btn btn-white btn-default btn-bold do-handle btn-sm"><i class="ace-icon fa fa-trash bigger-120 blue"></i></button>
                                    </td>
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
                $("#fetch").click(function() {
                    var type = $("#type").val();
                    var status = $("#status").val();

                    window.location.href = "?type=" + type + "&status=" + status;
                });

                $("[del]").click(function(){
                    noticeId = $(this).parent().parent().children().eq(0).html();
                    bootbox.confirm("确认删除吗？", function(result) {
                        if (result) {
                            $.post("/health_monitor/del_notice", {noticeId:noticeId}, function (response) {
                                alert("删除成功");
                                window.location.reload()
                            })

                        }
                    });
                })

                $("[frequency]").each(function() {

                    var out = $(this).prev();
                    var val = $(this).val();
                    var timeArr = val.split(":");
                    if (timeArr[0] == 1) {
                        out.html("每" + timeArr[1] + "小时")
                    } else if (timeArr[0] == 2) {
                        out.html("每" + timeArr[1] + "天")
                    } else if (timeArr[0] == 3) {
                        out.html("每" + timeArr[1] + "个月")
                    }
                });

                $("[noticeTypes]").each(function () {
                    var val = $(this).val();
                    var keys = val.split("=");
                    $(this).val(keys[0]);
                    $(this).html(keys[1]);
                })
            })
        </script>
    </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">提醒设置</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="control-label col-sm-2">提醒内容</label>
                                <div class="col-sm-8">
                                    <select class="form-control" id="noticeType">
                                        <c:forEach items="${noticeTypes}" var="row">
                                            <option value="${row}" noticeTypes></option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2">提醒频率</label>
                                <div class="col-sm-4">
                                    <select class="form-control" id="frequencyType">
                                        <option value="1">按小时</option>
                                        <option value="2">按天</option>
                                        <option value="3">按月</option>
                                    </select>
                                </div>
                                <div class="col-sm-4">
                                    <input type="number" value="" class="form-control" id="frequencyVal">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2">开始时间</label>
                                <div class="col-sm-8">
                                    <input type="text" value="" class="form-control datetime-picker" id="start"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2">结束时间</label>
                                <div class="col-sm-8">
                                    <input type="text" value="" class="form-control datetime-picker" id="end"/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="save">保存</button>
            </div>
        </div>
    </div>
</div>
<script>
    var noticeId = -1;
    $(document).ready(function() {
        $(".datetime-picker").datetimepicker({
            format: 'YYYY-MM-DD H:mm:ss'
        })

        $("[edit]").click(function() {
            var par = $(this).parent().parent().children();

            noticeId = $(par).eq(0).html();
            var typeName = $(par).eq(1).html();

            $("#noticeType").children().each(function () {
                if ($(this).html() == typeName ) {
                    $("#noticeType").val($(this).attr('value'))
                }
            })
            $("#frequencyType").val($(par).eq(2).children().eq(1).val().split(":")[0]);
            $("#frequencyVal").val($(par).eq(2).children().eq(1).val().split(":")[1]);
            $("#start").val($(par).eq(3).html());
            $("#end").val($(par).eq(4).html());

        })

        $("#add").click(function() {
            $("#noticeType").val(1);
            $("#frequencyType").val(1);
            $("#frequencyVal").val("");
            $("#start").val("");
            $("#end").val("");
            noticeId = -1;
        })

        $("#save").click(function () {

            var type = $("#noticeType").val();
            var frequencyVal = $("#frequencyVal").val();
            var start = $("#start").val();
            var end = $("#end").val();

            if (frequencyVal.length === 0 || frequencyVal === 0) {
                alert("提醒频率不能为空")
            } else if (start.length == 0) {
                alert("开始时间不能为空")
            } else if (end.length == 0) {
                alert("结束时间不能为空")
            } else {
                if (noticeId > 0) {
                    $.post("/health_monitor/update_notice", {
                        noticeId:noticeId,
                        type:type,
                        frequency: $("#frequencyType").val() + ":" + frequencyVal,
                        start:start,
                        end:end,
                    }, function (response) {
                        if (response.status) {
                            alert("修改成功")
                            window.location.reload()
                        } else {
                            alert(response.info)
                        }
                    })
                } else {
                    $.post("/health_monitor/add_notice", {
                        type:type,
                        frequency: $("#frequencyType").val() + ":" + frequencyVal,
                        start:start,
                        end:end,
                    }, function (response) {
                        if (response.status) {
                            alert("修改成功")
                            window.location.reload()
                        } else {
                            alert(response.info)
                        }
                    })
                }
            }
        })
    })
</script>
<%@ include file="../common/footer.jsp" %>
