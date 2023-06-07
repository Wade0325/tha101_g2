(() => {
    // function likeArticle() {
    //     var likeCount = document.getElementById('like-count');
    //     var currentCount = parseInt(likeCount.innerText);
    //     likeCount.innerText = currentCount + 1;
    // }

    // function dislikeArticle() {
    //     var dislikeCount = document.getElementById('dislike-count');
    //     var currentCount = parseInt(dislikeCount.innerText);
    //     dislikeCount.innerText = currentCount + 1;
    // }



    document.getElementById('reply-form').addEventListener('submit', function (e) {
        e.preventDefault();

        var replyName = document.getElementById('reply-name').value;
        var replyMessage = document.getElementById('reply-message').value;

        if (replyName.trim() !== '' && replyMessage.trim() !== '') {
            var replySection = document.getElementById('reply-section');

            var replyContainer = document.createElement('div');
            replyContainer.className = 'reply-container';

            var replyInfo = document.createElement('div');
            replyInfo.className = 'reply-info';
            replyInfo.textContent = '回覆人：' + replyName + ' | ' + getCurrentTime();

            var replyContent = document.createElement('div');
            replyContent.className = 'reply-content';
            replyContent.textContent = replyMessage;

            replyContainer.appendChild(replyInfo);
            replyContainer.appendChild(replyContent);
            replySection.appendChild(replyContainer);

            // 清空回覆框
            document.getElementById('reply-name').value = '';
            document.getElementById('reply-message').value = '';
        }
    });

    function getCurrentTime() {
        var currentDate = new Date();
        var year = currentDate.getFullYear();
        var month = ('0' + (currentDate.getMonth() + 1)).slice(-2);
        var day = ('0' + currentDate.getDate()).slice(-2);
        var hours = ('0' + currentDate.getHours()).slice(-2);
        var minutes = ('0' + currentDate.getMinutes()).slice(-2);
        var seconds = ('0' + currentDate.getSeconds()).slice(-2);
        var currentTime = year + '-' + month + '-' + day + ' ' + hours + ':' + minutes + ':' + seconds;
        return currentTime;
    }

    // // 收藏功能
    // function bookmarkArticle() {
    //     // 假設已經獲得文章的相關資訊，例如文章編號或識別碼
    //     const articleId = "123456";

    //     // 執行收藏文章的相關操作，例如發送 POST 請求到後端
    //     fetch(`/api/bookmark/${articleId}`, {
    //         method: "POST",
    //         // 其他相關設定和資料
    //     })
    //         .then(response => response.json())
    //         .then(data => {
    //             // 收藏成功，執行相應的處理邏輯
    //             console.log("文章已被收藏");
    //         })
    //         .catch(error => {
    //             // 收藏失敗，處理錯誤情況
    //             console.error("收藏文章時發生錯誤：", error);
    //         });
    // }

    // 檢舉功能
    function reportArticle() {

        // 在點擊「檢舉」按鈕後跳轉到檢舉文章的頁面
        window.location.href = 'report_article.html'; // 替換為檢舉文章頁面的 URL

        // // 假設已經獲得文章的相關資訊，例如文章編號或識別碼
        // const articleId = "123456";
        // const reportReason = "不適當內容";

        // // 執行檢舉文章的相關操作，例如發送 POST 請求到後端
        // fetch(`/api/report/${articleId}`, {
        //     method: "POST",
        //     headers: {
        //         "Content-Type": "application/json"
        //     },
        //     body: JSON.stringify({
        //         reason: reportReason
        //     })
        // })
        //     .then(response => response.json())
        //     .then(data => {
        //         // 檢舉成功，執行相應的處理邏輯
        //         alert("文章已被檢舉");
        //     })
        //     .catch(error => {
        //         // 檢舉失敗，處理錯誤情況
        //         alert("檢舉文章時發生錯誤：", error);
        //     });
    }

    // 監聽收藏按鈕點擊事件
    // const bookmarkBtn = document.getElementById("bookmark-btn");
    // bookmarkBtn.addEventListener("click", bookmarkArticle);

    // 監聽檢舉按鈕點擊事件
    const reportBtn = document.getElementById("report-btn");
    reportBtn.addEventListener("click", reportArticle);
})()


