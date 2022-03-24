$( document ).ready(function() {
$("#submit").click(function() {
var formData= {
"firstName" :$("#firstName").val(),
"lastName": $("#lastName").val(),
"email": $("#email").val(),
"password": $("#password").val(),
"mobile" : $("#mobile").val(),
"amount" : "3000",
"packageId" : "1"
}
$.ajax({
   url: "/api/v1/user/save",
   type: "POST",
   contentType: "application/json",
   data: JSON.stringify(formData),
   success: function (result) {
     $(".alert").remove();
    if(result.status && 0 == $(".alert").length)
      {
      $(".page-title").prepend("<div class='alert'>" + result.message + "&nbsp;<i class='fa fa-times' id='icon' aria-hidden='true'></i></div>")
    }
    else{
    $(".alert").html(result.message);
    }
         //location.reload()
    },
    error: function (err) {
    $(".alert").remove();
    if(err.responseJSON.httpStatusCode===400){
     setTimeout(function () {
       if(0 == $(".alert").length)
          {
           $(".py-4").after("<div class='alert'>" + err.responseJSON.message + "&nbsp;<i class='fa fa-times' id='icon' aria-hidden='true'></i></div>")
         }
       else{
        $(".alert").html(err.responseJSON.message);
       }
     }, 500);
    }
  }
 });
 return false;
});
});