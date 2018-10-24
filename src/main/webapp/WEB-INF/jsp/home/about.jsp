<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./header.jsp" %>
<section class="breadcumb-area bg-img gradient-background-overlay"
         style="background-image: url(/assets/home/img/bg-img/breadcumb1.jpg);">
    <div class="container h-100">
        <div class="row h-100 align-items-center">
            <div class="col-12">
                <div class="breadcumb-content">
                    <h3 class="breadcumb-title">关于我们</h3>
                </div>
            </div>
        </div>
    </div>
</section>

<div class="medilife-features-area section-padding-100">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-12 col-lg-6">
                <div class="features-content">
                    <h2>我们的平台</h2>
                    <p>本项目以社区和家庭养老人员为主要对象，采用云计算、大数据、物联网、人工智能、移动互联网技术手段，在构建老龄人口医学基本、生活信息的基础上，实现医护、照料、预警等医养调度决策服务。旨在解决设定区域内最广大老龄人口的医养结合问题，同时通过医养结合信息服务，提供更全面和准确的一线相关信息，从而为政府解决人口老龄化问题的决策提供依据。</p>
                    <a href="/page/services" class="btn medilife-btn mt-50">查看我们的服务 <span>+</span></a>
                </div>
            </div>
            <div class="col-12 col-lg-6">
                <div class="features-thumbnail">
                    <img src="/assets/home/img/bg-img/about1.jpg" alt="">
                </div>
            </div>
        </div>
    </div>
</div>
<section class="medilife-tabs-area section-padding-100">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="medilife-tabs-content">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link" id="institution-tab" data-toggle="tab" href="#institution" role="tab"
                               aria-controls="institution" aria-selected="false">我们是谁</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" id="specialities-tab" data-toggle="tab" href="#specialities"
                               role="tab" aria-controls="specialities" aria-selected="true">平台简介</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="laboratory-tab" data-toggle="tab" href="#laboratory" role="tab"
                               aria-controls="laboratory" aria-selected="false">我们的用户</a>
                        </li>
                    </ul>

                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade" id="institution" role="tabpanel" aria-labelledby="institution-tab">
                            <div class="medilife-tab-content d-md-flex align-items-center">
                                
                                <div class="medilife-tab-text">
                                    <h2>我们是谁</h2>
                                    <p>
                                        这里补一个你们的简介
                                    </p>
                                </div>
                                
                                <div class="medilife-tab-img">
                                    <img src="/assets/home/img/bg-img/about1.jpg" alt="">
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade show active" id="specialities" role="tabpanel"
                             aria-labelledby="specialities-tab">
                            <div class="medilife-tab-content d-md-flex align-items-center">
                                
                                <div class="medilife-tab-text">
                                    <h2>平台简介</h2>
                                    <p>
                                        本平台基于JavaEE开发<br/>
                                        使用Spring，SpringMVC，Mybaits作为开发框架<br/>
                                        前端使用了jQuery和Bootstrap
                                    </p>
                                </div>
                                
                                <div class="medilife-tab-img">
                                    <img src="/assets/home/img/bg-img/tab.jpg" alt="">
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="laboratory" role="tabpanel" aria-labelledby="laboratory-tab">
                            <div class="medilife-tab-content d-md-flex align-items-center">
                                
                                <div class="medilife-tab-text">
                                    <h2>我们的用户</h2>
                                    <p>
                                        北京市综合养老院<br/>
                                        上海市朝阳疗养院<br/>
                                        上海第一总院<br/>
                                    </p>
                                </div>
                                
                                <div class="medilife-tab-img">
                                    <img src="/assets/home/img/bg-img/medical1.png" alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<%@ include file="./footer.jsp" %>