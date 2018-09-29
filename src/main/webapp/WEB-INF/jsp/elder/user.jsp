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
                                    <span class="white">Alex M. Doe</span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="space-12"></div>
                    <div class="center">
                        <span class="btn btn-app btn-sm btn-light no-hover">
                            <span class="line-height-1 bigger-170 blue"> 1,411 </span>
                            <br>
                            <span class="line-height-1 smaller-90"> 总测量次数 </span>
                        </span>
                        <span class="btn btn-app btn-sm btn-yellow no-hover">
                                <span class="line-height-1 bigger-170"> 32 </span>
                                <br>
                                <span class="line-height-1 smaller-90"> 累积加入 </span>
                        </span>
                        <span class="btn btn-app btn-sm btn-pink no-hover">
                            <span class="line-height-1 bigger-170"> 4 </span>
                            <br>
                            <span class="line-height-1 smaller-90"> 病历记录数 </span>
                        </span>
                    </div>
                    <div class="center">
                        <span class="btn btn-app btn-sm btn-grey no-hover">
                            <span class="line-height-1 bigger-170"> 23 </span>
                            <br>
                            <span class="line-height-1 smaller-90"> 检验记录数 </span>
                        </span>
                        <span class="btn btn-app btn-sm btn-success no-hover">
                            <span class="line-height-1 bigger-170"> 7 </span>
                            <br>
                            <span class="line-height-1 smaller-90"> 用药记录数 </span>
                        </span>
                        <span class="btn btn-app btn-sm btn-primary no-hover">
                            <span class="line-height-1 bigger-170"> 55 </span>
                            <br>
                            <span class="line-height-1 smaller-90"> 待定 </span>
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
<script>
    var infoData = [
        {'key': '用户名', 'val': 'root', 'icon': ''},
        {'key': '姓名', 'val': '狗蛋', 'icon': ''},
        {'key': '性别', 'val': '男', 'icon': ''},
        {'key': '年龄', 'val': '77', 'icon': ''},
        {'key': '联系方式', 'val': '134,5678,9101', 'icon': ''},
        {'key': '家庭住址', 'val': '四川省，成都市，武侯区，XXX，XXXX', 'icon': ''},
        {'key': '身份证号', 'val': '123456，78912312，3121', 'icon': ''},
        {'key': '社保编号', 'val': '123456', 'icon': ''},
        {'key': '有无过敏史', 'val': '无', 'icon': ''},
        {'key': '有无外伤', 'val': '有', 'icon': ''},
        {'key': '有无手术史', 'val': '无', 'icon': ''},
        {'key': '有无遗传病', 'val': '有', 'icon': ''},
    ];
    $(document).ready(function () {
        for (let i = 0; i < infoData.length; i++) {
            $("#infoRow").append('' +
                '<div class="profile-info-row">' +
                '    <div class="profile-info-name"> ' + infoData[i].key + ' </div>' +
                '    <div class="profile-info-value">' +
                '        <span class="editable editable-click"> ' + infoData[i].val + ' </span>' +
                '    </div>' +
                '</div>')
        }
    })
</script>
<%@ include file="../common/footer.jsp" %>