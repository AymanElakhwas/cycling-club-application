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
    <link rel="stylesheet" href="resources/styles/master.css">
    <link rel="stylesheet" href="resources/styles/notifications.css">
    <link rel="stylesheet" href="resources/styles/map-addevent.css">
    <script src="resources/scripts/master-script.js"></script>
    <script src="resources/scripts/upcoming-script.js"></script>
    <script src="resources/scripts/live-script.js"></script>
    <script src="resources/scripts/enrolled-script.js"></script>
    <script src="resources/scripts/myrides-script.js"></script>
    <script src="resources/scripts/notification.js"></script>



</head>
<body>
<section class="hero is-dark">
    <div class="container">
        <div class="columns">
            <div class="column is-9">
                <img src="resources/images/cycling-logo-white-small.png" class="logo-img" width="150">
            </div>
            <div class="column have-top-padding notifications">
                <span id="notifications" class="icon is-large notifications-flag" title="no emercengy"><i
                        class="fas fa-flag fa-2x"></i></span>
                <div class="dropdown is-hoverable nodisplay">
                    <div class="dropdown-trigger">
                        <span class="icon is-small"><i class="fas fa-angle-down" aria-hidden="true"></i></span>
                    </div>
                    <div class="dropdown-menu" id="dropdown-menu4" role="menu">
                        <div class="dropdown-content notification-item">
                            <!--<div class="dropdown-item">-->
                            <!--</div>-->
                        </div>
                    </div>
                </div>
            </div>
            <div class="column have-top-padding ">
                <span class="icon is-large">${user.name}</span>
            </div>
            <div class="column have-top-padding ">
                <span class="icon is-large"><i class="fas fa-user-circle fa-2x"></i></span>
            </div>
        </div>
    </div>
</section>
<section class="section">
    <div class="container">

        <nav class="level" id="navMain">
            <!-- Left side -->
            <div class="level-left">
                <div class="level-item">
                    <a class="button is-success" id="btnCreatEvent">
                    <span class="icon is-small"><i class="fas fa-flag-checkered"></i>
                    </span><span>Create Event</span></a>
                </div>
            </div>
            <div class="level-right">
                <div class="level-item">
                    <div class="tabs is-right">
                        <ul>
                            <li id="upcoming-tab" class="is-active navigation-tab">
                                <a>
                                    <span class="icon is-small"><i class="far fa-calendar-alt"></i></span>
                                    <span>Upcoming</span>
                                </a>
                            </li>
                            <li id="live-tab" class="navigation-tab">
                                <a>
                                    <span class="icon is-small"><i class="fas fa-video"></i></span>
                                    <span>Live</span>
                                </a>
                            </li>
                            <li id="enrolled-tab" class="navigation-tab">
                                <a>
                                    <span class="icon is-small"><i class="far fa-clock"></i></span>
                                    <span>Enrolled Rides</span>
                                </a>
                            </li>
                            <li id="myrides-tab" class="navigation-tab">
                                <a>
                                    <span class="icon is-small"><i class="fas fa-flag-checkered"></i></span>
                                    <span>My Rides</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <div class="columns">
            <div class="column is-7">
                <jsp:include page="upcoming-events.jsp"/>
                <jsp:include page="live-events.jsp"/>
                <jsp:include page="enrolled-events.jsp"/>
                <jsp:include page="myride-events.jsp"/>
                <jsp:include page="add-event.jsp"/>
            </div>
            <div class="column is-5 main-map">
                <jsp:include page="map.html"/>
            </div>
        </div>
    </div>
</section>


</body>
</html>