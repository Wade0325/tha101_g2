(() => {
    const btn = document.querySelector('#btn');
    const msg = document.querySelector('#msg');
    const email = document.querySelector('#email');
    const password = document.querySelector('#password');
    const checkPassword = document.querySelector('#checkPassword');
    const phone = document.querySelector('#phone');
    const address = document.querySelector('#address');
    const inputs = document.querySelectorAll('input');
    const userName = document.querySelector('#userName')
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
        fetch('userController/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                userAccount: email.value,
                userPassword: password.value,
                userTel: phone.value,
                userName: userName.value,
                userAddr: address.value
            }),
        })
            .then(resp => resp.json())
            .then(body => {
                //解構賦值 const successful = body.successful
                const { successful, message } = body;
                if (successful) {
                    for (let input of inputs) {
                        input.disabled = true;
                    }
                    btn.disabled = true;
                    msg.className = 'info';
                    msg.textContent = '註冊成功';
                } else {
                    msg.className = 'error';
                    msg.textContent = '註冊失敗，' + message;

                }
            });
    });

})();