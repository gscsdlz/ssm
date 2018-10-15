<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./common/header.jsp" %>
<div class="page-header">
    <h1>
        医患对话
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="page-header">
            <h4>${question.question}@
                <c:if test="${act == 1}">
                    ${question.doctorName}
                </c:if>
                <c:if test="${act == 2}">
                    ${question.elderName}
                </c:if>
            </h4>
        </div>
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <div style="height: 600px;overflow-y: visible" class="well">
                    <table style="width:100%">
                        <tbody>
                        <tr>
                            <td style="width: 10%"></td>
                            <td style="width: 40%"></td>
                            <td style="width: 40%"></td>
                            <td style="width: 10%"></td>
                        </tr>
                        <c:forEach items="${answers}" var="answer">
                            <tr style="margin-top: 10px">
                                <c:if test="${answer.userType == act}">
                                    <td></td>
                                    <td></td>
                                    <td style="padding-left: 10px" class="text-right">
                                            ${answer.answerContent}<br/>
                                        <span style="font-size: 12px;color:gray">@${answer.createdAt}</span>
                                    </td>
                                    <td class="text-right" style="padding: 5px">
                                        <img src="/assets/images/avatars/avatar.png" />
                                    </td>
                                </c:if>
                                <c:if test="${answer.userType != act}">
                                    <td class="text-left"  style="padding: 5px">

                                        <img src="/assets/images/avatars/avatar.png" />
                                    </td>
                                    <td style="padding-left: 10px" class="text-left">
                                        ${answer.answerContent}<br/>
                                        <span style="font-size: 12px;color:gray">@${answer.createdAt}</span>
                                    </td>
                                    <td></td>
                                    <td></td>
                                </c:if>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <form class="form-horizontal">
                    <div class="form-group">
                        <div class="col-sm-10">
                            <textarea class="form-control" id="reply" placeholder="你的回复......"></textarea>
                        </div>
                        <div class="col-sm-2">
                            <button class="btn btn-success btn-sm" type="button" id="submit">提交</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $("#submit").click(function() {
            let content = $("#reply").val();
            if (content.length === 0 ) {
                alert("回复内容不能为空")
            } else {
                $.post("/qa_api/add_answer", {answer_content:content, question_id: ${question.questionId}}, function(response) {
                    if (response.status) {
                        window.location.reload()
                    } else {
                        alert(response.info);
                    }
                })
            }
        })
    })
</script>
<%@ include file="./common/footer.jsp" %>