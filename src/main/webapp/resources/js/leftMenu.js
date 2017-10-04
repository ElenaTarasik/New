$(document).ready(function(){
    var collection;
    var catalog;
    var jsonObj;

    $(".catalogLink").mouseenter(function(){
        $(this).css("color", "#B8860B").css("font-weight", "bolder");
    });
    $(".catalogLink").mouseleave(function(){
        $(this).css("color", "").css("font-weight", "");
    });

    $(".catalogLink").click(function(){
    catalog = $(this).attr("attr");
    collection = $(this).parents(".catalogField").find(".head_coll").attr("attr");
    jsonObj = {collection:collection, name:catalog, products:null};
    doAjax();
    });

    function doAjax() {
        $.ajax({
            url: "/products",
            type: "post",
            contentType: "application/json",
            data:  JSON.stringify(jsonObj),
            dataType: "json",
            success: function (data) {
                console.log(data.message);
                window.location.href="/products/products";
            },
            error: function (e) {
                alert("ERROR from left menu");
            }
        });
    }
});