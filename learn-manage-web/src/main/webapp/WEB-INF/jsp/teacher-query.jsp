<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师管理界面</title>
<style type="text/css">
</style>
<script type="text/javascript">

$(document).ready(function(){
	//初始化提示框
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
	
	
	if(sum==0){
		$.ajax({
			url:'/teacher/query',
			type:"POST",
			contentType:"application/json;charset=utf-8",
			dataType:"json",
			success:function(_data){
				//填充到选择框
				var selDom=$("#gradeAndClass");
				for(var i=0;i<_data.data.length;i++){
				selDom.append("<option value='"+_data.data[i]+"'>"+_data.data[i]+"</option>");
				}
			}
		});
		}
	
});

/*-------------------------------表格初始化----------------------------------------*/
//学生表
var TableInit = function (){
	var oTableInit =new Object();
	//初始化table
	oTableInit.Init = function (){
		$("#table-student").bootstrapTable({
			url:'/teacher/list',					//url
			method:'GET',							//请求方法
			dataType:'json',						//返回数据类型（*）
			contentType:"application/json;charset=utf-8",
			cache:false,							//是否开启缓存（*）
			striped: true, 							//是否启用行间隔色
			// toolbar:'#toolbar',						//工具条
			queryParams: oTableInit.queryParams,	//传递参数（*）
			sidePagination:'client', 				//client客户端分页，server服务端分页（*）
			search: true,  							//是否显示表格搜索，此搜索是客户端搜索
			height: 400, 							//行高，若不设置，表格自动调整
			pagination: true,  						//是否启用分页（*）
		    pageSize: 15,  							//每页的记录行数
		    pageNumber:1,							//初始化加载第一页，默认为1
		    pageList: [10, 20, 50],				 	//可供选择的每页行数
		    clickToSelect: true, 					//是否启用点击选中行
		  //  singleSelect:true,						//设置为true，禁止多选
		    columns:   
		        [  
		            {field:"checked",checkbox:true},  
		            {field:"sId",title:"学号",align:"center",valign:"middle",sortable:"true"},  
		            {field:"sName",title:"姓名",align:"center",valign:"middle",sortable:"true",
		            	formatter: function (value, row, index) {  
	                    return changeFormat(value,row);  
               	    	}  
		            },  
		            {field:"sGrade",title:"年级",align:"center",valign:"middle",sortable:"true"},  
		            {field:"sClass",title:"班级",align:"center",valign:"middle",sortable:"true"},  
		        ],  
		});
	};
	//得到查询的参数
	oTableInit.queryParams = function (params){
		var grade=encodeURI($("#gradeAndClass").val());   //中文参数.encode编码,后台解码
		var temp ={						//这里的键名与controller参数保持一致
			//limit:params.limit,			//页面大小
			//offset:params.offset,       //页码
			gradeAndClass:grade
		};
		return temp;
	};
	return oTableInit;
};

//题库表
var QuestionInit = function (){
	var qTableInit =new Object();
	//初始化qTableInit
	qTableInit.Init = function (){
		$("#table-question").bootstrapTable({
			url:'/teacher/questionlist',					//url
			method:'GET',							//请求方法
			dataType:'json',						//返回数据类型（*）
			contentType:"application/json;charset=utf-8",
			cache:false,							//是否开启缓存（*）
			striped: true, 							//是否启用行间隔色
			// toolbar:'#toolbar',						//工具条
			queryParams: qTableInit.queryParams,	//传递参数（*）
			sidePagination:'client', 				//client客户端分页，server服务端分页（*）
			search: true,  							//是否显示表格搜索，此搜索是客户端搜索
			height: 400, 							//行高，若不设置，表格自动调整
			pagination: true,  						//是否启用分页（*）
		    pageSize: 10,  							//每页的记录行数
		    pageNumber:1,							//初始化加载第一页，默认为1
		    pageList: [10, 20],				 	//可供选择的每页行数
		    clickToSelect: true, 					//是否启用点击选中行
		    singleSelect:true,						//设置为true，禁止多选
		    columns:   
		        [  
		            {field:"checked",checkbox:true},  
		            {field:"id",title:"试题编号",align:"center",valign:"middle",sortable:"true"},  
		            {field:"title",title:"试题标题",align:"center",valign:"middle",sortable:"true"},  
		            {field:"createTime",title:"创建时间",align:"center",valign:"middle",sortable:"true",
		            	formatter: function (value, row, index) {  
	                    return changeDateFormat(value)  
	               	    }  
		            },  
		            {field:"note",title:"备注",align:"center",valign:"middle",sortable:"true"},  
		        ],  
		});
	};
	//得到查询的参数
	qTableInit.queryParams = function (params){
		var temp ={						//这里的键名与controller参数保持一致
			token:$.cookie('TOKEN'),
			isUse:'1'					//0：弃用 1：启用
		};
	
		return temp;
	};
	return qTableInit;
};

