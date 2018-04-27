<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师管理界面</title>
<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script> 
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
<script type="text/javascript" src="/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="https://cdn.bootcss.com/popper.js/1.14.1/esm/popper.min.js"></script>
<style type="text/css">

</style>

</head>
<body style="overflow: hidden;">
	
 <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">杭商在线答题系统</a>
	<ul class="navbar-nav px-3 col-md-1 " style="margin-left:auto;text-align: right;">
		<li class="nav-item text-nowrap">
		<span class="nav-link" style="color:#ffe6e6;"></span>
		</li>
	</ul>
      <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          <a class="nav-link" href="/teacher/logout">Sign out</a>
        </li>
      </ul>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar" style="position: absolute;height:100%;">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item">
                <a class="nav-link active" href="javascript:studentList()">
                  <span data-feather="home"></span>
                  发布作业 <span class="sr-only">(current)</span>
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="javascript:homeworkList()">
                  <span data-feather="file"></span>
                  题库管理
                </a>
              </li>
               <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="file"></span>
                  查看作业
                </a>
              </li>
            </ul>
          
          </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4" >
          <div class="table-responsive" style="overflow: hidden;">
            <table id="rightTable" class="table table-striped table-sm">
            	<!-- 发布作业页面 -->
           	<div id="studentList">
           		<div class="panel-body" style="padding-bottom:0px;">
			        
<!-- 查询区域 -->
  <form class="form-inner">
  <div class="row">
  	<label class="col-md-2  control-label" style="text-align: center;font-size: 20px">班级查询:</label>
  	<div class="col-md-2">
  		<select class="form-control">
  		</select>
  	</div>
    <button class="btn btn-primary" type="submit">查询</button>
    <button class="btn btn-primary" style="position: absolute;left: 80%">发布作业</button>
   </div>
   <div class="row" style="border-style:  solid;border-bottom: 1px;margin: 5px;border-color: #ddd9d9;"></div>
  </form>
<!-- end  -->
 				<div class="table-responsive">
				        <table class="table table-striped table-sm">
			        	<thead>
			        		<tr>
			        			<th>学号</th>
			        			<th>姓名 </th>
			        			<th>年级</th>
			        			<th>班级</th>
			        		</tr>
			        	</thead>
			        	<tbody id="studentInfo">
			        		
			        	</tbody>
			        </table>
			        </div>
            	</div>
            	</div>
				<!-- 题库管理页面 -->
				<div id="workManage" style="display:none;">
				
				</div>
				<!-- 查看作业页面 -->
				<div id="queryWork" style="display:none;">
				
				</div>
            </table>
          </div>
        </main>
      </div>
    </div>


<script type="text/javascript">
var sum=0;
function studentList() {
	if(sum==0){
	$.ajax({
		url:'/teacher/query',
		type:"POST",
		contentType:"application/json;charset=utf-8",
		dataType:"json",
		success:function(_data){
			//填充到选择框
			sum++;
			var selDom=$("#gradeAndClass");
			for(var i=0;i<_data.data.length;i++){
			selDom.append("<option value='"+_data.data[i]+"'>"+_data.data[i]+"</option>");
			}
		}
	});
	}
	$("#studentList").show();
}
function homeworkList() {
	$("#studentList").hide();
}
	/* $("#btn_query").click(function(){
		$.ajax(function(){
			url:'/teacher/list',
			data:$("#formSearch").serialize(),
			async:true,
			dataType:'json',
			success:function(data){
				$('#studentInfo').bootstrapTable({
				    url: data,
				    columns: [{
				        field: 'sId',
				        title: '学号'
				    }, {
				        field: 'sName',
				        title: '姓名'
				    }, {
				        field: 'sGrade',
				        title: '年级'
				    },{
				    	field:'sClass',
				    	title:'班级'
				    }]
				});
			}
		});
	});	 */
	function queryStudent(){
		$.post("/teacher/list",$("#formSearch").serialize(),function(data){
			if(data.status == 200){
				console.info(data.data);
				$('#studentInfo').bootstrapTable({
				    url: data.data,
				    columns: [{
				        field: 'sId',
				        title: '学号'
				    }, {
				        field: 'sName',
				        title: '姓名'
				    }, {
				        field: 'sGrade',
				        title: '年级'
				    },{
				    	field:'sClass',
				    	title:'班级'
				    }]
				});
			}else{
				alert("a");
			}
		});
	}
</script>


</body>
</html>