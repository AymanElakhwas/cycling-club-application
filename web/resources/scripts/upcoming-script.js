/**
 * @author Ayman Elakhwas
 */

$(function () {

    $.get("GetUpcomingEvents").done(function (events) {
        events.forEach(event => {
            const eventnumber = event.id;
            const elem = "<a class='panel-block upcoming-event-record' data-event-id='" + eventnumber + "'><div class='container'><div class='level'><div class='level-left'><div class='level-item'><span class='panel-icon'><i class='far fa-calendar-alt'></i></span>" + event.title + " "
                + event.dateTime + "</div></div><div class='level-right'><div class='level-item'><input type='button' value='Join' class='button is-primary join-upcoming-event-btn' data-event-id='" + eventnumber + "'/></div></div></div></div></a>";
            $(".upcomming-pnl").append(elem);
        });
    });

    $(document).on("click", "a.upcoming-event-record", function (event) {
        const eventId = $(this).attr("data-event-id");
        $("a.upcoming-event-record").removeClass("is-active");
        $(this).addClass("is-active");
        //TODO add logic
        console.log("upcoming-event-record " + eventId);
    });

    $(document).on("click", "input.join-upcoming-event-btn", function (event) {
        const btn = $(this);
        const eventId = btn.attr("data-event-id");
        event.stopPropagation();
        if (!btn.hasClass("is-danger"))
            $.get("JoinUpcomingEvent", {"eventId": eventId}).done(function () {
                btn.removeClass("is-primary").addClass("is-danger").val("Enrolled");
            });
    });
});