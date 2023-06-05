(() => {
    const nickName = document.querySelector("#nickName")
    const phone = document.querySelector("#phone")
    const address = document.querySelector("#address")
    const Email = document.querySelector("#Email")
    var nickNameV;
    var userphoneV;
    var useraddressV;


    fetch('userController/findById', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(resp => resp.json())
        .then(body => {
            const { userAccount, userName, userTel, userAddr } = body;
            Email.value = userAccount
            nickName.value = userName
            nickNameV = nickName.value

            phone.value = userTel
            userphoneV = phone.value

            address.value = userAddr
            useraddressV = address.value
        })


    $("#btn_update_nickName").on("click", function () {
        const nickName = document.querySelector("#nickName")
        console.log(nickName.hasAttribute('disabled'))
        if (nickName.hasAttribute('disabled')) {
            nickName.removeAttribute('disabled');
        } else {
            nickName.setAttribute('disabled', 'disabled');
            if ((nickName.value != '')) {

            } else {
                window.alert("暱稱不得為空")
                nickName.value = userphoneV
            }
        }

    })

    $("#btn_update_phone").on("click", function () {
        const phone = document.querySelector("#phone")
        console.log(phone.hasAttribute('disabled'))
        if (phone.hasAttribute('disabled')) {
            phone.removeAttribute('disabled');
        } else {
            phone.setAttribute('disabled', 'disabled');
            if ((phone.value != '')) {

            } else {
                window.alert("電話不得為空")
                phone.value = nickNameV
            }
        }
    })

    $("#btn_update_address").on("click", function () {
        const address = document.querySelector("#address")
        console.log(address.hasAttribute('disabled'))
        if (address.hasAttribute('disabled')) {
            address.removeAttribute('disabled');
        } else {
            address.setAttribute('disabled', 'disabled');
            if ((address.value != '')) {

            } else {
                window.alert("地址不得為空")
                address.value = useraddressV
            }
        }
    })

})()