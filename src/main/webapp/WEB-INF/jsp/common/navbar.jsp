<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">医养结合信息服务与预警平台</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">主页</a></li>
                <li><a href="#"></a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" data-toggle="modal" data-target="#loginModal">登录</a></li>
                <li><a href="#" data-toggle="modal" data-target="#registerModal">注册</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">登录</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-sm-2">用户名</label>
                        <div class="col-sm-8">
                            <input type="text" id="navbar_username" placeholder="请输入用户名" value="" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">密码</label>
                        <div class="col-sm-8">
                            <input type="password" id="navbar_password" placeholder="请输入密码" value="" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">角色</label>
                        <div class="col-sm-8">
                            <select class="form-control" id="navbar_act">
                                <option value="0">请选择登录角色</option>
                                <option value="1">老人</option>
                                <option value="2">家属</option>
                                <option value="3">医生</option>
                                <option value="4">社区服务中心</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="navbar_login">登录</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">注册</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-sm-2">用户名</label>
                        <div class="col-sm-8">
                            <input type="text" id="navbar_new_username" placeholder="请输入用户名" value="" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">密码</label>
                        <div class="col-sm-8">
                            <input type="password" id="navbar_new_password" placeholder="请输入密码" value="" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">角色</label>
                        <div class="col-sm-8">
                            <select class="form-control" id="navbar_new_act">
                                <option value="0">请选择登录角色</option>
                                <option value="1">老人</option>
                                <option value="2">家属</option>
                                <option value="3">医生</option>
                                <option value="4">社区服务中心</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="navbar_register">注册</button>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function() {
        $("#navbar_login").click(function() {
            var username = $("#navbar_username").val();
            var password = $("#navbar_password").val();
            var act = $("#navbar_act").val();

            if (username.length == 0) {
                alert("用户名不能为空");
            } else if (password.length == 0) {
                alert("密码不能为空");
            } else if (act == 0 ) {
                alert("请选择用户角色");
            } else {
                $.post("/user/login", {
                    username:username,
                    password:password,
                    act:act,
                }, function(response) {
                    if (response.status) {
                        alert("登录成功，即将跳转")
                    } else {
                        alert("登录失败，" + response.info)
                    }
                })
            }
        })
        $("#navbar_register").click(function() {
            var username = $("#navbar_new_username").val();
            var password = $("#navbar_new_password").val();
            var act = $("#navbar_new_act").val();

            if (username.length == 0) {
                alert("用户名不能为空");
            } else if (password.length == 0) {
                alert("密码不能为空");
            } else if (act == 0 ) {
                alert("请选择用户角色");
            } else {
                $.post("/user/register", {
                    username:username,
                    password:password,
                    act:act,
                }, function(response) {
                    if (response.status) {
                        alert("注册成功，即将跳转")
                    } else {
                        alert("注册失败，" + response.info)
                    }
                })
            }
        })
    })
</script>
