<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>此路由我开，此树由我载</title>
<%@ include file="/common/common.jsp"%>
<script type="text/javascript">
	$(function() {
		$('.easyui-tree').tree({
			onClick : function(node) {
			var flag = $('#index_tabs').tabs("exists",node.text);
				if (flag) {
					$('#index_tabs').tabs("select", node.text);} else {
									// 在用户点击的时候提示
									if(node.pid!=0){
										$('#index_tabs').tabs('add',{
										title : node.text,content : '<iframe frameborder="0" marginwidth="100%" width="100%" height="100%" src="${ctx}'+ node.pageUrl+ '" ></iframe>',closable : true
									 });
									}
								}
							}
			});

		$('#index_tabs').tabs({
			onContextMenu : function(e, title) {
				e.preventDefault();
				$('#tabsMenu').menu('show', {
					left : e.pageX,
					top : e.pageY
				}).data("tabTitle", title);//右键事件时，把当前的title，放在当前的menu菜单里的一个属性。（1）
			}
		});

		$('#tabsMenu').menu({
			onClick : function(item) {
				if ('close' == item.name) {
					//$(this)当前的选择卡，里面放着tabTitle是上面右键事件设过来的值 。（2）
					var curTabTitle = $(this).data("tabTitle");
					$('#index_tabs').tabs("close", curTabTitle);
				} else if ('All' == item.name || 'Other' == item.name) {

					var tabs = $('#index_tabs').tabs("tabs");
					//要删除的数组
					var list = [];
					var curTabTitle = "";

					if ('Other' == item.name) {
						curTabTitle = $(this).data("tabTitle");
					}
					for (var i = 0; i < tabs.length; i++) {
						var opt = $(tabs[i]).panel("options");
						//判断这是否关闭其它
						if ('Other' == item.name) {
							//判断选中的选项卡名称是否在循环列表
							if (curTabTitle != opt.title) {
								list.push(opt.title);
							}
						} else {
							list.push(opt.title);
						}
					}
					//删除要删除的选项卡列表
					for (var i = 0; i < list.length; i++) {
						$('#index_tabs').tabs("close", list[i]);
					}
				}
			}
		});
	});


	
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false"
		style="height: 60px; background: #B3DFDA; padding: 10px">
		纵梦第一拆迁大队 <br>
		<h3>欢迎----->${SESSION_SYSUSER_KEY.username } 登陆</h3>


	</div>
	<div data-options="region:'west',split:true,title:'菜单导航'"
		style="width: 200px;">
		<div class="easyui-accordion" style="height: 100%">
			<ul class="easyui-tree"
				data-options="url:'${ctx }/systemmenu/menulist.do',method:'get',animate:false"></ul>
		</div>
	</div>
	<div data-options="region:'center'">
		<div id="index_tabs" data-options="tools:'#tab-tools'"
			class="easyui-tabs" style="width: 100%; height: 100%">
			<div title="首页" data-options="closable:false" style="padding: 5px;">
				<div class="post-permalink">
					nihao
				</div>
			</div>
		</div>
	</div>

	<div id="tabsMenu" class="easyui-menu" style="width: 120px;">
		<div name="close">关闭</div>
		<div name="Other">关闭其他</div>
		<div name="All">关闭所有</div>
	</div>

	<div id="tab-tools">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-user'" ></a>
    <span  class="easyui-linkbutton" data-options="iconCls:'icon-man'"></span>${SESSION_SYSUSER_KEY.username } 
    <a href="javascript:void(0)" data-options="iconCls:'icon-logout'"></a>
	</div>

</body>
</html>