<%--
  Created by IntelliJ IDEA.
  User: Elham
  Date: 4/23/2018
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="cyclist" uri="WEB-INF/custom.tld" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.0/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
    <link rel="stylesheet" href="resources/styles/master.css">
</head>
<body>
<section class="hero is-dark">
    <div class="container" style="font-family: cursive;font-size: 40px;">
        <img src="resources/images/cycling-logo-white-small.png" class="logo-img">
        Cyclying Club Application
    </div>
</section>
<div class="login-container" style="margin: 50px auto;width: 60%;text-align: center; ">
<h1>Please Provide Your Username and Passord to Login!</h1>
<form action="/Login" method="Post">
    <cyclist:ERROR text="Your UserName or Password is Wrong" htmlClass="${error!=null?error:'nodisplay'}"/>
    <cyclist:Input type="text" name="username" autocomplete="true" required="true"/>
    <cyclist:Input type="password" name="password" autocomplete="false" required="true"/>
    <cyclist:Input type="submit" value="Submit"/>
    <cyclist:Input type="reset" value="Reset"/>
</form>
</div>

</body>
</html>
