<!-- 作者：张彬   -->
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>admin_index</title>
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
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin_index.js"></script>
</head>
<body data-curpagename="page22" class="body_style1">
<div id="admin_index_index_order_jContainer1" class="tlayout_style2">
  <div id="admin_index_index_order_jContainer1_container" class="container">
    <div id="admin_index_index_order_jRegion1" class="admin_index_index_order_jContainer1_north">
      <div id="admin_index_index_order_jLabel1" class="text">欢迎来到房产销售系统！</div>
      <div id="admin_index_index_order_jLabel2" class="text">${admin_name}</div>
    </div>
    <div id="admin_index_index_order_jRegion2" class="admin_index_index_order_jContainer1_center"> </div>
    <div id="admin_index_index_order_jRegion3" class="admin_index_index_order_jContainer1_west">
      <div class="MenuV MenuV_style3" id="admin_index_index_order_jMenuV1">
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
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/TmenuV.js"></script>
</html>
