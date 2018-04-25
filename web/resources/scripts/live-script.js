/**
 * @author Ayman Elakhwas
 */

const liveEventsClicked = function () {
    $(".live-pnl").empty().append("<p class='panel-heading'>Live Rides</p>");
    const isEnrolled = function (user, event) {
        let isUserEnrolled = false;
        event.participants.forEach(u => {
            if (u.id == user.id) isUserEnrolled = true;
        });
        return isUserEnrolled;
    }

    const isOwner = function (user, event) {
        return event.owner.id == user.id;
    }

    $.get("GetLiveEvents").done(function (data) {
        const events = data["events"];
        const user = data["user"];

        let btnClass = "is-primary";
        let btnVal = "Join";

        events.forEach(event => {
            if (isEnrolled(user, event) || isOwner(user, event)) {
                btnClass = "is-warning";
                btnVal = "Enrolled";
            } else {
                btnClass = "is-primary";
                btnVal = "Join";
            }

            const eventnumber = event.id;
            const elem = "<a class='panel-block live-event-record' data-event-id='" + eventnumber + "'><div class='container'><div class='level'><div class='level-left'><div class='level-item'><span class='panel-icon'><i class='fas fa-play-circle'></i></i></span>" + event.title + " "
                + event.dateTime + "</div></div><div class='level-right'><div class='level-item'><input type='button' value='" + btnVal + "' class='button " + btnClass + " join-live-event-btn' data-event-id='" + eventnumber + "'/></div></div></div></div></a>";
            $(".live-pnl").append(elem);
        });
        $(".live-pnl").children("a").first().click();
    });


};

$(function () {
    $(document).on("click", "a.live-event-record", function (event) {
        const eventId = $(this).attr("data-event-id");
        $("a.live-event-record").removeClass("is-active");
        $(this).addClass("is-active");
        $.get("/EventDetails?eventid=" + eventId).done(function (data) {
            $('.column.event-details').empty().append(data)
        });
        console.log("live-event-record " + eventId);
    });

    $(document).on("click", "input.join-live-event-btn", function (event) {
        const btn = $(this);
        const eventId = btn.attr("data-event-id");
        event.stopPropagation();
        if (!btn.hasClass("is-warning"))
            $.get("JoinLiveEvent", {"eventId": eventId}).done(function () {
                btn.removeClass("is-primary").addClass("is-warning").val("Enrolled");
            });
    });
});