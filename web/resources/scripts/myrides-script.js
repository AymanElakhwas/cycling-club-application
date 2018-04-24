/**
 * @author Ayman Elakhwas
 */

$(function () {

    $.get("GetMyRideEvents").done(function (data) {
        const events = data["events"];
        const user = data["user"];


        events.forEach(event => {
            const eventnumber = event.id;
            let btnMarkup = "";

            if (event.status == 0) { //status = created
                btnMarkup = "<div class='level-item'><input type='button' value='Start' class='button is-primary start-my-event-btn' data-event-id='" + eventnumber + "'/></div>";
            } else if (event.status == 1) { // status = started
                btnMarkup = "<div class='level-item'><input type='button' value='Emergency' class='button is-danger is-rounded flag-my-event-btn' data-event-id='" + eventnumber + "'/></div>";
                btnMarkup += "<div class='level-item'><input type='button' value='Finish' class='button is-link finish-my-event-btn' data-event-id='" + eventnumber + "'/></div>";

            } else if (event.status == 2) { // status = emergency
                btnMarkup = "<div class='level-item'><input type='button' value='Resume' class='button is-primary resume-my-event-btn' data-event-id='" + eventnumber + "'/></div>";
            } else if (event.status == 3) { // status = finish
                btnMarkup = "<div class='level-item'><input type='button' value='Completed' class='button is-warning completed-my-event-btn' data-event-id='" + eventnumber + "'/></div>";
            }

            const elem = "<a class='panel-block myrides-event-record' data-event-id='" + eventnumber + "'><div class='container'><div class='level'><div class='level-left'><div class='level-item'><span class='panel-icon'><i class='fas fa-flag-checkered'></i></i></span>" + event.title + " "
                + event.dateTime + "</div></div><div class='level-right'>" + btnMarkup + "</div></div></div></a>";
            $(".myrides-pnl").append(elem);
        });
    });

    $(document).on("click", "a.myrides-event-record", function (event) {
        const eventId = $(this).attr("data-event-id");
        $("a.myrides-event-record").removeClass("is-active");
        $(this).addClass("is-active");
        //TODO add logic
        console.log("myrides-event-record " + eventId);
    });

    // $(document).on("click", "input.join-live-event-btn", function (event) {
    //     const btn = $(this);
    //     const eventId = btn.attr("data-event-id");
    //     event.stopPropagation();
    //     if (!btn.hasClass("is-danger"))
    //         $.get("JoinLiveEvent", {"eventId": eventId}).done(function () {
    //             btn.removeClass("is-primary").addClass("is-danger").val("Enrolled");
    //         });
    // });
});