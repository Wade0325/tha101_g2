(() => {

    function reportArticle() {
        // 執行檢舉相關的操作，例如發送檢舉請求等
        const articleId = '文章的唯一識別符'; // 根據您的需求設置文章的唯一識別符

        // 發送檢舉請求
        fetch('http://localhost:8080/petpet/forum/report', {
            method: 'POST',
            body: JSON.stringify({ articleId }), // 將文章的唯一識別符作為請求的內容
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(resp => resp.json())
            .then(data => {
                if (data.successful) {
                    alert('檢舉成功');
                    // 在檢舉成功後進行相應的處理，例如顯示成功提示、更新頁面等
                    window.location.href = 'forum.html'; // 跳轉回論壇首頁
                } else {
                    alert('檢舉失敗');
                    // 在檢舉失敗後進行相應的處理，例如顯示錯誤提示、處理錯誤狀態等
                    window.location.href = 'forum.html'; // 跳轉回論壇首頁
                }
            })
            .catch(error => {
                console.error('發生錯誤', error);
            });

        // 跳轉到檢舉頁面
        window.location.href = 'report_article.html'; // 根據檢舉頁面的 URL 進行相應的設置
    }


})()