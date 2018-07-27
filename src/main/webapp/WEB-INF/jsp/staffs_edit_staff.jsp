<%@ page language="java" pageEncoding="utf-8" %>
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
    <jsp:include page="staff_frame.jsp"/>

    <div id="right" frameborder="0" seamless>
        <%--@elvariable id="user_edit" type="house_sale.model.User"--%>
        <sf:form
                id="edit_form"
                name="uform"
                method="post" action="save_edit_user" modelAttribute="user_edit">
            <div id="content">
                <table class="table table-hover table-bordered table-condensed" id="house_message_table">

                    <tr>
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon">用户昵称:</span>
                                <sf:input path="user_name" class="form-control" value="${list.user_name}"
                                          id="user_name"/>
                            </div>
                        </td>
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon">用户密码:</span>
                                <sf:input path="user_password" class="form-control" value="${list.user_password}"
                                          id="password"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td><div class="input-group">
                            <span class="input-group-addon">用户性别:</span>
                            <sf:input path="user_sex" class="form-control"
                                      value="${list.user_sex}"
                                      id="user_sex"/>
                        </div>
                        </td>
                        <td> <div class="input-group">
                            <span class="input-group-addon">用户真实姓名:</span>
                            <sf:input path="user_real_name" class="form-control" value="${list.user_real_name}"
                                      id="user_real_name"/>
                        </div>
                        </td>
                    </tr>
                    <tr>
                        <td><div class="input-group">
                            <span class="input-group-addon">用户年龄:</span>
                            <sf:input path="user_age" class="form-control" value="${list.user_age}"
                                      id="user_age"/>
                        </div>
                        </td>
                        <td> <div class="input-group">
                            <span class="input-group-addon">账户余额:</span>
                            <sf:input path="user_balance" class="form-control" value="${list.user_balance}"
                                      id="user_balance"/>
                        </div>
                        </td>
                    </tr>
                    <tr>
                        <td><div class="input-group">
                            <span class="input-group-addon">用户手机号:</span>
                            <sf:input path="user_phone" class="form-control" value="${list.user_phone}"
                                      id="user_phone"/>
                        </div>
                        </td>
                        <td> <div class="input-group">
                            <span class="input-group-addon">用户身份证号:</span>
                            <sf:input path="user_IDnumber" class="form-control" value="${list.user_IDnumber}"
                                      id="user_IDCard"/>
                        </div>
                        </td>
                    </tr>
                    <tr>

                        <td colspan="4" align="center"><input type="submit" name="house_owner_name"
                                                              class="btn btn-primary" value="提交"/></td>
                    </tr>
                </table>
            </div>
        </sf:form>
    </div>
</div>
</body>

</html>
