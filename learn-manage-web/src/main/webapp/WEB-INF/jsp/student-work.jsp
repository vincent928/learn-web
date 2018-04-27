<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生作业界面</title>
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
			token:$.cookie('TOKEN')
		};
		return temp;
	}; 
	$("#table-question").bootstrapTable('destroy');
	 $("#table-question").bootstrapTable({
			url:'/student/homeworklist',					//url
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
		            	formatter:function (value,row,index){
		            		return getDetail(value,row);
		            	}},  
		            {field:"type",title:"状态",align:"center",valign:"middle",sortable:"true",
		            	formatter: function (value, row, index) {  
	                    return changeFormat(value)  
	               	    }  
		            },  
		        ],  
		});
	
	

});
/*--------------------------------点击进入详情页面-------------------------------*/
function getDetail(value,row){
	var hId=row.hId;
	var type=row.type;
	var sId=row.sId;
	var qId=row.qId;
	if(type != '0'){
	return '<a href="javascript:detail(\''+hId+'\',\''+type+'\',\''+qId+'\')">'+value+'</a>';
	}else{
		return value;
	}
}

function detail(hId,type,qId){
	//根据type进入不同详情页
	if(type =='2'){
		//审批完成
		window.location.href ="/student/correctdetail?qId="+qId+"&hId="+hId;
	}else{
		window.location.href ="/student/homeworkdetail?qId="+qId+"&hId="+hId;
	}
}

/*-------------------------------toolbar----------------------------------------*/
 
var Index=0;
//新增
$("#btn_add").click(function(){
	var select = $("#table-question").bootstrapTable('getSelections');
	if(select.length < 1){
		toastr.warning("请选择一份作业");
		return false;
	}
	var qId=select[0].qId;
	var hId=select[0].hId;
	var type=select[0].type;
	console.info(select);
	if(type == '0'){
	window.location.href = "/student/tostudent?qId="+qId+"&hId="+hId;
	}else if(type == '3'){
		//修改答案
		window.location.href ="/student/updateHomeWork?qId="+qId+"&hId="+hId;
	}else{
		toastr.warning("该作业已无法修改");
		return false;
	}
});

//提交
$("#btn_edit").click(function(){
		var select = $("#table-question").bootstrapTable('getSelections');
		if(select.length < 1){
			toastr.warning("请选择需要提交的作业 ");
			return false;
		}
		var hId=select[0].hId;
		var type=select[0].type;
		if(type == '3'){
		$.ajax({
			url:'/student/submithomework',
			type:'post',
			data:{"hId":hId},
			dataType:'json',
			success:function(){
				$("#table-question").bootstrapTable('refresh',{silent: true});
				toastr.success("作业提交成功");
			}
		});
		}else{
			toastr.warning("作业非未提交状态");
			return false;
		}
});

/*---------------------------------END---------------------------------------------------------*/
 

  /*-----------------工具类js------------------------*/
        function changeFormat(cellval) {  
            if (cellval != null) {  
                var type = cellval;
                if(type == '0'){
                	return "<font color='red'>未完成</font>";
                }else if(type == '1'){
                	return "<font color='#337ab7'>已提交</font>";
                }else if(type == '2'){
                	return "<font color='green'>已审批</font>";
                }else{
                	return "<font color='#a413ff'>未提交</font>";
                }
            }  
        }  
  /*------------------END---------------------------*/
</script>

</head>
<body>
<!-- 作业页面 -->
<div id="questionList">
<!-- 学生作业列表 -->
			<div id="toolbar" class="btn-group">
	               <button id="btn_add" type="button" class="btn btn-default">
	                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>答题
	            </button>
	            <button id="btn_edit" type="button" class="btn btn-default">
	                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>提交
	            </button>
       		 </div>
			<table id="table-question" class="table table-striped table-bordered table-sm" >
		     </table>
		
   <!-- 学生作业列表end -->       
</div>





</body>
</html>