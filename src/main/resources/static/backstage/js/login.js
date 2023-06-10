$(".shelter-login").hide();
$(".clinic-login").hide();
$(".shop-login").hide();


$("#adminselect").on("change", function () {
  hideAllForms();
  const selected = $(this).val();
  if (selected === "shelter") {
    $("#shelterselect").val("shelter");
    $(".email-login").fadeOut(100);
    $(".shelter-login").delay(100).fadeIn(100);
  } else if (selected === "clinic") {
    $("#clinicselect").val("clinic");
    $(".email-login").fadeOut(100);
    $(".clinic-login").delay(100).fadeIn(100);
  } else if (selected === "shop") {
    $("#shopselect").val("shop");
    $(".email-login").fadeOut(100);
    $(".shop-login").delay(100).fadeIn(100);
  }
});

$("#shelterselect").on("change", function () {
  hideAllForms();
  const selected = $(this).val();
  if (selected === "admin") {
    $("#adminselect").val("admin");
    $(".email-login").delay(100).fadeIn(100);
  } else if (selected === "clinic") {
    $("#clinicselect").val("clinic");
    $(".clinic-login").delay(100).fadeIn(100);
  } else if (selected === "shop") {
    $("#shopselect").val("shop");
    $(".shop-login").delay(100).fadeIn(100);
  }
});

$("#shopselect").on("change", function () {
  hideAllForms();
  const selected = $(this).val();
  if (selected === "admin") {
    $("#adminselect").val("admin");
    $(".email-login").delay(100).fadeIn(100);
  } else if (selected === "clinic") {
    $("#clinicselect").val("clinic");
    $(".clinic-login").delay(100).fadeIn(100);
  } else if (selected === "shelter") {
    $("#shelterselect").val("shelter");
    $(".shelter-login").delay(100).fadeIn(100);
  }
});

$("#clinicselect").on("change", function () {
  hideAllForms();
  const selected = $(this).val();
  if (selected === "admin") {
    $("#signselect").val("admin");
    $(".email-login").delay(100).fadeIn(100);
  } else if (selected === "shelter") {
    $("#shelterselect").val("shelter");
    $(".shelter-login").delay(100).fadeIn(100);
  } else if (selected === "shop") {
    $("#shopselect").val("shop");
    $(".shop-login").delay(100).fadeIn(100);
  }
});


function hideAllForms() {
  $(".email-login").hide();
  $(".shelter-login").hide();
  $(".clinic-login").hide();
  $(".shop-login").hide();
}