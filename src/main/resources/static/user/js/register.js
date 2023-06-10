(() => {
    const btn = document.querySelector('#btn');
    const msg = document.querySelector('#msg');
    var email = document.querySelector('#email');
    const password = document.querySelector('#password');
    const checkPassword = document.querySelector('#checkPassword');
    const phone = document.querySelector('#phone');
    const address = document.querySelector('#address');
    const inputs = document.querySelectorAll('input');
    const userName = document.querySelector('#userName')
    var check = false;

    btn.addEventListener('click', () => {
        const accLength = email.value.length;
        console.log(accLength);
        if (accLength < 5 || accLength > 50) {
            msg.textContent = '帳號長度須介於5~50字元';
            return;
        }

        const pwdLength = password.value.length;
        if (pwdLength < 6 || pwdLength > 12) {
            msg.textContent = '密碼長度須介於6~12字元';
            return;
        }

        if (checkPassword.value !== password.value) {
            msg.textContent = '密碼與確認密碼不相符';
            return;
        }

        const phoneLength = phone.value.length;
        if (phoneLength != 10) {
            msg.textContent = '電話號碼長度錯誤';
            return;
        }

        msg.textContent = '';
        if (check) {
            fetch('userController/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    userAccount: email.value,
                    userPassword: password.value,
                    userTel: phone.value,
                    userName: userName.value
                }),
            })
                .then(resp => resp.json())
                .then(body => {
                    const { successful, message } = body;
                    if (successful) {
                        for (let input of inputs) {
                            input.disabled = true;
                        }
                        btn.disabled = true;
                        window.alert('註冊成功')
                        window.location.href = "login.html"
                    } else {
                        msg.textContent = '註冊失敗，' + message;
                    }
                });
        } else {
            msg.textContent = '註冊失敗'
        }

    });


    var verifyText = document.querySelector("#verifyText");
    var buttonVerify = document.querySelector("#buttonVerify");

    buttonVerify.addEventListener("click", () => {
        verifyCode = verifyText.value
        userAccount = email.value

        fetch(`checkVerify/${verifyCode}/${userAccount}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'text/plain', // 將 Content-Type 設置為 'text/plain'
            },
            body: {

            }
        })
            .then(response => response.text()) // 解析回傳的文字資料
            .then(body => {
                console.log(body)
                if (body == "true") {
                    window.alert("驗證成功")
                    check = true
                } else {
                    window.alert("驗證失敗")
                    verifyText.value = ''
                }
            });

    })




})();