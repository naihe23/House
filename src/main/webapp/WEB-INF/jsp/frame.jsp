<%@ page language="java" pageEncoding="utf-8" %>
<div class="header">
    <div id="header_l">
        <img alt="徽章" src="<%=request.getContextPath()%>/resources/images/badge.jpg" width="100%;" height="150px"
             style="float:left"/>
        <label id="welcome">
            <h3>欢迎来到房产销售系统
                <small>用户端</small>
            </h3>
        </label>
        <label id="userName">当前用户：${user_name}</label>
        <label id="time"></label>
    </div>
    <div id="header_b">
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collaspe" data-target="#demo">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="user">首页</a>
                </div>
                <div>
                    <ul class="nav navbar-nav" id="demo">
                        <li class="active"><a href="#">发布销售房产</a></li>
                        <li><a href="#">我的发布</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                个人信息
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="edit_user_message?edit=1">修改个人信息</a></li>
                                <li class="divider"></li>
                                <li><a href="#">修改密码</a></li>
                            </ul>
                        </li>
                        <li id="loginOut"><a href="#">退出</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>
<div id="left">
    <ul class="nav nav-list well">
        <li class="nav-header">
            主要功能
        </li>
        <li class="active">
            <a href="query_house">预订房产</a>
        </li>
        <li>
            <a href="user_query_request_order">已预订</a>
        </li>
        <li>
            <a href="query_finished_order">已完成</a>
        </li>
        <li>
            <a href="#">充值</a>
        </li>
        <li class="nav-header">
            其它
        </li>
        <li>
            <a href="#">资料</a>
        </li>
        <li>
            <a href="#">设置</a>
        </li>
        <li class="divider">
        </li>
        <li>
            <a href="#">帮助</a>
        </li>
    </ul>

</div>
