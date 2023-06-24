(() => {

    const urlParams = new URLSearchParams(window.location.search);
    const articleId = urlParams.get('articleId');

    const editButton = document.querySelector('#editBtn');
    editButton.addEventListener('click', (e) => {
        e.preventDefault();
        

        var articleContent  = document.getElementById('editContent').value;

        fetch(`edit_article/${articleId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(articleContent )
        })
        .then(function(resp) {
            if(resp.ok) {
                console.log('文章內容已更新');
                window.location.href = `article_cat.html?articleId=${articleId}`;
                alert('修改成功');
            } else {
                console.log('更新文章內容失敗');
                alert('修改失敗');
            }
        })
        .catch(function(error) {
            console.log('發生錯誤:', error);
        });
    });



}) ()