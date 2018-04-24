$(function(){
    $(".navigation-tab").click(function(){
        $(".navigation-tab").removeClass("is-active");
        $(this).addClass("is-active");
        $(".view-panel").hide();
    });

    $("#upcoming-tab").click(function(){
        $(".upcoming-pnl").show();
    });

    $("#live-tab").click(function(){
        $(".live-pnl").show();
    });

    $("#enrolled-tab").click(function(){
        $(".enrolled-pnl").show();
    });

    $("#myrides-tab").click(function(){
        $(".myrides-pnl").show();
    });

});