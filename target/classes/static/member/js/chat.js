(() => {
    const url = `ws://${location.host}${location.pathname.substring(0, location.pathname.lastIndexOf('/') + 1)}chat`;
    const btnConnect = document.querySelector('#btnConnect');
    const messages = document.querySelector('#messages');
    const text = document.querySelector('#text');
    const btnSubmit = document.querySelector('#btnSubmit');
    const username = sessionStorage.getItem('nickname');
    let webSocket;

    btnConnect.addEventListener('click', () => {
        webSocket = new WebSocket(url);
        webSocket.addEventListener('open', e => {
            btnConnect.disabled = true;
            text.disabled = false;
            btnSubmit.disabled = false;
        });

        webSocket.addEventListener('message', e => {
            messages.value += `${e.data}\n`;
        });

        webSocket.addEventListener('close', e => {
            btnConnect.disabled = false;
            text.disabled = true;
            btnSubmit.disabled = true;
        });

        webSocket.addEventListener('error', e => {
            alert('Error!');
            btnConnect.disabled = false;
            text.disabled = true;
            btnSubmit.disabled = true;
        });
    });

    btnSubmit.addEventListener('click', () => {
        if (webSocket) {
            webSocket.send(`${username}: ${text.value}`);
            text.value = '';
        }
    });
})();
