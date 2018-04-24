/**
 * @author Ayman Elakhwas
 */

$(function () {

    $.get("GetMyRideEvents").done(function (data) {
        const events = data["events"];
        const user = data["user"];


        events.forEach(event => {
            const eventnumber = event.id;
            const elem = "<a class='panel-block myrides-event-record' data-event-id='" + eventnumber + "'><div class='container'><div class='level'><div class='level-left'><div class='level-item'><span class='panel-icon'><i class='fas fa-flag-checkered'></i></i></span>" + event.title + " "
                + event.dateTime + "</div></div><div class='level-right'><div class='level-item'></div></div></div></div></a>";
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