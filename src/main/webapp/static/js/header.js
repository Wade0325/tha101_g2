(() => {
    `<!--做一個nav標籤 <nav></nav>-->`
      const nav = document.createElement('nav');
    `<!--將nav標籤加入class屬性 <nav class="sb-topnav navbar navbar-expand navbar-dark color"></nav> -->`
    nav.classList.add('sb-topnav', 'navbar', 'navbar-expand', 'navbar-dark', 'color');
      nav.innerHTML = `
      <!-- Navbar Brand-->
      <img src="./images/petpet.png" width="70px" height="70px" />
      <img src="./images/Petword.png" width="40px" height="40px" />
      <a class="navbar-brand ps-3" href="#">PETPET陪陪你</a>
      <!-- dropdown index-->
      <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
        <div class="dropdown">
          <button
            class="btn dropdown-toggle"
            type="button"
            id="dropdownMenu2"
            data-bs-toggle="dropdown"
            aria-expanded="false"
          >
            首頁
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
            <li><button class="dropdown-item" type="button">#</button></li>
            <li>
              <button class="dropdown-item" type="button">#</button>
            </li>
            <li>
              <button class="dropdown-item" type="button">#</button>
            </li>
          </ul>
        </div>
      </ul>

      <!-- dropdown index-->
      <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
        <div class="dropdown">
          <button
            class="btn dropdown-toggle"
            type="button"
            id="dropdownMenu2"
            data-bs-toggle="dropdown"
            aria-expanded="false"
          >
            論壇管理
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
            <li><button class="dropdown-item" type="button">#</button></li>
            <li>
              <button class="dropdown-item" type="button">#</button>
            </li>
            <li>
              <button class="dropdown-item" type="button">#</button>
            </li>
          </ul>
        </div>
      </ul>
      <!-- dropdown index-->
      <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
        <div class="dropdown">
          <button
            class="btn dropdown-toggle"
            type="button"
            id="dropdownMenu2"
            data-bs-toggle="dropdown"
            aria-expanded="false"
          >
            會員管理
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
            <li><button class="dropdown-item" type="button">#</button></li>
            <li>
              <button class="dropdown-item" type="button">#</button>
            </li>
            <li>
              <button class="dropdown-item" type="button">#</button>
            </li>
          </ul>
        </div>
      </ul>
      <!-- dropdown index-->
      <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
        <div class="dropdown">
          <button
            class="btn dropdown-toggle"
            type="button"
            id="dropdownMenu2"
            data-bs-toggle="dropdown"
            aria-expanded="false"
          >
            商城管理
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
            <li><button class="dropdown-item" type="button">#</button></li>
            <li>
              <button class="dropdown-item" type="button">#</button>
            </li>
            <li>
              <button class="dropdown-item" type="button">#</button>
            </li>
          </ul>
        </div>
      </ul>
      <!-- dropdown index-->
      <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
        <div class="dropdown">
          <button
            class="btn dropdown-toggle"
            type="button"
            id="dropdownMenu2"
            data-bs-toggle="dropdown"
            aria-expanded="false"
          >
            診所管理
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
            <li><button class="dropdown-item" type="button">#</button></li>
            <li>
              <button class="dropdown-item" type="button">#</button>
            </li>
            <li>
              <button class="dropdown-item" type="button">#</button>
            </li>
          </ul>
        </div>
      </ul>

      <form
        class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0"
      >
        <div class="input-group">
          <span class="navbar-text me-4" id="accName"> 管理員名稱 </span>
        </div>
      </form>
      <!-- Navbar-->
      <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
        <li class="nav-item dropdown">
          <a
            class="nav-link dropdown-toggle"
            id="navbarDropdown"
            href="#"
            role="button"
            data-bs-toggle="dropdown"
            aria-expanded="false"
            ><i class="fas fa-user fa-fw"></i
          ></a>
          <ul
            class="dropdown-menu dropdown-menu-end"
            aria-labelledby="navbarDropdown"
          >
            <li><a class="dropdown-item" href="Login2.html">註冊</a></li>
            <li><a class="dropdown-item" href="Login2.html">登入</a></li>
            <li><hr class="dropdown-divider" /></li>
            <li><a class="dropdown-item" href="#!">登出</a></li>
          </ul>
        </li>
      </ul>
  `;
  `<!--選取body元素-->`
  const body = document.querySelector('body');
      body.insertBefore(nav, body.firstChild);
  })();