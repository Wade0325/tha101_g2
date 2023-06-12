const btn = document.querySelector('#submitbtn');
const file = document.querySelector('#file');

file.addEventListener('change', () => {
  const service_img = document.querySelector('#service_img');
  service_img.src = URL.createObjectURL(file.files[0]);
});

document.querySelector('#submitbtn').addEventListener('click', async (event) => {
  event.preventDefault();

  const clinic_service_name = document.querySelector('#clinic_service_name').value;
  const service_price = document.querySelector('#service_price').value;
  const service_discount_price = document.querySelector('#service_discount_price').value;
  const service_item1 = document.querySelector('#service_item1').value;
  const service_item2 = document.querySelector('#service_item2').value;
  const service_item3 = document.querySelector('#service_item3').value;
  const service_item4 = document.querySelector('#service_item4').value;
  const file = document.querySelector('#file');

  const fr = new FileReader();
  fr.addEventListener('load', async (e) => {
    const base64Img = e.target.result.split(',')[1]; // 获取 base64 字符串部分

    try {
      const response = await fetch('../../PriceList', {
        method: "POST",
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          clinicServiceName: clinic_service_name,
          servicePrice: service_price,
          serviceDiscountPrice: service_discount_price,
          serviceItem1: service_item1,
          serviceItem2: service_item2,
          serviceItem3: service_item3,
          serviceItem4: service_item4,
          serviceImg: base64Img
        })
      });

      if (response.ok) {
        alert('成功提交表單！');
        // 在這裡執行您希望在成功後進行的操作
      } else {
        alert('提交表單失敗！');
      }
    } catch (error) {
      console.log('錯誤：', error);
    }
  });

  fr.readAsDataURL(file.files[0]);
});

//const btn = document.querySelector('#submitbtn');
//const file = document.querySelector('#file');
//
//file.addEventListener('change', () => {
//  const service_img = document.querySelector('#service_img');
//  service_img.src = URL.createObjectURL(file.files[0]);
//});
//
//document.querySelector('#submitbtn').addEventListener('click', (event) => {
//  event.preventDefault();
//
//  const clinic_service_name = document.querySelector('#clinic_service_name').value;
//  const service_price = document.querySelector('#service_price').value;
//  const service_discount_price = document.querySelector('#service_discount_price').value;
//  const service_item1 = document.querySelector('#service_item1').value;
//  const service_item2 = document.querySelector('#service_item2').value;
//  const service_item3 = document.querySelector('#service_item3').value;
//  const service_item4 = document.querySelector('#service_item4').value;
//  const file = document.querySelector('#file');
//
//  const fr = new FileReader();
//  fr.addEventListener('load', (e) => {
//    const base64Img = e.target.result.split(',')[1]; // 获取 base64 字符串部分
//    fetch('../../PriceList', {
//      method: "POST",
//      headers: {
//        'Content-Type': 'application/json'
//      },
//      body: JSON.stringify({
//        clinicServiceName: clinic_service_name,
//        servicePrice: service_price,
//        serviceDiscountPrice: service_discount_price,
//        serviceItem1: service_item1,
//        serviceItem2: service_item2,
//        serviceItem3: service_item3,
//        serviceItem4: service_item4,
//        serviceImg: base64Img
//      })
//    });
//  })
//   .then(response => {
//    if (response.ok) {
//      alert('成功提交表單！');
//      // 在這裡執行您希望在成功後進行的操作
//    } else {
//      alert('提交表單失敗！');
//    }
//  })
//  .catch(error => {
//    console.log('錯誤：', error);
//  });
//  fr.readAsDataURL(file.files[0]);
//});
