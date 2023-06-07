
  // 生成随机验证码
  function generateCaptcha() {
    var captcha = "";
    var characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    for (var i = 0; i < 6; i++) {
      captcha += characters.charAt(Math.floor(Math.random() * characters.length));
    }

    // 返回生成的验证码
    return captcha;
  }

  // 更新验证码文本
  function updateCaptchaText() {
    var captchaText = document.getElementById("captchaText");
    var generatedCaptcha = generateCaptcha();
    captchaText.textContent = generatedCaptcha;

    // 将生成的验证码存储在输入框的 data-captcha 属性中，以便稍后进行验证
    document.getElementById("captchaInput").setAttribute("data-captcha", generatedCaptcha);
  }

  // 验证表单
  document.getElementById("adminLoginForm").addEventListener("submit", function(event) {
    event.preventDefault();

    var captchaInput = document.getElementById("captchaInput");
    var captchaText = captchaInput.getAttribute("data-captcha");
    var captcha = captchaInput.value;

    if (captcha !== captchaText) {
      alert("验证码错误，请重新输入！");
      updateCaptchaText();
      captchaInput.value = "";
      return;
    }

    // 在此处执行登录逻辑
    alert("登录成功！");
    // ...
  });

  // 初始化验证码
  updateCaptchaText();
