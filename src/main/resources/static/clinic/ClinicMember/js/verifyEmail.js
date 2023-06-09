(() => {
    const verifyText = document.querySelector("#verifyText");
    const btn = document.querySelector("#buttonVerify");
    btn.addEventListener("click", () => {
        // console.log("有綁到")

        fetch('verify', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                verifiCode: verifyText.value,
            }),
        })
    })
})()