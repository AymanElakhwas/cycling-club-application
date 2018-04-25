<%--
  Created by IntelliJ IDEA.
  User: Elham
  Date: 4/24/2018
  Time: 5:35 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.0/css/bulma.min.css">
<script defer src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
<%@taglib prefix="cyclist" uri="WEB-INF/custom.tld" %>

<div class="section">
    <div class="container" style="max-width: 30%;">
        <div class="content">
            <div class="field">
                <label class="label">Route of Event</label>
                <div class="control">
                    Place HOLDER
                </div>
            </div>
        </div>
        <div class="columns">
            <div class="column is-8">
                <div class="field">
                    <label class="label">Title</label>
                    <div class="control">
                        ${Event.title}
                    </div>
                </div>
            </div>
            <div class="column is-4">
                <div class="field">
                <label class="label">Date</label>
                <div class="control">
                    ${Event.startDateTime}
                </div>
            </div></div>
        </div>
        <div class="columns">
            <div class="column is-12">
                <div class="field">
                    <label class="label">Description</label>
                    <div class="control">
                        ${Event.description}
                    </div>
                </div>
            </div>
        </div>
        <div class="content">
                <div class="field">
                    <label class="label">Participant</label>
                    <div class="control">
                        <div class="columns is-multiline is-centered is-8">
                        <cyclist:FOREACH var="user" items="${Event.participants}">
                            <div class="column has-background-light" style="margin: 1px">
                                ${user.name}
                            </div>
                        </cyclist:FOREACH>
                        </div>
                    </div>
                </div>

        </div>
    </div>
</div>