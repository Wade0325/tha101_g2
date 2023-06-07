function deleteClick(reservationNumber) {
	if (!confirm('是否刪除?')) {
		return;
		console.log(${reservationNumber});
	}
	fetch(`../../../../../clinicAppointment/${reservationNumber}`, {
		method: `DELETE`,
	})
//	window.location.reload();
}