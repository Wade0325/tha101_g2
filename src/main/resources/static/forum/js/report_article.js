(() => {

    $(document).ready(function () {
        // 监听表单提交事件
        $("#report-article-form").submit(function (event) {
            event.preventDefault(); // 阻止表单默认提交行为

            var currentTime = new Date(); // 獲取當前時間
            var formattedTime = currentTime.toISOString();// 格式化時間
            var reportTime = formattedTime; 
            

            var userId = $("#userId").val();
            // var articleId = $("#articleId").val();
            var articleId = 35;
            var userId = 5;
            var reportReason = $("#reportReason").val(); // 获取举报原因
            

            // 创建一个包含举报原因的数据对象
            // var data = {
            //     reporterId: reporterId,
            //     articleId: articleId,
            //     reportReason: reportReason,
            //     reportTime: reportTime
            // };

            // 发送请求到后端
            fetch('report_article', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    userId: userId,
                    articleId: articleId,
                    reportReason: reportReason,
                    reportTime: reportTime
                }),
            })
                .then((response) => response.json())
                .then((data) => {
                    alert("举报成功");
                    // 在此处进行页面重定向或显示成功消息等操作
                    // window.location.href = "forum.html";
                })
                .catch((error) => {
                    alert("举报失败");
                    // 在此处显示错误消息等操作
                    // window.location.href = "forum.html";
                });
        });
    });


})();














// function reportArticle() {
//     // 執行檢舉相關的操作，例如發送檢舉請求等
//     const articleId = '文章的唯一識別符'; // 根據您的需求設置文章的唯一識別符

//     // 發送檢舉請求
//     fetch('http://localhost:8080/petpet/forum/report', {
//         method: 'POST',
//         body: JSON.stringify({ articleId }), // 將文章的唯一識別符作為請求的內容
//         headers: {
//             'Content-Type': 'application/json'
//         }
//     })
//         .then(resp => resp.json())
//         .then(data => {
//             if (data.successful) {
//                 alert('檢舉成功');
//                 // 在檢舉成功後進行相應的處理，例如顯示成功提示、更新頁面等
//                 window.location.href = 'forum.html'; // 跳轉回論壇首頁
//             } else {
//                 alert('檢舉失敗');
//                 // 在檢舉失敗後進行相應的處理，例如顯示錯誤提示、處理錯誤狀態等
//                 window.location.href = 'forum.html'; // 跳轉回論壇首頁
//             }
//         })
//         .catch(error => {
//             console.error('發生錯誤', error);
//         });

//     // 跳轉到檢舉頁面
//     window.location.href = 'report_article.html'; // 根據檢舉頁面的 URL 進行相應的設置
// }
