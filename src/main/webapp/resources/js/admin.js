$(document).ready(function(){

    var attrForDel;
    var jsonObj;

    $(".adminTable").mouseenter(function(){
        $(this).css("color", "#FFF8DC");
    });
    $(".adminTable").mouseleave(function(){
        $(this).css("color", "");
    });

    $(".delBut").click(function(){
       var result = confirm("Вы уверены, что хотите удалить этого пользователя?");
        if(result){
            attrForDel = $(this).attr("attr");
            jsonObj = {email:attrForDel};
            doDelAjax();
        }
    });


        $(".editRole").fancybox();



function doDelAjax() {
    $.ajax({
        url: "/admin/deleteUser",
        type: "post",
        contentType: "application/json",
        data:  JSON.stringify(jsonObj),
        dataType: "json",
        success: function (data) {
            console.log(data.message);
            window.location.href="/admin/admin";
        },
        error: function (e) {
            alert("ERROR for delete user");
        }
    });
}
});