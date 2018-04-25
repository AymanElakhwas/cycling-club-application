<!-- @author Abdelrahman-->

<%@ taglib prefix='mytag' uri='TagTest'%>

<div id="dvAddEventContainer" style="display: none">

    <mytag:Head theclass='panel-heading' words='Create Event' />

    <div class="add-event-map">
        <div id="floating-panel">
            <a class="button is-danger" id="btnDeletePath">
                    <span class="icon is-small">
                         <i class="fas fa-times"></i>
                    </span>
                <span>Clear</span>
            </a>
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

                <div>
                    <a class="button is-danger is-outlined" id="btnCancelCreatingEvent">
                        <span>Cancel</span>
                        <span class="icon is-small">
                    <svg class="svg-inline--fa fa-times fa-w-12" aria-hidden="true" data-prefix="fas" data-icon="times" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 384 512" data-fa-i2svg=""><path fill="currentColor" d="M323.1 441l53.9-53.9c9.4-9.4 9.4-24.5 0-33.9L279.8 256l97.2-97.2c9.4-9.4 9.4-24.5 0-33.9L323.1 71c-9.4-9.4-24.5-9.4-33.9 0L192 168.2 94.8 71c-9.4-9.4-24.5-9.4-33.9 0L7 124.9c-9.4 9.4-9.4 24.5 0 33.9l97.2 97.2L7 353.2c-9.4 9.4-9.4 24.5 0 33.9L60.9 441c9.4 9.4 24.5 9.4 33.9 0l97.2-97.2 97.2 97.2c9.3 9.3 24.5 9.3 33.9 0z"></path></svg><!-- <i class="fas fa-times"></i> -->
                </span>
                    </a>

                    <a class="button is-link" id="btnCreateEvent">
                    <span class="icon is-small">
                         <i class="fas fa-check"></i>
                    </span>
                    <span>Save</span>
                    </a>

                </div>
        </div>


</div>
<script src="resources/scripts/map.js"></script>
<script src="resources/scripts/add-event.js"></script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBk_JTdFX0pCAgSvyVK74dPaSQz1ybPH-E&callback=initMap">
</script>

