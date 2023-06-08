function searchClinicAppointment() {
	const searchInput = document.querySelector('#searchInput');
	const clinicName = searchInput.value;

	// 清空表格內容
	tbody.innerHTML = '';

	fetch('../../../../clinicAppointment/' + clinicName,
		{
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({
				clinicName: clinicName
			})
		})
		.then(resp => resp.json())
		.then(ClinicAppointment => {
			for (let appointment of ClinicAppointment) {
				tbody.innerHTML += `
                    <tr>
                        <td>${appointment.clinicName}</td>
                        <td id="vetName${appointment.clinicName}">${appointment.vetName}</td>
                        <td>${appointment.clinicName}</td>
                        <td id="appointTime${appointment.clinicName}">${appointment.appointTime}</td>
                        <td id="ownerMobile${appointment.clinicName}">${appointment.ownerMobile}</td>
                        <td id="petType${appointment.clinicName}">${appointment.petType}</td>
                        <td id="petName${appointment.clinicName}">${appointment.petName}</td>
                        <td id="serviceItem${appointment.clinicName}">${appointment.serviceItem}</td>
                        <td id="ownerName${appointment.clinicName}">${appointment.ownerName}</td>
                        <td id="petSituation${appointment.clinicName}">${appointment.petSituation}</td>
                        
                        <td>
                            <button type="button" class="btn-edit" onclick="saveClick(${appointment.clinicName})">儲存</button>
                            <button type="button" class="btn-delete" onclick="deleteClick(${appointment.clinicName})">刪除</button>
                        </td>
                    </tr>`;
			}
		});
}

