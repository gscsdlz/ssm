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
                <div id="map" style="width: 100%;height:700px"></div>
            </div>
        </div>
    </div>
</div>
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
    })
</script>
<%@ include file="../common/footer.jsp" %>