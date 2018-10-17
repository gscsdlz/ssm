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
                            <span class="line-height-1 bigger-170 blue" id="elder"> 0 </span>
                            <br>
                            <span class="line-height-1 smaller-90"> 现有病人 </span>
                        </span>
                        <span class="btn btn-app btn-sm btn-yellow no-hover">
                                <span class="line-height-1 bigger-170" id="join"> 0 </span>
                                <br>
                                <span class="line-height-1 smaller-90"> 累积加入 </span>
                        </span>

                    </div>
                    <div class="center">
                       <span class="btn btn-app btn-sm btn-grey no-hover">
                            <span class="line-height-1 bigger-170" id="evaluates"> 0 </span>
                            <br>
                            <span class="line-height-1 smaller-90"> 评估数 </span>
                        </span>
                        <span class="btn btn-app btn-sm btn-pink no-hover">
                            <span class="line-height-1 bigger-170" id="answers"> 0 </span>
                            <br>
                            <span class="line-height-1 smaller-90"> 问答数 </span>
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
        {'key': '所属医院', 'val': '<c:out value="${user.hospitalName}" />', 'name': 'hospitalName', 'type': 'text'},
        {'key': '所属科室', 'val': '<c:out value="${user.section}" />', 'name': 'section', 'type': 'text'},
    ];
    $(document).ready(function () {
        $("#infoRow").userInfo({
            'data': infoData,
            'updateURL': '/doctor_user/update'
        });

        $.get("/user_count/doctor", function (response) {
            if (response.status) {
                $("#elder").html(response.elder);
                $("#join").html(response.join);
                $("#evaluates").html(response.evaluates);
                $("#answers").html(response.answers);
            } else {
                alert(response.info);
            }
        })
    })
</script>
<%@ include file="../common/footer.jsp" %>