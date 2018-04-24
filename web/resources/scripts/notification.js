$(function(){
    $('.notifications').click(showNotifications);

    function showNotifications(){
        $.get("/Notification").done(function(data){console.log(data)});
    }



    let count=0;
    let timer = null; // stores ID of interval timer
    function delayMsg2() {
        if (timer === null) {
            timer = setInterval(rudy, 1000);
        } else {
            clearInterval(timer);
            timer = null;
        }
    }
    function rudy() { // called each time the timer goes off
        document.getElementById("notifications").innerHTML += "InterVal"+count++;
    }











});