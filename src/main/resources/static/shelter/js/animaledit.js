const urlParams = new URLSearchParams(window.location.search);
const id = urlParams.get('id');

const delaybtn = document.querySelector('#delaybtn');
const animalId = document.querySelector('#animalId');
const userId = document.querySelector('#userId');
const animalName = document.querySelector('#animalName');
const animalNumber = document.querySelector('#animalId');
const animalType = document.querySelector('#animalType');
const animalCategory = document.querySelector('#animalCategory');
const animalColor = document.querySelector('#animalColor');
const animalGender = document.querySelector('#animalGender');
const animalDate = document.querySelector('#animalDate');
const animalAge = document.querySelector('#animalAge');
const animalDescribe = document.querySelector('#animalDescribe');
const animalP1 = document.querySelector('#animalPhoto1');
const animalP2 = document.querySelector('#animalPhoto2');
const animalP3 = document.querySelector('#animalPhoto3');
const ifAdopted = document.querySelector('#ifAdopted');
const fileInputs = document.querySelectorAll('.fileupload');
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
		animal = ShelterAnimal
		console.log(animal);
		animalName.value = animal.animalName;
		animalType.value = animal.animalType;
		animalCategory.value = animal.animalCategory;
		animalColor.value = animal.animalColor;
		animalGender.value = animal.animalGender;
		animalDate.value = animal.animalDate;
		animalAge.value = animal.animalAge;
		animalNumber.value = animal.animalNumber;
		animalDescribe.value = animal.animalDescribe;
		animalP1.src = animalP1.src + animal.animalPhoto1;
		animalP2.src = animalP2.src + animal.animalPhoto2;
		animalP3.src = animalP3.src + animal.animalPhoto3;


	})