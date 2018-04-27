<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师审批界面</title>
<link rel="stylesheet" type="text/css" href="/css3/bootstrap.min.css">
<link rel="stylesheet" href="/css/bootstrap-table.min.css"> 
<link rel="stylesheet" href="/css/toastr.min.css">
<script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.12.4/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/js3/bootstrap.min.js" ></script>
<script type="text/javascript" src="/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="/js/toastr.min.js"></script>
</head>
<script type="text/javascript">
var sum=0;
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
	var num=1;
	$("label[name='Q_index']").each(function(){
		$(this).html(num+"、");
		num++;
	});

});
function turnTo(url){
	$("#rightTable").load(url);
	$.cookie('TEACHER_URL',null,{expires:-1,path:'/'});
	$.cookie('TEACHER_URL',url);
}

//提交表单
function saveQuestion(){
	if(checkForm()){
		return ;
	$("#newQuestion").submit();
	}
}
//表单验证
function checkForm(){
	var flag=true;
	var scop=$("#scope").val();
	var number=/^\+?[1-9]\d{0,2}?$/;
	var result=number.test(scop);
	if(scop == ""||scop == null){
		toastr.warning("请输入作业分数");
		flag=false;
		return flag;
	}else if(!result){
		toastr.warning("请输入正整数")
		flag=false;
		return flag;
	}else if(Number(scop)>100){
		toastr.warning("分数应小于等于100分")
		flag=false;
		return flag;	
	}
	
	return flag;
}

