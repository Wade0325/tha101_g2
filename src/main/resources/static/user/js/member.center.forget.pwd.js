(() => {
    const msg_btn = document.querySelector("#msg_btn")
    const msg_btn_submit = document.querySelector("#msg_btn_submit")
    const email = document.querySelector("#email")
    const randonPassword = document.querySelector("#randonPassword")
    const btn = document.querySelector("#btn")
    const btn_submit = document.querySelector("#btn_submit")

    $("#btn").on("click", function () {
        if (email.value == '') {
            msg_btn.textContent = '信箱不得為空';
            return;
        }
        // 發送randon密碼的信件

    })

})()