$(function(){
    $(".navigation-tab").click(function(){
        $(".navigation-tab").removeClass("is-active");
        $(this).addClass("is-active");
        $(".view-panel").hide();
    });

    $("#upcoming-tab").click(function(){
        upcomingEventsClicked();
        $(".upcoming-pnl").show();
    });

    $("#live-tab").click(function(){
        liveEventsClicked();
        $(".live-pnl").show();
    });

    $("#enrolled-tab").click(function(){
        enrolledEventsClicked();
        $(".enrolled-pnl").show();
    });

    $("#myrides-tab").click(function(){
        myridesEventsClicked();
        $(".myrides-pnl").show();
    });

});