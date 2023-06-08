(() => {
    console.log("aaa")
    fetch('../clinicAppointment', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        },
    })
        .then(resp => resp.json())
        .then(ClinicAppointment => {
            for (let appointment of ClinicAppointment) {
                console.log(appointment);

                tbody.innerHTML += `
    				<tr>
    				 	<td>${appointment.clinicName}</td>
    					<td>${appointment.vetName}</td>
    					<td>${appointment.appointDate}</td>
    					<td>${appointment.appointTime}</td>
    					<td>${appointment.ownerName}</td>
                        <td>${appointment.ownerMobile}</td>
    					<td>${appointment.petType}</td>
    					<td>${appointment.petName}</td>
    					<td>${appointment.serviceItem}</td>
    					<td>${appointment.petSituation}</td>
    				</tr>`
            }
        })
})()

