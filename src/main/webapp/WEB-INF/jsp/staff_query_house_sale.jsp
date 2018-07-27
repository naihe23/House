<!--
作者:张家旺 
 -->
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>query_house_sale</title>
<link href="<%=request.getContextPath()%>/resources/css/jqueryui.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/resources/css/layout-default.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/tlayout.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/vjpublic.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/vjpage.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/config.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/public.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-1.10.2.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.layout.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/page28.js"></script>
</head>
<body data-curpagename="page28" class="body_style1">
	<div id="page28_request_order_order_jContainer1" class="tlayout_style2">
		<div id="page28_request_order_order_jContainer1_container"
			class="container">
			<div id="page28_request_order_order_jRegion1"
				class="page28_request_order_order_jContainer1_north">
				<div id="page28_request_order_order_jLabel1" class="text">欢迎来到房产销售系统！</div>
				<div id="page28_request_order_order_jLabel2" class="text">${staff_name}</div>
			</div>
			<div id="page28_request_order_order_jRegion2"
				class="page28_request_order_order_jContainer1_center">
				<input type="text" class="Edit Edit_style1" name="name"
					id="page28_request_order_order_jEdit1" placeholder="请输入户主名字" />
					<div><ul id="tip" style="margin: 0;padding:0;"></ul>  </div>
				<div id="page28_request_order_order_jImageButton1"
					class="imgbutton border_radius_8 imgbutton_bgcc imgbutton_txtc btntxt_color2 button_border3">
					<div class="button_txtR"></div>
					<div class="valigh-fix"></div>
				</div>
			</div>
			<div id="page28_request_order_order_jRegion3"
				class="page28_request_order_order_jContainer1_west">
				<div class="MenuV MenuV_style3"
					id="page28_house_house_index_order_jMenuV1">
					<ul>
				<li class="Menutitle"><a href="staff_index"><span>首页</span></a></li>
				<li><a href="announce_house"><span>发布房屋信息</span></a></li>
				<li><a href="query_house_sale"><span>修改已提交的房屋信息</span></a></li>
				<li><a href="query_all_request_order"><span>审批客户请求订单</span></a></li>
				<li class="last"><a href="query_staff_information"><span>个人信息</span></a></li>
			</ul>
				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/TmenuV.js"></script>
<script type="text/javascript">
	var search = document.getElementById("page28_request_order_order_jImageButton1");
	search.onclick = function() {
		var house_owner_name = document.getElementById("page28_request_order_order_jEdit1").value;
		window.location.href = "query_edit_house?house_owner_name="
				+ house_owner_name;
	}
	
	
</script>
</html>
