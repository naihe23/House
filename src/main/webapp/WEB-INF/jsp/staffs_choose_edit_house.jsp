<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div id="right-header">
            <input type="text" class="form-control" placeholder="请输入户主姓名"
                   style="float: left" id="house_owner_name"/>
            <input type="button" name="house_owner_name" class="btn btn-primary" value="搜索" style="margin-left: 5px" onclick="queryByName()"/>
        </div>
        <form role="form">
            <div id="content">
                <table class="table table-hover " id="house_message_table">

                    <tr>
                        <th >序号:</th>
                        <th >户主姓名:</th>
                        <th >房屋类型:</th>
                        <th >房屋楼层数:</th>
                        <th >房屋地点:</th>
                        <th >房屋大小:</th>
                        <th >房屋建造年份:</th>
                        <th >状态:</th>
                        <th >房屋规格:</th>
                        <th >房屋价格:</th>
                        <th >操作</th>
                    </tr>
                    <tbody id="content_body">
                    <c:forEach items="${house_list}" var="list" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td height="35">${list.house_owner}</td>
                            <td>${list.house_type}</td>
                            <td>${list.house_floor_num}</td>
                            <td>${list.house_place}</td>
                            <td>${list.house_size}</td>
                            <td>${list.house_build_year}</td>
                            <td><c:if test="${list.house_state==0}">
                                <c:out value="未预订"/>
                            </c:if> <c:if test="${list.house_state==1}">
                                <c:out value="已预订"/>
                            </c:if></td>
                            <td>${list.house_standard}</td>
                            <td>${list.house_price}</td>
                            <td>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-primary dropdown-toggle"
                                            data-toggle="dropdown">
                                        操作 <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="edit_house_message?house_id=${list.house_ID}">修改信息</a></li>
                                        <li class="divider"></li>
                                        <li><a
                                                href="#">取消发布</a></li>
                                    </ul>
                                </div>
                            </td>

                        </tr>
                    </c:forEach>
                    </tbody>
                    <tr>
                        <td colspan="11">
                            <ul class="pagination ">
                                <li><a href="#">&laquo;</a></li>
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                                <li><a href="#">&raquo;</a></li>
                            </ul>
                        </td>
                    </tr>
                </table>
            </div>
        </form>
    </div>
</div>
</body>
 <script type="text/javascript">
     function queryByName() {
         var house_owner_name = document.getElementById("house_owner_name").value;
         window.location.href = "query_edit_house?house_owner_name="+house_owner_name;
     }
 </script>
</html>
