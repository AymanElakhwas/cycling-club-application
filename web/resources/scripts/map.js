
var poly;
var map;
var markers=[];

function initMap() {

    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 15,
        center: {lat: 41.006678, lng: -91.962879}  // Center the map on Chicago, USA.
    });

    poly = new google.maps.Polyline({
        strokeColor: '#000000',
        strokeOpacity: 1.0,
        strokeWeight: 3
    });
    poly.setMap(map);

    // Add a listener for the click event
    map.addListener('click', addLatLng);
}

// Handles click events on a map, and adds a new point to the Polyline.
function addLatLng(event) {
    var path = poly.getPath();

    addToPath(event.latLng);
    addMarker(event.latLng);
}

function drawPath(points) {

    for (var property1 in points) {
        string1 = string1 + object1[property1];
    }
}

function addToPath(latLng) {

    path.push(latLng);

}
function addMarker(latLng) {

    // Add a new marker at the new plotted point on the polyline.
    var marker = new google.maps.Marker({
        position: latLng,
        title: '#' + path.getLength(),
        map: map
    });

    markers.push(marker);

}
function deleteMarkers() {
    clearMarkers();
    markers = [];
    var path = poly.getPath();
    path.clear();
}

function clearMarkers() {
    setMapOnAll(null);
}
function setMapOnAll(map) {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(map);
    }
}
