<!-- 作者：张彬   -->
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>edit_admin_information</title>
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
	src="<%=request.getContextPath()%>/resources/js/edit_admin.js"></script>
</head>
<body data-curpagename="page26" class="body_style1">
	<div id="edit_admin_staff_index_order_jContainer1"
		class="tlayout_style2">
		<div id="edit_admin_staff_index_order_jContainer1_container"
			class="container">
			<div id="edit_admin_staff_index_order_jRegion1"
				class="edit_admin_staff_index_order_jContainer1_north">
				<div id="edit_admin_staff_index_order_jLabel1" class="text">欢迎来到房产销售系统！</div>
				<div id="edit_admin_staff_index_order_jLabel2" class="text">${admin_name}</div>
			</div>
			<div id="edit_admin_staff_index_order_jRegion2"
				class="edit_admin_staff_index_order_jContainer1_center">
				<div
					id="edit_admin_staff_personal_information_personal_information_jHtmlForm1_form">

					<c:forEach items="${admin_list}" var="list" varStatus="status">
						<div
							id="edit_admin_staff_personal_information_personal_information_jPanel1"
							class="Panel Panel_Null">
							<input type="text" class="Edit Edit_style1"
								value="${list.staff_name}"
								id="edit_admin_staff_personal_information_personal_information_jEdit1" />
							<div
								id="edit_admin_staff_personal_information_personal_information_user_name"
								class="text">管理员名:</div>
						</div>
						<div
							id="edit_admin_staff_personal_information_personal_information_jPanel2"
							class="Panel Panel_Null">
							<input type="text" class="Edit Edit_style1"
								value="${list.staff_sex}"
								id="edit_admin_staff_personal_information_personal_information_jEdit2" />
							<div
								id="edit_admin_staff_personal_information_personal_information_user_sex"
								class="text">性 别:</div>
						</div>
						<div
							id="edit_admin_staff_personal_information_personal_information_jPanel3"
							class="Panel Panel_Null">
							<input type="text" class="Edit Edit_style1"
								value="${list.staff_age}"
								id="edit_admin_staff_personal_information_personal_information_jEdit3" />
							<div
								id="edit_admin_staff_personal_information_personal_information_age"
								class="text">年 龄:</div>
						</div>
						<div
							id="edit_admin_staff_personal_information_personal_information_jPanel4"
							class="Panel Panel_Null">
							<input type="text" class="Edit Edit_style1"
								value="${list.staff_password}"
								id="edit_admin_staff_personal_information_personal_information_jEdit4" />
							<div
								id="edit_admin_staff_personal_information_personal_information_user_real_name"
								class="text">密 码:</div>
						</div>

						<div
							id="edit_admin_staff_personal_information_personal_information_jButton1"
							class="vjbutton vjbutton_c_style1 border_radius_8">
							<div class="vjbutton_txtR">修改</div>
						</div>
					</c:forEach>

				</div>
			</div>
			<div id="edit_admin_staff_index_order_jRegion3"
				class="edit_admin_staff_index_order_jContainer1_west">
				<div class="MenuV MenuV_style3"
					id="edit_admin_staff_index_order_jMenuV1">
					<ul>
						<li class="Menutitle"><a href="admin"><span>首页</span></a></li>
						<li><a href="query_user"><span>管理用户</span></a></li>
						<li><a href="admin_check_users"><span>审批用户注册</span></a></li>
						<li><a href="query_staff"><span>管理职员</span></a></li>
						<li class="last"><a href="admin_info"><span>个人信息</span></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/TmenuV.js"></script>
<script type="text/javascript">
	var search = document
			.getElementById("edit_admin_staff_personal_information_personal_information_jButton1");
	search.onclick = function() {
		var name = document
				.getElementById("edit_admin_staff_personal_information_personal_information_jEdit1").value;
		var age = document
				.getElementById("edit_admin_staff_personal_information_personal_information_jEdit3").value;
		var password = document
				.getElementById("edit_admin_staff_personal_information_personal_information_jEdit4").value;
		var sex = document
				.getElementById("edit_admin_staff_personal_information_personal_information_jEdit2").value;
		window.location.href = "edit_admin?admin_name=" + name + "&admin_age="
				+ age + "&admin_sex=" + sex + "&password=" + password;
	}
</script>
</html>
