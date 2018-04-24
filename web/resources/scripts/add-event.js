/**
 * @author Abdelrahman
 */



let poly;
let map;
let markers=[];

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

    // Because path is an MVCArray, we can simply append a new coordinate
    // and it will automatically appear.
    path.push(event.latLng);

    // Add a new marker at the new plotted point on the polyline.
    var marker = new google.maps.Marker({
        position: event.latLng,
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

(function () {

    $(function () {


        $("#btnCreatEvent").click(function () {

            $("#navMain").hide();
            $(".view-panel").hide();
            $("#dvAddEventContainer").show();

        });


        $("#btnDeletePath").click(function () {
            deleteMarkers()
        });

            $("#btnSaveEvent").click(function () {

            let title=$("#txtTitle").val();
            let date=$("#dtStart").val();
                let description=$("#txtDescription").val();


            if(!title){
                $("#lblTitle").css("color","red");
            }
            else {
                $("#lblTitle").css("color","black");
            }
            if(!date){
                $("#lblEventDate").css("color","red");
            }
            else {
                $("#lblEventDate").css("color","black");
            }
            if(markers.length>1){

                $("#lblMapError").text("").css("color","black");
            }
            else {
                $("#lblMapError").text("Pls click Map to Select Path").css("color","red");
            }

            let points=[];
            for(let i=0;i<markers.length;i++){

                points.push( {"lat":markers[i].position.lat(),"long":markers[i].position.lng(),"order":i});
            }

            if(title&&date&&markers.length>1) {

                $.post( "http://localhost:8080/AddEvent", { "title": title, "date": date,"description":description,"markers":JSON.stringify({"RoutePoints":points}) } ) .done(function() {
                    alert( "second success" );
                })
                    .fail(function() {
                        alert( "error" );
                    });


                $("#navMain").show();
                $(".view-panel").first().show();
                $("#dvAddEventContainer").hide();
            }
        });




    });

})();