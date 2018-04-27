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
	//toastr init()
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
			token:$.cookie('TOKEN'),
			isUse:'1'					//0：弃用 1：启用
		};
		return temp;
	}; 
	$("#table-question").bootstrapTable('destroy');
	 $("#table-question").bootstrapTable({
			url:'/teacher/questionlist',					//url
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
		   // singleSelect:true,						//设置为true，禁止多选
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
	
	

});

/*-------------------------------toolbar----------------------------------------*/
 
var Index=0;
//新增
$("#btn_add").click(function(){
	/* $("#addQuestion").modal('show');
	Index=0; */
	$.ajax({
		url:'/teacher/toteacher',
		type:'GET',
		async:false,
		success:function(result){
			if(result.status==200){
				  window.location.href = "/teacher/teacher-add";
			}
		}
	});
});
//新增选择题
function addchoose(){
	var row="<div name='choose'>"+"<tr><td><label>"+(Index+1)+"、</label><input type='text' placeholder='题目内容' class='form-control'>"
			+"</td></tr><tr><td><label>A、</label><input type='text' placeholder='A内容' class='form-control'></td></tr>"
			+"<tr><td><label>B、</label><input type='text' placeholder='B内容' class='form-control'></td></tr>"
			+"<tr><td><label>C、</label><input type='text' placeholder='C内容' class='form-control'></td></tr>"
			+"<tr><td><label>D、</label><input type='text' placeholder='D内容' class='form-control'></td></tr>"
			+"<tr><td><label>正确答案为:</label><select class='form-control'><option key='A'>A</option><option key='B'>B</option>"
			+"<option key='C'>C</option><option key='D'>D</option></select></td></tr>"
			+"<tr><td><br></td></tr></div>";
	$("#questionList").html(row);
	Index++;
}

//修改
$("#btn_edit").click(function(){
	var select = $("#table-question").bootstrapTable('getSelections');
	if(select.length != 1){
		toastr.warning("请选择一条数据进行修改");
		return false;
	}
});


//删除
$("#btn_delete").click(function(){
		var select = $("#table-question").bootstrapTable('getSelections');
		if(select.length < 1){
			toastr.warning("请至少选择一条数据");
			return false;
		}
		$("#myModal").modal('show');
});

 function deleteQuestion(){
	var select = $("#table-question").bootstrapTable('getSelections');
	var ids="";
	for(var i=0 ; i < select.length ; i++){
		ids+=select[i].id+",";
	}
	ids = ids.substr(0,ids.length-1);
	$.ajax({
		url:'/teacher/deleteQuestion',
		type:"GET",
		contentType:"application/json;charset=utf-8",
		data:{ids:ids},
		dataType:"json",
		success:function(_data){
			if(_data.status == 200){
				$('#myModal').modal('hide');
				$("#table-question").bootstrapTable('refresh',{silent: true});
				toastr.success("删除成功");
			}
		}
	});
} 
/*---------------------------------END---------------------------------------------------------*/
 

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
  /*------------------END---------------------------*/
</script>

</head>
<body>
<!-- 发布作业页面 -->
<div id="questionList">
<!-- 查询end -->
<!-- 学生列表 -->
			<div id="toolbar" class="btn-group">
	               <button id="btn_add" type="button" class="btn btn-default">
	                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
	            </button>
	            <button id="btn_delete" type="button" class="btn btn-default">
	                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
	            </button>
       		 </div>
			<table id="table-question" class="table table-striped table-bordered table-sm" >
		     </table>
		
   <!-- 学生列表end -->       
</div>


<!-- 发布作业的模态框 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
   <div class="modal-dialog" role="document">
    <div class="modal-content">
      <!-- 模态框头部 -->
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        	<span aria-hidden="true">&times;</span>
        </button>
        <h4 class="modal-title" id="ModalLabel"><font style="color:red;">警告</font></h4>
      </div>
      <!-- 模态框主体 -->
      <div class="modal-body">
      	<p>确定删除选中数据吗?</p>
      </div>
      <!-- 模态框底部 -->
      <div class="modal-footer">
      	<input type="button" class="btn btn-primary" onclick="deleteQuestion()" value="确定"/>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
      </div>
    </div>
  </div>
</div>

<!-- 新增题型模态框 -->
<div class="modal fade" id="addQuestion" tabindex="-1" role="dialog" aria-labelledby="QuestionLabel" aria-hidden="true">
   <div class="modal-dialog" role="document">
    <div class="modal-content">
      <!-- 模态框头部 -->
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        	<span aria-hidden="true">&times;</span>
        </button>
        <h4 class="modal-title" id="QuestionLabel"><font style="color:green;">新增题库</font></h4>
      </div>
      <!-- 模态框主体 -->
      <div class="modal-body" style="height: 500px;overflow: auto;">
      	<form action="" >
      		<div class="form-group">
      			<label>题库标题:</label>
      			<input type="text" class="form-control" id="title" placeholder="题库标题">
      		</div>
  			<table id="questionList" class="form-inline">
  			</table>
     	</form>
      </div>
     
      <!-- 模态框底部 -->
      <div class="modal-footer">
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
      	<input type="button" class="btn btn-primary" onclick="saveNewQuestion()" value="保存"/>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
      </div>
    </div>
  </div>
</div>

</body>
</html>