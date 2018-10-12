<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>
        健康档案调阅授权
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="space-6"></div>
        <hr/>
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <table class="table table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>申请人姓名</th>
                        <th>申请人电话</th>
                        <th>申请人住址</th>
                        <th>申请时间</th>
                        <th>状态</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${data}" var="row">
                            <tr>
                                <td>${row.recordId}</td>
                                <td>${row.realname}</td>
                                <td>${row.phone}</td>
                                <td>${row.address}</td>
                                <td>${row.createdAt}</td>
                                <c:if test="${row.stat == 0}">
                                    <td>
                                        <span class="text-danger">未授权</span>
                                    </td>
                                    <td>
                                        <button class="btn btn-success btn-sm" type="button" invoke>授权</button>
                                    </td>
                                </c:if>
                                <c:if test="${row.stat == 1}">
                                    <td>
                                        <span class="text-success">已授权</span>
                                    </td>
                                    <td>
                                        <button class="btn btn-danger btn-sm" type="button" revoke>取消授权</button>
                                    </td>
                                </c:if>

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
        $("[invoke]").click(function(){
            let id = $(this).parent().parent().children().eq(0).html();
            let that = $(this);
            $.post("/record_auth/do_invoke", {id:id, stat:1}, function (response) {
                if (response.status) {
                   window.location.reload()
                } else {
                    alert(response.info)
                }
            })
        })

        $("[revoke]").click(function(){
            let id = $(this).parent().parent().children().eq(0).html();
            let that = $(this);
            $.post("/record_auth/do_invoke", {id:id, stat:0}, function (response) {
                if (response.status) {
                    window.location.reload()
                } else {
                    alert(response.info)
                }
            })
        })
    })
</script>
<%@ include file="../common/footer.jsp" %>