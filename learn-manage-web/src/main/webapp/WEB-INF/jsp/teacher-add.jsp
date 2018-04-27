<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师管理界面</title>
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
	
});

var sum=0; //用于计算点击左侧同一菜单次数，为0则不调用ajax加载
function turnTo(url){
	$.cookie('TEACHER_URL',null,{expires:-1,path:'/'});
	$.cookie('TEACHER_URL',url);
	$("#rightTable").load(url);
	
}
//新增选择题
var Index=0; //题号
var xz_num=0; //选择题号
var pd_num=0; //判断题号
var zg_num=0; //主观题号
function addchoose(){
	var row="<tr><td>"
			+"<label>"+(Index+1)+"、</label><input type='text' id='xz_title"+xz_num+"' name='xz_title"+xz_num+"'  placeholder='题目内容' class='form-control'>"
			+"</td></tr>"
			+"<tr><td><label>A、</label><input type='text' id='xz_A"+xz_num+"' name='xz_A"+xz_num+"'  placeholder='A内容' class='form-control'></td></tr>"
			+"<tr><td><label>B、</label><input type='text' id='xz_B"+xz_num+"' name='xz_B"+xz_num+"'  placeholder='B内容' class='form-control'></td></tr>"
			+"<tr><td><label>C、</label><input type='text' id='xz_C"+xz_num+"' name='xz_C"+xz_num+"'  placeholder='C内容' class='form-control'></td></tr>"
			+"<tr><td><label>D、</label><input type='text' id='xz_D"+xz_num+"' name='xz_D"+xz_num+"' placeholder='D内容' class='form-control'></td></tr>"
			+"<tr><td><label>正确答案为:</label><select id='xz_current"+xz_num+"' name='xz_current"+xz_num+"' class='form-control'><option key='A'>A</option><option key='B'>B</option>"
			+"<option key='C'>C</option><option key='D'>D</option></select></td></tr>"
			+"<tr><td><br></td></tr>";
	$("#questionList").append(row);
	Index++;
	xz_num++;
}
//新增判断题
function addjudgment() {
	var row="<tr><td>"
			+"<laber>"+(Index+1)+"、</label><input type='text' id='pd_title"+pd_num+"' name='pd_title"+pd_num+"' placeholder='题目内容' class='form-control'>"
			+"</td></tr>"
			+"<tr><td><label>A、</label><input type='text' id='pd_A"+pd_num+"' name='pd_A"+pd_num+"' placeholder='A内容' class='form-control'></td></tr>"
			+"<tr><td><label>B、</label><input type='text' id='pd_B"+pd_num+"' name='pd_B"+pd_num+"' placeholder='B内容' class='form-control'></td></tr>"
			+"<tr><td><label>正确答案为:</label><select id='pd_current"+pd_num+"' name='pd_current"+pd_num+"' class='form-control'><option key='A'>A</option><option key='B'>B</option>"
			+"</select></td></tr>"
			+"<tr><td><br></td></tr>";
	$("#questionList").append(row);
	Index++;
	pd_num++;
}

//新增主观题
function addsubject(){
	var row="<tr><td>"
			+"<label>"+(Index+1)+"、</label><input type='text' id='zg_title"+zg_num+"' name='zg_title"+zg_num+"' placeholder='题目内容' class='form-control'>"
			+"</td></tr>"
			+"<tr><td><br></td></tr>"
	$("#questionList").append(row);
	Index++;	
	zg_num++;		
}


//表单提交
function saveQuestion() {
	//表单验证
	if(checkForm()){
		$("#chooseNum").val(xz_num);
		$("#judgmentNum").val(pd_num);
		$("#subjectNum").val(zg_num);
		$("#newQuestion").submit();
	}
}

//表单验证
function checkForm(){
	var flag=true;
	$(":text").each(function(){
		if($(this).val() == "" || $(this).val()==null){
			console.info($(this).val());
			toastr.warning("输入框不能为空");
			flag=false;
			return flag;
		}
	});
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
        		<input onclick="saveQuestion()" type="button" class="btn btn-primary" style="float: right;" value="保存 "/>
        		<h3><span class="glyphicon glyphicon-align-justify" style="color:#3b7e3b;"/><font style="color:green;">新增题库</font></h3>
        		</div>
        		 <div class="row" style="border-style:  solid;border-bottom: 1px;margin: 5px;border-color: #d3d3d3;height:1px;"/>
        		 <form id="newQuestion" action="/teacher/saveQuestion" method="post" style="height: 500px;overflow-y: auto;overflow-x:hidden; ">
        		 <input type="hidden" name="chooseNum" id="chooseNum" value="">
        		 <input type="hidden" name="judgmentNum" id="judgmentNum" value="">
        		 <input type="hidden" name="subjectNum" id="subjectNum" value="">
        		 <div class="form-inline" style="margin-top: 20px;">
        		 	<div class="row">
        		 		<div class="form-group col-md-6 col-md-offset-4">
			      			<label>题库标题:</label>
			      			<input type="text" class="form-control" id="title" name="title" placeholder="题库标题">
			      		</div>
        		 	</div>
        		 </div>
        		 <div class="form-body">
					<table id="questionList" class="form-inline">
					</table>
					<div class="form-group">
					<label class="form-inline">备注:</label>
					<textarea id="note" name="note" class="form-control" rows="3" cols="20"></textarea>
					</div>
        		 </div>
        		 </form>
        		  <div class="button-group" style="height: 40px;">
        		   <div class="form-group">
	      			<div class="col-md-2">
	      			<input type="button" class="btn btn-primary" onclick="addchoose()" value="新增选择题">
	      			</div>
	      			<div class="col-md-2">
	      			<input type="button" class="btn btn-primary" onclick="addjudgment()" value="新增判断题">
	      			</div>
	      			<div class="col-md-2">
	      			<input type="button" class="btn btn-primary" onclick="addsubject()" value="新增主观题">
      				</div>
      			   </div>
        		 </div>
        	</div>
        </div>
        
        
        
      </div>
    </div>

</body>
</html>