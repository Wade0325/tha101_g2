(() => {

    const urlParams = new URLSearchParams(window.location.search);
    const articleId = urlParams.get('articleId');

    const tbody = document.querySelector('#tbody');
    const article_container = document.querySelector('#article-container');
    // const articleId = document.querySelector('#articleId');
    const articleTitle = document.querySelector('#articleTitle');
    const userId = document.querySelector('#userId');
    const articleCreateTime = document.querySelector('#articleCreateTime');
    const articleContent = document.querySelector('#articleContent');

    fetch(`article_cat/${articleId}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: {

        }
    })
        .then(resp => resp.json())
        .then(article => {
            const art = article;
            // console.log(art.article);

            articleId.textContent = art.articleId;
            articleTitle.textContent = art.articleTitle;
            articleContent.textContent = art.articleContent;
            articleCreateTime.textContent = art.articleCreateTime;
            userId.textContent = art.userId;



        });


    const replyButton = document.querySelector('#reply-button');
    replyButton.addEventListener('click', () => {
        window.location.href = `reply.html?articleId=${articleId}`;
    });


    var replyC = document.querySelector('#reply_content');
    var reC = document.querySelector('#rect');
    var replyContainer = document.querySelector('.reply-container');

    // console.log(reC); // null

    fetch(`article_cat/${articleId}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },

    })
        .then(resp => resp.json())
        .then(data => {
            console.log(data)
            for (const { replyContent } of data) {
                console.log(replyContent);

                const newDiv = document.createElement('div');
                newDiv.classList.add('reply-item');
                newDiv.setAttribute('style', 'color:black; font-size:20px');
                newDiv.innerHTML = `
                    <p>${replyContent}</p>
                    <hr>
                `;

                replyContainer.appendChild(newDiv);
            }
            // data.forEach(
            //     item => {
            //         const { replyContent } = item;
            //         console.log(replyContent);
            //         // console.log(reC); // null
            //         // replyC.innerText = item.replyContent;

            //         const newDiv = document.createElement('div');
            //         newDiv.classList.add(`reply-item`);
            //         newDiv.innerHTML = `
            //             <p>${item.replyContent}</p>
            //         `;
            //         console.log(newDiv);

            //         reply_Container.append(newDiv);

            //         console.log(newDiv);
            //         console.log(reC);


            //         // let replyCItemHTML = `
            //         // <div class="reply-item">
            //         //     <p>${item.replyContent}</p>
            //         // </div>
            //         // `;

            //         // replyContainer.innerHTML += replyCItemHTML;
            //     }
            // )
        })

})()
/*

.then(resp => resp.json())
        .then(article => {
            console.log(article);
            console.log(replyContent);

            replyContent.textContent = article.replyContent
        })
        .catch(error => {
            // 处理请求错误
            console.error('请求出错:', error);
        });


const urlParams = new URLSearchParams(window.location.search);
    const articleId2 = urlParams.get('articleId');

    const tbody = document.querySelector('#tbody');
    const article_container = document.querySelector('#article-container');
    const articleId = document.querySelector('#articleId');
    const articleTitle = document.querySelector('#articleTitle');
    const userId = document.querySelector('#userId');
    const articleCreateTime = document.querySelector('#articleCreateTime');
    const articleContent = document.querySelector('#articleContent');

    fetch('article_cat/${articleId2}', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: {

        }
    })
        .then(resp => resp.json())
        .then(article => {
            const art = article;
            console.log(art.article);

            articleId.textContent = art.articleId;
            articleTitle.textContent = art.articleTitle;
            articleContent.textContent = art.articleContent;
            articleCreateTime.textContent = art.articleCreateTime;
            userId.textContent = art.userId;

            

        })






    const articleContainer = document.querySelector('#articleContainer');
    const article_container = document.querySelector('.article-container');
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
            // modifierTime: null,
            // articleStatus: null
        }),

    })
        .then(resp => resp.json())
        .then(articleData => {
          
            articleContainer.innerHTML = `
             <h2 class="article-title">${articleData.articleTitle}</h2>
             <div class="article-info">
                <span class="article-author">作者:${articleData.userId}</span> |
                 <span class="article-time">發表時間：${articleData.articleCreateTime}</span>
             </div>
             <div class="article-content">
                 ${articleData.articleContent}
             </div>
             `;

        });


        // const replyForm = document.querySelector('#replyForm');
    // const replyBtn = document.querySelector('#replyBtn');
    // replyBtn.addEventListener('submit', (e) => {
    //     e.preventDefault();

    //     // 获取回复内容
    //     const replyContent = document.getElementById('replyContent').value;

    //     // 创建回复对象
    //     const reply = {
    //         articleId: articleId,
    //         replyContent: replyContent
    //     };

    //     fetch(`reply/${articleId}`, {
    //         method: 'POST',
    //         headers: {
    //             'Content-Type': 'application/json'
    //         },
    //         body: JSON.stringify(reply)
    //     })
    //         .then(resp => resp.json())
    //         .then(data => {
    //             alert('回复提交成功！');
    //             window.location.href = `article_cat.html?articleId=${articleId}`;
    //         })
    //         .catch(error => {
    //             console.error('发生错误', error);
    //             alert('发生错误', error);
    //         });
    // });


*/



