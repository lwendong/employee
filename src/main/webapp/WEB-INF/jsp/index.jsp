<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>员工首页</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="../css/index.css"/>
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script type="text/javascript" src="../public/jquery.js"></script>
    <script type="text/javascript" src="../js/index.js"></script>
</head>
<body>
<div class="bg">
    <div class="inner_bg">
        <div class="inner_left">
            <div class="logo">
                <i class="fa fa-angle-up fa-5x"></i><br/>
                <i class="fa fa-square fa-lg"><span>.</span></i>
            </div>
            <nav class="nav">
                <ul>

                    <li class="query_dept"><i class="fa fa-align-center"></i></li>
                    <c:if test="${sessionScope.user.isAdmin}">
                        <li class="add_dept"><i class="fa fa-sitemap"></i></li>
                        <li class="user_info"><i class="fa fa-user-circle"></i></li>
                    </c:if>
                </ul>
            </nav>
        </div>
        <div class="inner_center">
            <iframe src="" id="iframe"></iframe>
        </div>
    </div>
    <div class="right">
        <div class="right_date">
            <span class="date"></span><br/>
            <span class="time"></span>
        </div>
        <div class="right_info">
            <div class="right_info_photo"><img src="img/loginbg.jpg"></div>
            <div class="right_info_right">
                <span class="name">${sessionScope.user.username}(${sessionScope.user.employee.name})</span>
                <span class="birthday">${sessionScope.user.employee.birthday}</span>
                <span class="code">${sessionScope.user.id}</span>
                <span class="dept">${sessionScope.user.employee.deptName}</span>
                <span class="admin">${sessionScope.user.isAdmin ? "管理员":""}</span>
            </div>
        </div>
        <div class="right_list">
            <input type="text" value="${sessionScope.user.id}" hidden="hidden" id="userId">
            <div class="right_list_manager">
                <span class="title">您的主管是：</span>
                <span class="content">${sessionScope.user.employee.managerName}</span>
            </div>
            <div class="right_list_money">
                <span class="title">您的工资是：</span>
                <span class="content">￥${sessionScope.user.employee.money}</span>
            </div>
            <div class="right_list_moneyb">
                <span class="title">您的补助是：</span>
                <span class="content">￥${sessionScope.user.employee.moneyB}</span>
            </div>
            <div class="right_list_work">
                <span class="title">您的工作是：</span>
                <span class="content">${sessionScope.user.employee.work}</span>
            </div>
            <div class="right_list_workdate">
                <span class="title">您的工作开始时间是：</span>
                <span class="content">${sessionScope.user.employee.workDate}</span>
            </div>
        </div>
    </div>
</div>
</body>
</html>
