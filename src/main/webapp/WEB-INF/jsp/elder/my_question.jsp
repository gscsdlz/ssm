<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>
        我的咨询
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="row">
            <div class="col-md-5">
                <div class="page-header"><h3>我关注的医生</h3></div>
                <table class="table table-hover table-bordered">
                    <thead>
                        <tr>
                            <th>医生编号</th>
                            <th>医生姓名</th>
                            <th>所属医院</th>
                            <th>所属科室</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${doctors}" var="d">
                            <tr>
                                <td>${d.accountId}</td>
                                <td>${d.realname}</td>
                                <td>${d.hospitalName}</td>
                                <td>${d.section}</td>
                                <td>
                                    <button class="btn btn-danger btn-sm" type="button" unconnection="${d.accountId}">取消关注</button>
                                    <button class="btn btn-primary btn-sm" type="button" data-toggle="modal" data-target="#questionModal" onclick="addQ(${d.accountId})">发起提问</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-md-7">
                <div class="page-header"><h3>我的提问列表</h3></div>
                <table class="table table-hover table-bordered">
                    <thead>
                        <tr>
                            <th>提问编号</th>
                            <th>提问内容</th>
                            <th>医生姓名</th>
                            <th>提问时间</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${data}" var="q">
                            <tr>
                                <td>${q.questionId}</td>
                                <td>${q.question}</td>
                                <td>${q.doctorName}</td>
                                <td>${q.createdAt}</td>
                                <td>
                                    <a class="btn btn-sm btn-primary" type="button" href="/my_doctor/chat?question_id=${q.questionId}">查看对话</a>
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
<div class="modal fade" id="questionModal" tabindex="-1" role="dialog" aria-labelledby="questionModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="questionModalLabel">发起提问</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="control-label col-sm-2">提问内容</label>
                                <div class="col-sm-8">
                                   <input type="text" class="form-control" value="" id="question" placeholder="">
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
    let uid = 0;

    $(document).ready(function () {
        $("[unconnection]").click(function() {
            let id = $(this).attr("unconnection") ;
            $.post("/my_doctor/unconnection", {doctor_id: id}, function(response) {
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

    $("#save").click(function() {
        let content = $("#question").val();
        if (content.length === 0) {
            alert("提问内容不能为空");
        } else {
            $.post("/qa_api/add_question", {question:content, doctor_id: uid}, function(response) {
                if (response.status) {
                    window.location.reload()
                } else {
                    alert(response.info);
                }
            })
        }
    });

    function addQ(id) {
        uid = id;
    }
</script>
<%@ include file="../common/footer.jsp" %>