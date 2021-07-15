<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee - 欢迎登录！</title>
    <link rel="stylesheet" href="../css/login.css"/>
    <script type="text/javascript" src="../public/jquery.js"></script>
    <script type="text/javascript" src="../js/login.js"></script>
</head>
<body>
    <div class="login_bg">
        <div class="top"></div>
        <div class="left">
            <img src="../img/run.png" />
        </div>
        <div class="right">
            <div class="right_top">
                <img src="../img/font.png" />
            </div>
            <div class="right_center">
                <div class="welcome">
                   Welcome
                </div>
                <div class="input_div">
                    <label for="username">Username</label><br />
                    <input type="text" id="username"  placeholder="请输入用户名!"/>
                    <br />
                    <label for="password">Password</label><br />
                    <input type="password" id="password"  placeholder="请输入密码!"/>
                </div>
                <br />
                <div class="button_div">
                    <span>Welcome to login !</span>
                    <input type="button" id="login" value="Sign in"/>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
