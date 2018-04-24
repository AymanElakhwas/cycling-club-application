<!-- @author Abdelrahman-->

<div id="dvAddEvent" style="display: none">

    <div class="add-event-map">
        <div id="floating-panel">

            <a class="button is-danger">Delete Path</a>
        </div>
        <div id="map"></div>
    </div>

        <div class="add-event-data">
            <div class="field">
                <label class="label">title</label>
                <div class="control">
                    <input class="input" type="text" placeholder="Text input" id="txtTitle" required>
                </div>
            </div>

            <div class="field">
                <label class="label">start date</label>
                <div class="control">
                    <input class="input" type="datetime-local" placeholder="Text input" id="dtStart" required>
                </div>
            </div>

            <div class="field">
                <label class="label">description</label>
                <div class="control">
                    <textarea class="textarea" placeholder="e.g. Race Details"></textarea>
                </div>
            </div>

                <div style="text-align: right;">
                    <a class="button is-success" >
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

