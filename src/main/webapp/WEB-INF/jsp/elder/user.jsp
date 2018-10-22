<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>
        个人中心
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="">
            <div id="user-profile-1" class="user-profile row">
                <div class="col-xs-12 col-sm-3 col-sm-offset-1 center">
                    <div>
                        <span class="profile-picture">
                            <img id="avatar"
                                 class="editable img-responsive editable-click editable-empty"
                                 alt="Alex's Avatar" src="/assets/images/avatars/profile-pic.jpg"
                                 style="display: block;">
                        </span>
                        <div class="space-4"></div>
                        <div class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
                            <div class="inline position-relative">
                                <a href="#" class="user-title-label">
                                    <span class="white"> <c:out value="${user.realname}"/> </span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="space-12"></div>
                    <div class="center">
                         <span class="btn btn-app btn-sm btn-light no-hover">
                            <span class="line-height-1 bigger-170 blue" id="healthDataCount"> 0 </span>
                            <br>
                            <span class="line-height-1 smaller-90"> 总测量次数 </span>
                        </span>
                        <span class="btn btn-app btn-sm btn-yellow no-hover">
                                <span class="line-height-1 bigger-170" id="join"> 0 </span>
                                <br>
                                <span class="line-height-1 smaller-90"> 累积加入 </span>
                        </span>
                        <span class="btn btn-app btn-sm btn-pink no-hover">
                            <span class="line-height-1 bigger-170" id="sicks"> 0 </span>
                            <br>
                            <span class="line-height-1 smaller-90"> 病历记录数 </span>
                        </span>
                    </div>
                    <div class="center">
                       <span class="btn btn-app btn-sm btn-grey no-hover">
                            <span class="line-height-1 bigger-170" id="checks"> 0 </span>
                            <br>
                            <span class="line-height-1 smaller-90"> 检验记录数 </span>
                        </span>
                        <span class="btn btn-app btn-sm btn-success no-hover">
                            <span class="line-height-1 bigger-170" id="drugs"> 0 </span>
                            <br>
                            <span class="line-height-1 smaller-90"> 用药记录数 </span>
                        </span>
                        <span class="btn btn-app btn-sm btn-primary no-hover">
                            <span class="line-height-1 bigger-170" id="doctor"> 0 </span>
                            <br>
                            <span class="line-height-1 smaller-90"> 家庭医生数 </span>
                        </span>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-8">
                    <div class="profile-user-info profile-user-info-striped" id="infoRow">
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

        $.get("/user_count/elder", function (response) {
            if (response.status) {
                $("#healthDataCount").html(response.healthDataCount);
                $("#join").html(response.join);
                $("#sicks").html(response.sicks);
                $("#checks").html(response.checks);
                $("#drugs").html(response.drugs);
                $("#doctor").html(response.doctor);
            } else {
                alert(response.info);
            }
        })
    })
</script>
<%@ include file="../common/footer.jsp" %>