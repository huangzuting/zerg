<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>关系列表</title>
<%@ include file="/common/common.jsp"%>
<script type="text/javascript">

$(function() {
	$("#inputForm").submit(function() {
		var flag = $(this).form('enableValidation').form('validate');
		if (flag) {
			var json = $("#inputForm").serializeArray();
			$.post("${ctx}/relation/bind.do", json, function(data) {
				if (data.status) {
					$.messager.alert('系统消息', data.msg, 'info', function() {
						parent.$('#grid').treegrid('reload');
						//ok后的回调方法，去关闭父页面的窗口元素
						parent.$('#${windowid}').window('close');
					});
				}else{
					$.messager.alert('系统消息', "操作失败", 'info');
					return;
				}
			}, "json");
		}
		//返回flase ，否则会提交表单
		return false;
	});

});
</script>
</head>
<body>
	<form id="inputForm" method="post">
		<input name="devId" class="easyui-combobox" name="dev"
			data-options="valueField:'id',textField:'text',url:'${ctx}/relation/dev-show.do'" />
		<input name="cardId" class="easyui-combobox" name="card"
			data-options="valueField:'id',textField:'text',url:'${ctx}/relation/card-show.do'" />
	</form>
	<a id="submit" href="#" onclick="$('#inputForm').submit()"
		class="easyui-linkbutton" data-options="iconCls:'icon-ok'">绑定</a>
</body>
</html>