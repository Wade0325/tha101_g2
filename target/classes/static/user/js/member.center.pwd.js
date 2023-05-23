$("#btn_update_address").on("click", function () {
    if (window.confirm("確定要修改密碼?")) {
        if (newPassword.value == confirmPassword.value) {
            console.log(newPassword.value)
            fetch('insert', () => {

            })
        }
    }

})
