const btn = document.querySelector('#submitbtn');
const clinic_service_name = document.querySelector('#clinic_service_name').value;
const service_price = document.querySelector('#service_price').value;
const service_discount_price = document.querySelector('#service_discount_price').value;
const service_item1 = document.querySelector('#service_item1').value;
const service_item2 = document.querySelector('#service_item2').value;
const service_item3 = document.querySelector('#service_item3').value;
const service_item4 = document.querySelector('#service_item4').value;
const service_img = document.querySelector('#service_img');
const file = document.querySelector('#file');

file.addEventListener('change', () => {
  service_img.src = URL.createObjectURL(file.files[0]);
});

document.querySelector('#submitbtn').addEventListener('click', (event) => {
  const fr = new FileReader();
  fr.addEventListener('load', (e) => {
    fetch('../PriceList', {
      method: "POST",
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        clinicServiceName: clinic_service_name,
        servicePrice: service_price,
        serviceDiscount_price: service_discount_price,
        serviceItem1: service_item1,
        serviceItem2: service_item2,
        serviceItem3: service_item3,
        serviceItem4: service_item4,
        serviceImg: btoa(e.target.result)
      })
    });
  });
  fr.readAsBinaryString(file.files[0]);
});
