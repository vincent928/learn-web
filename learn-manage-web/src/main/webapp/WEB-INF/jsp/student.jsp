<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生界面</title>
<link rel="stylesheet" type="text/css" href="/css3/bootstrap.min.css">
<link rel="stylesheet" href="/css/bootstrap-table.min.css"> 
<link rel="stylesheet" href="/css/toastr.min.css">
<script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.12.4/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/js3/bootstrap.min.js" ></script>
<script type="text/javascript" src="/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="/js/toastr.min.js"></script>
<style type="text/css">
</style>
<script type="text/javascript">
var _URL="/student/student-work";
var sum=0; //用于计算点击左侧同一菜单次数，为0则不调用ajax加载
$(document).ready(function(){
	toastr.options={
			"closeButton": false, //是否显示关闭按钮
			"debug": false, //是否使用debug模式
			"positionClass": "toast-top-center",//弹出窗的位置
			"showDuration": "300",//显示的动画时间
			"hideDuration": "1000",//消失的动画时间
			"timeOut": "2000", //展现时间
			"showEasing": "swing",//显示时的动画缓冲方式
			"hideEasing": "linear",//消失时的动画缓冲方式
			"showMethod": "fadeIn",//显示时的动画方式
			"hideMethod": "fadeOut" //消失时的动画方式
		};
	
	var url=$.cookie('STUDENT_URL');
	if (url == null || url == ""){
		url="/student/student-work";
	}
	$("#rightTable").load(url);
	var msg=$.cookie('msg');
	console.info(msg);
	if(msg!=null && msg !=""){
		toastr.success(msg);
		$.cookie('msg',null,{expires:-1,path:'/'});
	}
});
function turnTo(url){
	$("#rightTable").load(url);
	$.cookie('STUDENT_URL',null,{expires:-1,path:'/'});
	$.cookie('STUDENT_URL',url);
}
</script>
</head>
<body  style="overflow: hidden;">
	
	<!-- 导航栏  -->
  <nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation" style="padding-left:50px">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">杭商在线答题系统</a>
        </div>
        <div style="padding-right:100px">
            <form class="navbar-form navbar-right" role="search">
                <div class="form-group">
                    <span class="nav-link" style="color:#ffe6e6;">用户名：${student.sName }</span>
                </div>
                <a class="nav-link btn btn-primary" href="/student/logout">Sign out</a>
            </form>
        </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar" style="height:900px;top:50px;background-color:#222222;">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item">
                <a class="nav-link active" href="javascript:turnTo('/student/student-work')">
                  <span data-feather="home"></span>
                  我的作业 <span class="sr-only">(current)</span>
                </a>
              </li>
            </ul>
          
          </div>
        </nav>
        
        <div class="col-md-9 col-md-offset-3" style="margin: 50px 10px 0px;">
        	<div id="rightTable">
        	</div>
        </div>
      </div>
    </div>

</body>
</html>