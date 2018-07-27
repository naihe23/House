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
    <jsp:include page="frame.jsp"/>

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
                                        <li><a href="#" onclick="book(${list.house_ID})">预订</a></li>
                                        <li class="divider"></li>
                                        <li><a
                                                href="house_position?house_pos=${list.house_place}">查看地图</a></li>
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
       window.location.href = "query_house_byName?house_owner_name="+house_owner_name;
   }

    function book(house_id) {
        if (confirm("确定预订？")) {
            window.location.href = "book_house?house_id=" + house_id;
        }
    }

    function searchByName() {
        var house_owner_name = document.getElementById("house_owner_name").value;
        http_request = false;
        if (window.XMLHttpRequest) {
            http_request = new XMLHttpRequest();
        } else if (window.ActiveXObject) {
            try {
                http_request = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e) {
                try {
                    http_request = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e) {
                }
            }
        }

        if (!http_request) {
            alert("不能创建XMLHTTPRequest对象");
            return false;
        }
        http_request.onreadystatechange = getResult;//这边指定一旦接受到返回值就提交到getResult处理
        http_request.open('GET', "query_house_byName?house_owner_name=" + house_owner_name, true);
        http_request.send(null);
    }

    function getResult() {
        if (http_request.readyState == 4) {
            if (http_request.status == 200) {
                var result = http_request.responseText;//获取到json数据
                var json = eval("(" + result + ")");//解析json数据
                setContent(json);//进行DOM操作
            }
            else {
                alert("您所请求的页面有错误");
            }
        }
    }

    function setContent(contents) {//将json数据解析并输出到页面上
        var size = contents.length;
        var p = document.getElementById("content_body");//先将之前的删除
        var body_size = p.childNodes.length;
        for (var i = body_size-1;i>=0;i--){
            p.removeChild(p.childNodes[i]);
        }
         
        for (var i = 0; i < size; i++) {
            var id = i + 1;
            var house_owner = contents[i].house_owner;
            var house_type = contents[i].house_type;
            var house_floor_num = contents[i].house_floor_num;
            var house_place = contents[i].house_place;
            var house_size = contents[i].house_size;
            var house_build_year = contents[i].house_build_year;
            var house_state = contents[i].house_state;
            var house_standard = contents[i].house_standard;
            var house_price = contents[i].house_price;
            var tr = document.createElement("tr");
            var td = document.createElement("td");
            var text = document.createTextNode(id);
            var td1 = document.createElement("td");
            var text1 = document.createTextNode(house_owner);
            var td2 = document.createElement("td");
            var text2 = document.createTextNode(house_type);
            var td3 = document.createElement("td");
            var text3 = document.createTextNode(house_floor_num);
            var td4 = document.createElement("td");
            var text4 = document.createTextNode(house_place);
            var td5 = document.createElement("td");
            var text5 = document.createTextNode(house_size);
            var td6 = document.createElement("td");
            var text6 = document.createTextNode(house_build_year);
            var td7 = document.createElement("td");
            var text7 = document.createTextNode(house_state);
            var td8 = document.createElement("td");
            var text8 = document.createTextNode(house_standard);
            var td9 = document.createElement("td");
            var text9 = document.createTextNode(house_price);
            td.appendChild(text);
            tr.append(td);
            td1.appendChild(text1);
            tr.append(td1);
            td2.appendChild(text2);
            tr.append(td2);
            td3.appendChild(text3);
            tr.append(td3);
            td4.appendChild(text4);
            tr.append(td4);
            td5.appendChild(text5);
            tr.append(td5);
            td6.appendChild(text6);
            tr.append(td6);
            td7.appendChild(text7);
            tr.append(td7);
            td8.appendChild(text8);
            tr.append(td8);
            td9.appendChild(text9);
            tr.append(td9);
            document.getElementById("content_body").appendChild(tr);
        }
    }

</script>
</html>
