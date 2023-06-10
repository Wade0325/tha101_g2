document.addEventListener('DOMContentLoaded', function () {
    const articleContainer = document.querySelector('#articleContainer');
    const articleId = 30;
    const articleTitle = '';
    const userId = '';
    const articleCreateTime = '';
    const articleContent = '';
    const articleGroupId = '';
    const articleImage = '';

    fetch('article_cat', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            articleId: articleId,
            userId: 0,
            articleGroupId: articleGroupId,
            articleTitle: articleTitle,
            articleContent: articleContent,
            articleImage: articleImage,
            articleCreateTime: articleCreateTime,
        }),
    })
        .then(resp => resp.json())
        .then(articleData => {
            articleContainer.innerHTML = `
            <h2 class="article-title">${articleData.articleTitle}</h2>
            <div class="article-info">
                <span class="article-author">作者: ${articleData.userId}</span> |
                <span class="article-time">發表時間：${articleData.articleCreateTime}</span>
            </div>
            <div class="article-content">
                ${articleData.articleContent}
            </div>
        `;
        });
});
