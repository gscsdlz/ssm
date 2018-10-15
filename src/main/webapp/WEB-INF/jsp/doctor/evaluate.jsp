<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>
        医生评估
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <table class="table table-bordered table-hover" id="table">
        </table>
    </div>
</div>
<script>
    $(document).ready(function () {
        $("#table").dynamicTables({
            title: ["编号", "老人姓名", "老人地址", "健康状态", "建议", "评估时间"],
            typeConfig: [
                {edit: false},
                {edit: false},
                {edit: false},
                {
                    type: "select",
                    options: [
                        [1, "健康"],
                        [2, "良好"],
                        [3, "身体欠佳"],
                        [4, "身体差"]
                    ]
                },
                {type: "text"},
                {edit: false}
            ],
            delsURL: "",
            saveURL: "",
            noAdd: true,
            dataKeys: [],
        });
    })
</script>
<%@ include file="../common/footer.jsp" %>