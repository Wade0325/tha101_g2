const tbody = document.querySelector('#tbody');
fetch('findbyifadopted/0', {
	method: 'Post',
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
			const animalElement = document.createElement('div');
			animalElement.id = `animal_${animal.animalId}`;
			animalElement.classList.add('col-md-6', 'col-lg-3', 'ftco-animate', 'fadeInUp', 'ftco-animated');
			animalElement.innerHTML = `
				<div class="staff">
					<div class="img-wrap d-flex align-items-stretch">
						<div class="img align-self-stretch" style="background-image: url(data:image/jpeg;base64,${animal.animalPhoto1})"></div>
					</div>
					<div class="text pt-3 px-3 pb-4 text-center">
						<h3 id="animalName${animal.animalName}">${animal.animalName}</h3>
						<span class="position mb-2" id="animalCategory${animal.animalCategory}">${animal.animalCategory}</span>
						<div class="faded">
							<p>所屬收容所：${animal.shelterName}</p>
							<ul class="ftco-social text-center">
								<li class="ftco-animate"></li>
							</ul>
						</div>
					</div>
				</div>`;
		animalElement.addEventListener('click', () => {
				const animalId = animal.animalId;
				 window.location.href = `animal.html?id=${animalId}`;
			});

			tbody.appendChild(animalElement);
		}
	})




