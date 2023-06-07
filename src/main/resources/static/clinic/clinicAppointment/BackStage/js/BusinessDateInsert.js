document.addEventListener('DOMContentLoaded', () => {
  const btn = document.querySelector('#submitbtn2');
  const clinicName = document.querySelector('#clinicName');
  const vetSn = document.querySelector('#vetSn');
  const weekDate = document.querySelector('#weekDate');
  const morningBusiness = document.querySelector('#morningBusiness');
  const morningAppointMax = document.querySelector('#morningAppointMax');
  const afternoonBusiness = document.querySelector('#afternoonBusiness');
  const afternoonAppointMax = document.querySelector('#afternoonAppointMax');
  const nightBusiness = document.querySelector('#nightBusiness');
  const nightAppointMax = document.querySelector('#nightAppointMax');

  const morningBusinessSelect = document.querySelector('#morningBusiness');
  const morningAppointMaxSelect = document.querySelector('#morningAppointMax');

  const afternoonBusinessSelect = document.querySelector('#afternoonBusiness');
  const afternoonAppointMaxSelect = document.querySelector('#afternoonAppointMax');

  const nightBusinessSelect = document.querySelector('#nightBusiness');
  const nightAppointMaxSelect = document.querySelector('#nightAppointMax');

  morningBusinessSelect.addEventListener('change', () => {
    const selectedOption = morningBusinessSelect.value;

    if (selectedOption === '否') {
      morningAppointMaxSelect.value = 0;
      morningAppointMaxSelect.disabled = true;
    } else {
      morningAppointMaxSelect.disabled = false;
    }
  });

  afternoonBusinessSelect.addEventListener('change', () => {
    const selectedOption = afternoonBusinessSelect.value;

    if (selectedOption === '否') {
      afternoonAppointMaxSelect.value = 0;
      afternoonAppointMaxSelect.disabled = true;
    } else {
      afternoonAppointMaxSelect.disabled = false;
    }
  });

  nightBusinessSelect.addEventListener('change', () => {
    const selectedOption = nightBusinessSelect.value;

    if (selectedOption === '否') {
      nightAppointMaxSelect.value = 0;
      nightAppointMaxSelect.disabled = true;
    } else {
      nightAppointMaxSelect.disabled = false;
    }
  });

  btn.addEventListener('click', () => {
    if (confirm('確認營業時間?')) {
      const data = {
        clinicName: clinicName.value,
        vetSn: vetSn.value,
        weekDate: weekDate.value,
        morningBusiness: morningBusiness.value,
        morningAppointMax: morningAppointMax.value,
        afternoonBusiness: afternoonBusiness.value,
        afternoonAppointMax: afternoonAppointMax.value,
        nightBusiness: nightBusiness.value,
        nightAppointMax: nightAppointMax.value,
      };

      fetch('../../../business', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
      })
        .then((response) => response.json())
        .then((body) => {
          const { successful } = body;
          if (successful) {
			  console.log("更新成功");
            window.location.reload();
          }
        })
        .catch((error) => {
          console.log('Error:', error);
        });
    }
     window.location.reload();
  });
});
