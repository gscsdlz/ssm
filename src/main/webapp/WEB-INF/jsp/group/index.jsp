<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>

    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="page-header">
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
<script>
    $(document).ready(function () {

    })
</script>
<%@ include file="../common/footer.jsp" %>