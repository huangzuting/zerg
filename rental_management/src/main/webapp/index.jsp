<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="keywords" content="百度地图,百度地图API，百度地图自定义工具，百度地图所见即所得工具" />
<meta name="description" content="百度地图API自定义地图，帮助用户在可视化操作下生成百度地图" />

<!--引用百度地图API-->
<!-- <script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=2o8vGNprbvy3wTwjGGKLi3Omr1B3mgSg"></script> -->
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
		我们是腾科第一拆迁大队 <br>
		<h3>欢迎----->${SESSION_SYSUSER_KEY.name }登陆</h3>


	</div>
	<div data-options="region:'west',split:true,title:'菜单导航'"
		style="width: 200px;">
		<div class="easyui-accordion" style="height: 100%">
			<ul class="easyui-tree"
				data-options="url:'${ctx }/systemmenu/menulist.do',method:'get',toolbar:toolbar,animate:false"></ul>
		</div>
	</div>
	<div data-options="region:'center'">
		<div id="index_tabs" data-options="tools:'#tab-tools'"
			class="easyui-tabs" style="width: 100%; height: 100%">
			<div title="首页" data-options="closable:false" style="padding: 5px;">
				<div class="post-permalink">
					<!-- <div style="height: 100%; border: #ccc solid 1px; font-size: 12px"
						id="map"></div> -->
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
    <span  class="easyui-linkbutton" data-options="iconCls:'icon-man'"></span>${SESSION_SYSUSER_KEY.name }
    <a href="javascript:void(0)" data-options="iconCls:'icon-logout'"></a>
	</div>

</body>
<script type="text/javascript">
		//创建和初始化地图函数：
		function initMap() {
			createMap(); //创建地图
			setMapEvent(); //设置地图事件
			addMapControl(); //向地图添加控件
			addMapOverlay(); //向地图添加覆盖物
		}

		function createMap() {
			map = new BMap.Map("map");
			map.centerAndZoom(new BMap.Point(113.384248, 23.138969), 15);
		}

		function setMapEvent() {
			map.enableScrollWheelZoom();
			map.enableKeyboard();
			map.enableDragging();
			map.enableDoubleClickZoom()
		}

		function addClickHandler(target, window) {
			target.addEventListener("click", function() {
				target.openInfoWindow(window);
			});
		}

		function addMapOverlay() {
			var markers = [{
				content: "我的备注",
				title: "我在这里",
				imageOffset: {
					width: 0,
					height: 3
				},
				position: {
					lat: 23.140697,
					lng: 113.38317
				}
			},{
				content: "新增试点",
				title: "新增试点测试",
				imageOffset: {
					width: 0,
					height: 3
				},
				position: {
					lat: 23.130697,
					lng: 113.38417
				}
			},
			{
				content: "新增试点",
				title: "又一个新增的测试点",
				imageOffset: {
					width: 0,
					height: 3
				},
				position: {
					lat: 23.140197,
					lng: 113.38917
				}
			}

			];
			for(var index = 0; index < markers.length; index++) {
				var point = new BMap.Point(markers[index].position.lng, markers[index].position.lat);
				var marker = new BMap.Marker(point, {
					icon: new BMap.Icon("http://api.map.baidu.com/lbsapi/createmap/images/icon.png", new BMap.Size(20, 25), {
						imageOffset: new BMap.Size(markers[index].imageOffset.width, markers[index].imageOffset.height)
					})
				});
				var label = new BMap.Label(markers[index].title, {
					offset: new BMap.Size(25, 5)
				});
				var opts = {
					width: 200,
					title: markers[index].title,
					enableMessage: false
				};
				var infoWindow = new BMap.InfoWindow(markers[index].content, opts);
				marker.setLabel(label);
				addClickHandler(marker, infoWindow);
				map.addOverlay(marker);
			};
		}
		//向地图添加控件
		function addMapControl() {
			var scaleControl = new BMap.ScaleControl({
				anchor: BMAP_ANCHOR_BOTTOM_LEFT
			});
			scaleControl.setUnit(BMAP_UNIT_IMPERIAL);
			map.addControl(scaleControl);
			var navControl = new BMap.NavigationControl({
				anchor: BMAP_ANCHOR_TOP_LEFT,
				type: BMAP_NAVIGATION_CONTROL_LARGE
			});
			map.addControl(navControl);
			var overviewControl = new BMap.OverviewMapControl({
				anchor: BMAP_ANCHOR_BOTTOM_RIGHT,
				isOpen: true
			});
			map.addControl(overviewControl);
		}
		var map;
		initMap();
	</script>
</html>