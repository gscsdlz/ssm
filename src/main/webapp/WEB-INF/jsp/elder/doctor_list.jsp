<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>

    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <form class="form-inline" method="get">
            <input type="text" placeholder="姓名" value="${name}" name="realname" class="form-control">
            <input type="text" placeholder="电话" value="${phone}" name="phone" class="form-control">
            <button class="btn btn-sm btn-primary" type="submit">查询</button>
        </form>
        <hr/>
        <table class="table table-hover table-bordered">
            <thead>
                <tr>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>手机号</th>
                    <th>医院名</th>
                    <th>科室名称</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${data}" var="user">
                <tr>
                    <td>${user.accountId}</td>
                    <td>${user.realname}</td>
                    <td>${user.phone}</td>
                    <td>${user.hospitalName}</td>
                    <td>${user.section}</td>
                    <td>
                        <button class="btn btn-success btn-sm" connection type="button">关注</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script>
    $(document).ready(function () {
        $("[connection]").click(function() {
            if ($(this).hasClass("btn-danger")) {
                return;
            }
            let id = $(this).parent().parent().children().eq(0).html();
            let that = $(this);
            $.post("/my_doctor/add_connection", {doctor_id: id}, function (response) {
                if (response.status) {
                    $(that).html("已关注");
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