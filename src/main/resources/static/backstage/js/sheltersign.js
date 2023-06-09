const shelterAccount = document.querySelector('#shelterAccount');
const shelterName = document.querySelector('#shelterName');
const shelterPassword = document.querySelector('#shelterPassword');
const shelterpasswordChecked = document.querySelector('#shelterpasswordChecked');
const shelterPrincipal = document.querySelector('#shelterPrincipal');
const shelterPhone = document.querySelector('#shelterPhone');
const shelterAddress = document.querySelector('#shelterAddress');
shelterbtn.addEventListener('click', () => {
	 const accLength = shelterAccount.value.length;
        if (accLength < 5 || accLength > 50) {
            alert('帳號長度須介於5~50字元');
            return;
        }

        const pwdLength = shelterPassword.value.length;
        if (pwdLength < 6 || pwdLength > 12) {
            alert('密碼長度須介於6~12字元');
            return;
        }

        if (shelterpasswordChecked.value !== shelterPassword.value) {
            alert('密碼與確認密碼不相符');
            return;
        }

        const phoneLength = shelterPhone.value.length;
        if (phoneLength != 10) {
            alert('電話號碼長度錯誤');
            return;
        }
        
        if (shelterPrincipal.value == '') {
            alert('請輸入負責人');
            return;
        }
        if (shelterAddress.value == '') {
            alert('請輸入地址');
            return;
        }

        fetch('shelterregister', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                shelterEmail: shelterAccount.value,
                shelterAddress: shelterAddress.value,
                shelterName: shelterName.value,
                shelterPassword: shelterPassword.value,
                shelterPhone: shelterPhone.value,
                shelterPrincipal: shelterPrincipal.value
            }),
        })
            .then(resp => resp.json())
            .then(body => {
                //解構賦值 const successful = body.successful
                const { successful, message } = body;
                if (successful) {
                    alert('註冊成功')
                } else {
                     alert('註冊失敗')}
            });
});


const shelterlogin = document.querySelector('#shelterlogin');
const shelteracc = document.querySelector('#shelterAcc');
const shelterpass = document.querySelector('#shelterPass');



shelterlogin.addEventListener('click', () => {
	if (shelteracc.value == '') {
            alert('請輸入帳號');
            return;
        }

        if (shelterpass.value == '') {
            alert('請輸入密碼');
            return;
        }

        fetch('shelterlogin', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                shelterEmail: shelteracc.value,
                shelterPassword: shelterpass.value,
            }),
        })
            .then(resp => resp.json())
            .then(body => {
                const { successful, message } = body;
                if (successful) {
                    window.location.href = "/petpet/shelter/animalmanage.html";
                } else {
                   alert('登入失敗');
                }
            })

});