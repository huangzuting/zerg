<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>设备列表</title>
<%@ include file="/common/common.jsp"%>
<script type="text/javascript">
	$(function() {
		var pager = $('#grid').datagrid('getPager');
		pager.pagination({
			buttons : [{
				text : '新增',
				iconCls : 'icon-add',
				handler : function() {
				var url = '${ctx}/dev/dev-input.do';
				open('新增设备信息', url, 600, 480);
				}
			},'-',{
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
				var row = $('#grid').datagrid('getSelected');
				if (!row) {$.messager.alert('系统消息','请选择一条记录进行修改！', 'info');
					return;
				}
				var url = '${ctx}/dev/dev-input.do?id='+ row.id;
					open('修改设备信息', url, 600, 480);
				}
				},
				'-',{
					text : '删除',
					iconCls : 'icon-remove',
					handler : function() {
						var row = $('#grid').datagrid('getSelected');
						if (!row) {
							$.messager.alert('系统消息', "请选择...", 'info');
							return;
						}
						$.messager.confirm('确认对话框', '确认你是否要删除数据？', function(r) {
							if (r) {
								$.post("${ctx}/dev/dev-delete.do", {
									'id' : row.id
								}, function(data) {
									if (data.status) {
										$.messager.alert('系统消息', data.msg, 'info',
											function() {
												//重新加载
												parent.$('#grid').datagrid('reload');
												//清除所有选择的行。	
												parent.$('#grid').datagrid(
														'clearSelections');
											});
									}else{
										$.messager.alert('系统消息', "删除失败", 'info');
									}
								}, "json");
							}
						});
					}
					}]
				});
	
		//条件查询
		$("#search").click(function() {
			$('#grid').datagrid('reload', {
				username : $("#username").val(),
				departmentId : $('#departmentId').combo('getValue')
			});
		});

	});
</script>
</head>
<body>

	<table id="grid" title="设备管理" class="easyui-datagrid" style="width: 100%; height: 100%"
		data-options="fit:true,fitColumns:true,singleSelect:false,rownumbers:true,url:'${ctx}/dev/list.do',pagination:true,toolbar:'#tb',checkbox:true,checkOnSelect:true">
		<thead>
			<tr>
				<th data-options="field:'id',checkbox:true"></th>
				<th data-options="field:'name',checkbox:false,width:100">设备名称</th>
				<th data-options="field:'cdp',width:100">登记人</th>
				<th data-options="field:'houseAddress',width:100">房屋地址</th>
				
			</tr>
		</thead>
	</table>

</body>
</html>