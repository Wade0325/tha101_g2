// (() => {
//     var verifyText = document.querySelector("#verifyText");
//     var btn = document.querySelector("#buttonVerify");
//     var email = document.querySelector("#email");
//     btn.addEventListener("click", () => {
//         verifyCode = verifyText.value
//         userAccount = email.value

//         fetch(`checkVerify/${verifyCode}/${userAccount}`, {
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'text/plain', // 將 Content-Type 設置為 'text/plain'
//             },
//             body: {

//             }
//         })
//             .then(response => response.text()) // 解析回傳的文字資料
//             .then(body => {
//                 console.log(body)
//                 if (body == "true") {
//                     window.alert("驗證成功")
//                     verifyText.value = ''
//                 } else {
//                     window.alert("驗證失敗")
//                     verifyText.value = ''
//                 }
//             });
//     })
// })()