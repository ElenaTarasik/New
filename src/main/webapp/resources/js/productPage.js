$(document).ready(function(){

    var productId;
    var jsonObj;
    var jsonObjBasket;

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

    $(".addBasket").click(function(){
        var articul=$(this).attr("data-art");
        var quantity=1;
        jsonObjBasket={articul:articul, quantity:quantity};
        doAjaxBasket();
    });

    function doAjaxBasket() {
        $.ajax({
            url: "/basketPage",
            type: "post",
            contentType: "application/json",
            data:  JSON.stringify(jsonObjBasket),
            dataType: "json",
            success: function (data) {
                alert("Add in basket");
            },
            error: function (e) {
                alert("ERROR");
            }
        });
    }

    $("#delBas").click(function(){
        var idArt=$(this).attr("data-art");
        jsonObjBasketDel={id:idArt};
        doAjaxDel();
    });

    function  doAjaxDel(idArt) {
        $.ajax({
            url: "/basketDel",
            type: "post",
            contentType: "application/json",
            data:  JSON.stringify(jsonObjBasketDel),
            dataType: "json",
            success: function (data) {
                alert("Item deleted");
                document.getElementById(idArt).parentNode.removeChild(document.getElementById(idArt));
            },
            error: function (e) {
                alert("ERROR");
            }
        });
    }


});



