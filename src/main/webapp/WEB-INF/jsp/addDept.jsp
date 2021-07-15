<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../css/addDept.css"/>
    <script type="text/javascript" src="../public/jquery.js"></script>
    <script type="text/javascript" src="../js/index.js"></script>
</head>
<body>
<div class="inner_center_top">
    <div class="dept_div">
        <span>部门名称</span>
        <input type="text" placeholder="请输入部门名称" class="input"/>
    </div>
    <div class="dept_div">
        <span>部门主管</span>
        <input type="text" placeholder="请输入部门主管ID" class="input"/>
    </div>
    <div class="dept_div">
        <span>部门编号</span>
        <input type="text" placeholder="请输入部门编号" class="input"/>
    </div>
    <input type="button" value="确认添加" class="add_btn"/>
</div>
<hr />
<div class="inner_center_info">
    <div class="inner_center_info_list">
        <div class="dept_div list">
            <span class="name">软件开发 部</span>
            <span class="toe">1921.1.1</span>
            <span class="code">6+55sd6f5+5s65+s</span>
            <span class="mana">马二中</span>
            <span class="count">37 人</span>
        </div>
        <div class="dept_div list"></div>
        <div class="dept_div list"></div>
        <div class="dept_div list"></div>
        <div class="dept_div list"></div>
        <div class="dept_div list"></div>
        <div class="dept_div list"></div>
        <div class="dept_div list"></div>
        <div class="dept_div list"></div>
    </div>
    <div class="inner_center_info_bottom">
        <input type="button" value="上一页" class="previous"/>
        <input type="button" value="下一页" class="next"/>
    </div>
</div>
</body>
</html>
