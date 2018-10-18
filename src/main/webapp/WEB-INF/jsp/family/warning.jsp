<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>
        异常指标信息
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="row">
            <div class="col-md-4">
                <div class="page-header"><h3>我关注的老人</h3></div>
                <table class="table table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>老人编号</th>
                        <th>老人姓名</th>
                        <th>联系方式</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${elders}" var="d">
                        <tr>
                            <td>${d.accountId}</td>
                            <td>${d.realname}</td>
                            <td>${d.phone}</td>
                            <td>
                                <button class="btn btn-danger btn-sm" type="button" unfollow="${d.accountId}">取消关注</button>
                                <button class="btn btn-success btn-sm" type="button" onclick="window.location.href='?id=${d.accountId}'">查看详情</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <hr/>
                <form class="form-horizontal well">
                    <div class="form-group">
                        <label class="control-label col-sm-2">身份证号</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" value="" id="idCard" placeholder="输入老人身份证号码">
                        </div>
                    </div>
                    <button class="btn btn-primary btn-sm" type="button" id="follow">搜索并关注</button>
                </form>
            </div>
            <div class="col-md-8">
                <div class="page-header">
                    <h3>告警信息<small>从左侧列表中选择老人</small></h3>
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table table-hover table-bordered">
                                <thead>
                                <tr>
                                    <th>编号</th>
                                    <th>姓名</th>
                                    <th>老人电话</th>
                                    <th>报警类型</th>
                                    <th>异常值</th>
                                    <th>检测时间</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${alarms}" var="alarm">
                                    <tr>
                                        <c:forEach items="${elderUsers}" var="elder">
                                            <c:if test="${alarm.accountId == elder.accountId}">
                                                <td>${alarm.alarmId}</td>
                                                <td>${elder.realname}</td>
                                                <td>${elder.phone}</td>
                                                <td>${keyNameMap.get(alarm.keyName)}</td>
                                                <td class="text-danger">${alarm.healthValue}</td>
                                                <td>${alarm.createdAt}</td>
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
<script>
    $(document).ready(function () {

        $("[unfollow]").click(function() {
            let id = $(this).attr("unfollow");
            $.post("/follow_api/unfollow", {id: id}, function(response) {
                if (response.status) {
                    window.location.reload();
                }
            });
        });

        $("#follow").click(function () {
            let id = $("#idCard").val();
            if (id.length === 0) {
                alert("身份号不能为空");
            } else {
                $.post("/follow_api/follow", {id_card:id}, function(response){
                    if (response.status) {
                        window.location.reload()
                    } else {
                        alert(response.info);
                    }
                })
            }
        })
    });
</script>
<%@ include file="../common/footer.jsp" %>