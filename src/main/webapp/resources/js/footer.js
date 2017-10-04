$(document).ready(function(){

$(".footerField").find("a").mouseenter(function(){
    $(this).css("font-weight", "bolder");
});
$(".footerField").find("a").mouseleave(function(){
    $(this).css("font-weight", "");
});

});