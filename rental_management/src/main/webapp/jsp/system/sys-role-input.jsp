<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
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
				$.post("${ctx}/systemrole/role-saveOrUpdate.do", json, function(data) {
					if (data.status) {
						$.messager.alert('系统消息', data.msg, 'info', function() {
							parent.$('#grid').datagrid('reload');
							//ok后的回调方法，去关闭父页面的窗口元素
							parent.$('#${windowid}').window('close');
						});
					}
				}, "json");
			}
			//返回flase ，否则会提交表单
			return false;
		});
		$('#status').combobox('setValues', ['${model.status}']);
	});
</script>
</head>
<body>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center',border:false" style="padding: 10px;">
			<form action="${ctx}/systemrole/role-saveOrUpdate.do" id="inputForm" method="post" enctype="multipart/form-data">
			    <input type="hidden" name="id" value="${model.id }">
				<table>
					<tr>
						<td>角色名称</td>
						<td><input type="text" name="roleName" class="easyui-textbox" data-options="required:true" value="${model.roleName }"></input></td>
					</tr>
					<tr>
						<td>角色编码</td>
						<td><input type="text" name="flag" class="easyui-textbox" data-options="required:true" value="${model.flag }"></input></td>
					</tr>
					<tr>
						<td>状态</td>
						<td><select id="status" name="status" class="easyui-combobox" data-options="required:true">
								<option value="1">有效</option>
								<option value="0">无效</option>
						</select></td>
					</tr>
				</table>
			</form>

		</div>
		<div data-options="region:'south',border:false" style="text-align: right; margin-bottom: 0px; padding: 5px; background-color: #D3D3D3">
			<a id="submit" href="#" onclick="$('#inputForm').submit()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提交</a> <a id="close"
				href="#" onclick="parent.$('#${windowid}').window('close')" class="easyui-linkbutton" data-options="iconCls:'icon-no'">关闭</a>
		</div>
	</div>
</body>
</html>