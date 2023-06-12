function deleteClick(clinicId) {
	if (!confirm('是否刪除?')) {
		return;
	}
	fetch(`../../../manage/${clinicId}`, {
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
	const clinicName = document.querySelector(`#clinicname${clinicId}`).textContent;
	const clinicPrincipal = document.querySelector(`#clinicprincipal${clinicId}`).textContent;
	const clinicPassword = document.querySelector(`#clinicpassword${clinicId}`).textContent;
	const clinicPhone = document.querySelector(`#clinicphone${clinicId}`).textContent;
	const clinicAddress = document.querySelector(`#clinicaddress${clinicId}`).textContent;
	const clinicService = document.querySelector(`#clinicservice${clinicId}`).textContent;
	// const clinicEmail = sessionStorage.getItem('clinicemail');
	const clinicEmail = document.querySelector(`#clinicemail${clinicId}`).textContent;
	console.log(clinicEmail)
	fetch('../../../clinicMember/manage', {
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




