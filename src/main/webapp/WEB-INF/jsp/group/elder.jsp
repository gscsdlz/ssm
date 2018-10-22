<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>
        老人档案
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="row">
            <div class="col-md-3">
                <table class="table table-hover table-bordered">
                    <thead>
                        <tr>
                            <th>编号</th>
                            <th>姓名</th>
                            <th>电话</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${elders}" var="elder">
                        <tr>
                            <td>${elder.accountId}</td>
                            <td>${elder.realname}</td>
                            <td>${elder.phone}</td>
                            <td>
                                <a href="?id=${elder.accountId}" class="btn btn-primary btn-sm">查看详情</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-md-9 well">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="profile-user-info profile-user-info-striped" id="infoRow">
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <table class="table table-hover table-bordered">
                            <thead>
                                <tr>
                                    <th>编号</th>
                                    <th>姓名</th>
                                    <th>所属医院</th>
                                    <th>科室</th>
                                    <th>电话</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${doctors}" var="doctor">
                                    <tr>
                                        <td>${doctor.accountId}</td>
                                        <td>${doctor.realname}</td>
                                        <td>${doctor.hospitalName}</td>
                                        <td>${doctor.section}</td>
                                        <td>${doctor.phone}</td>
                                        <td>
                                            <button class="btn btn-danger btn-sm" type="button" unconnection>解绑</button>
                                        </td>
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
<script src="/assets/js/userInfo.js"></script>
<script>
    let radioData = [
        {
            'key': '有', 'val': '1',
        },
        {
            'key': '无', 'val': '0',
        }
    ];
    let infoData = [
        {'key': '编号', 'val': '<c:out value="${user.accountId}"/>', 'name': 'accountId', 'type': 'hidden'},
        {'key': '用户名', 'val': '<c:out value="${user.username}" />'},
        {'key': '姓名', 'val': '<c:out value="${user.realname}" />', 'name': 'realname', 'type': 'text'},
        {'key': '性别', 'val': '<c:out value="${user.gender}" />', 'name': 'gender', 'type': 'radio', 'option': [
                {
                    'key': '男', 'val': '1'
                },
                {
                    'key': '女', 'val': '0'
                }
            ]},
        {'key': '年龄', 'val': '<c:out value="${user.age}" />', 'name': 'age', 'type': 'text'},
        {'key': '联系方式', 'val': '<c:out value="${user.phone}" />', 'name': 'phone', 'type': 'text'},
        {'key': '家庭住址', 'val': '<c:out value="${user.address}" />', 'name': 'address', 'type': 'text'},
        {'key': '身份证号', 'val': '<c:out value="${user.idCard}" />', 'name': 'idCard', 'type': 'text'},
        {'key': '社保编号', 'val': '<c:out value="${user.ssId}" />', 'name': 'ssId', 'type': 'text'},
        {'key': '有无过敏史', 'val': '<c:out value="${user.hasAllergy}" />', 'name': 'hasAllergy', 'type': 'radio', 'option': radioData},
        {'key': '有无外伤', 'val': '<c:out value="${user.hasTrauma}" />', 'name': 'hasTrauma', 'type': 'radio', 'option': radioData},
        {'key': '有无手术史', 'val': '<c:out value="${user.hasOperation}" />', 'name': 'hasOperation', 'type': 'radio', 'option': radioData},
        {'key': '有无遗传病', 'val': '<c:out value="${user.hasInheritance}" />', 'name': 'hasInheritance', 'type': 'radio', 'option': radioData},
    ];
    $(document).ready(function () {
        $("#infoRow").userInfo({
            'data': infoData,
            'updateURL': '/elder_user/update'
        });

        $("[unconnection]").click(function() {
            let elderId = ${user.accountId};
            let doctorId = $(this).parent().parent().children().eq(0).html();

            $.post("/my_doctor/unconnection", {elder_id: elderId, doctor_id: doctorId}, function(response) {
                if (response.status) {
                    window.location.reload();
                }
            })
        })
    })
</script>
<%@ include file="../common/footer.jsp" %>