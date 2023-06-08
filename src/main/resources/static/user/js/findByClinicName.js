(() => {
    console.log("aaa")
    console.log("aaa")


    fetch('userController/getUser', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
    })
})()

