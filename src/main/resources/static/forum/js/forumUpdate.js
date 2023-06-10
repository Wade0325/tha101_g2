(() => {

    // const urlParams = new URLSearchParams(window.location.search);
    // const id = urlParams.get('id');

    const articleGroupId = document.querySelector("#articleGroupId");
    const articleId = document.querySelector('#articleId');
    const articleList = document.querySelector('#articleList');

    fetch('http://localhost:8080/petpet/forum/forum')
        .then(resp => resp.json())
        .then(data => {
            // console.log(data);
            renderArticles(data);
        })
        .catch(error => {
            console.error('发生错误', error);
        });

    function renderArticles(articles) {

        let articleListHTML = '';

        // 生成文章列表的 HTML
        articles.forEach(article => {
            let articleGroupIdText = '';
            if (article.articleGroupId === 1) {
                articleGroupIdText = '【貓貓討論區】';
            } else if (article.articleGroupId === 2) {
                articleGroupIdText = '【狗狗討論區】';
            }

            let articleItemHTML = `
                <div class="dog-discussion" id="${article.articleId}">
                    <h5>
                        <span>${articleGroupIdText}</span>
                        <span><a  href="http://localhost:8080/petpet/forum/article_cat.html?articleId=${article.articleId}">${article.articleTitle}</a></span>
                        <span><a  href="http://localhost:8080/petpet/forum/article_cat.html?articleId=${article.articleId}">${article.articleContent}</a></span>
                    </h5>
                </div>
            `;
            // href="http://localhost:8080/petpet/forum/article_cat.html/${article.articleId}" class="article-link" data-articleid="${articleId}
            articleListHTML += articleItemHTML;
        });

        const articleListDiv = document.getElementById('articleList');
        articleListDiv.innerHTML = articleListHTML;

        const articleLinks = document.querySelectorAll('.article-link');
        articleLinks.forEach(articleLink => {
            
            const title = articleLink.dataset.title;
            const content = articleLink.dataset.content;
            window.location.href = `article_cat.html?articleId=${articleId}`;
        });

    }
    // function getArticleGroupIdText(groupId) {
    //     if (groupId === 1) {
    //         return '【貓貓討論區】';
    //     } else if (groupId === 2) {
    //         return '【狗狗討論區】';
    //     } else {
    //         return '';
    //     }
    // }

    // function getArticleLink(groupId) {
    //     if (groupId === 1) {
    //         return 'article_cat.html';
    //     } else if (groupId === 2) {
    //         return 'article_dog.html';
    //     } else {
    //         return '#';
    //     }
    // }

    // const articleItemDiv = document.createElement('div');
    //         articleItemDiv.className = 'cat-discussion'; // 默认使用 cat-discussion 样式

    //         if (article.articleGroupId === 1) {
    //             articleItemDiv.className = 'cat-discussion'; // 使用 cat-discussion 样式
    //         } else if (article.articleGroupId === 2) {
    //             articleItemDiv.className = 'dog-discussion'; // 使用 dog-discussion 样式
    //         }

    //         const articleTitle = document.createElement('h5');
    //         articleTitle.textContent = article.articleTitle;

    //         const articleContent = document.createElement('span');
    //         articleContent.textContent = article.articleContent;

    //         const articleGroupId = document.createElement('span');
    //         articleGroupId.textContent = '【貓貓討論區】'; // 根据需要设置内容

    //         const articleLink = document.createElement('a');
    //         articleLink.href = 'article_cat.html'; // 根据需要设置链接

    //         const articleLinkText = document.createTextNode('大家好這是我剛領養的貓貓'); // 根据需要设置链接文本
    //         articleLink.appendChild(articleLinkText);

    //         articleItemDiv.appendChild(articleGroupId);
    //         articleItemDiv.appendChild(articleLink);
    //         articleItemDiv.appendChild(articleTitle);
    //         articleItemDiv.appendChild(articleContent);

    //         articleListDiv.appendChild(articleItemDiv);


})()

