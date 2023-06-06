(() => {

    const userId = document.querySelector('#userId');
    var articleId = '';

    fetch('/forum/article_cat.html' + articleId)
        .then(resp => resp.json())
        .then(data => {
            renderArticle(data);
        })
        .catch(error => {
            console.error('发生错误', error);
            alert("article_list_for_chat.js發生錯誤");
        });

    function renderArticle(article) {
        const articleTitle = document.querySelector('.article-title');
        const articleAuthor = document.querySelector('.article-author');
        const articleTime = document.querySelector('.article-time');
        const articleContent = document.querySelector('.article-content');

        articleTitle.textContent = article.articleTitle;
        articleAuthor.textContent = `作者：` + article.userId;
        articleTime.textContent = `发表时间：` + article.articleCreateTime;
        articleContent.textContent = article.articleContent;
    }

})()