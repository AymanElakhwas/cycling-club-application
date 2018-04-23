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
</head>
<body>

<form action="/Login" method="Post">
    <cyclist:Input type="text" name="username" autocomplete="true" required="true"/>
    <cyclist:Input type="password" name="password" autocomplete="false" required="true"/>
    <input type="submit" value="Submit">
    <input type="reset" value="Cancle"/>
</form>

</body>
</html>
