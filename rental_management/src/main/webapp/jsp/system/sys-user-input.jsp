<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增居住人员</title>
<%@ include file="/common/common.jsp"%>
<script>
	$(function() {
		$("#inputForm").submit(
				function() {
					var flag = $(this).form('enableValidation')
							.form('validate');
					if (flag) {
						var json = $("#inputForm").serializeArray();
						$.post("${ctx}/systemuser/sysuser-add.do", json,
								function(data) {
									if (data.status) {
										$.messager.alert('系统消息', data.msg,
												'info', function() {
													parent.$('#grid').treegrid(
															'reload');
													//ok后的回调方法，去关闭父页面的窗口元素
													parent.$('#${windowid}')
															.window('close');
												});
									}
								}, "json");
					}
					//返回flase ，否则会提交表单
					return false;
				});

		$('#address').combotree({
			url : '${ctx}/card/devlist.do',
			required : true
		});
	});
	
	
	
</script>
<style type="text/css">
.title {
	width: 400px;
}
</style>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center',border:false"
			style="padding: 10px;">
			<form action="" id="inputForm" method="post" class="easyui-form"
				data-options="novalidate:true">



				<table class="table_03">
					<tbody>
						<tr id="title_T1" class="td_title1">
							<td colspan="7">
								<div class="title">
									<h1 class="h1_title">1.人员基本信息</h1>
								</div>
							</td>
						</tr>
						<tr id="title_T2">
							<td align="right" class="td_01"><div class="td_01">姓名：</div></td>
							<td colspan="2" class="td_02"><input type="text" id="name"
								size="30" maxlength="50" class="easyui-textbox textbox-f"
								data-options="required:true,width:'120'" value="" name="name"
								style="display: none;"></td>

						</tr>

						<tr id="title_T5" style="margin-top: 10px;">
							<td align="right" class="td_01">密码：</td>
							<td colspan="4"><input type="password" id="password"
								size="30" maxlength="50" class="easyui-textbox textbox-f"
								data-options="required:true,width:'200px'" value=""
								name="password" style="display: none;"></td>
						</tr>





						<tr id="title_T3" style="margin-top: 10px;">
							<td align="right" class="td_01">性别：</td>
							<td colspan="2"><input type="radio" id="sex" name="sex"
								value="1" checked="checked">男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="sex" value="2">女</td>

						</tr>







						<tr id="title_T11" style="margin-top: 10px;">
							<td align="right" class="td_01">联系电话：</td>
							<td colspan="2"><input class="easyui-textbox textbox-f"
								type="text" id="phone" size="16" maxlength="16"
								data-options="required:true,width:'300px'" value="" name="phone"
								style="display: none;"></td>

						</tr>

						<tr id="title_T3" style="margin-top: 10px;">
							<td align="right" class="td_01">状态：</td>
							<td colspan="2"><input type="radio" id="status"
								name="status" value="1" checked="checked"><span>可用&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
								<input type="radio" name="status" value="2"><span>不可用</span></td>

						</tr>

					</tbody>
				</table>

			</form>

		</div>
		<div data-options="region:'south',border:false"
			style="text-align: right; margin-bottom: 0px; padding: 5px; background-color: #D3D3D3">
			<a id="submit" href="#" onclick="$('#inputForm').submit()"
				class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提交</a> <a
				id="close" href="#"
				onclick="parent.$('#${windowid}').window('close')"
				class="easyui-linkbutton" data-options="iconCls:'icon-no'">关闭</a>
		</div>
	</div>
</body>
</html>