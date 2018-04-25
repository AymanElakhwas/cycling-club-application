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


        $("#btnCancelCreatingEvent").click(function () {
            $("#navMain").show();
            $(".view-panel").first().show();
            $("#dvAddEventContainer").hide();
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

                $.post( "http://localhost:8080/AddEvent", { "title": title, "date": date,"description":description,"markers":JSON.stringify({"RoutePoints":points}) } ) .done(function() {

                    $("#navMain").show();
                    $(".view-panel").first().show();
                    $("#dvAddEventContainer").hide();

                    upcomingEventsClicked();
                    alert("Done")
                })
                    .fail(function() {
                        alert( "error" );
                    });
            }
        });

    });

})();