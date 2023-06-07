(() => {
    const btn_forgetEmail = document.querySelector("#btn_forgetEmail")
    const msg_btn_submit = document.querySelector("#msg_btn_submit")
    const email = document.querySelector("#forgetEmail")
    const randonPassword = document.querySelector("#randonPassword")
    const btn = document.querySelector("#btn")
    const btn_submit = document.querySelector("#btn_submit")

    $("#btn_forgetEmail").on("click", function () {
        if (forgetEmail.value == '') {
            msg_btn.textContent = '信箱不得為空';
            return;
        }
        // 發送randon密碼的信件
        fetch('forgotMail', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                recipient: email.value,
            }),
        })
    })

    $("#btn_submit").on("click", function () {
        fetch('userController/newLogin', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                userAccount: email.value,
                userPassword: randonPassword.value
            }),
        })
            .then(resp => resp.json())
            .then(body => {

                const { successful } = body;
                console.log(successful)
                if (true) {
                    console.log(successful)
                    window.alert("登入成功")
                    window.location.href = "/petpet/user/member_center.html"
                } else {
                    window.alert("密碼錯誤")
                    randonPassword.value = ''
                }
            })
    })
})()