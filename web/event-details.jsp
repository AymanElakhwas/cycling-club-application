<%--
  Created by IntelliJ IDEA.
  User: Elham
  Date: 4/24/2018
  Time: 5:35 PM
  To change this template use File | Settings | File Templates.
--%>


<div class="section view-panel event-details-pnl">
    <div class="container">
        <div class="content">
            <div class="field">
                <label class="label">Route of Event</label>
                <div class="control">
                    <div class="add-event-map">
                        <div id="map"></div>
                    </div>
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


