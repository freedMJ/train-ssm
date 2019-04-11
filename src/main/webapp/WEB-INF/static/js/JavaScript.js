// user
var user_Boolean = false;
var password_Boolean = false;
var varconfirm_Boolean = false;
var emaile_Boolean = false;
var Mobile_Boolean = false;
var idCard_Boolean=false;
$('.reg_user').blur(function(){
  if ((/^[a-z0-9_-]{4,8}$/).test($(".reg_user").val())){
    $('.user_hint').html("✔").css("color","green");
    user_Boolean = true;
  }else {
    $('.user_hint').html("×").css("color","red");
    user_Boolean = false;
  }
});
// password
$('.reg_password').blur(function(){
  if ((/^[a-z0-9_-]{6,16}$/).test($(".reg_password").val())){
    $('.password_hint').html("✔").css("color","green");
    password_Boolean = true;
  }else {
    $('.password_hint').html("×").css("color","red");
    password_Boolean = false;
  }
});


// password_confirm
$('.reg_confirm').blur(function(){
  if (($(".reg_password").val())==($(".reg_confirm").val())){
    $('.confirm_hint').html("✔").css("color","green");
    varconfirm_Boolean = true;
  }else {
    $('.confirm_hint').html("×").css("color","red");
    varconfirm_Boolean = false;
  }
});


// Email
$('.reg_email').blur(function(){
  if ((/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/).test($(".reg_email").val())){
    $('.email_hint').html("✔").css("color","green");
    emaile_Boolean = true;
  }else {
    $('.email_hint').html("×").css("color","red");
    emaile_Boolean = false;
  }
});


// Mobile
$('.reg_mobile').blur(function(){
  if ((/^1[34578]\d{9}$/).test($(".reg_mobile").val())){
    $('.mobile_hint').html("✔").css("color","green");
    Mobile_Boolean = true;
  }else {
    $('.mobile_hint').html("×").css("color","red");
    Mobile_Boolean = false;
  }
});

// idCard
$('.reg_idCard').blur(function(){
  
  if ((/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/).test($(".reg_idCard").val())){
    $('.idCard_hint').html("✔").css("color","green");
    idCard_Boolean = true;
  }else {
    $('.idCard_hint').html("×").css("color","red");
    idCard_Boolean = false;
  }
});
// click
$('.red_button').click(function(){
  if(user_Boolean && password_Boolea && varconfirm_Boolean && emaile_Boolean && Mobile_Boolean == true &&idCard_Boolean ==true){
    var username=$(".reg_user").val();
    var password=$(".reg_password").val();
    var email=$(".reg_email").val();
    var phoneNums=$(".reg_mobile").val();
    var idCard= $(".reg_idCard").val();
    //var type=1
    var jsonData={
      "username":username,
      "password":password,
      "email":email,
      "phoneNums":phoneNums,
      "idCard":idCard,
      "type":1
    }
    $.ajax({
      url:"/register",
      type:"post",
      data:JSON.stringify(jsonData),
      success:function(data){
        alert("注册成功，请返回首页");
        //window.location.replace("/index");
        //window.location.href = "http://www.jb51.net";
      }

    });
  }else {
    alert("请完善信息");
  }
});
