<!-- 作者：张彬   -->

<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>check_user</title>
	<link href="<%=request.getContextPath() %>/resources/css/jqueryui.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/resources/css/layout-default.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/resources/css/tlayout.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/resources/css/vjpublic.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/resources/css/vjpage.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/resources/css/config.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/public.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.layout.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/check_user.js"></script>
</head>
<body data-curpagename="page24" class="body_style1">
<div id="check_user_index_order_jContainer1" class="tlayout_style2"><div id="check_user_index_order_jContainer1_container" class="container">
	<div id="check_user_index_order_jRegion1" class="check_user_index_order_jContainer1_north">
		<div id="check_user_index_order_jLabel1" class="text">欢迎来到房产销售系统！</div>
		<div id="check_user_index_order_jLabel2" class="text">${admin_name}</div></div>
	<div id="check_user_index_order_jRegion3" class="check_user_index_order_jContainer1_west">
		<div class="MenuV MenuV_style3" id="check_user_index_order_jMenuV1">
			<ul>
				<li class="Menutitle"><a href="admin"><span>首页</span></a></li>
				<li><a href="query_user"><span>管理用户</span></a></li>
				<li><a href="admin_check_users"><span>审批用户注册</span></a></li>
				<li><a href="query_staff"><span>管理职员</span></a></li>
				<li class="last"><a href="admin_info"><span>个人信息</span></a></li>
			</ul>
		</div></div>
	<div id="check_user_index_order_jRegion2" class="check_user_index_order_jContainer1_center">
		<table class="table_style2 tablebox" id="check_user_jTable1" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td width="117" height="40">用户名</td>
				<td width="117">用户年龄</td>
				<td width="117">用户姓名</td>
				<td width="114">用户电话号码</td>
				<td align="center" width="120">用户注册身份证号</td>
				<td align="center" width="105">用户性别</td>
				<td align="center" width="62">操作</td>
			</tr>
			<c:forEach items="${check_user_list}" var="list" varStatus="status">
			<tr>
				<td height="27">${list.user_name}</td>
				<td>${list.user_age}</td>
				<td>${list.user_real_name}</td>
				<td>${list.user_phone}</td>
				<td>${list.user_IDnumber}</td>
				<td>${list.user_sex}</td>
				<td width="200px"><input type="Button" value="通过" onclick="pass(${list.user_ID})"/>
				<input type="Button" value="不通过" onclick="unpass(${list.user_ID})"/>
				</td>
			</tr>
			</c:forEach>
		</table></div></div></div>

</body>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/TmenuV.js"></script>
<script type="text/javascript">
function pass(user_id){
	if(confirm("确定通过?")){
		window.location.href="check_pass?user_id="+user_id;
	}
}
function unpass(user_id){
	if(confirm("确定不通过?")){
		window.location.href="check_unpass?user_id="+user_id;
	}
}
</script>
</html>
