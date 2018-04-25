<!-- @author Abdelrahman-->

<%@ taglib prefix='mytag' uri='TagTest'%>

<div id="dvAddEventContainer" style="display: none">

    <mytag:Head theclass='panel-heading' words='Create Event' />


    <div class="add-event-map">
        <div id="floating-panel">
            <a class="button is-danger" id="btnDeletePath">Delete Path</a>
        </div>
        <div id="map"></div>
        <label id="lblMapError" style="color: red;"></label>
    </div>

        <div class="add-event-data">
            <div class="field">
                <label class="label" id="lblTitle">title</label>
                <div class="control">
                    <input class="input is-primary" type="text" placeholder="Event Title" id="txtTitle" required>
                </div>
            </div>

            <div class="field">
                <label class="label" id="lblEventDate">start date</label>
                <div class="control">
                    <input class="input is-primary" type="datetime-local" id="dtStart" required>
                </div>
            </div>

            <div class="field">
                <label class="label">description</label>
                <div class="control">
                    <textarea class="textarea" placeholder="e.g. Race Details" id="txtDescription"></textarea>
                </div>
            </div>

                <div style="text-align: right;">

                    <a class="button is-link" id="btnSaveEvent">
                    <span class="icon is-small">
                         <i class="fas fa-check"></i>
                    </span>
                    <span>Save</span>
                    </a>
                </div>
        </div>


</div>
<script src="resources/scripts/add-event.js"></script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBk_JTdFX0pCAgSvyVK74dPaSQz1ybPH-E&callback=initMap">
</script>

