$(document).ready(function(){

    var productId;
    var jsonObj;

    $(".productImg").mouseenter(function(){
        $(this).css("cursor", "pointer");
    });
    $(".productImg").mouseleave(function(){
        $(this).css("cursor", "");
    });

    $(".productImg").click(function(){
        productId = $(this).parents(".productTable").find(".prodId").attr("value");
        jsonObj = {id:productId};
        doAjax();
    });

    function doAjax() {
        $.ajax({
            url: "/productPage",
            type: "post",
            contentType: "application/json",
            data:  JSON.stringify(jsonObj),
            dataType: "json",
            success: function (data) {
                window.location.href="/products/productPage";
            },
            error: function (e) {
                alert("ERROR");
            }
        });
    }
});



