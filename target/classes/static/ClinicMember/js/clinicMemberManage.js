(() => {
	const btn = document.getElementById('btn-manage')

	btn.addEventListener('click', function() {
		console.log("有觸發")
		window.location.href = 'manage.html';
	})
})();