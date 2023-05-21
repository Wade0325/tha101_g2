(() => {
  const btn1 = document.querySelector('#btn1');
  const username = document.querySelector('#username');
  const nickname = document.querySelector('#nickname');
  const oPassword = document.querySelector('#oPassword');
  const lastUpdatedDate = document.querySelector('#lastUpdatedDate');
  const image = document.querySelector('#image');
  const preImage = document.querySelector('#preImage');
  init();

  function init() {
    btn1.addEventListener('click', edit);

    fetch('edit')
      .then(resp => resp.json())
      .then(body => {
        lastUpdatedDate.textContent = body['lastUpdatedDate'];
        username.value = body['username'];
        nickname.value = body['nickname'];
        const imageBinaryStr = atob(body['image']);
        let len = imageBinaryStr.length;
        const uint8Array = new Uint8Array(len);
        while (len--) {
          uint8Array[len] = imageBinaryStr.charCodeAt(len);
        }
        const blob = new Blob([uint8Array]);
        preImage.src = URL.createObjectURL(blob);
      });

    oPassword.addEventListener('blur', checkOldPassword);
    image.addEventListener('change', onImageChange)
  }

  function onImageChange() {
    const file = image.files[0];
    if (file) {
      preImage.src = URL.createObjectURL(file);
    }
  }

  function checkOldPassword() {
    fetch(`edit/${oPassword.value || '_'}`)
      .then(resp => resp.json())
      .then(body => {
        btn1.disabled = !body['successful']
      });
  }

  const msg = document.querySelector('#msg');
  const nPassword = document.querySelector('#nPassword');
  const confirmPassword = document.querySelector('#confirmPassword');
  const currentUser = document.querySelector('#currentUser');

  function edit() {
    if (nPassword.value && confirmPassword.value) {
      if (nPassword.value.length < 6 || nPassword.value.length > 12) {
        msg.textContent = '密碼長度須介於6~12字元';
        return;
      }

      if (confirmPassword.value !== nPassword.value) {
        msg.textContent = '密碼與確認密碼不相符';
        return;
      }
    }

    const nicknameLength = nickname.value.length;
    if (nicknameLength < 1 || nicknameLength > 20) {
      msg.textContent = '暱稱長度須介於1~20字元';
      return;
    }

    msg.textContent = '';
    if (image.files.length === 0) {
      requestEdit();
    } else {
      file2Base64Str(requestEdit);
    }

    function requestEdit(imageBase64) {
      fetch('edit', {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          password: nPassword.value,
          nickname: nickname.value,
          image: imageBase64
        }),
      })
        .then(resp => resp.json())
        .then(body => {
          const { successful, message, nickname: nicknameValue, image: imageValue } = body;
          if (successful) {
            msg.className = 'info';
            sessionStorage.setItem('nickname', nicknameValue);
            currentUser.textContent = nicknameValue;
            oPassword.value = '';
            nPassword.value = '';
            confirmPassword.value = '';
            nickname.value = nicknameValue;
            btn1.disabled = true;
            sessionStorage.setItem('image', imageValue);
            base64Str2Avatar();
          } else {
            msg.className = 'error';
          }
          msg.textContent = message;
        });
    }

    function file2Base64Str(next) {
      const fileReader = new FileReader();
      fileReader.addEventListener('load', e => {
        const imageBase64 = btoa(e.target.result);
        next(imageBase64);
      });
      fileReader.readAsBinaryString(image.files[0]);
    }

    function base64Str2Avatar() {
      const img = sessionStorage.getItem('image');
      if (!img) {
        return;
      }
      const imageBinaryStr = atob(img);
      let len = imageBinaryStr.length;
      const uint8Array = new Uint8Array(len);
      while (len--) {
        uint8Array[len] = imageBinaryStr.charCodeAt(len);
      }
      const blob = new Blob([uint8Array]);
      document.querySelector('#avatar').src = URL.createObjectURL(blob);
    }
  }

})();