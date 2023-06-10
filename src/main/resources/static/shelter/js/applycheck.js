const urlParams = new URLSearchParams(window.location.search);
const id = urlParams.get('applyid');
const animalid = urlParams.get('animalid');
const subbtn = document.querySelector('#delaybtn');
document.getElementById('userid').style.display = 'none';
document.getElementById('useraccount').style.display = 'none';


const useraccount = document.querySelector('#useraccount');
const userid = document.querySelector('#userid');
const animalType = document.querySelector('#animalType');
const animalName = document.querySelector('#animalName');
const animalP1 = document.querySelector('#animalphoto');
const animalCate = document.querySelector('#animalCategory');
const animalNumber = document.querySelector('#animalNumber');
const animalGender = document.querySelector('#animalGender');
const animalAge = document.querySelector('#animalAge');
const animalColor = document.querySelector('#animalColor');
const adoptname = document.querySelector('#name');	
const adopterid = document.querySelector('#id');	
const birth = document.querySelector('#birth');	
const email = document.querySelector('#email');	
const phonenumber = document.querySelector('#phonenumber');	
const calltime = document.querySelector('#calltime');	
const address = document.querySelector('#address');	
const hometype = document.querySelector('#hometype');	
const homesize = document.querySelector('#homesize');	
const plan = document.querySelector('#plan');	
const question = document.querySelector('#question');	
const date = document.querySelector('#applyDate');	
const delaybtn = document.querySelector('#delaybtn');
fetch(`animalfindbyid/${animalid}`, {
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
		
		if (animal.ifAdopted === 1){
			subbtn.setAttribute('disabled', 'true');
		}
	
		animalType.textContent = animal.animalType;
		animalName.textContent = animal.animalName;
		animalP1.src = animalP1.src + animal.animalPhoto1;
		animalCate.textContent = animal.animalCategory;
		animalNumber.textContent = animal.animalNumber;
		animalGender.textContent = animal.animalGender;

	})
	
	fetch(`adoptfindbyid/${id}`, {
	method: 'POST',
	headers: {
		'Content-Type': 'application/json'
	},
	body: {

	}
})
	.then(resp => resp.json())
	.then(AdoptApply => {
		const adopt = AdoptApply;
		adoptname.value = adopt.adopterName;
		adopterid.value = adopt.adopterId,
        email.value = adopt.adopterEmail,
        birth.value = adopt.adopterBirth,
        phonenumber.value = adopt.adopterPhone,
        calltime.value = adopt.adopterContactTime,
        address.value = adopt.adopterAddress,
        hometype.value = adopt.homeType,
        homesize.value = adopt.homeSize,
        plan.value = adopt.plan,
        question.value = adopt.question,
        date.textContent = adopt.adopterApplyDate 
        userid.value = adopt.userId;       
        useraccount.value = adopt.userAccount;       
		
	})
	





subbtn.addEventListener('click', function() {
  if (!confirm('確定設為領養人?')) {
    return;
  } else {
	  

    var shelteranimal = {  
      "ifAdopted": "1",
      "userId": userid.value,
      "userAccount": useraccount.value
    };
  
    fetch(`ifadopted/${animalid}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(shelteranimal),
    })
      .then((resp) => resp.json())
      .then((body) => {
        // 確認領養成功後進行頁面跳轉
        if (body.successful) {
          window.location.href = 'manageanimal.html';
        } else {
			window.location.href = 'animalmanage.html';
          // 可以根據需要顯示相應的失敗訊息
          // msg.className = 'error';
          // msg.textContent = '送出失敗';
        }
      })
      .catch((error) => {
		  window.location.href = 'manageanimal.html';
        // 處理錯誤並顯示相應的訊息
        // msg.className = 'error';
        // console.log(error.message);
      });
  }
});
