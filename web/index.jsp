<%--
  Created by IntelliJ IDEA.
  User: ayman
  Date: 4/22/18
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cycling Club</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.0/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <script src="resources/scripts/upcoming-script.js"></script>
    <script src="resources/scripts/notification.js"></script>
    <link rel="stylesheet" href="resources/styles/master.css">
</head>
<body>
<section class="hero is-dark">
    <div class="container">
        <img src="resources/images/cycling-logo-white-small.png" class="logo-img">
        <span class="icon is-small username-icon"><i class="fas fa-user-circle"></i></span>
        <span class="title is-4 username-txt">User</span>
        <span id="notifications" class="notifications"><i class="far fa-flag"></i></span>
    </div>
</section>
<section class="section">
    <div class="container">

        <div class="tabs is-right">
            <ul>
                <li class="is-active">
                    <a>
                        <span class="icon is-small"><i class="far fa-calendar-alt"></i></span>
                        <span>Upcoming</span>
                    </a>
                </li>
                <li>
                    <a>
                        <span class="icon is-small"><i class="fas fa-video"></i></span>
                        <span>Live</span>
                    </a>
                </li>
                <li>
                    <a>
                        <span class="icon is-small"><i class="far fa-clock"></i></span>
                        <span>Enrolled Rides</span>
                    </a>
                </li>
                <li>
                    <a>
                        <span class="icon is-small"><i class="fas fa-flag-checkered"></i></span>
                        <span>My Rides</span>
                    </a>
                </li>
            </ul>
        </div>

        <jsp:include page="upcomming-events.jsp" />

    </div>
</section>

</body>
</html>