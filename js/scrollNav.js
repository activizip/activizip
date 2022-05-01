$(window).on('scroll', retraerMenu);
function retraerMenu() {
    var scrollRealizado = $(window).scrollTop()
    console.log(scrollRealizado);

    if (scrollRealizado > 680) {
        $('.cont-nav').addClass('retractil');
    } else {
        $('.cont-nav').removeClass('retractil');
    }
}