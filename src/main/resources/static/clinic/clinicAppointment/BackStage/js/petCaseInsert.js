(() => {
  const btn = document.querySelector('#submitbtn');
  const vet_sn = document.querySelector('#vetSn');
  const user_id = document.querySelector('#userId');
  const appoint_date = document.querySelector('#appointDate');
  const owner_mobile = document.querySelector('#ownerMobile');
  const pet_type = document.querySelector('#petType');
  const pet_name = document.querySelector('#petName');
  const pet_gender = document.querySelector('#petGender');
  const pet_age = document.querySelector('#petAge');
  const pet_situation = document.querySelector('#petSituation');
  const treatment = document.querySelector('#treatment');
  const result = document.querySelector('#result');

  btn.addEventListener('click', () => {
    const requestBody = {
      vetSn: vet_sn.value,
      userId: parseInt(user_id.value),
      appointDate: new Date(appoint_date.value),
      ownerMobile: owner_mobile.value,
      petType: pet_type.value,
      petName: pet_name.value,
      petGender: pet_gender.value,
      petAge: parseInt(pet_age.value),
      petSituation: pet_situation.value,
      treatment: treatment.value,
      result: result.value,
    };

    fetch('../../../petcases', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(requestBody),
    });
  });
})();
