<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>
        预警设置
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <table id="sets"></table>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function() {
        $.get("/warning_set_api/get", function (response) {

            var maps = [];

            for(var p in response.selectMap) {
                maps.push([p, response.selectMap[p]])
            }

            $("#sets").dynamicTables({
                "title": [
                    "编号", "预警项目", "最小值", "最大值", "设置时间"
                ],
                'dataKeys': ["warningId", "keyName", "minVal", "maxVal", "createdAt"],
                "data": response.data,
                "delsURL": "/warning_set_api/del",
                "saveURL": "/warning_set_api/update",
                "addURL": "/warning_set_api/add",
                "paginationURL": "/warning_set_api/get",
                "typeConfig": [
                    {"edit": false},
                    {
                        "type": "select",
                        "options": maps
                    },
                    {"type": "text"},
                    {"type": "text"},
                    {"edit": false}
                ]
            })
        })
    })
</script>

<%@ include file="../common/footer.jsp"%>