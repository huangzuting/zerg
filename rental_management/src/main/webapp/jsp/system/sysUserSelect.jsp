<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/common/common.jsp"%>

<body>
	<script type="text/javascript">
		/* $(function(){
			//加载easyui-tree数据
			$.ajax({
				 url:'systemOrganization!loadOrganizationTree.action',  
			     dataType : 'json',
			     cache:false,
				 success:function(datas) {
					//点击树节点,获取其详细信息
					$("#orgSelTree").tree({
						data:datas,
						onClick:function(node){//单击事件  
							$("#group").val(node.id);
							doSearch();
					    }
					});
				 }
			});
		}); */
	</script>
	<div class="easyui-layout" data-options="fit:true" style="width: 100%;">
		<!-- 菜单列表-->
		<!-- <div title="机构信息" class="easyui-panel"
			data-options="region:'west',split:false"
			style="width: 20%; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				style="width: 100%;" onclick="getAllUsers();">所有账号</a>
			<ul id="orgSelTree" class="easyui-tree"></ul>
		</div> -->
		<div title="" iconCls='${icon}' class="easyui-panel"
			data-options="region:'center'">
			<div id="stb" style="padding: 10px;">
				<form id="ssform">
					<input type="hidden" id="group" name="group" /> <input name="wfds"
						id="wfds" class="easyui-searchbox"
						data-options="prompt:'请输入账号、姓名、联系方式....',searcher:doSearch"
						style="width: 300px"></input>
					<div style="float: right">
						<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
							plain="true" onclick="select('sdg',userSelectfun)">选择</a>
					</div>
				</form>
			</div>
			<table class="easyui-datagrid" id="sdg" title=""
				style="width: 100%; height: 100%; padding: 0px;"
				data-options="
                border:false,
                rownumbers:true,
                singleSelect:false,
                autoRowHeight:true,
                pagination:true,
                toolbar:'#stb',
                url:'${ctx}/SystemUser/queryAll',
                pageSize:20">
				<thead>
					<tr>
						<th data-options="field:'ck',checkbox:true"></th>
						<th field="czyid" hidden=true>czyid</th>
						<th field="xm" width="10%" align="center">姓名</th>
						<th field="xb" width="10%" align="center">性别</th>
						<th field="xzq" width="26%" align="center">行政区</th>
						<th field="jz" width="30%" align="center">街镇</th>
						<th field="zjhm" width="10%" align="center">身份证号</th>
						<th field="sfzx" width="10%" align="center">是否注销</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		function doSearch() {
			$('#sdg').datagrid({
				queryParams : $('#ssform').serializeObject()
			});
		}
		var fileview = $.extend({}, $.fn.datagrid.defaults.view, { onAfterRender: function (target) { ischeckItem(); } });
		$("#sdg").datagrid({//分页保存checkbox的选中状态 
		    idField: 'id', 
		    view: fileview 
		 });
		
		var checkedItems = [];
		function ischeckItem() {
			for (var i = 0; i < checkedItems.length; i++) {
				$('#sdg').datagrid('selectRecord', checkedItems[i]); //根据id选中行 
			}
		}
		function findCheckedItem(ID) {
			for (var i = 0; i < checkedItems.length; i++) {
				if (checkedItems[i] == ID)
					return i;
			}
			return -1;
		}
		function addcheckItem() {
			var row = $('#sdg').datagrid('getChecked');
			for (var i = 0; i < row.length; i++) {
				if (findCheckedItem(row[i].id) == -1) {
					checkedItems.push(row[i].id);
				}
			}
		}
		function removeAllItem(rows) {
			for (var i = 0; i < rows.length; i++) {
				var k = findCheckedItem(rows[i].id);
				if (k != -1) {
					checkedItems.splice(i, 1);
				}
			}
		}
		function removeSingleItem(rowIndex, rowData) {
			var k = findCheckedItem(rowData.id);
			if (k != -1) {
				checkedItems.splice(k, 1);
			}
		}
		/* 所有用户 */
		function getAllUsers() {
			$('#wfds').searchbox('setValue', null);
			$("#group").val("");
			doSearch();
		}
	</script>
</body>