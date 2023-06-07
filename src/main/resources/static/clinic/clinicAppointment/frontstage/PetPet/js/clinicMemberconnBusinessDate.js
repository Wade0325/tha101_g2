const tbody = document.querySelector('#tbody');

// Fetch ClinicMember Data
const fetchClinicMemberData =
	fetch('../../../../clinicMember/manage', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: null
	})
		.then(resp => resp.json());

// Fetch BusinessData
const fetchBusinessData =
	fetch('../../../../business/all', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: null
	})
		.then(resp => resp.json());

// Function to merge ClinicMember and BusinessData
function mergeData(clinicMemberData, businessData) {
	const mergedData = [];
	for (let member of clinicMemberData) {
		const mergedItem = {
			...member,
			morningBusiness: '',
			morningAppointMax: '',
			afternoonBusiness: '',
			afternoonAppointMax: '',
			nightBusiness: '',
			nightAppointMax: ''
		};
		const matchingBusinessData = businessData.find(data => data.clinicName === member.clinicName);
		if (matchingBusinessData) {
			mergedItem.morningBusiness = matchingBusinessData.morningBusiness;
			mergedItem.morningAppointMax = matchingBusinessData.morningAppointMax;
			mergedItem.afternoonBusiness = matchingBusinessData.afternoonBusiness;
			mergedItem.afternoonAppointMax = matchingBusinessData.afternoonAppointMax;
			mergedItem.nightBusiness = matchingBusinessData.nightBusiness;
			mergedItem.nightAppointMax = matchingBusinessData.nightAppointMax;
		}
		mergedData.push(mergedItem);
	}
	return mergedData;
}

// 合併 ClinicMember and BusinessData表格到變數
Promise.all([fetchClinicMemberData, fetchBusinessData])
	.then(([clinicMemberData, businessData]) => {
		const mergedData = mergeData(clinicMemberData, businessData);
		displayMergedData(mergedData);
	});

// Function to display merged data in the table
function displayMergedData(data) {
	for (let item of data) {
		tbody.innerHTML += `
						<tr>
							<td>${item.clinicName}</td>
							<td>${item.clinicPhone}</td>
							<td>${item.clinicAddress}</td>
							<td>${item.morningBusiness}</td>
							<td>${item.morningAppointMax}</td>
							<td>${item.afternoonBusiness}</td>
							<td>${item.afternoonAppointMax}</td>
							<td>${item.nightBusiness}</td>
							<td>${item.nightAppointMax}</td>
						</tr>`;
	}
}
