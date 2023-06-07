const urlParams = new URLSearchParams(window.location.search);
const id = urlParams.get('id');
const animalType = document.querySelector('#animalType');
const animalName = document.querySelector('#animalName');
const animalP1 = document.querySelector('#animalphoto');
const animalCate = document.querySelector('#animalCategory');
const animalNumber = document.querySelector('#animalNumber');
const animalGender = document.querySelector('#animalGender');
const animalAge = document.querySelector('#animalAge');
const animalColor = document.querySelector('#animalColor');
fetch(`animalfindbyid/${id}`, {
	method: 'POST',
	headers: {
		'Content-Type': 'application/json'
	},
	body: {

	}
})
	.then(resp => resp.json())
	.then(ShelterAnimal => {
		console.log(ShelterAnimal)
		const animal = ShelterAnimal;

		animalType.textContent = animal.animalType;
		animalName.textContent = animal.animalName;
		animalP1.src = animalP1.src + animal.animalPhoto1;
		animalCate.textContent = animal.animalCategory;
		animalNumber.textContent = animal.animalNumber;
		animalGender.textContent = animal.animalGender;




	})
	
const adoptname = document.querySelector('#name');	
const adopterid = document.querySelector('#id');	
const birth = document.querySelector('#birth');	
const email = document.querySelector('#email');	
const phonenumber = document.querySelector('#phonenumber');	
const calltime = document.querySelector('#calltime');	
const address = document.querySelector('#address');	
const hometype = document.querySelector('#hometype');	
const homesize = document.querySelector('#homesize');	
const plan = document.querySelector('#currentpets');	
const question = document.querySelector('#message');	
const date = document.querySelector('#applyDate');	
const delaybtn = document.querySelector('#delaybtn');

delaybtn.addEventListener('click', () => {
	console.log("aaa")
		const nameLength = adoptname.value.trim().length;
		const idLength = adopterid.value.trim().length;
		const birthLength = birth.value.trim().length;
		const emailLength = email.value.trim().length;
		const phoneLength = phonenumber.value.trim().length;
		const callLength = calltime.value.trim().length;
		const addLength = address.value.trim().length;
		const hometypeLength = hometype.value.trim().length;
		const homesizeLength = homesize.value.trim().length;
		const planLength = plan.value.trim().length;
		const questionLen = question.value.trim().length;
	
		if (nameLength === 0) {
			alert('名稱不可為空');
			return;
		} else if (idLength === 0) {
			alert('身分證不可為空');
			return;
		} else if (birthLength === 0) {
			alert('出生日期不可為空');
			return;
		} else if (emailLength === 0) {
			alert('信箱不可為空');
			return;
		} else if (phoneLength === 0) {
			alert('連絡電話不可為空');
			return;
		} else if (callLength === 0) {
			alert('聯絡時間不可為空');
			return;
		} else if (hometypeLength === 0) {
			alert('請輸入住家型態');
			return;
		} else if (addLength === 0) {
			alert('請輸入地址');
			return;
		} else if (homesizeLength === 0) {
			alert('請輸入居住坪數');
			return;
		} else if (planLength === 0) {
			alert('請輸入飼養計畫');
			return;
		} else if (questionLen === 0) {
			alert('請輸入提問');
			return;
		
		}


		var adopt = {
    adopterId: adopterid.value,
    adopterName: adoptname.value,
    adopterEmail: email.value,
    adopterBirth: birth.value,
    adopterPhone: phonenumber.value,
    adopterContactTime: calltime.value,
    adopterAddress: address.value,
    homeType: hometype.value,
    homeSize: hometype.value,
    plan: plan.value,
    question: question.value,
    adopterApplyDate: formattedDate,
    animalId:id
		};





		fetch('adoptupload', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify(adopt),
		})
			.then((resp) => resp.json())
			.then((body) => {
				const {successful, message} = body;
				if (successful) { 
					message.textcontent
					alert('送出成功 (｡◕∀◕｡) 請等候收容所與您聯絡');
					window.location.href = 'shelter.html';
				} else {
					alert('送出失敗QQ 請與聯絡');
				
				}
			})
			.catch((error) => {
				 console.error(error);


			});

	});

