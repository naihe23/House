<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="user_edit" class="house_sale.model.User" scope="request"/>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>book</title>
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/style.js"></script>
<link href="<%=request.getContextPath()%>/resources/css/style.css"
	rel="stylesheet" type="text/css">
</head>

<body>
	<div id="container">
		<jsp:include page="frame.jsp" />

		<div id="right" frameborder="0" seamless>

				<div id="content">
					<table class="table table-hover " id="house_message_table">

						<tr>
							<th >用户昵称:${list.user_name}</th>
							<th>用户密码:${list.user_password}</th>
						</tr>
						<tr><th >用户性别:${list.user_sex}</th>
							<th >用户真实姓名:${list.user_real_name}</th>
						</tr>
						<tr><th >用户年龄:${list.user_age}</th>
							<th >账户余额:${list.user_balance}</th>
						</tr>
						<tr><th >用户类型:${list.user_state}</th>
							<th >用户手机号:${list.user_phone}</th>
						</tr>
						<tr>
							<th >用户身份证号:${list.user_IDnumber}</th>
							<td><a href="edit_user_message?edit=2">修改</a></td>
						</tr>
					</table>
				</div>
		</div>
	</div>
</body>
</html>
