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
    <link rel="stylesheet" href="resources/styles/login.css">
</head>
<body>
<section class="hero is-dark login">
    <div class="container " style="font-family: cursive;font-size: 40px;">
        <div class="columns">
            <div class="column is-3">
                <img src="resources/images/cycling-logo-white-small.png" class="logo-img">
            </div>
            <div class="column is-6">
                <p>Cyclying Club Application</p>
            </div>
            <div class="column is-3"></div>
        </div>
    </div>
</section>
<div class="login-container" >
    <cyclist:NOTIFICATION text="Please Provide Your Username and Passord to Login!" htmlClass="is-medium notification is-primary nodisplay"/>
    <div class="columns">
        <div class="column column is-4 is-offset-one-third">
        <form action="Login" method="Post">
        <cyclist:NOTIFICATION text="Your UserName or Password is Wrong" htmlClass="${error!=null?error:'nodisplay'}"/>
        <div class="field">
            <label class="label">Username</label>
            <div class="control">
                <cyclist:Input type="text" name="username" autocomplete="true" required="true" htmlClass="input is-primary"/>
            </div>
        </div>
        <div class="field">
            <label class="label">Password</label>
            <div class="control">
        <cyclist:Input type="password" name="password" autocomplete="false" required="true" htmlClass="input is-primary"/>
            </div>
        </div>
        <cyclist:Input type="submit" value="Submit" htmlClass="button is-link"/>
        <cyclist:Input type="reset" value="Reset" htmlClass="button is-danger"/>
    </form>
        </div>
    </div>
</div>

</body>
</html>
