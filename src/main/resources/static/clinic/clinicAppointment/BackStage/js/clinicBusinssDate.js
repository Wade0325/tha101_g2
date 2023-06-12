function deleteClick(businessSn) {
	if (!confirm('是否刪除?')) {
		return;
	}
	fetch(`../../../business/${businessSn}`, {
		method: `DELETE`,
	})
	location.reload();
}

function saveClick(businessSn) {
	const clinicName = document.querySelector(`#clinicName${businessSn}`).textContent;
	const vetName = document.querySelector(`#vetName${businessSn}`).textContent;
	const weekDate = document.querySelector(`#weekDate${businessSn}`).textContent;
	const morningBusiness = document.querySelector(`#morningBusiness${businessSn}`).textContent;
	const morningAppointMax = document.querySelector(`#morningAppointMax${businessSn}`).textContent;
	const afternoonBusiness = document.querySelector(`#afternoonBusiness${businessSn}`).textContent;
	const afternoonAppointMax = document.querySelector(`#afternoonAppointMax${businessSn}`).textContent;
	const nightBusiness = document.querySelector(`#nightBusiness${businessSn}`).textContent;
	const nightAppointMax = document.querySelector(`#nightAppointMax${businessSn}`).textContent;

	fetch(`../../../business/${businessSn}`, {
		method: 'PUT',
		headers: { 'Content-Type': 'application/json' },
		body: JSON.stringify({
			clinicName,
			vetName,
			weekDate,
			morningBusiness,
			morningAppointMax,
			afternoonBusiness,
			afternoonAppointMax,
			nightBusiness,
			nightAppointMax
		})
	})
		.then(resp => {
			if (resp.ok) {
				alert('修改成功!');
				location.reload();
			} else {
				alert('修改失败');
			}
		})
}






