<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<div class="page-header">
    <h1>
        工单处理
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <table class="table table-hover table-bordered" id="table">

        </table>
    </div>
</div>
<script src="/assets/js/dynamicTables.js"></script>
<script>
    $(document).ready(function () {
        $.get("/work_order/init", function (response) {

            let elderMap = [];
            if (response.status) {
                for (let i = 0; i < response.data.length; i++) {
                    elderMap.push([response.data[i].accountId, response.data[i].realname]);
                }
            }

            $.get("/work_order/get", function (response) {
                $("#table").dynamicTables({
                    'title': [
                        '编号', '老人姓名', '类别', '内容', '价格', '服务时间', '创建时间', '管理员'
                    ],
                    'data': response.data,
                    'delsURL': '/work_order/del',
                    'saveURL': '/work_order/update',
                    'addURL': '/work_order/add',
                    'typeConfig': [
                        {'edit': false},
                        {
                            'type': 'select',
                            'options': elderMap
                        },
                        {
                            'type': 'select',
                            'options': [
                                [1, '房屋清洁'],
                                [2, '个人洗护'],
                                [3, '按摩保健'],
                                [4, '出行服务'],
                                [5, '一日三餐'],
                            ],
                        },
                        {'type': 'text'},
                        {'type': 'text'},
                        {'type': 'text'},
                        {'edit': false},
                        {'edit': false},
                    ],
                    'dataKeys': [
                        'orderId', 'elderId', 'type', 'content', 'price', 'serviceTime', 'createdAt', 'groupName',
                    ],
                });
            });
        });
    })
</script>
<%@ include file="../common/footer.jsp" %>