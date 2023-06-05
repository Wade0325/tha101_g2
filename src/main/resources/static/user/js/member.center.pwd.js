(() => {
    const msg = document.querySelector("#msg")
    const password = document.querySelector("#oldPassword")

    fetch('userController/findById', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(resp => resp.json())
        .then(body => {
            const { userPassword } = body;
            password.value = userPassword;
        })

    $("#btn_update_address").on("click", function () {
        if (oldPassword.value == '') {
            msg.textContent = '舊密碼不得為空';
            return;
        }

        if (newPassword.value == '') {
            msg.textContent = '新密碼不得為空';
            return;
        }

        if (confirmPassword.value == '') {
            msg.textContent = '確認新密碼不得為空';
            return;
        }

        if (window.confirm("確定要修改密碼?")) {
            msg.textContent = '';
            if (newPassword.value == confirmPassword.value) {
                console.log(newPassword.value)
                fetch('userController/findById', {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                })
                    .then(resp => resp.json())
                    .then(body => {
                        const { userPassword } = body;
                        password.value = userPassword;
                    })

            } else {
                msg.textContent = '';
                window.confirm("新密碼與確認密碼不相符")
            }
        }

    })

})()