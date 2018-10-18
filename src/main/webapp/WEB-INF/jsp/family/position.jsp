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
            <div class="col-md-4">
                <div class="page-header"><h3>我关注的老人</h3></div>
                <table class="table table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>老人编号</th>
                        <th>老人姓名</th>
                        <th>联系方式</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${elders}" var="d">
                        <tr>
                            <td>${d.accountId}</td>
                            <td>${d.realname}</td>
                            <td>${d.phone}</td>
                            <td>
                                <button class="btn btn-danger btn-sm" type="button" unfollow="${d.accountId}">取消关注</button>
                                <button class="btn btn-success btn-sm" type="button" onclick="window.location.href='?id=${d.accountId}'">查看详情</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <hr/>
                <form class="form-horizontal well">
                    <div class="form-group">
                        <label class="control-label col-sm-2">身份证号</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" value="" id="idCard" placeholder="输入老人身份证号码">
                        </div>
                    </div>
                    <button class="btn btn-primary btn-sm" type="button" id="follow">搜索并关注</button>
                </form>
            </div>
            <div class="col-md-8">
                <div class="row">
                    <div class="col-sm-12">
                        <div id="map" style="width: 100%;height:700px"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>

    $(document).ready(function () {

        $("[unfollow]").click(function() {
            let id = $(this).attr("unfollow");
            $.post("/follow_api/unfollow", {id: id}, function(response) {
                if (response.status) {
                    window.location.reload();
                }
            });
        });

        $("#follow").click(function () {
            let id = $("#idCard").val();
            if (id.length === 0) {
                alert("身份号不能为空");
            } else {
                $.post("/follow_api/follow", {id_card:id}, function(response){
                    if (response.status) {
                        window.location.reload()
                    } else {
                        alert(response.info);
                    }
                })
            }
        })

    });
</script>
<script type="text/javascript" src="https://webapi.amap.com/maps?v=1.4.10&key=ca21520f63a4ca42c5e5abdc95adf05e"></script>
<script src="//webapi.amap.com/ui/1.0/main.js"></script>
<script>
    $(document).ready(function() {

        var map = new AMap.Map('map');
        AMap.plugin('AMap.ToolBar',function(){//异步加载插件
            map.addControl(new AMap.ToolBar());
        });
        AMapUI.load(['ui/misc/PathSimplifier'], function(PathSimplifier) {

            if (!PathSimplifier.supportCanvas) {
                alert('当前环境不支持 Canvas！');
                return;
            }

            //启动页面
            initPage(PathSimplifier);
        });

        function initPage(PathSimplifier) {
            //创建组件实例
            var pathSimplifierIns = new PathSimplifier({
                zIndex: 100,
                map: map, //所属的地图实例
                getPath: function(pathData, pathIndex) {
                    //返回轨迹数据中的节点坐标信息，[AMap.LngLat, AMap.LngLat...] 或者 [[lng|number,lat|number],...]
                    return pathData.path;
                },
                getHoverTitle: function(pathData, pathIndex, pointIndex) {
                    //返回鼠标悬停时显示的信息
                    if (pointIndex >= 0) {
                        //鼠标悬停在某个轨迹节点上
                        return pathData.name + '，点:' + pointIndex + '/' + pathData.path.length;
                    }
                    //鼠标悬停在节点之间的连线上
                    return pathData.name + '，点数量' + pathData.path.length;
                },
                renderOptions: {
                    //轨迹线的样式
                    pathLineStyle: {
                        strokeStyle: 'red',
                        lineWidth: 6,
                        dirArrowStyle: true
                    }
                }
            });

            //这里构建两条简单的轨迹，仅作示例
            pathSimplifierIns.setData([{
                name: '老人轨迹',
                path: [
                    <c:forEach items="${position.list}" var="p">
                    [${p.longitude}, ${p.latitude}],
                    </c:forEach>
                ]
            }]);
        }

        $('.date-picker').datepicker({
            autoclose: true,
            todayHighlight: true
        })

        $("#find").click(function () {
            var t1 = $("#date").val();

            if (t1.length === 0) {
                alert("开始时间不能为空");
            } else {
                window.location.href = "?date=" + t1;
            }
        })
    })
</script>
</script>
<%@ include file="../common/footer.jsp" %>