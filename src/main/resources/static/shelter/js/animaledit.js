const delaybtn = document.querySelector('#delaybtn');
const animalId = document.querySelector('#animalId');
const userId = document.querySelector('#userId');
const animalName = document.querySelector('#animalName');
const animalType = document.querySelector('#animalType');
const animalCategory = document.querySelector('#animalCategory');
const animalColor = document.querySelector('#animalColor');
const animalGender = document.querySelector('#animalGender');
const animalDate = document.querySelector('#animalDate');
const animalAge = document.querySelector('#animalAge');
const animalDescribe = document.querySelector('#animalDescribe');
const ifAdopted = document.querySelector('#ifAdopted');
const fileInputs = document.querySelectorAll('.fileupload');
fetch('animalfindbyid/{animaId}', {
	method: 'POST',
	headers: {
		'Content-Type': 'application/json'
	},
	body: {

	}
})
	.then(resp => resp.json())
	.then(ShelterAnimal => {
		for (let animal of ShelterAnimal) {
			console.log(animal);
			animalName.value = '${animalName}'; 
			animalType.value = '${animalType}';  
			animalCategory.value = '${animalCategory}';  
			animalColor.value = '${animalColor}';   
			animalGender.value = '${animalGender}';  
			animalDate.value = '${animalDate}';   
			animalAge.value = '${animalAge}';  
			animalDescribe.value = '${animalDescribe}'; 

		}
	})