/**
 * @author Ayman Elakhwas
 */

$(function () {

    $.get("GetUpcomingEvents").done(function (events) {
        events.forEach(event => {
            const elem = "<a class='panel-block upcoming-event-record' data-event-id='" + event.id + "'><div class='container'><div class='level'><div class='level-left'><div class='level-item'><span class='panel-icon'><i class='far fa-calendar-alt'></i></span>" + event.title + " "
                + event.dateTime + "</div></div><div class='level-right'><div class='level-item'><input type='button' value='Join' class='button is-primary'/></div></div></div></div></a>";
            $(".upcomming-pnl").append(elem);

        });
    });

});