const btn = document.querySelector('#submitbtn');
const file = document.querySelector('#file');

file.addEventListener('change', () => {
  const service_img = document.querySelector('#service_img');
  service_img.src = URL.createObjectURL(file.files[0]);
});

document.querySelector('#submitbtn').addEventListener('click', (event) => {
  event.preventDefault();

  const clinic_id = document.querySelector('#clinic_id').value;
  const vet_name = document.querySelector('#vet_name').value;
  const vet_gender = document.querySelector('#vet_gender').value;s
  const speciality= document.querySelector('#speciality').value;
  const seniority = document.querySelector('#seniority').value;
  
//   const fr = new FileReader();
//   fr.addEventListener('load', (e) => {
//     const base64Img = e.target.result.split(',')[1]; // 获取 base64 字符串部分
    fetch('../PriceList', {
      method: "POST",
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        clinicId: clinic_id,
        vetName: vet_name,
        vetGender: vet_gender,
        speciality:  speciality,
        seniority: seniority,
        // serviceImg: base64Img
      })
    });
  });
//   fr.readAsDataURL(file.files[0]);
// });
