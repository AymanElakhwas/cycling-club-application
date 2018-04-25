/**
 * @author Ayman Elakhwas
 */

const enrolledEventsClicked = function () {
    $(".enrolled-pnl").empty().append("<p class='panel-heading'>Enrolled Rides</p>");
    $.get("GetEnrolledEvents").done(function (data) {
        const events = data["events"];
        events.forEach(event => {

            const eventnumber = event.id;
            const elem = "<a class='panel-block enrolled-event-record' data-event-id='" + eventnumber + "'><div class='container'><div class='level'><div class='level-left'><div class='level-item'><span class='panel-icon'><i class='far fa-clock'></i></i></span>" + event.title + " "
                 + "</div></div><div class='level-right'><div class='level-item'><input type='button' class='button enrolled-event-btn'/></div></div></div></div></a>";
            $(".enrolled-pnl").append(elem);
        });
        $(".enrolled-pnl").children("a").first().click();
    });

};

$(function () {
    $(document).on("click", "a.enrolled-event-record", function (event) {
        const eventId = $(this).attr("data-event-id");
        $("a.enrolled-event-record").removeClass("is-active");
        $(this).addClass("is-active");
        $.get("/EventDetails?eventid=" + eventId).done(function (data) {
            $('.column.event-details').empty().append(data)
        });
        console.log("enrolled-event-record " + eventId);
    });
});