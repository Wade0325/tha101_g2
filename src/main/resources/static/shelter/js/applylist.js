const urlParams = new URLSearchParams(window.location.search);
const id = urlParams.get('id');

const tbody = document.querySelector('#tbody');
fetch(`findbyanimalid/${id}`, {
	method: 'POST',
	headers: {
		'Content-Type': 'application/json'
	},
	body: {

	}
})
	.then(resp => resp.json())
	.then(AdoptApply => {
		for (let adopt  of AdoptApply) {
//		const adopt = AdoptApply;

			tbody.innerHTML += `
				<tr>
				<td id="applyId${adopt.applyId}">${adopt.applyId}</td>
				<td id="animalId${adopt.animalId}">${adopt.animalId}</td>
				<td id="adopter${adopt.adopterId}">${adopt.adopterId}</td>
				<td id="adopter${adopt.adopterApplyDate}">${adopt.adopterApplyDate}</td>	
				<td class="button-td">			
					<button type="button" class="btn-edit btn btn-success" onclick="editItem(${adopt.applyId},${adopt.animalId})">查看</button>
				</td>
				<td class="button-td">
					<button type="button" class="btn-delete btn btn-danger" onclick="deleteClick(${adopt.applyId})">刪除</button>
				</td>
				</tr>`
		}
	})

function deleteClick(applyId) {
	if (!confirm('是否刪除?')) {
		return;
	}
	fetch(`deleteanimal/${applyId}`, {
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

function editItem(applyId,animalId) {
	window.open(`applycheck.html?applyid=${applyId}&animalid=${animalId}`, '_blank');
}
