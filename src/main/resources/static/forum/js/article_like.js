(() => {

    function likeArticle() {
        const likeBtn = document.querySelector('#like-btn');
        const likeCountElement = document.querySelector('#like-count');

        let isLiked = false;

        likeBtn.addEventListener('click', () => {
            if (!isLiked) {
                // 增加點讚數
                let likeCount = parseInt(likeCountElement.innerText);
                likeCount++;
                likeCountElement.innerText = likeCount;

                // 發送後端請求
                fetch('http://localhost:8080/petpet/forum/article_cat.html', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        // 傳遞相關資料給後端
                        
                    })
                })
                    .then(response => response.json())
                    .then(data => {
                        // 在收到後端的回應後進行相應的處理
                        console.log('點讚成功');
                    })
                    .catch(error => {
                        // 處理錯誤情況
                        console.error('點讚時發生錯誤:', error);
                    });
            }
        });


    }

    likeArticle();
})();

/* <div class="article-reaction">
    <button class="reaction-btn" id="like-btn" onclick="likeArticle()">讚</button>
    <button class="reaction-btn" id="dislike-btn" onclick="dislikeArticle()">踩</button>
    <span id="like-count">0</span> 人讚 |
    <span id="dislike-count">0</span> 人踩
    <button class="reaction-btn" id="bookmark-btn" onclick="bookmarkArticle()">收藏</button>
    <button class="reaction-btn" id="report-btn" onclick="reportArticle()">檢舉</button>
</div> */