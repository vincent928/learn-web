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
	
	var queryParams = function (params){
		var temp ={						//这里的键名与controller参数保持一致
			sId:$("#studentId").val()
		};
		return temp;
	}; 
	$("#table-question").bootstrapTable('destroy');
	 $("#table-question").bootstrapTable({
			url:'/teacher/getstudentworklist',					//url
			method:'GET',							//请求方法
			dataType:'json',						//返回数据类型（*）
			contentType:"application/json;charset=utf-8",
			cache:false,							//是否开启缓存（*）
			striped: true, 							//是否启用行间隔色
			toolbar:'#toolbar',						//工具条
			queryParams:queryParams,	//传递参数（*）
			sidePagination:'client', 				//client客户端分页，server服务端分页（*）
			search: true,  							//是否显示表格搜索，此搜索是客户端搜索
			//height: 400, 							//行高，若不设置，表格自动调整
			pagination: true,  						//是否启用分页（*）
		    pageSize: 10,  							//每页的记录行数
		    pageNumber:1,							//初始化加载第一页，默认为1
		    pageList: [10, 20],				 	//可供选择的每页行数
		    clickToSelect: true, 					//是否启用点击选中行
		    singleSelect:true,						//设置为true，禁止多选
		    columns:   
		        [  
		            {field:"checked",checkbox:true},  
		            {field:"qId",title:"题库编号",align:"center",valign:"middle",sortable:"true"},  
		            {field:"qTitle",title:"试题标题",align:"center",valign:"middle",sortable:"true",
		            		formatter:function(value,row,index){
		            			return getDetail(value,row);
		            		}
		            },  
		            {field:"type",title:"状态",align:"center",valign:"middle",sortable:"true",
		            	formatter: function (value, row, index) {  
	                    return changeFormat(value)  
	               	    }  
		            },  
		        ],  
		});
	 
	 var msg=$.cookie('msg');
		console.info(msg);
		if(msg!=null && msg !=""){
			toastr.success(msg);
			$.cookie('msg',null,{expires:-1,path:'/'});
		}
	 
	 
	 $("#btn_edit").click(function(){
		 var select = $("#table-question").bootstrapTable('getSelections');
			if(select.length < 1){
				toastr.warning("请选择需要审批的作业 ");
				return false;
			}
			var hId=select[0].hId;
			var type=select[0].type;
			var qId=select[0].qId;
			var sId=$("#studentId").val();
			if(type == '2'){
				toastr.warning("已审批完成,请选择其他作业");
				return false;
			}
			window.location.href ="/teacher/correctHomeWork?qId="+qId+"&hId="+hId+"&sId="+sId;
			
		});
	 
});

var sum=0; //用于计算点击左侧同一菜单次数，为0则不调用ajax加载
function turnTo(url){
	$("#rightTable").load(url);
	$.cookie('TEACHER_URL',null,{expires:-1,path:'/'});
	$.cookie('TEACHER_URL',url);
}


/*--------------------------作业审批-------------------------------------------*/
function getDetail(value,row){
	var hId=row.hId;
	var type=row.type;
	var sId=row.sId;
	var qId=row.qId;
	if(type == '2'){
	return '<a href="javascript:detail(\''+hId+'\',\''+qId+'\')">'+value+'</a>';
	}else{
		return value;
	}
}

function detail(hId,qId){
	//审批完成
	window.location.href ="/teacher/correctdetail?qId="+qId+"&hId="+hId;
}

/*--------------------------------js工具方法-----------------------------------*/
    function changeFormat(cellval) {  
            if (cellval != null) {  
                var type = cellval;
               if(type == '1'){
                	return "<font color='red'>未审批</font>";
                }else if(type == '2'){
                	return "<font color='green'>已审批</font>";
                }
            }  
        }  
 /*-------------------------------end------------------------------------------*/
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
        		<!-- 作业页面 -->
					<div id="questionList">
					<!-- 学生作业列表 -->
					<div class="row">
						<div class="form-group">
							<label class="label-control" style="margin: 20px 0px 0px 20px">学生姓名：${student.sName }</label>
						</div>
					</div> 
								<div id="toolbar" class="btn-group">
						            <button id="btn_edit" type="button" class="btn btn-default">
						                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>审批
						            </button>
					       		 </div>
								<table id="table-question" class="table table-striped table-bordered table-sm" >
						            <input type="hidden" id="studentId" name="studentId" value="${sId }">
							     </table>
							
					   <!-- 学生作业列表end -->       
					</div>
        	</div>
        </div>
        
        
        
      </div>
    </div>

</body>
</html>