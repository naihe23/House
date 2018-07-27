<!--
作者:张家旺 
 -->
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>check_order</title>
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
	src="<%=request.getContextPath()%>/resources/js/check_order.js"></script>
</head>
<body data-curpagename="page20" class="body_style1">
	<div id="check_order_index_order_jContainer1" class="tlayout_style2">
		<div id="check_order_index_order_jContainer1_container"
			class="container">
			<div id="check_order_index_order_jRegion1"
				class="check_order_index_order_jContainer1_north">
				<div id="check_order_index_order_jLabel1" class="text">欢迎来到房产销售系统！</div>
				<div id="check_order_index_order_jLabel2" class="text">${staff_name}</div>
			</div>
			<div id="check_order_index_order_jRegion2"
				class="check_order_index_order_jContainer1_center">
				<div id="check_order_jLabel3" class="text">请求订单</div>
				<table class="table_style2 tablebox" id="check_order_jTable1"
					border="1" cellpadding="0" cellspacing="0">
					<tr>
						<th width="98" height="32">用户名</th>
						<th width="98">用户性别</th>
						<th width="98">用户真实姓名</th>
						<th width="97">用户身份证号码</th>
						<th width="97">用户年龄</th>
						<th width="97">用户余额</th>
						<th width="98">用户手机号码</th>
						<th width="98">用户状态</th>
						<th width="98">下单时间</th>
						<th width="98">操作</th>
					</tr>
					<c:forEach items="${re_order_list}" var="list"
						varStatus="status">
						<tr>
							<td height="32">${list.user_name}</td>
							<td>${list.user_sex}</td>
							<td>${list.user_real_name}</td>
							<td>${list.user_IDnumber}</td>
							<td>${list.user_age}</td>
							<td>${list.user_balance}</td>
							<td>${list.user_phone}</td>
							<td><c:if test="${list.user_state==0}">
									<c:out value="待审核" />
								</c:if> <c:if test="${list.user_state==1}">
									<c:out value="正常" />
								</c:if> <c:if test="${list.user_state==2}">
									<c:out value="封禁" />
								</c:if> <c:if test="${list.user_state==3}">
									<c:out value="已注销" />
								</c:if></td>
							<td>${list.time}</td>
							<td width="250px"><input id="pass" type="Button" value="通过"
								onclick="pass(${list.request_ID})" /> <input id="nopass"
								type="Button" value="信息有误" onclick="nopass(${list.request_ID})" />
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="10" height="50px" style="text-align:center;">第${check_order_list.curPage}页，共${check_order_list.totalPage}页，总计 <b>${check_order_list.totalCount}</b>
							条信息 <a href="<%=request.getContextPath()%>/query_all_request_order?curPage=1">首页</a>
							<c:if test="${check_order_list.curPage!=1}">
							<a
							href="<%=request.getContextPath()%>/query_all_request_order?curPage=${check_order_list.curPage-1}">上一页</a></c:if>
							<c:if test="${check_order_list.curPage ne check_order_list.totalPage}">
							<a
							href="<%=request.getContextPath()%>/query_all_request_order?curPage=${check_order_list.curPage+1}">下一页</a></c:if>
							<a
							href="<%=request.getContextPath()%>/query_all_request_order?curPage=${check_order_list.totalPage}">末页</a>
						</td>
					</tr>
				</table>
			</div>
			<div id="check_order_index_order_jRegion3"
				class="check_order_index_order_jContainer1_west">
				<div class="MenuV MenuV_style3" id="check_order_index_order_jMenuV1">
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
function pass(order_id){
	if(confirm("确认通过?")){
		window.location.href="check_user_order?order_id="+order_id;
	}
}

function nopass(order_id){
	if(confirm("确认有误?")){
		window.location.href="check_order_error?order_id="+order_id;
	}
}
</script>
</html>
