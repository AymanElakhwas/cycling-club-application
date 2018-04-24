/**
 * @author Ayman Elakhwas
 */

$(function () {

    const isEnrolled = function (user, event) {
        event.participants.forEach(u => {
            if (u.id == user.id) return true;
        });
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
            // if (isEnrolled(user, event) || isOwner(user, event)) {
            //     btnClass = "is-danger";
            //     btnVal = "Enrolled";
            // }

            const eventnumber = event.id;
            const elem = "<a class='panel-block live-event-record' data-event-id='" + eventnumber + "'><div class='container'><div class='level'><div class='level-left'><div class='level-item'><span class='panel-icon'><i class='far fa-calendar-alt'></i></span>" + event.title + " "
                + event.dateTime + "</div></div><div class='level-right'><div class='level-item'><input type='button' value='" + btnVal + "' class='button " + btnClass + " join-live-event-btn' data-event-id='" + eventnumber + "'/></div></div></div></div></a>";
            $(".live-pnl").append(elem);
        });
    });

    $(document).on("click", "a.live-event-record", function (event) {
        const eventId = $(this).attr("data-event-id");
        $("a.live-event-record").removeClass("is-active");
        $(this).addClass("is-active");
        //TODO add logic
        console.log("live-event-record " + eventId);
    });

    $(document).on("click", "input.join-live-event-btn", function (event) {
        const btn = $(this);
        const eventId = btn.attr("data-event-id");
        event.stopPropagation();
        if (!btn.hasClass("is-danger"))
            $.get("JoinLiveEvent", {"eventId": eventId}).done(function () {
                btn.removeClass("is-primary").addClass("is-danger").val("Enrolled");
            });
    });
});