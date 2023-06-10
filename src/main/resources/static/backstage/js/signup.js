$(".shelter-signup").hide();
$(".clinic-signup").hide();
$(".shop-signup").hide();

$("#signviewModeSelect").on("change", function () {
  $(".shelter-signup").hide();
$(".clinic-signup").hide();
$(".shop-signup").hide();
$(".email-signup").hide();
  const selected = $(this).val();
  if (selected === "shelter") {
    $("#shelterviewModeSelect").val("shelter");
    $(".email-signup").fadeOut(100);
    $(".shelter-signup").delay(100).fadeIn(100);
  } else if (selected === "clinic") {
    $("#clinicviewModeSelect").val("clinic");
    $(".email-signup").fadeOut(100);
    $(".clinic-signup").delay(100).fadeIn(100);
  } else if (selected === "shop") {
    $("#shopviewModeSelect").val("shop");
    $(".email-signup").fadeOut(100);
    $(".shop-signup").delay(100).fadeIn(100);
  }
});

$("#shelterviewModeSelect").on("change", function () {
  $(".shelter-signup").hide();
$(".clinic-signup").hide();
$(".shop-signup").hide();
$(".email-signup").hide();
  const selected = $(this).val();
  if (selected === "admin") {
    $("#signviewModeSelect").val("admin");
    $(".email-signup").delay(100).fadeIn(100);
  } else if (selected === "clinic") {
    $("#clinicviewModeSelect").val("clinic");
    $(".clinic-signup").delay(100).fadeIn(100);
  } else if (selected === "shop") {
    $("#shopviewModeSelect").val("shop");
    $(".shop-signup").delay(100).fadeIn(100);
  }
});

$("#shopviewModeSelect").on("change", function () {
  $(".shelter-signup").hide();
$(".clinic-signup").hide();
$(".shop-signup").hide();
$(".email-signup").hide();
  const selected = $(this).val();
  if (selected === "admin") {
    $("#signviewModeSelect").val("admin");
    $(".email-signup").delay(100).fadeIn(100);
  } else if (selected === "clinic") {
    $("#clinicviewModeSelect").val("clinic");
    $(".clinic-signup").delay(100).fadeIn(100);
  } else if (selected === "shelter") {
    $("#shelterviewModeSelect").val("shelter");
    $(".shelter-signup").delay(100).fadeIn(100);
  }
});

$("#clinicviewModeSelect").on("change", function () {
  $(".shelter-signup").hide();
$(".clinic-signup").hide();
$(".shop-signup").hide();
$(".email-signup").hide();
  const selected = $(this).val();
  if (selected === "admin") {
    $("#signviewModeSelect").val("admin");
    $(".email-signup").delay(100).fadeIn(100);
  } else if (selected === "shelter") {
    $("#shelterviewModeSelect").val("shelter");
    $(".shelter-signup").delay(100).fadeIn(100);
  } else if (selected === "shop") {
    $("#shopviewModeSelect").val("shop");
    $(".shop-signup").delay(100).fadeIn(100);
  }
});


function hideAllForms() {
  $(".email-signup").hide();
  $(".shelter-signup").hide();
  $(".clinic-signup").hide();
  $(".shop-signup").hide();
}