</script>
<body  style="overflow: hidden;">
	<!-- 导航栏  -->
  <nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation" style="padding-left:50px">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">杭商在线答题系统</a>
        </div>
        <div style="padding-right:100px">
            <div class="navbar-form navbar-right" role="search">
                <div class="form-group">
                    <span class="nav-link" style="color:#ffe6e6;">用户名：${teacher.tName }</span>
                </div>
                <a class="nav-link btn btn-primary" href="/teacher/logout">Sign out</a>
            </div>
        </div>
    </nav>
 	
 	  <div class="container-fluid">
      <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar" style="height:900px;top:50px;background-color:#222222;">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
                          <li class="nav-item">
                <a class="nav-link active" href="javascript:turnTo('/teacher/teacher-query')">
                  <span data-feather="home"></span>
                  学生管理 <span class="sr-only">(current)</span>
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="javascript:turnTo('/teacher/teacher-work')">
                  <span data-feather="file"></span>
                  题库管理
                </a>
              </li>
            </ul>
          
          </div>
        </nav>
        
        <div class="col-md-9 col-md-offset-3" style="margin: 50px 10px 0px;">
        	<div id="rightTable">
        		<div class="form-group">
        		<input onclick="saveQuestion()" type="button" class="btn btn-primary" style="float: right;" value="审批完成 "/>
        		<h3><span class="glyphicon glyphicon-align-justify" style="color:#3b7e3b;"/><font style="color:green;">作业审批</font></h3>
        		</div>
        		 <div class="row" style="border-style:  solid;border-bottom: 1px;margin: 5px;border-color: #d3d3d3;height:1px;"/>
        		 <form id="newQuestion" action="/teacher/correct" method="post" style="height: 600px;overflow-y: auto;overflow-x:hidden; " >
        		 <input type="hidden" name="hId" id="hId" value="${hId }">
        		 <input type="hidden" name="qId" id="qId" value="${qId }">
        		 <input type="hidden" name="sId" id="sId" value="${sId }">
        		 <div class="form-inline" style="margin-top: 20px;">
        		 	<div class="row">
        		 		<div class="form-group col-md-4 col-md-offset-3" style="margin-bottom: 40px;">
			      			<label>题库标题:</label>
			      			<input type="text" class="form-control" id="title" name="title" placeholder="题库标题" readonly="readonly" value="四月中旬考题">
			      		</div>
			      		<div>
			      			<label>分数：</label>
			      			<input type="text" class="form-control" id="scope" name="scope" placeholder="分数">
			      		</div>
        		 	</div>
        		 </div>
        		 <div class="form-body">
					<table id="questionList" class="form-inline">
						<!-- 题目列表 -->
						<!-- 选择题 -->
						<c:forEach items="${chooseList }" var="choose" varStatus="ch">
							<tr>
								<td>
									<label name="Q_index"></label><input type="text" readonly="readonly" value="${choose.xzTitle }" class="form-control" style="width: 400px!important;">
								</td>
								<td>
								<label>答案：</label>
									<input type="text" id="choose${ch.index }" name="choose${ch.index }" readonly="readonly" 
									class="form-control" value="${choose.xzCurrent}" 
									<c:choose>
										<c:when test="${choose.xzCurrent eq theXZ[ch.count-1].xzCurrent }">
										style="width: 50px!important;background-color:#a2f3a2;" 
										</c:when>
										<c:otherwise>
										style="width: 50px!important;background-color:#f67c7c" 
										</c:otherwise>
									</c:choose> >
								</td>
								<td>
									<label>正确答案：</label>
									<input type="text" readonly="readonly" 
									class="form-control" value="${theXZ[ch.count-1].xzCurrent}" style="width: 50px!important;">
								</td>
							</tr>
							<tr>
								<td>
									<label>A、</label><input type="text"  readonly="readonly" class="form-control" value="${choose.xzA }" style="width: 400px!important;">
								</td>
							</tr>
							<tr>
								<td>
									<label>B、</label><input type="text"  readonly="readonly" class="form-control" value="${choose.xzB }" style="width: 400px!important;">
								</td>
							</tr>
							<tr>
								<td>
									<label>C、</label><input type="text"  readonly="readonly" class="form-control" value="${choose.xzC }" style="width: 400px!important;">
								</td>
							</tr>
							<tr>
								<td>
									<label>D、</label><input type="text"  readonly="readonly" class="form-control" value="${choose.xzD }" style="width: 400px!important;">
								</td>
							</tr>
							<tr><td><br></td></tr>
						</c:forEach>
						<!-- 判断题 -->
						<c:forEach items="${judgmentList }" var="judg" varStatus="ju">
						<tr>
							<td>
								<label name="Q_index"></label><input type="text" readonly="readonly" class="form-control" value="${judg.pdTitle }" style="width: 400px!important;">
							</td>
							<td>
								<label>答案：</label>
									<input type="text" id="judg${ju.index }" name="judg${ju.index }" readonly="readonly" 
									class="form-control" value="${judg.pdCurrent}" 
									<c:choose>
										<c:when test="${judg.pdCurrent eq theJU[ju.count-1].pdCurrent }">
										style="width: 50px!important;background-color:#a2f3a2;" 
										</c:when>
										<c:otherwise>
										style="width: 50px!important;background-color:#f67c7c" 
										</c:otherwise>
									</c:choose>
									>
								</td>
							<td>
								<label>正确答案：</label>
								<input type="text"  readonly="readonly" 
									class="form-control" value="${theJU[ju.count-1].pdCurrent}" style="width: 50px!important;">
							</td>
						</tr>
						<tr>
							<td>
								<label>A、</label><input type="text" readonly="readonly" class="form-control" value="${judg.pdA }" style="width: 400px!important;">
							</td>
						</tr>
						<tr>
							<td>
								<label>B、</label><input type="text" readonly="readonly" class="form-control" value="${judg.pdB }" style="width: 400px!important;">
							</td>
						</tr>
						<tr><td><br></td></tr>
						</c:forEach>
						<!-- 主观题 -->
						<c:forEach items="${cuList }" var="sub" varStatus="su">
						<tr>
							<td>
								<label name="Q_index"></label><input type="text" readonly="readonly" class="form-control" value="${sub.zgTitle }" style="width: 400px!important;">
							</td>
						</tr>
						<tr>
							<td>
								<label></label><textarea id="subj${su.index}" name="subj${su.index }" 
								 class="form-control" rows="5" cols="60" readonly="readonly">${sub.sAnswer }</textarea>
							</td>
						</tr>
						<tr><td><br></td></tr>
						</c:forEach>
					</table>
        		 </div>
        		 </form>
        	</div>
        </div>
      </div>
    </div>

</body>
</html>