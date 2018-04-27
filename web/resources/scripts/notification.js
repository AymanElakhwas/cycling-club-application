/**
 * @Author Elham
 * @Date 04/23/2018
 *
 */

$(function(){
    let timer = null;
    notificationController();
    function notificationController() {
        if (timer === null) {
            timer = setInterval(showNotifications, 3000);
        } else {
            clearInterval(timer);
            timer = null;
        }
    }

    function showNotifications(){
        $.get("Notification").done(function(data){console.log(data); addNotifications(data);});

    }

    function addNotifications(data) {
        let elem ="";
        $(".notifications .notification-item").empty();
        if(data.length>0) {
            $.each(data,function(index,value){
                console.log(value);
                elem += "<div class=\"dropdown-item\">"+" "+value.title+" "+value.description+" "+value.currentlocation+"</div>";
            })
            $(".notifications .notification-item").append(elem);
            $(".notifications .dropdown.is-hoverable").removeClass('nodisplay');
            $('#notifications').css('color', 'red');
            $('#notifications').attr('title', data.length+' emercenies')
        }else {
            $('#notifications').attr('title','no emerceny')
        }

    }



});