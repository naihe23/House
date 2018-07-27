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
    <jsp:include page="staff_frame.jsp"/>

    <div id="right" frameborder="0" seamless>
        <table class="table table-hover" cellpadding="0" cellspacing="0">
            <tr>
                <th>用户名</th>
                <th>用户性别</th>
                <th>用户真实姓名</th>
                <th>用户身份证号码</th>
                <th>用户年龄</th>
                <th>用户余额</th>
                <th>用户手机号码</th>
                <th>用户状态</th>
                <th>下单时间</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${re_order_list}" var="list"
                       varStatus="status">
                <tr>
                    <td>${list.user_name}</td>
                    <td>${list.user_sex}</td>
                    <td>${list.user_real_name}</td>
                    <td>${list.user_IDnumber}</td>
                    <td>${list.user_age}</td>
                    <td>${list.user_balance}</td>
                    <td>${list.user_phone}</td>
                    <td><c:if test="${list.user_state==0}">
                        <c:out value="待审核"/>
                    </c:if> <c:if test="${list.user_state==1}">
                        <c:out value="正常"/>
                    </c:if> <c:if test="${list.user_state==2}">
                        <c:out value="封禁"/>
                    </c:if> <c:if test="${list.user_state==3}">
                        <c:out value="已注销"/>
                    </c:if></td>
                    <td>${list.time}</td>
                    <td><input id="pass" type="Button" value="通过"
                                             onclick="pass(${list.request_ID})"/> <input id="nopass"
                                                                                         type="Button" value="信息有误"
                                                                                         onclick="nopass(${list.request_ID})"/>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="10" style="text-align:center;">第${check_order_list.curPage}页，共${check_order_list.totalPage}页，总计
                    <b>${check_order_list.totalCount}</b>
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
</div>
</body>
<script type="text/javascript">
    function pass(order_id) {
        if (confirm("确认通过?")) {
            window.location.href = "check_user_order?order_id=" + order_id;
        }
    }

    function nopass(order_id) {
        if (confirm("确认有误?")) {
            window.location.href = "check_order_error?order_id=" + order_id;
        }
    }
</script>
</html>
