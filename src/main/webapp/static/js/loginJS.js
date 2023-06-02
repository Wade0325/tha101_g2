(() => {
  const adminAccount = document.querySelector('#adminAccount');
  const adminPassword = document.querySelector('#adminPassword');
//  const errMsg = document.querySelector('#errMsg');
  document.getElementById('btn1').addEventListener('click', () => {
    fetch(`login/${adminAccount.value}/${adminPassword.value}`)
      .then(resp => resp.json())
      .then(body => {
        errMsg.textContent = '';
        const { successful, message } = body;
        if (successful) {
          const { id, nickname, roleId, image } = body;
          sessionStorage.setItem('id', id);
          sessionStorage.setItem('nickname', nickname);
          sessionStorage.setItem('roleId', roleId);
//          sessionStorage.setItem('image', image);
          location = '../index.html';
        } else {
          errMsg.textContent = message;
        }
      });
  });
})();