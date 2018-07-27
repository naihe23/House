<!--
作者:张家旺 
 -->
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<jsp:useBean id="house_sale" class="house_sale.model.House_sale"
	scope="request" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>announce_house</title>
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
	src="<%=request.getContextPath()%>/resources/js/announce_house.js"></script>
<script type="text/javascript">
	var insertIsTrue = "${insert}";
	if (insertIsTrue == 3) {
		window.alert("信息不能为空！");
	}
</script>
</head>
<body data-curpagename="page18" class="body_style1">
	<div id="announce_house_index_order_jContainer1" class="tlayout_style2">
		<div id="announce_house_index_order_jContainer1_container"
			class="container">
			<div id="announce_house_index_order_jRegion1"
				class="announce_house_index_order_jContainer1_north">
				<div id="announce_house_index_order_jLabel1" class="text">欢迎来到房产销售系统！</div>
				<div id="announce_house_index_order_jLabel2" class="text">${staff_name}</div>
			</div>
			<div id="announce_house_index_order_jRegion2"
				class="announce_house_index_order_jContainer1_center">
				<div
					id="announce_house_house_house_personal_information_personal_information_jHtmlForm1_form">
					<sf:form
						id="announce_house_house_house_personal_information_personal_information_jHtmlForm1"
						name="announce_house_house_house_personal_information_personal_information_jHtmlForm1"
						modelAttribute="house_sale" method="post" action="save_house">
						<div
							id="announce_house_house_house_personal_information_personal_information_jPanel1"
							class="Panel Panel_Null">
							<sf:input path="house_owner" class="Edit Edit_style1"
							placeholder="比如:张三"
								id="announce_house_house_house_personal_information_personal_information_jEdit1" />
							<div
								id="announce_house_house_house_personal_information_personal_information_user_name"
								class="text">房主真实姓名:</div>
						</div>
						<div
							id="announce_house_house_house_personal_information_personal_information_jPanel2"
							class="Panel Panel_Null">
							<div
								id="announce_house_house_house_personal_information_personal_information_user_sex"
								class="text">房屋类型:</div>
							<sf:input path="house_type" class="Edit Edit_style1"
							placeholder="比如:套房"
								id="announce_house_house_house_personal_information_personal_information_jEdit2" />
						</div>
						<div id="announce_house_house_house_jPanel4"
							class="Panel Panel_Null">
							<div id="announce_house_house_house_jLabel6" class="text">房屋楼层数:</div>
							<sf:input path="house_floor_num" class="Edit Edit_style1"
							placeholder="输入房屋楼层数"
								id="announce_house_house_house_jEdit4" />
						</div>
						<div id="announce_house_house_house_jPanel5"
							class="Panel Panel_Null">
							<div id="announce_house_house_house_jLabel7" class="text">房屋地点:</div>
							<sf:input path="house_place" class="Edit Edit_style1"
							placeholder="请精确到门牌号"
								id="announce_house_house_house_jEdit5" />
						</div>
						<div id="announce_house_house_house_jPanel6"
							class="Panel Panel_Null">
							<div id="announce_house_house_house_jLabel8" class="text">房屋建造年份:</div>
							<sf:input path="house_build_year" class="Edit Edit_style1"
							placeholder="比如:2011-1-1"
								value="" id="announce_house_house_house_jEdit6" />
						</div>
						<div id="announce_house_house_house_jPanel3"
							class="Panel Panel_Null">
							<div id="announce_house_house_house_jLabel5" class="text">房屋规格:</div>
							<sf:input path="house_standard" class="Edit Edit_style1"
							placeholder="比如:两室一厅"
								id="announce_house_house_house_jEdit3" />
						</div>
						<div id="announce_house_house_house_jPanel7"
							class="Panel Panel_Null">
							<div id="announce_house_house_house_jLabel9" class="text">房屋价格:</div>
							<sf:input path="house_price" class="Edit Edit_style1"
							placeholder="请输入房屋总价格"
								id="announce_house_house_house_jEdit7" />
						</div>
						<div id="announce_house_house_house_house_jPanel7"
							class="Panel Panel_Null">
							<div id="announce_house_house_house_house_jLabel9" class="text">房屋大小:</div>
							<sf:input path="house_size" class="Edit Edit_style1"
							placeholder="请输入房屋大小"
								id="announce_house_house_house_house_jEdit7" />
						</div>
						<div id="announce_house_house_house_jButton1"
							class="vjbutton   border_radius_8">
							<input type="submit" value="提交" />
						</div>
					</sf:form>
				</div>
			</div>
			<div id="announce_house_index_order_jRegion3"
				class="announce_house_index_order_jContainer1_west">
				<div class="MenuV MenuV_style3"
					id="announce_house_index_order_jMenuV1">
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
</html>
