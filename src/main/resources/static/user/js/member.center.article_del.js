(() => {
    const btn = document.querySelector("#button")

    btn.addEventListener('click', () => {
        console.log(row.articleId)
        fetch(`../forum/delete/${articleId}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            },
            body: {
                articleId: row.articleId
            }
        }).then()

    })
})()