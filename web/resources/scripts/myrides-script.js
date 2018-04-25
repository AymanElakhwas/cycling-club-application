/**
 * @author Ayman Elakhwas
 */

const myridesEventsClicked = function () {
    $(".myrides-pnl").empty().append("<p class='panel-heading'>My Rides</p>");
    $.get("GetMyRideEvents").done(function (data) {
        const events = data["events"];
        const user = data["user"];

        events.forEach(event => {
            const eventnumber = event.id;
            let btnMarkup = "";

            if (event.status == 0) { //status = created -> btns: start
                btnMarkup = "<div class='level-item'><input type='button' value='Start' class='button is-primary start-my-event-btn' data-event-id='" + eventnumber + "'/></div>";
            } else if (event.status == 1) { // status = started -> btns: emergency, finish
                btnMarkup = "<div class='level-item'><input type='button' value='Emergency' class='button is-danger is-rounded flag-my-event-btn' data-event-id='" + eventnumber + "'/></div>";
                btnMarkup += "<div class='level-item'><input type='button' value='Finish' class='button is-link finish-my-event-btn' data-event-id='" + eventnumber + "'/></div>";
            } else if (event.status == 2) { // status = emergency -> btns: resume
                btnMarkup = "<div class='level-item'><input type='button' value='Resume' class='button is-primary resume-my-event-btn' data-event-id='" + eventnumber + "'/></div>";
            } else if (event.status == 3) { // status = finish -> btns: completed
                btnMarkup = "<div class='level-item'><input type='button' value='Completed' class='button is-warning completed-my-event-btn' data-event-id='" + eventnumber + "'/></div>";
            }

            const elem = "<a class='panel-block myrides-event-record' data-event-id='" + eventnumber + "'><div class='container'><div class='level'><div class='level-left'><div class='level-item'><span class='panel-icon'><i class='fas fa-flag-checkered'></i></i></span>" + event.title + " "
                +  "</div></div><div id='myrides-event-buttons-container' class='level-right'>" + btnMarkup + "</div></div></div></a>";
            $(".myrides-pnl").append(elem);
        });
        $(".myrides-pnl").children("a").first().click();
    });
};

$(function () {
    $(document).on("click", "a.myrides-event-record", function (event) {
        const eventId = $(this).attr("data-event-id");
        $("a.myrides-event-record").removeClass("is-active");
        $(this).addClass("is-active");
        $.get("/EventDetails?eventid=" + eventId).done(function (data) {
            $('.column.event-details').empty().append(data)
        });
        console.log("upcoming-event-record " + eventId);
    });


    $(document).on("click", "input.start-my-event-btn", function (event) {
        const btn = $(this);
        const btnsContainer = btn.parent().parent();
        const eventId = btn.attr("data-event-id");
        event.stopPropagation();
        $.get("StartEvent", {"eventId": eventId}).done(function () {
            let btnMarkup = "<div class='level-item'><input type='button' value='Emergency' class='button is-danger is-rounded flag-my-event-btn' data-event-id='" + eventId + "'/></div>";
            btnMarkup += "<div class='level-item'><input type='button' value='Finish' class='button is-link finish-my-event-btn' data-event-id='" + eventId + "'/></div>";
            btnsContainer.empty();
            btnsContainer.append(btnMarkup)
        });
    });

    $(document).on("click", "input.resume-my-event-btn", function (event) {
        const btn = $(this);
        const btnsContainer = btn.parent().parent();
        const eventId = btn.attr("data-event-id");
        event.stopPropagation();
        $.get("StartEvent", {"eventId": eventId}).done(function () {
            let btnMarkup = "<div class='level-item'><input type='button' value='Emergency' class='button is-danger is-rounded flag-my-event-btn' data-event-id='" + eventId + "'/></div>";
            btnMarkup += "<div class='level-item'><input type='button' value='Finish' class='button is-link finish-my-event-btn' data-event-id='" + eventId + "'/></div>";
            btnsContainer.empty();
            btnsContainer.append(btnMarkup)
        });
    });

    $(document).on("click", "input.flag-my-event-btn", function (event) {
        event.stopPropagation();
        const btn = $(this);
        const btnsContainer = btn.parent().parent();
        const eventId = btn.attr("data-event-id");
        btn.prop('disabled', true);

        getLocation(eventId, btnsContainer);
    });

    function getLocation(eventId, btnsContainer) {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(raiseFlag(eventId, btnsContainer));
        } else {
            alert("Geolocation is not supported or not permitted.");
        }
    }

    function raiseFlag(eventId, btnsContainer) {
        return function (position) {
            const location = position.coords.latitude.toFixed(6) + "," + position.coords.longitude.toFixed(6);
            $.get("RaiseFlagForEvent", {"eventId": eventId, "location": location}).done(function () {
                const btnMarkup = "<div class='level-item'><input type='button' value='Resume' class='button is-primary resume-my-event-btn' data-event-id='" + eventId + "'/></div>";
                btnsContainer.empty();
                btnsContainer.append(btnMarkup)
            });
        }
    }


    $(document).on("click", "input.finish-my-event-btn", function (event) {
        const btn = $(this);
        const btnsContainer = btn.parent().parent();
        const eventId = btn.attr("data-event-id");
        event.stopPropagation();
        $.get("FinishEvent", {"eventId": eventId}).done(function () {
            const btnMarkup = "<div class='level-item'><input type='button' value='Completed' class='button is-warning completed-my-event-btn' data-event-id='" + eventId + "'/></div>";
            btnsContainer.empty();
            btnsContainer.append(btnMarkup)
        });
    });

});