/*---------------------------------END---------------------------------------------------------*/
 function queryStudent(){
	 $("#table-student").bootstrapTable('destroy');    //在初始化table之前，要将table销毁，否则会保留上次加载的内容
	 var oTable = new TableInit();
	    oTable.Init();
	} 
 
 //-------------发布作业-------------------
  function homework(){
	  $("#table-question").bootstrapTable('destroy');
		 var qTable = new QuestionInit();
		    qTable.Init();
		
 } 
  function sendHomeWork(){
	  var gradeAndClass=$("#gradeAndClass").val();
	  console.info(gradeAndClass);
	  var select = $("#table-question").bootstrapTable('getSelections');
		console.info(select);
		var id=select[0].id;
		var title=select[0].title;
		if(select.length < 1){
			toastr.warning("请选择一份试题");
			return false;
		}
		//发布作业
		$.post('/teacher/sendHomeWork',{"gradeAndClass":gradeAndClass,"id":id,"title":title},function(data){
			if(data.status==200){
				$("#myModal").modal('hide');
				toastr.success("作业发布成功");
			}
		});
  }
  
  function detail(sId){
	  window.location.href = "/teacher/teacher-worklist?sId="+sId;
  }
  /*-----------------工具类js------------------------*/
  //修改——转换日期格式(时间戳转换为datetime格式)  
        function changeDateFormat(cellval) {  
            if (cellval != null) {  
                var date = new Date(parseInt(cellval));  
                var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;  
                var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate(); 
                var Hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
                var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes(); 
                return date.getFullYear() + "-" + month + "-" + currentDate + " " + Hours + ":" + minutes;  
            }  
        }  
  		function changeFormat(value,row){
  			var sId=row.sId;
  			//点击名字，可以进入详情面
  			return '<a href="javascript:detail(\''+sId+'\')">'+value+'</a>';
  		}
  /*------------------END---------------------------*/
</script>

</head>
<body>
<!-- 发布作业页面 -->
<div id="studentList">
 <div class="panel-body" style="padding-bottom:0px;">
    <!-- 查询区域 -->
	<form class="form-inner" id="formSearch">
	   <div class="row">
		 <label class="col-md-2  control-label" style="text-align: center;font-size: 20px">班级查询:</label>
		  	<div class="col-md-2">
		  	   <select id="gradeAndClass" name="gradeAndClass" class="form-control">
		  	   </select>
		  	</div>
		    <input type="button" class="btn btn-primary" onclick="queryStudent()" value="查询"/>
		    <input class="btn btn-primary" type="button" data-toggle='modal' data-target='#myModal' style="position: absolute;left: 80%" onclick="homework()" value="发布作业">
	   </div>
	   <div class="row" style="border-style:  solid;border-bottom: 1px;margin: 5px;border-color: #ddd9d9;"/>
	 </form>
<!-- 查询end -->
<!-- 学生列表 -->
		<div class="table-responsive">
			<table id="table-student" class="table table-striped table-bordered table-sm" >
		     </table>
		</div>
		
   <!-- 学生列表end -->       
 </div>
</div>


<!-- 模态框 -->
<!-- 模态框 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
   <div class="modal-dialog" role="document">
    <div class="modal-content">
      <!-- 模态框头部 -->
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        	<span aria-hidden="true">&times;</span>
        </button>
        <h4 class="modal-title" id="ModalLabel">发布作业</h4>
      </div>
      <!-- 模态框主体 -->
      <div class="modal-body">
      		<table id="table-question">
      		</table>
      </div>
      <!-- 模态框底部 -->
      <div class="modal-footer">
      	<input type="button" class="btn btn-primary" onclick="sendHomeWork()" value="发布作业"/>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
      </div>
    </div>
  </div>
</div>


</body>
</html>