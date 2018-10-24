<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>医养结合信息服务与预警平台</title>
    <link rel="icon" href="/assets/home/img/core-img/favicon.ico">
    <link rel="stylesheet" href="/assets/home/style.css">
    <script src="/assets/home/js/jquery/jquery-2.2.4.min.js"></script>
</head>
<body>
<header class="header-area">
    <div class="top-header-area">
        <div class="container h-100">
            <div class="row h-100">
                <div class="col-12 h-100">
                    <div class="h-100 d-md-flex justify-content-between align-items-center">
                        <p>欢迎来到医养结合信息服务与预警平台</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="main-header-area" id="stickyHeader">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12 h-100">
                    <div class="main-menu h-100">
                        <nav class="navbar h-100 navbar-expand-lg">
                            <a class="navbar-brand" href="#"><img src="/assets/home/img/core-img/logo.png" alt="Logo"></a>
                            <div class="collapse navbar-collapse" id="medilifeMenu">
                                <ul class="navbar-nav ml-auto" id="menu">
                                    <li class="nav-item active">
                                        <a class="nav-link" href="/">主页</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="/page/services">服务简介</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="/page/about">关于我们</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="/page/contact">联系我们</a>
                                    </li>
                                </ul>
                                <c:if test="${sessionScope.username != null }">
                                    <a href="/home" class="btn medilife-appoint-btn ml-30">进入后台</a>
                                </c:if>
                                <c:if test="${sessionScope.username == null }">
                                    <a href="/login" class="btn medilife-appoint-btn ml-30">登录 / 注册</a>
                                </c:if>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<script>
    $(document).ready(function() {
        let menuId = parseInt("${menu}");
        $("#menu").children().removeClass("active");
        $("#menu").children().eq(menuId - 1).addClass("active");
    })
</script>