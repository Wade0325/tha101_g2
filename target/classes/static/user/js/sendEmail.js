(() => {
    const btn = document.querySelector("#buttonSendEmail")
    const email = document.querySelector("#email")
    btn.addEventListener("click", () => {
        // console.log(email.value);
        if (email.value !== '') {
            fetch('sendMail', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    recipient: email.value,
                }),
            })
        } else {
            window.alert("電子信箱不得為空")
        }
    })
})();