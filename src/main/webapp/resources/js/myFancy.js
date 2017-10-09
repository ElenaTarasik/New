$(document).ready(function(){

    var jsonObj = null;
    var role_admin = null;
    var role_user = null;

    $(".modal").fancybox();

    $(".editRole").click(function () {

if($("[name='admin_box']").prop("checked")){role_admin = 1;}
if($("[name='user_box']").prop("checked")){role_user = 2;}

if(role_admin != null && role_user != null){
    jsonObj = [role_admin, role_user];
    roleEditAjax();
} else {
    if (role_admin != null && role_user == null) {
        jsonObj = [role_admin];
        roleEditAjax();
    } else if (role_admin == null && role_user != null) {
        jsonObj = [role_user];
        roleEditAjax();
    }
}
    });

    function roleEditAjax() {
        $.ajax({
            url: "/admin/roleChange",
            type: "post",
            contentType: "application/json",
            data:  JSON.stringify(jsonObj),
            dataType: "json",
            success: function (data) {
                console.log(data.message);
                window.location.href="/admin/admin";
            },
            error: function (e) {
                alert("ERROR for role change");
            }
        });
    }
});