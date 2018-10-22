<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1 id="handle">
        <c:if test="${handle == 1}">
            已处理投诉
        </c:if>
        <c:if test="${handle == 0}">
            待处投诉
        </c:if>
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

        $.get("/complaint/get", {handle: ${handle}}, function (response) {
            if (response.status) {
                $("#table").dynamicTables({
                    title: ['编号', '老人姓名', '内容', '创建时间', '处理状态', '处理意见', '处理时间'],
                    'data': response.data,
                    'delsURL': '/complaint/del',
                    'saveURL': '/complaint/update',
                    'typeConfig': [
                        {'edit': false},
                        {'edit': false},
                        {'edit': false},
                        {'edit': false},
                        {
                            'type': 'select',
                            'options': [
                                [0, '未处理'],
                                [1, '已处理']
                            ]
                        },
                        {'type': 'text'},
                        {'edit': false}
                    ],
                    'noAdd': true,
                    'dataKeys': [
                        'complaintId', 'realname', 'content', 'createdAt', 'handle', 'handleContent', 'handleTime'
                    ],
                    'userHandle': {}
                })
            }
        })
    })
</script>
<%@ include file="../common/footer.jsp" %>