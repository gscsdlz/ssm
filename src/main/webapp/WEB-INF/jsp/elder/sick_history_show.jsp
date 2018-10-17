<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>
    门诊病历
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <table id="sickHistory" class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>病历编号</th>
                            <th>医院名称</th>
                            <th>科室名</th>
                            <th>诊断结果</th>
                            <th>医生姓名</th>
                            <th>诊断方式</th>
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
        $("#sickHistory").  dynamicTableView({
           initURL: '/health_history/get_sick_history',
            keysMap: [
                'shId', 'hospitalName', 'section', 'result', 'realName', 'method', 'createdAt'
            ]
        });
    })
</script>
<%@ include file="../common/footer.jsp" %>