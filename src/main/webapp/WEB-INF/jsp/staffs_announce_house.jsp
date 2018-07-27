<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="house_sale" class="house_sale.model.House_sale" scope="request"/>
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
        <%--@elvariable id="house_sale" type="house_sale.model.House_sale"--%>
        <sf:form
                id="edit_form"
                name="uform"
                method="post" action="save_house" modelAttribute="house_sale">
            <div id="content">
                <table class="table table-hover table-bordered table-condensed" id="house_message_table" >

                    <tr style="width: 300px">
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon">房主真实姓名:</span>
                                <sf:input path="house_owner" placeholder="房主真实姓名" class="form-control"
                                          id="user_name"/>
                            </div>
                        </td>
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon">房屋类型:</span>
                                <sf:input path="house_type" placeholder="房屋类型" class="form-control"
                                          id="password"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon">房屋楼层数:</span>
                                <sf:input path="house_floor_num"   class="form-control" placeholder="房屋楼层数"
                                          id="user_sex"/>
                            </div>
                        </td>
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon">房屋地点:</span>
                                <sf:input path="house_place" placeholder="房屋地点" class="form-control"
                                          id="user_real_name"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon">房屋建造年份:</span>
                                <sf:input path="house_build_year" placeholder="房屋建造年份" class="form-control"
                                          id="user_age"/>
                            </div>
                        </td>
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon">房屋规格:</span>
                                <sf:input path="house_standard" placeholder="房屋规格" class="form-control"
                                          id="user_balance"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon">房屋价格:</span>
                                <sf:input path="house_price" placeholder="房屋价格" class="form-control"
                                          id="user_phone"/>
                            </div>
                        </td>
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon">房屋大小:</span>
                                <sf:input path="house_size" placeholder="房屋大小" class="form-control"
                                          id="user_IDCard"/>
                            </div>
                        </td>
                    </tr>
                    <tr>

                        <td colspan="2" align="center"><input type="submit" name="house_owner_name"
                                                              class="btn btn-primary" value="提交"/></td>
                    </tr>
                </table>
            </div>
        </sf:form>
    </div>
</div>
</body>

</html>
