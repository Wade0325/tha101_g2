const tbody = document.querySelector('#tbody');
fetch('animalmanage', {
	method: 'POST',
	headers: {
		'Content-Type': 'application/json'
	},
	body: {

	}
})
	.then(resp => resp.json())
	.then(ShelterAnimal => {
		for (let animal of ShelterAnimal) {
			console.log(animal);
			  const adoptionStatus = animal.ifAdopted === 1 ? '已領養' : '未領養';
			tbody.innerHTML += `
				<tr>
				<td id="animalName${animal.animalName}">${animal.animalName}</td>
				<td id="animalNum${animal.animalNameber}">${animal.animalNumber}</td>
				<td id="userId${animal.userId}">${animal.userId}</td>
				<td><a href="applylist.html?id=${animal.animalId}" onclick="apply(${animal.animalId})">查看申請人</a></td>
				<td class="button-td">
					<button type="button" class="btn-edit btn btn-success" onclick="editItem(${animal.animalId})">編輯</button>
				</td>
				<td class="button-td">
					<button type="button" class="btn-delete btn btn-danger" onclick="deleteClick(${animal.animalId})">刪除</button>
				</td>
				<td id="animalId${animal.animalId}" style="display: none;">${animal.animalId}</td>
				<td id="animalId${animal.ifAdopted}" >${adoptionStatus}</td>
				</tr>`
		}
	})

function deleteClick(animalId) {
	if (!confirm('是否刪除?')) {
		return;
	}
	fetch(`deleteanimal/${animalId}`, {
		method: `DELETE`,
	})
		.then(resp => {
			if (resp.ok) {
				location.reload(); // 删除成功，重新加载页面
			} else {
				alert('刪除失敗'); // 删除失败，显示错误消息
			}
		})
		.catch(error => {
			console.error(error);
			alert('刪除失敗'); // 删除失败，显示错误消息
		});
}

function editItem(animalId) {
	window.location.href = `animaledit.html?id=${animalId}`;
}