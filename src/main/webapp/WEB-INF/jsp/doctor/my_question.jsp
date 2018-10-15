<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>
        咨询问题
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
                                    <button class="btn btn-danger btn-sm" type="button" unconnection="${d.accountId}">取消关注</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-md-7">
                <div class="page-header"><h3>我收到的提问</h3></div>
                <table class="table table-hover table-bordered">
                    <thead>
                        <tr>
                            <th>提问编号</th>
                            <th>提问内容</th>
                            <th>老人姓名</th>
                            <th>提问时间</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${data}" var="q">
                            <tr>
                                <td>${q.questionId}</td>
                                <td>${q.question}</td>
                                <td>${q.elderName}</td>
                                <td>${q.createdAt}</td>
                                <td>
                                    <a class="btn btn-sm btn-primary" type="button" href="/doctor_user/chat?question_id=${q.questionId}">查看对话</a>
                                    <button class="btn btn-sm btn-danger" type="button" delQA="${q.questionId}">删除问答</button>
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
        $("[unconnection]").click(function() {
            let id = $(this).attr("unconnection") ;
            $.post("/doctor_user/unconnection", {elder_id: id}, function(response) {
                if (response.status)
                    window.location.reload();
            })
        });

        $("[delQA]").click(function() {
            let qid = $(this).attr("delQA");
            $.post("/qa_api/del_question", {question_id : qid}, function(response) {
                if (response.status) {
                    window.location.reload();
                }
            })
        });
    });
</script>
<%@ include file="../common/footer.jsp" %>