<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>
        健康档案调阅申请
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="space-6"></div>
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <form class="form-inline" method="get">
                    <input type="text" placeholder="输入老人姓名以查询" name="realname" value="${realname}">
                    <input type="text" placeholder="输入老人手机以查询" name="phone" value="${phone}">
                    <button class="btn btn-primary" type="submit">查询</button>
                </form>
            </div>
        </div>
        <hr/>
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <table class="table table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>老人姓名</th>
                        <th>电话</th>
                        <th>住址</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${data}" var="row">
                            <tr>
                                <td>${row.accountId}</td>
                                <td>${row.realname}</td>
                                <td>${row.phone}</td>
                                <td>${row.address}</td>
                                <td>
                                    <button class="btn btn-success btn-sm" type="button" apply>申请</button>
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
        $("[apply]").click(function(){
            let id = $(this).parent().parent().children().eq(0).html();
            let that = $(this);
            $.post("/record_auth/do_apply", {id:id}, function (response) {
                if (response.status) {
                    $(that).html("申请中");
                    $(that).removeClass("btn-success");
                    $(that).addClass("btn-danger");
                } else {
                    alert(response.info)
                }
            })
        })
    })
</script>
<%@ include file="../common/footer.jsp" %>