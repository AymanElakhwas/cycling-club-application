
var generalpoly;
var generalmap;
var generalmarkers=[];

function initGeneralMap() {


    generalmap = new google.maps.Map(document.getElementById('dvGeneralmap'), {
        zoom: 15,
        center: {lat: 41.006678, lng: -91.962879}  // Center the map on Chicago, USA.
    });

    generalpoly = new google.maps.Polyline({
        strokeColor: '#000000',
        strokeOpacity: 1.0,
        strokeWeight: 3
    });
    generalpoly.setMap(generalmap);

    // Add a listener for the click event
    generalmap.addListener('click', addLatLng);
}

// Handles click events on a map, and adds a new point to the Polyline.
function addLatLng(event) {
    var path = generalpoly.getPath();

    // Because path is an MVCArray, we can simply append a new coordinate
    // and it will automatically appear.
    path.push(event.latLng);

    // Add a new marker at the new plotted point on the polyline.
    var marker = new google.maps.Marker({
        position: event.latLng,
        title: '#' + path.getLength(),
        map: generalmap
    });

    generalmarkers.push(marker);

}
function deleteMarkers() {
    clearMarkers();
    generalmarkers = [];
    var path = generalpoly.getPath();
    path.clear();
}

function clearMarkers() {
    setMapOnAll(null);
}
function setMapOnAll(map) {
    for (var i = 0; i < generalmarkers.length; i++) {
        generalmarkers[i].setMap(map);
    }
}
