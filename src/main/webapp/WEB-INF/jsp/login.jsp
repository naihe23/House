<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
<link href="<%=request.getContextPath() %>/resources/css/jqueryui_login.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/resources/css/vjpublic_login.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/resources/css/vjpage_login.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/resources/css/config_login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/public_login.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.10.2_login.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-ui.min_login.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
	 var insertIsTrue = "${insert}";
	 if(insertIsTrue==1){
	    	window.alert("注册成功!");
	    }
	   
	  
	</script>
<script type="text/javascript">
  function register(){
	window.location.href="register_user";
}
</script>
</head>
<body data-curpagename="page10" class="body_style1"
	style="background-image: url(resources/images/jloginbg04.jpg); background-repeat: repeat-y; background-size: cover;">
	<div id="login_container" class="Panel Panel_Null">
		<div id="login_container1_form">
			<form id="login_container1" name="login_container1" method="post"
				action="logins">
				<div id="login_jPanel4" class="Panel Panel_Null border_radius_5">
					<div id="login_inputType">
						<select name="login_inputType_select" size="1"
							id="login_inputType_select" style="width: inherit">
							<option value="0" selected="selected" id="login_inputType_option1">客户</option>
							<option value="1" id="login_inputType_option2">职员</option>
							<option value="2" id="login_inputType_option3">管理员</option>
						</select>
					</div>
					<div id="login_type" class="text">类 型：</div>
				</div>
				<div id="login_login"
					class="vjbutton " tabindex="4">
					 <button type="submit" class="btn btn-default btn-sm">登陆</button>
				</div>
				<div id="login_register"
					class="vjbutton  btn_font2 border_radius_3"
					tabindex="4">
					<button type="Button" class="btn btn-default btn-sm" onclick="register()">注册</button>
				</div>
				<div id="login_nameLabel" class="Panel Panel_Null border_radius_5">
					<div id="login_userName" class="text">用户名：</div>
					<input type="text" name="Uname" class="Edit Edit_style1" value=""
						id="login_inputName" tabindex="1" />
				</div>
				<div id="login_passwordLabel"
					class="Panel Panel_Null border_radius_5">
					<div id="login_password" name="Upassword" class="text">密 码：</div>
					<input type="password" class="Edit Edit_style4" value=""
						id="login_inputPassword" tabindex="2" name="Upassword"/>
				</div>
			</form>
		</div>

		<div id="login_userLogin" class="text">用户登录</div>
		<div id="login_loginin" class="text">LOGIN IN</div>
	</div>

</body>
</html>
