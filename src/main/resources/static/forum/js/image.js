

// var preview = document.querySelector("#preview");
// var postForm = document.querySelector("#postForm");
// var postImage = document.querySelector("#postImage");

// postImage.onchange = function (e) {
//     var files = this.files;
//     var pettern = /^image/;

//     preview.innerHTML = "";

//     for (var i = 0; i < files.length; i++) {
//         var file = files[i];

//         if (!pettern.test(file.type)) {
//             alert("圖片格式不正確");
//             continue;
//         }

//         formData.append('articleImage', file);

//         var reader = new FileReader();
//         reader.onload = function (event) {
//             preview.innerHTML += '<img src="' + event.target.result + '"/>'
//         }
//         reader.readAsDataURL(file);
//     }
// };

// postForm.onsubmit = function (e) {
//     e.preventDefault();

//     var formData = new FormData(postForm);

//     fetch('publish', {
//         method: 'POST',
//         body: formData
//     })
//         .then(response => response.json())
//         .then(data => {
//             // 處理後端返回的數據
//             console.log(data);
//             // 清空預覽區域和表單
//             preview.innerHTML = "";
//             postForm.reset();
//         })
//         .catch(error => {
//             // 處理錯誤
//             alert('發生錯誤', error)
//         });
// };
