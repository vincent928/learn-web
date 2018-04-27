<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>杭商课堂在线答题系统</title>
<script type="text/javascript" src="/js/jquery-3.3.1.min.js" />
<script type="text/javascript" src="/js/bootstrap.min.js" />
<script type="text/javascript" src="https://cdn.bootcss.com/popper.js/1.14.1/esm/popper.min.js"></script>
<!-- <link href="https://cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.css" rel="stylesheet"> -->
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
<style type="text/css">
	 body{
	 background:url(/images/background.png);
	 }
	 .login-form{
	 position:absolute;
	 	top:35%;
	 	left: 40%;
	 	text-align: center;
	 }
 
</style>

<script type="text/javascript">

var LOGIN = {
		checkInput:function() {
			if ($("#username").val() == "") {
				alert("用户名不能为空");
				$("#username").focus();
				return false;
			}
			if ($("#password").val() == "") {
				alert("密码不能为空");
				$("#password").focus();
				return false;
			}
			if($("input:radio:checked").val()==""){
				alert("请选择登录入口");
				return false;
			}
			return true;
		},
		doLogin:function() {
			$.post("/user/login", $("#loginForm").serialize(),function(data){
				if (data.status == 200) {
					alert("登录成功！");
					var type=$("input:radio:checked").val();
					if(type == '0'){
					location.href = "http://localhost:8082/teacher";
					}else{
					location.href = "http://localhost:8082/student";
					}
				} else {
					alert("登录失败，原因是：" + data.msg);
					$("#username").select();
				}
			});
		},
		login:function() {
			if (this.checkInput()) {
				this.doLogin();
			}
		}
	
};
$(function(){
	$("#loginBtn").click(function(){
		LOGIN.login();
	});
});


function reset(){
	$("#loginForm")[0].reset();
}
</script>
</head>
<body>
<div class="container">
<div class="row">
<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="/page/login">杭商课堂在线答题系统</a>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                </li>
                <li class="nav-item active">
                </li>
            </ul>
        </div>
    </nav>
</header>
</div>
	<div class="row">
	<div class="login-form col-md-3">
			<form id="loginForm" method="post" onsubmit="return false;">
			<h1 style="color:white;">Login</h1>
				<div style="margin: 20px 0px;">
				<input class="form-control" type="text" placeholder="Username" id="username" name="username">
				</div>
				<div style="margin: 20px 0px;">
				<input class="form-control" type="password"  placeholder="Password" id="password" name="password">
				</div>
				<div style="color:white;">
				<div style="width: 60%;padding: 0;margin-bottom:10px;float: left;">
					<input class="" type="radio"  name="type" value="0"  style="color:white;">教师
					</div>
					<div style="width: 20%;padding: 0;margin-bottom:10px;float: left;">
					<input class="" type="radio" name="type" value="1"  style="color:white;">学生
					</div>
				</div>
				<div class="" style="margin: 10px 0px;">
					   <div style="width: 50%;padding: 0;margin: 0;float: left;">
			           <button class="btn btn-outline-success btn-lg" id="loginBtn" >登录</button>
			           </div>
			           <div style="width: 50%;padding: 0;margin: 0;float: left;">
			            <button class="btn btn-outline-success btn-lg" onclick="reset()">重置</button>
			            </div>
		
				</div>
			</form>
		</div>
	</div>
 
</div>
</body>

</html>