<!--
作者:张家旺 
 -->
<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="house_sale" class="house_sale.model.House_sale" scope="request"/>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>edit_house_information</title>
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
	src="<%=request.getContextPath()%>/resources/js/edit_house.js"></script>
</head>
<body data-curpagename="page19" class="body_style1">
	<div id="edit_house_house_index_order_jContainer1"
		class="tlayout_style2">
		<div id="edit_house_house_index_order_jContainer1_container"
			class="container">
			<div id="edit_house_house_index_order_jRegion1"
				class="edit_house_house_index_order_jContainer1_north">
				<div id="edit_house_house_index_order_jLabel1" class="text">欢迎来到房产销售系统！</div>
				<div id="edit_house_house_index_order_jLabel2" class="text">${staff_name}</div>
			</div>
			<div id="edit_house_house_index_order_jRegion2"
				class="edit_house_house_index_order_jContainer1_center">
				<div
					id="edit_house_house_personal_information_personal_information_jHtmlForm1_form">
					<sf:form
						id="edit_house_house_personal_information_personal_information_jHtmlForm1"
						name="edit_house_house_personal_information_personal_information_jHtmlForm1"
						method="post" action="save_edit_house" modelAttribute="house_sale">
						 <sf:input path="house_ID" value="${edit_house_sale.house_ID}" style="display:none"/>
						<div
							id="edit_house_house_personal_information_personal_information_jPanel1"
							class="Panel Panel_Null">
							<sf:input path="house_owner" class="Edit Edit_style1" value="${edit_house_sale.house_owner}"
								id="edit_house_house_personal_information_personal_information_jEdit1" />
							<div
								id="edit_house_house_personal_information_personal_information_user_name"
								class="text">户主名字:</div>
						</div>
						<div
							id="edit_house_house_personal_information_personal_information_jPanel2"
							class="Panel Panel_Null">
							<div
								id="edit_house_house_personal_information_personal_information_user_sex"
								class="text">房屋类型:</div>
							<sf:input path="house_type" class="Edit Edit_style1" value="${edit_house_sale.house_type}"
								id="edit_house_house_personal_information_personal_information_jEdit2" />
						</div>
						<div id="edit_house_house_jPanel4" class="Panel Panel_Null">
							<div id="edit_house_house_jLabel6" class="text">房屋楼层数:</div>
							<sf:input path="house_floor_num" class="Edit Edit_style1"
								value="${edit_house_sale.house_floor_num}"
								id="edit_house_house_jEdit4" />
						</div>
						<div id="edit_house_house_jPanel5" class="Panel Panel_Null">
							<div id="edit_house_house_jLabel7" class="text">房屋地点:</div>
							<sf:input path="house_place" class="Edit Edit_style1" value="${edit_house_sale.house_place}"
								id="edit_house_house_jEdit5" />
						</div>
						<div id="edit_house_house_jPanel6" class="Panel Panel_Null">
							<div id="edit_house_house_jLabel8" class="text">房屋建造年份:</div>
							<sf:input path="house_build_year" class="Edit Edit_style1" value="${edit_house_sale.house_build_year}"
								id="edit_house_house_jEdit6" />
						</div>
						<div id="edit_house_house_jPanel3" class="Panel Panel_Null">
							<div id="edit_house_house_jLabel5" class="text">房屋规格:</div>
							<sf:input path="house_standard" class="Edit Edit_style1" value="${edit_house_sale.house_standard}"
								id="edit_house_house_jEdit3" />
						</div>
						<div id="edit_house_house_jPanel7" class="Panel Panel_Null">
							<div id="edit_house_house_jLabel9" class="text">房屋价格:</div>
							<sf:input path="house_price" class="Edit Edit_style1" value="${edit_house_sale.house_price}"
								id="edit_house_house_jEdit7" />
						</div>
						<div id="edit_house_house_house_jPanel7" class="Panel Panel_Null">
							<div id="edit_house_house_house_jLabel9" class="text">房屋大小:</div>
							<sf:input path="house_size" class="Edit Edit_style1" value="${edit_house_sale.house_size}"
								id="edit_house_house_house_jEdit7" />
						</div>
						<div id="edit_house_house_jButton1"
							class="vjbutton vjbutton_c_style1 border_radius_8">
							 <input type="submit" value="提交" onclick="success()"/>
						</div>
					</sf:form>
				</div>
			</div>
			<div id="edit_house_house_index_order_jRegion3"
				class="edit_house_house_index_order_jContainer1_west">
				<div class="MenuV MenuV_style3"
					id="edit_house_house_index_order_jMenuV1">
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
	function success(){
		window.alert("提交成功!");
	}
	</script>
</html>
