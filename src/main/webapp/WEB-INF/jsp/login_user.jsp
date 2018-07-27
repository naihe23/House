<%@ page language="java" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>login</title>
<link href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/resources/css/bootstrap-combined.min.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/layoutit.css" rel="stylesheet">
 <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
 <script type="text/javascript">

     var insertIsTrue = "${insert}";
     if(insertIsTrue==1){
         window.alert("注册成功!");
     }

   function hide(){
	    document.getElementById("user_name_error").innerHTML="";
		 document.getElementById("user_password_error").innerHTML="";
	   }
   function userNameNull(){
         var user_name=" ";
          user_name = document.getElementById("userName").value;
         if (!user_name) {
             document.getElementById("user_name_error").innerHTML = "用户名不能为空!";
         }
	   }
    function userPasswordNull(){
         var user_password = document.getElementById("userPassword").value;
        if (!user_password) {
            document.getElementById("user_password_error").innerHTML = "密码不能为空!";
         }
        }

 </script>
</head>

<body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span6">
			<img alt="140x140" src="<%=request.getContextPath() %>/resources//images/login.jpg" class="img-rounded" />
		</div>
		<div class="span6">
			<hr />
			<form id="login_container1" name="login_container1" class="form-horizontal" action="logins"
			  method="post">
				<div class="control-group">
					<label class="control-label" >用户名</label>
					<div class="controls">             
						<input type="text" name="Uname"  id="userName"  onblur="userNameNull()" onfocus="hide()" style="float:left"/>
                        <label id="user_name_error" style="color:  hsla(359,87%,51%,1.00)"></label>                        
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" >密码</label>
					<div class="controls">
						<span><input name="Upassword" type="password" id="userPassword"  onblur="userPasswordNull()" onfocus="hide()" style="float:left"/><label id="user_password_error" style="color:  hsla(359,87%,51%,1.00)"></label></span>
					</div>
				</div>
                <div class="control-group">
					<label class="control-label">类型</label>
					<div class="controls">
						<select name="login_inputType_select">
                          <option value="0" selected="slected">客户</option>
                          <option value="1">职员</option>
                          <option value="2">管理员</option>
                        </select>
					</div>
				</div>
                
				<div class="control-group">
					<div class="controls">
						<label class="checkbox"><input type="checkbox" />记住密码  <a href="" style="margin-left:20px">忘记密码</a></label>
						 <input class="btn" type="submit" value="登录"/>
						<button type="Button" class="btn btn-default btn-sm" onclick="register()" style="margin-left:60px">注册</button>
					</div>
				</div>
                <hr/>
			</form>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
    function register(){
        window.location.href="register_user";
    }
</script>
</html>
