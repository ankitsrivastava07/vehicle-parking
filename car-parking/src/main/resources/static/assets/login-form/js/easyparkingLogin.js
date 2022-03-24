$( document ).ready(function() {
$("#submit").click(function() {
var formData={
 "email": $("#email").val(),
 "password": $("#password").val()
 }
$.ajax({
    type: "POST",
    url: "/api/v1/user/login",
    data: JSON.stringify(formData),
    contentType:"application/json",
    success: function(result)
    {
    if(result.status && 0 == $(".alert").length)
    {
      $(".heading-section").after("<div class='alert'>" + result.message + "&nbsp;<i class='fa fa-times' id='icon' aria-hidden='true'></i></div>")
    }
    else{
    $(".alert").html(result.message);
    }
    },
    error:function(result){
    $("#err_password").remove();
    $("#err_email").remove();
    result.responseJSON.errors.forEach(function(item) {
        $("#"+item.fieldName).after("<span id="+"err_"+item.fieldName+">" + item.message)
    });
  }
});
return false;
});
});
