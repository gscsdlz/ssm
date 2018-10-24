<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./header.jsp" %>
<section class="breadcumb-area bg-img gradient-background-overlay"
         style="background-image: url(/assets/home/img/bg-img/breadcumb3.jpg);">
    <div class="container h-100">
        <div class="row h-100 align-items-center">
            <div class="col-12">
                <div class="breadcumb-content">
                    <h3 class="breadcumb-title">联系我们</h3>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="medilife-contact-area section-padding-100">
    <div class="container">
        <div class="row">
            <div class="col-12 col-lg-8">
                <div style="width: 100%;height: 500px;" id="map">

                </div>
            </div>

            <div class="col-12 col-lg-4">
                <div class="content-sidebar">
                    <div class="medilife-contact-card mb-50">
                        <div class="single-contact d-flex align-items-center">
                            <div class="contact-icon mr-30">
                                <i class="icon-doctor"></i>
                            </div>
                            <div class="contact-meta">
                                <p>地址: 写一个你们的地址 </p>
                            </div>
                        </div>

                        <div class="single-contact d-flex align-items-center">
                            <div class="contact-icon mr-30">
                                <i class="icon-doctor"></i>
                            </div>
                            <div class="contact-meta">
                                <p>联系电话：写一个你们的电话</p>
                            </div>
                        </div>

                        <div class="single-contact d-flex align-items-center">
                            <div class="contact-icon mr-30">
                                <i class="icon-doctor"></i>
                            </div>
                            <div class="contact-meta">
                                <p>Email: 写一个你们的邮件</p>
                            </div>
                        </div>
                    </div>
                    <div class="medilife-emergency-card bg-img bg-overlay"
                         style="background-image: url(/assets/home/img/bg-img/about1.jpg);">
                        <i class="icon-smartphone"></i>
                        <h2>有紧急情况请拨打</h2>
                        <h3>120</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script type="text/javascript" src="https://webapi.amap.com/maps?v=1.4.10&key=ca21520f63a4ca42c5e5abdc95adf05e"></script>
<script src="//webapi.amap.com/ui/1.0/main.js"></script>
<script>
    $(document).ready(function() {
        var map = new AMap.Map('map', {
            zoom:15,
            center: [112.4455057, 38.0144296],
        });
        AMap.plugin('AMap.ToolBar',function(){//异步加载插件
            map.addControl(new AMap.ToolBar());
        });
    })
</script>
<%@ include file="./footer.jsp" %>