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

<form action="/Login" method="Post">
    <cyclist:ERROR text="Your UserName or Password is Wrong" htmlClass="${error!=null?error:'nodisplay'}"/>
    <cyclist:Input type="text" name="username" autocomplete="true" required="true"/>
    <cyclist:Input type="password" name="password" autocomplete="false" required="true"/>
    <cyclist:Input type="submit" value="Submit"/>
    <cyclist:Input type="reset" value="Reset"/>
</form>

</body>
</html>
