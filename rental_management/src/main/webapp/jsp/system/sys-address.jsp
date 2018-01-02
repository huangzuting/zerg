<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>地址列表</title>
<%@ include file="/common/common.jsp"%>
<script>
	$(function() {
		$("#grid").treegrid({
			onDblClickRow : function(index, row) {
				var url = '${ctx}/address/tree.do&id=' + row.id;
				open('查看地址信息', url, 600, 400);
			}
		});
	});

	var toolbar = [
			{
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					var row = $('#grid').datagrid('getSelected');
					var url = '${ctx}/address/tree-input.do';
					open('新增地址信息', url, 600, 200);
				}
			},
			{
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					var row = $('#grid').datagrid('getSelected');
					if (!row) {
						$.messager.alert('系统消息', "请选择...", 'info');
					}
					var id = 0;
					if (row) {
						id = row.id;
					}
					var url = '${ctx}/address/tree-input.do?id=' + row.id;
					open('修改地址信息', url, 600, 400);
				}
			},
			'-',
			{
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
							$.post("${ctx}/address/tree-delete.do", {
								'id' : row.id
							}, function(data) {
								if (data.status) {
									$.messager.alert('系统消息', data.msg, 'info',
											function() {
												//重新加载
												$('#grid').treegrid('reload');
												//清除所有选择的行。	
												$('#grid').datagrid(
														'clearSelections');
											});
								}else{
									$.messager.alert('系统消息', "删除失败,请从最下层开始删除", 'info');
								}
							}, "json");
						}
					});
				}
			}, {
				text : '刷新',
				iconCls : 'icon-reload',
				handler : function() {
					$('#grid').treegrid('reload');
				}
			}, {
				text : '增加具体地址',
				iconCls : 'icon-add',
				handler : function() {
					var row = $('#grid').datagrid('getSelected');
					if (!row) {
						$.messager.alert('系统消息', "请选择...", 'info');
						return;
					}
						var url = '${ctx}/address/tree-input.do?id=' + row.id+'&house=true';
						open('增加具体地址信息', url, 600, 400);
						
					
					
				}
			} ];
</script>
</head>
<body>
	<table id="grid" title="地址管理" style="width: 100%; height: 100%"
		data-options="idField:'id',treeField:'name',fit:true,fitColumns:true,singleSelect:false,rownumbers:true,url:'${ctx}/address/tree.do',pagination:false,toolbar:toolbar,checkOnSelect:true">
		<thead>
			<tr>
				<th data-options="field:'id',checkbox:true"></th>
				<th data-options="field:'name'" width="200">地址名称</th>

			</tr>
		</thead>
	</table>
</body>
</html>