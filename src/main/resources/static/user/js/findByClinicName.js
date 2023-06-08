(() => {


    console.log("aaa")
    console.log("aaa")
    fetch('../../../../clinicAppointment/all', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: {

        }
    })
        .then(resp => resp.json())
        .then(ClinicAppointment => {
            for (let appointment of ClinicAppointment) {
                console.log(appointment);

                tbody.innerHTML += `
				<tr>
					<td>${appointment.reservationNumber}</td>
					<td id="clinicName${appointment.reservationNumber}">${appointment.clinicName}</td>
					<td id="vetName${appointment.reservationNumber}">${appointment.vetName}</td>
					<td>${appointment.appointDate}</td>
					<td id="appointTime${appointment.reservationNumber}">${appointment.appointTime}</td>
					<td id="ownerMobile${appointment.reservationNumber}">${appointment.ownerMobile}</td>
					<td id="petType${appointment.reservationNumber}">${appointment.petType}</td>
					<td id="petName${appointment.reservationNumber}">${appointment.petName}</td>
					<td id="serviceItem${appointment.reservationNumber}">${appointment.serviceItem}</td>
					<td id="ownerName${appointment.reservationNumber}">${appointment.ownerName}</td>
					<td id="petSituation${appointment.reservationNumber}">${appointment.petSituation}</td>
					
					<td>
<!--						<button type="button" class="btn-edit" onclick="saveClick(${appointment.reservationNumber})">儲存</button> -->
						<button type="button" class="btn-delete" onclick="deleteClick(${appointment.reservationNumber})">刪除</button>
					</td>
				</tr>`
            }
        })
})()

