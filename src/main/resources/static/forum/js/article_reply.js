(() => {

    const urlParams = new URLSearchParams(window.location.search);
    const articleId = urlParams.get('articleId');

    const replyForm = document.querySelectorAll('#replyForm');
    const replyBtn = document.querySelector('#replyBtn');

    replyBtn.addEventListener('click', (e) => {
        e.preventDefault();



        // 获取回复内容
        const replyContent = document.getElementById('replyContent').value;

        if (replyContent.trim() === '') {
            alert('请输入回复内容');
            return;
        }

        // 创建回复对象
        const reply = {
            articleId: articleId,
            replyContent: replyContent
        };

        // 将回复发送到服务器进行处理   article_cat/${articleId}
        fetch(`reply/${articleId}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(reply)
        })
            .then(() => {
                alert("回覆成功");
                window.location.href = `article_cat.html?articleId=${articleId}`;
            })
            .catch((error) => {
                alert('回覆失败' + error);
            })



    });

})();


  // const replyContent = document.querySelector('#reply_content');

    // fetch(`article_cat/${articleId}`, {
    //     method: 'GET',
    //     headers: {
    //         'Content-Type': 'application/json',
    //     },
    // })
    //     .then(resp => resp.json())
    //     .then(article => {
    //         console.log(article);
    //     })