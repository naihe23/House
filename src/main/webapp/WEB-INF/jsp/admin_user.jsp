<!-- 作者：张彬   -->
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>admin_user</title>
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
	src="<%=request.getContextPath()%>/resources/js/admin_user.js"></script>
</head>
<body data-curpagename="page23" class="body_style1">
	<div id="admin_user_index_order_jContainer1" class="tlayout_style2">
		<div id="admin_user_index_order_jContainer1_container"
			class="container">
			<div id="admin_user_index_order_jRegion1"
				class="admin_user_index_order_jContainer1_north">
				<div id="admin_user_index_order_jLabel1" class="text">欢迎来到房产销售系统！</div>
				<div id="admin_user_index_order_jLabel2" class="text">${admin_name}</div>
			</div>
			<div id="admin_user_index_order_jRegion3"
				class="admin_user_index_order_jContainer1_west">
				<div class="MenuV MenuV_style3" id="admin_user_index_order_jMenuV1">
					<ul>
						<li class="Menutitle"><a href="admin"><span>首页</span></a></li>
						<li><a href="query_user"><span>管理用户</span></a></li>
						<li><a href="admin_check_users"><span>审批用户注册</span></a></li>
						<li><a href="query_staff"><span>管理职员</span></a></li>
						<li class="last"><a href="admin_info"><span>个人信息</span></a></li>
					</ul>
				</div>
			</div>
			<div id="admin_user_index_order_jRegion2"
				class="admin_user_index_order_jContainer1_center">
				<input type="text" class="Edit Edit_style1" value=""
					id="admin_user_request_order_order_jEdit1" />
				<div id="admin_user_request_order_order_jImageButton1"
					class="imgbutton border_radius_8 imgbutton_bgcc imgbutton_txtc btntxt_color2 button_border3">
					<div class="button_txtR"></div>
					<div class="valigh-fix"></div>
				</div>
				<table class="table_style2 tablebox" id="admin_user_user_jTable1"
					border="1" cellpadding="0" cellspacing="0">
					<tr>
						<td width="104" height="38">客户名</td>
						<td width="104">客户当前状态</td>
						<td colspan="2">操作</td>
					</tr>
					<c:forEach items="${user_list}" var="list" varStatus="status">
						<tr>
							<td height="36">${list.user_name}</td>
							<td><c:if test="${list.user_state == 1}">
									<c:out value="正常" />
									</c:if>
									<c:if test="${list.user_state == 3}">
									<c:out value="封禁" />
								</c:if></td>
							<td width="104"><input type="Button" value="删除"
								onclick="del('${list.user_name}')" /></td>
							<td width="103"><input type="Button" value="封禁"
								onclick="ban('${list.user_name}')" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/TmenuV.js"></script>
<script type="text/javascript">
	function del(user_name) {
		if (confirm("确定删除?")) {
			window.location.href = "delete_user?user_name=" + user_name;
		}
	}
	function ban(user_name) {
		if (confirm("确定封禁?")) {
			window.location.href = "ban_user?user_name=" + user_name;
		}
	}
</script>
<script type="text/javascript">
	var search = document
			.getElementById("admin_user_request_order_order_jImageButton1");
	search.onclick = function() {
		var user_name = document
				.getElementById("admin_user_request_order_order_jEdit1").value;
		window.location.href = "query_concret_user?user_name=" + user_name;
	}
</script>
</html>
