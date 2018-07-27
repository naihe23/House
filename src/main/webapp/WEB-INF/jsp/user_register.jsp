<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="register" class="house_sale.model.User" scope="request"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
<link href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
</head>

<body background="resources/images/jloginbg04.jpg">
<div class="text-center"><h1>欢迎注册！</h1></div>
<div>
  <table width="100%" border="0" height="100%">
  <%--@elvariable id="register" type="house_sale.model.User"--%>
  <sf:form
	id="register_user_personal"
	name="register_user_personal"
	class="form-horizontal"
	modelAttribute="register" method="post" action="register">
    <tbody>
      <tr>
        <td width="20%"></td>
        <td><table width="80%" border="0" class="table table-condensed table-hover"  cellspacing="0">
  <tbody>
  
    <tr>
      <td  ><span class="input-group-addon" ><h5>用户名</h5></span>
           </td>
           
      <td> <sf:input path="user_name" class="form-control"
				id="register_user_personal_jEdit1"  placeholder="请输入用户名"/></td>
    </tr>
    <tr>
      <td><span class="input-group-addon" ><h5>性别</h5></span></td>
      <td><sf:input path="user_sex" class="form-control"
				id="register_user_personal_jEdit2" placeholder="请输入性别"/></td>
    </tr>
    <tr>
      <td><span class="input-group-addon" ><h5>年龄</h5></span></td>
      <td><sf:input path="user_age" class="form-control"
				id="register_user_personal_jEdit3" placeholder="请输入年龄"/></td>
    </tr>
    <tr>
      <td><span class="input-group-addon" ><h5>真实姓名</h5></span></td>
      <td><sf:input path="user_real_name" class="form-control"
				id="register_user_personal_jEdit4" placeholder="请输入真实姓名"/></td>
    </tr>
    <tr>
      <td><span class="input-group-addon" ><h5>身份证号</h5></span></td>
      <td><sf:input path="user_IDnumber" class="form-control" value=" "
				id="register_user_personal_jEdit5" placeholder="请输入身份证号"/></td>
    </tr>
    <tr>
      <td><span class="input-group-addon" ><h5>手机号</h5></span></td>
      <td><sf:input path="user_phone" class="form-control"
				id="register_user_personal_jEdit6" placeholder="请输入手机号"/></td>
    </tr>
    <tr>
      <td><span class="input-group-addon" ><h5>密码</h5></span></td>
      <td><sf:input path="user_password" class="form-control"
				id="register_user_personal_jEdit7" placeholder="请输入密码"/></td>
    </tr>
    <tr>
      <td><span class="input-group-addon" ><h5>确认密码</h5></span></td>
      <td><input type="text" class="form-control" placeholder="请确认密码"></td>
    </tr>
     <tr>
      <td ></td>
      <td><input type="submit" value="注册" class="btn btn-default" /></td>
    </tr>
  </tbody>
  	
</table>

</td>
        <td width="20%"></td>
      </tr>
    </tbody>
    </sf:form>
  </table>
</div>
</body>
</html>
