function onSaveClick(id) {
    const username = document.querySelector(`#username${id}`).textContent;
    const password = document.querySelector(`#password${id}`).textContent;
    const nickname = document.querySelector(`#nickname${id}`).textContent;
    const pass = !!+document.querySelector(`#pass${id}`).value;
    const roleId = document.querySelector(`#roleId${id}`).value;
    const updater = sessionStorage.getItem('nickname');

    fetch('manage', {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            id,
            username,
            password,
            nickname,
            pass,
            roleId,
            updater
        })
    })
        .then(resp => resp.json())
        .then(body => {
            const { successful, message } = body;
            if (successful) {
                alert('存檔成功!');
                location.reload();
            } else {
                alert(message ?? '存檔失敗');
            }
        });
}

function onRemoveClick(id) {
    if (!confirm('確定刪除?')) {
        return;
    }
    fetch(`manage/${id}`, {
        method: 'DELETE',
    })

        .then(resp => resp.json())
        .then(body => {
            if (body.successful) {
                location.reload();
            }
        });
}