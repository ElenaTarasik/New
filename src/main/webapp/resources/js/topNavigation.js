$(document).ready(function(){
    var catalog;
    var collection;
    var jsonObj;

    $(".coll").mouseenter(function(){
        $(this).css("cursor", "pointer");
    });
    $(".coll").mouseleave(function(){
        $(this).css("cursor", "");
    });

    $(".dropdown-content").find("span").mouseenter(function(){
        $(this).css("cursor", "pointer");
        $(this).css("background-color", "#FFFFFF");
    });
    $(".dropdown-content").find("span").mouseleave(function(){
        $(this).css("background-color", "");
        $(this).css("cursor", "");
    });

    $(".cat").click(function(){
        catalog = $(this).attr("bdcat");
        collection = $(this).parents(".dropdown").attr("id");
        jsonObj = {collection:collection, name:catalog, products:null};
        doAjaxProducts();
    });

    function doAjaxProducts() {
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
                alert("ERROR! Products or catalogs didn't found!");
            }
        });
    }
});
