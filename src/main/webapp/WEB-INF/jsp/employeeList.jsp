<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../css/employeeList.css"/>
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script type="text/javascript" src="../public/jquery.js"></script>
    <script type="text/javascript" src="../js/employee.js"></script>
</head>
<body>
<div class="inner_center_top">
    <div class="search">
        <i class="fa fa-search fa-lg"></i>
        <input type="text" placeholder="Search" class="search_em"/>
    </div>
</div>

<div class="inner_center_info">
    <div class="inner_center_info_list">
<%--        <div class="inner_center_info_dept item" >--%>
<%--            <span class="name">软件开发 部</span>--%>
<%--            <span class="toe">1921.1.1</span>--%>
<%--            <span class="code">6+55sd6f5+5s65+s</span>--%>
<%--            <span class="mana">马二中</span>--%>
<%--            <span class="count">37 人</span>--%>
<%--        </div>--%>
    </div>
<%--    <div class="inner_center_info_bottom">--%>
<%--        <input type="button" value="上一页" class="previous"/>--%>
<%--        <input type="button" value="下一页" class="next"/>--%>
<%--    </div>--%>

</div>

<div class="edit">
<%--    <div class="dept_div">--%>
<%--        <span>员工编号</span>--%>
<%--        <input type="text" placeholder="请输入员工编号" class="input"/>--%>
<%--    </div>--%>
    <input type="text" hidden="hidden" class="edit_code">
    <div class="dept_div">
        <span>员工姓名</span>
        <input type="text" placeholder="请输入员工姓名" class="input edit_name"/>
    </div>
    <div class="dept_div">
        <span>出生日期</span>
        <input type="text" placeholder="请输入出生日期" class="input birthday"/>
    </div>
    <div class="dept_div">
        <span>性别</span>
        <input type="text" placeholder="请输入性别" class="input sex"/>
    </div>
    <div class="dept_div">
        <span>工作岗位</span>
        <input type="text" placeholder="请输入工作岗位" class="input work"/>
    </div>
    <div class="dept_div">
        <span>上岗日期</span>
        <input type="text" placeholder="请输入上岗日期" class="input word_time"/>
    </div>
    <div class="dept_div">
        <span>基本工资</span>
        <input type="text" placeholder="请输入基本工资" class="input money"/>
    </div>
    <div class="dept_div">
        <span>补贴</span>
        <input type="text" placeholder="请输入补贴" class="input money_b"/>
    </div>
    <div class="dept_div">
        <span>部门编号</span>
        <input type="text" placeholder="请输入编号" class="input dept_code"/>
    </div>
    <div class="edit_bottom">
        <input type="button" value="关闭" class="close"/>
        <input type="button" value="确认修改" class="submit"/>
    </div>
</div>
</body>
</html>
