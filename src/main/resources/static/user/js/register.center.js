(() => {
    fetch('findById', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(resp => resp.json())
        .then(body => {
            const { userEmail, userName, userTel, userAddr } = body;
            nickName.value = userName
        })


    const nickName = document.querySelector("#nickName")
    const phone = document.querySelector("#phone")
    const address = document.querySelector("#address")
    const Email = document.querySelector("#Email")
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
                fetch('findById', {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                })
            } else {
                window.alert("電話不得為空")
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
                fetch('findById', {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                })
            } else {
                window.alert("地址不得為空")
            }
        }
    })

})()