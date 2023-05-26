function deleteClick(clinicId) {
	if (!confirm('是否刪除?')) {
		return;
	}
	fetch(`manage/${clinicId}`, {
		method: `DELETE`,
	})
		.then(resp => resp.json())
		.then(body => {
			if (body.successful) {
				location.reload();
			}
		});
}

function saveClick(clinicId) {
	const clinicName = document.querySelector(`#clinicName${clinicId}`).textContent;
	const clinicPrincipal = document.querySelector(`#clinicPrincipal${clinicId}`).textContent;
	const clinicPassword = document.querySelector(`#clinicPassword${clinicId}`).textContent;
	const clinicPhone = document.querySelector(`#clinicPhone${clinicId}`).textContent;
	const clinicAddress = document.querySelector(`#clinicAddress${clinicId}`).textContent;
	const clinicService = document.querySelector(`#clinicService${clinicId}`).textContent;
	const clinicEmail = sessionStorage.getItem('clinicEmail');

	fetch('manage', {
		method: 'PUT',
		headers: { 'Content-Type': 'application/json' },
		body: JSON.stringify({
			clinicName,
			clinicPrincipal,
			clinicPassword,
			clinicPhone,
			clinicAddress,
			clinicService,
			clinicEmail
		})
	})
		.then(resp => resp.json())
		.then(body => {
			const { successful } = body;
			if (successful) {
				alert('修改成功!');
				location.reload();
			} else {
				alert('修改失敗');
				location.reload();
			}
		});
}


