function deleteClick(reservationNumber) {
	if (!confirm('是否刪除?')) {
		return;
	}
	fetch(`../../../../../clinicAppointment/${reservationNumber}`, {
		method: `DELETE`,
	})
	window.location.reload();
}