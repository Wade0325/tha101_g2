(() => {
	const nav = document.createElement('nav');
	nav.classList.add('navbar', 'navbar-expand', 'navbar-dark', 'bg-dark');
	nav.innerHTML = `
    <div class="container-fluid">
		<a class="navbar-brand" href="${getContextPath()}/index.html">會員系統</a>
		<div class="collapse navbar-collapse" id="navbarScroll">
			<ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
				<li id="register" class="nav-item">
					<a href="${getContextPath()}/member/register.html" class="nav-link active" aria-current="page">註冊</a>
				</li>
				<li id="edit" class="nav-item">
					<a href="${getContextPath()}/member/edit.html" class="nav-link active" aria-current="page">編輯會員資訊</a>
				</li>
				<li id="chat" class="nav-item">
					<a href="${getContextPath()}/member/chat.html" class="nav-link active" aria-current="page">聊天室</a>
				</li>
                <li id="manage" class="nav-item">
					<a href="${getContextPath()}/member/manage" class="nav-link active" aria-current="page">會員管理</a>
				</li>
				<li id="login" class="nav-item">
					<a href="${getContextPath()}/member/login.html" class="nav-link active" aria-current="page">登入</a>
				</li>
				<li id="logout" class="nav-item">
					<a href="#" class="nav-link active" aria-current="page">登出</a>
				</li>
			</ul>
			<div class="d-flex">
				<div id="currentUser" class="me-2 text-light"></div>
			</div>
			<div class="d-flex">
				<img id="avatar" style="height: 50px;">
			</div>
		</div>
	</div>
`;
	const body = document.querySelector('body');
	body.insertBefore(nav, body.firstChild);

	const nickname = sessionStorage.getItem('nickname');
	const roleId = sessionStorage.getItem('roleId');
	const register = document.querySelector('#register');
	const edit = document.querySelector('#edit');
	const manage = document.querySelector('#manage');
	const login = document.querySelector('#login');
	const logout = document.querySelector('#logout');
	const image = sessionStorage.getItem('image');
	const chat = document.querySelector('#chat');
	if (nickname) {
		register.classList.add('hide');
		edit.classList.remove('hide');
		roleId == 1 ? manage.classList.remove('hide') : manage.classList.add('hide');
		login.classList.add('hide');
		logout.classList.remove('hide');
		document.querySelector('#currentUser').textContent = nickname;
		const imageBinaryStr = atob(image);
		let len = imageBinaryStr.length;
		const uint8Array = new Uint8Array(len);
		while (len--) {
			uint8Array[len] = imageBinaryStr.charCodeAt(len);
		}
		const blob = new Blob([uint8Array]);
		document.querySelector('#avatar').src = URL.createObjectURL(blob);
		chat.classList.remove('hide');
	} else {
		register.classList.remove('hide');
		edit.classList.add('hide');
		manage.classList.add('hide');
		login.classList.remove('hide');
		logout.classList.add('hide');
		chat.classList.add('hide');
	}

	logout.addEventListener('click', () => {
		sessionStorage.removeItem('nickname');
		fetch('member/logout');
		location = `${getContextPath()}/index.html`;
	});

	function getContextPath() {
		return window.location.pathname.substring(0, window.location.pathname.indexOf('/', 2));
	}
})();