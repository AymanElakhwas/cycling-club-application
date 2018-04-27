/**
 * @author Abdelrahman
 * This js file is used for the add-event use case
 */
(function () {

    $(function () {


        $("#btnCreatEvent").click(function () {

            $("#navMain").hide();
            $(".view-panel").hide();
            $(".event-details").hide();
            $("#dvAddEventContainer").show();
            $('#btnClearMarks').attr('disabled', false);
            mapDisabled=false;
            deleteMarkers();
        });


        $("#btnDeletePath").click(function () {
            deleteMarkers()
        });


        $("#btnCancelCreatingEvent").click(function () {
            $("#navMain").show();
            $(".view-panel").first().show();
            $("#dvAddEventContainer").hide();
            $(".event-details").show();
            deleteMarkers();
            mapDisabled=true;
            $("#lblMapError").text("").css("color","black");
            $('#btnClearMarks').attr('disabled', true);

        });

        $("#btnCreateEvent").click(function () {

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

                $.post( "AddEvent", { "title": title, "date": date,"description":description,"markers":JSON.stringify({"RoutePoints":points}) } ) .done(function() {

                    $("#navMain").show();
                    $(".view-panel").first().show();
                    $("#dvAddEventContainer").hide();
                    $(".event-details").show();
                    $('#btnClearMarks').attr('disabled', true);
                    mapDisabled=true;
                    deleteMarkers();
                    upcomingEventsClicked();

                })
                    .fail(function() {
                        alert( "error" );
                    });
            }
        });

    });

})();