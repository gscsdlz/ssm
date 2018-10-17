<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2 text-center">
            <div class="medilife-appointment-form" style="background-color: #081f3e;padding:40px;margin-top:200px;margin-bottom: 20px">
                <form>
                    <div class="row align-items-end">
                        <div class="col-md-4">
                            <div class="form-group">
                                <select class="form-control" id="act">
                                    <option value="1">老人</option>
                                    <option value="2">医生</option>
                                    <option value="3">家属</option>
                                    <option value="4">社区</option>
                                    <option value="5">管理员</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <input type="text"
                                       class="form-control border-top-0 border-right-0 border-left-0" id="username" placeholder="用户名">
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <input type="password"
                                       class="form-control border-top-0 border-right-0 border-left-0" id="password" placeholder="密码">
                            </div>
                        </div>
                        <div class="col-md-5 mb-0">
                            <div class="form-group mb-0">
                                <button type="button" class="btn medilife-btn" id="login">登录</button>
                            </div>
                        </div>
                        <div class="col-md-5 mb-0">
                            <div class="form-group mb-0">
                                <button type="button" class="btn medilife-btn" id="register">注册</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $("#login").click(function() {
            var username = $("#username").val();
            var password = $("#password").val();
            var act = $("#act").val();

            if (username.length == 0) {
                alert("用户名不能为空");
            } else if (password.length == 0) {
                alert("密码不能为空");
            } else if (act == 0 ) {
                alert("请选择用户角色");
            } else {
                $.post("/user/login", {
                    username:username,
                    password:password,
                    act:act,
                }, function(response) {
                    if (response.status) {
                        alert("登录成功，即将跳转");
                        window.location.reload();
                    } else {
                        alert("登录失败，" + response.info)
                    }
                })
            }
        })
        $("#register").click(function() {
            var username = $("#username").val();
            var password = $("#password").val();
            var act = $("#act").val();

            if (username.length == 0) {
                alert("用户名不能为空");
            } else if (password.length == 0) {
                alert("密码不能为空");
            } else if (act == 0 ) {
                alert("请选择用户角色");
            } else {
                $.post("/user/register", {
                    username:username,
                    password:password,
                    act:act,
                }, function(response) {
                    if (response.status) {
                        alert("注册成功，即将跳转");
                        window.location.href = '/user/me';
                    } else {
                        alert("注册失败，" + response.info)
                    }
                })
            }
        })
    })
</script>
<%@ include file="./footer.jsp" %>