(() => {
	const btn = document.querySelector('#sumbitbtn');
	const clinic_service_name = document.querySelector('#clinic_service_name');
	const service_price = document.querySelector('#service_price');
	const service_discount_price = document.querySelector('#service_discount_price');
	const service_item1 = document.querySelector('#service_item1');
	const service_item2 = document.querySelector('#service_item2');
    const service_item3 = document.querySelector('#service_item3');
    const service_item4 = document.querySelector('#service_item4');
	btn.addEventListener('click', () => {
		console.log("有用到嗎")
		fetch('clinicMember/clinic_pricelist_intsert', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({
				clinicServiceName: clinic_service_name.value,
		        servicePrice: service_price.value, 
                service_discount_price: service_discount_price.value,
                service_item1: service_item1.value,
                service_item2: service_item2.value,
                service_item3: service_item3.value,
                service_item4: service_item4.value
			}),
		})
			.then(resp => resp.json())
			.then(body => {
				//解構賦值 const successful = body.successful
				const { successful,message } = body; 
				if (successful) {
					for (let input of inputs) {
						input.disabled = true;
					}
					btn.disabled = true;
					msg.className = 'info';
					msg.textContent = '註冊成功';
				} else {
					msg.className = 'error';
					msg.textContent = '註冊失敗，' + message;
					
				}
			});
	});

})();



    