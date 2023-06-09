(() => {
    const btn = document.querySelector("#buttonSendEmail")
    const btn_forgetEmail = document.querySelector("#btn_forgetEmail")
    const email = document.querySelector("#email")
    const forgetEmail = document.querySelector("#forgetEmail")
    var emailRegxp = /^([\w]+)(.[\w]+)*@([\w]+)(.[\w]{2,3}){1,2}$/;
    // 註冊
    btn.addEventListener("click", () => {
        // console.log(email.value);
        if (email.value !== '' && emailRegxp.test(email.value) == true) {
            fetch('sendMail', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    recipient: email.value,
                }),
            })
                .then(resp => resp.text())
                .then(resp => {
                    console.log(resp);
                })

        } else if (email.value == '') {
            window.alert("電子信箱為必填")
        } else if (!(emailRegxp.test(email.value))) {
            window.alert('電子信箱格式錯誤');
        }
        window.alert("驗證信已送出")
    })

    // 忘記密碼
    btn_forgetEmail.addEventListener("click", () => {
        // console.log(email.value);
        if (email.value !== '' && emailRegxp.test(email.value) == true) {
            fetch('sendMail', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    recipient: email.value,
                }),
            })
                .then(resp => resp.text())
                .then(resp => {
                    console.log(resp);
                })
        } else if (!(emailRegxp.test(email.value))) {
            window.alert('電子信箱格式錯誤');
        }
    })
})();