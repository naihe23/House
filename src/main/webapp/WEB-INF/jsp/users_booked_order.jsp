<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>已提交的预订订单</title>
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
    <jsp:include page="frame.jsp"/>

    <div id="right" frameborder="0" seamless>
        <div id="right-header">
            <input type="text" class="form-control" placeholder="请输入户主姓名"
                   style="float: left" id="house_owner_name"/>
            <input type="button" name="house_owner_name" class="btn btn-primary" value="搜索" style="margin-left: 5px"
                   onclick="queryByName()"/>
        </div>
        <form role="form">
            <div id="content">
                <c:if test="${list_size!=0}">
                    <table class="table table-hover " id="house_message_table">

                        <tr>
                            <th width="96" height="35">户主姓名</th>
                            <th width="96">房屋类型</th>
                            <th width="96">房屋楼层数</th>
                            <th width="75">房屋地点</th>
                            <th width="87">房屋大小</th>
                            <th width="87">房屋建造年份</th>
                            <th width="87">订单状态</th>
                            <th width="87">房屋规格</th>
                            <th width="87">房屋价格</th>
                            <th width="87">操作</th>
                        </tr>
                        <c:forEach items="${user_request_order_state}" var="list"
                                   varStatus="status">
                            <c:if test="${list.request_state==0||list.request_state==1||list.request_state==2}">
                                <tr>
                                    <td height="32">${list.house_owner}</td>
                                    <td>${list.house_type}</td>
                                    <td>${list.house_floor_num}</td>
                                    <td>${list.house_place}</td>
                                    <td>${list.house_size}</td>
                                    <td>${list.house_build_year}</td>

                                    <td width="110px"><c:if test="${list.request_state==0}">
                                        <c:out value="待审核"/>
                                    </c:if> <c:if test="${list.request_state==1}">
                                        <c:out value="已通过"/>
                                    </c:if>
                                        <c:if test="${list.request_state==2}">
                                            <c:out value="用户信息有误"/>
                                        </c:if>
                                    </td>
                                    <td>${list.house_standard}</td>
                                    <td>${list.house_price}</td>
                                    <td width="150px">
                                        <c:if test="${list.request_state==1}">
                                            <input type="Button" value="付款" class="btn btn-primary"
                                                   onclick="pay(${list.request_ID},${list.house_price})"/>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </c:if>
            </div>
        </form>
    </div>
</div>
</body>
<script type="text/javascript">
    function pay(request_id, price) {
        if (confirm("确认付款？")) {
            window.location.href = "pay_order?request_id=" + request_id + "&price=" + price;
        }
    }

    var size = "${list_size}";
    if (size == 0) {
        window.alert("无预订订单!");
        window.location.href = "query_house";
    }
</script>
</html>
