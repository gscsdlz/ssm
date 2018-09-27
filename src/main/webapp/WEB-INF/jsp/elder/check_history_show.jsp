<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>
    检验项目
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <table id="checkHistory" class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>检验编号</th>
                            <th>医院名称</th>
                            <th>科室名</th>
                            <th>检验项目名</th>
                            <th>检验目的</th>
                            <th>医生姓名</th>
                            <th>记录时间</th>
                        </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $("#checkHistory").dynamicTableView({
           initURL: '/health_history/get_check_history',
            keysMap: [
                'chId', 'hospitalName', 'section', 'checkName', 'checkReason', 'realName','createdAt'
            ]
        });
    })
</script>
<%@ include file="../common/footer.jsp" %>