<!--
作者:张家旺 
 -->
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>edit_staff_information</title>
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
pt>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/edit_staff.js"></script>
</head>
<body data-curpagename="page21" class="body_style1">
	<div id="edit_staff_index_order_jContainer1" class="tlayout_style2">
		<div id="edit_staff_index_order_jContainer1_container"
			class="container">
			<div id="edit_staff_index_order_jRegion1"
				class="edit_staff_index_order_jContainer1_north">
				<div id="edit_staff_index_order_jLabel1" class="text">欢迎来到房产销售系统！</div>
				<div id="edit_staff_index_order_jLabel2" class="text">${staff_name}</div>
			</div>
			<div id="edit_staff_index_order_jRegion2"
				class="edit_staff_index_order_jContainer1_center">
				<div
					id="edit_staff_personal_information_personal_information_jHtmlForm1_form">
					
						<div
							id="edit_staff_personal_information_personal_information_jPanel1"
							class="Panel Panel_Null">
							<input type="text" class="Edit Edit_style1" value="${staff_information.staff_name}"
								id="edit_staff_personal_information_personal_information_jEdit1" />
							<div
								id="edit_staff_personal_information_personal_information_user_name"
								class="text">职员名:</div>
						</div>
						<div
							id="edit_staff_personal_information_personal_information_jPanel2"
							class="Panel Panel_Null">
							<input type="text" class="Edit Edit_style1" value="${staff_information.staff_sex}"
								id="edit_staff_personal_information_personal_information_jEdit2" />
							<div
								id="edit_staff_personal_information_personal_information_user_sex"
								class="text">性 别:</div>
						</div>
						<div
							id="edit_staff_personal_information_personal_information_jPanel3"
							class="Panel Panel_Null">
							<input type="text" class="Edit Edit_style1" value="${staff_information.staff_age}"
								id="edit_staff_personal_information_personal_information_jEdit3" />
							<div
								id="edit_staff_personal_information_personal_information_age"
								class="text">年 龄:</div>
						</div>
						<div
							id="edit_staff_personal_information_personal_information_jPanel4"
							class="Panel Panel_Null">
							<input type="text" class="Edit Edit_style1" value="${staff_information.staff_password}"
								id="edit_staff_personal_information_personal_information_jEdit4" />
							<div
								id="edit_staff_personal_information_personal_information_user_real_name"
								class="text">密 码:</div>
						</div>
						<div
							id="edit_staff_personal_information_personal_information_jPanel5"
							class="Panel Panel_Null">
							<div
								id="edit_staff_personal_information_personal_information_user_Id_num"
								class="text">确认密码:</div>
							<input type="text" class="Edit Edit_style1" value=""
								id="edit_staff_personal_information_personal_information_jEdit5" />
						</div>
						<div
							id="edit_staff_personal_information_personal_information_jButton1"
							class="vjbutton vjbutton_c_style1 border_radius_8">
							<div class="vjbutton_txtR">确认修改</div>
						</div>
					
				</div>
			</div>
			<div id="edit_staff_index_order_jRegion3"
				class="edit_staff_index_order_jContainer1_west">
				<div class="MenuV MenuV_style3" id="edit_staff_index_order_jMenuV1">
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
<script>
var search = document.getElementById("edit_staff_personal_information_personal_information_jButton1");
search.onclick = function(){
	var sex = document.getElementById("edit_staff_personal_information_personal_information_jEdit2").value;
	var name = document.getElementById("edit_staff_personal_information_personal_information_jEdit1").value;
	var age = document.getElementById("edit_staff_personal_information_personal_information_jEdit3").value;
	var password = document.getElementById("edit_staff_personal_information_personal_information_jEdit4").value;
	var password2 = document.getElementById("edit_staff_personal_information_personal_information_jEdit5").value;
    if(password!=password2){
    	window.alert("两次密码不相同！");
    }else{
	window.location.href = "save_staff_information?sex="+sex+"&name="+name+"&age="+age+"&password="+password;
}
}
</script>
</html>
