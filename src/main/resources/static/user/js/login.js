(() => {
    const btn = document.querySelector('#btn');
    const msg = document.querySelector('#msg');
    const email = document.querySelector('#Email1');
    const password = document.querySelector('#Password');
    btn.addEventListener('click', () => {

        console.log(email.value);
        if (email.value == '') {
            msg.textContent = '請輸入帳號';
            return;
        }

        if (password.value == '') {
            msg.textContent = '請輸入密碼';
            return;
        }
        msg.textContent = '';

        fetch('user/userController/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                userAccount: email.value,
                userPassword: password.value,
            }),

        })
            .then(resp => resp.json())
            .then(body => {
                const { successful, message } = body;
                if (successful) {
                    msg.className = 'info';
                    msg.textContent = '登入成功';
                    window.location.href = "/petpet/user/member_center.html";
                } else {
                    msg.className = 'error';
                    msg.textContent = '登入失敗，' + message;

                }
            })
    })

})
    ()