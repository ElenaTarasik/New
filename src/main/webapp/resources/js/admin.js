$(document).ready(function(){
    var options = [
        {value: 1, text: 'Администратор'},
        {value: 2, text: 'Пользователь'},
    ];

    $(".adminTable").mouseenter(function(){
        $(this).css("color", "#FFF8DC");
    });
    $(".adminTable").mouseleave(function(){
        $(this).css("color", "");
    });

$(".editRole").click(function (){
    bootbox.prompt({
        title: "Выберите роль/роли для пользователя: ",
        inputType: "checkbox",
        inputOptions: options,
        callback: function(result) {
            showResult(result);
        }
    });
});

});

function showResult(result) {
    if (typeof result !== "undefined" && result !== null) {
        alert(result);
    }
}