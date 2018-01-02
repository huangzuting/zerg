<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增角色</title>
<%@ include file="/common/common.jsp"%>
<script>
 

$(function() {
	$("#inputForm").submit(function() {
		var flag = $(this).form('enableValidation').form('validate');
		if (flag) {
			var json = $("#inputForm").serializeArray();
			$.post("${ctx}/address/addhouse.do", json, function(data) {
				if (data.status) {
					$.messager.alert('系统消息', data.msg, 'info', function() {
						parent.$('#grid').treegrid('reload');
						//ok后的回调方法，去关闭父页面的窗口元素
						parent.$('#${windowid}').window('close');
					});
				}else{
					$.messager.alert('系统消息', "请选择县级或县级以下", 'info');
					return;
				}
			}, "json");
		}
		//返回flase ，否则会提交表单
		return false;
	});

	$('#pid').combotree({    
	    url: '${ctx}/address/tree.do',    
	    required: true   
	});  
});

</script>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
<div data-options="region:'center',border:false" style="padding: 10px;">
<form action="" id="inputForm" method="post" class="easyui-form" data-options="novalidate:true" >
<input type="hidden" name="id" value="${id}">
<table>
	<tr>
		<td>地址名称</td>
		<td><input type="text" value="" name="name" class="easyui-textbox" data-options="required:true"></input></td>
	</tr>
	<tr>
		<td>父级地址</td>
		<td><input id="pid" type="text" value="${id}" name="pid" class="easyui-textbox" data-options="required:true"></input></td>
	</tr>
</table>
</form>
</div>
<div data-options="region:'south',border:false" style="text-align: right; margin-bottom:0px; padding: 5px; background-color: #D3D3D3">
<a id="submit" href="#" onclick="$('#inputForm').submit()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提交</a>  
<a id="close" href="#" onclick="parent.$('#${windowid}').window('close')" class="easyui-linkbutton" data-options="iconCls:'icon-no'">关闭</a>  
</div>
</div>
</body>
</html>