<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>
    用药记录
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <table id="drugHistory" class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>记录编号</th>
                            <th>医院名称</th>
                            <th>药物名称</th>
                            <th>用药规格</th>
                            <th>单次剂量</th>
                            <th>剂量单位</th>
                            <th>用药状态</th>
                            <th>药物类别</th>
                            <th>药物治疗类别</th>
                            <th>开药医生</th>
                            <th>时间</th>
                        </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $("#drugHistory").dynamicTableView({
           initURL: '/health_history/get_drug_history',
            keysMap: [
                'dhId', 'hospitalName', 'drugName', 'totalSize', 'onceSize', 'unit', 'status', 'drugType', 'typeDetail', 'realName','createdAt'
            ]
        });
    })
</script>
<%@ include file="../common/footer.jsp" %>