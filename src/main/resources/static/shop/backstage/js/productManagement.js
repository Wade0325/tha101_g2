


(() => {
    const pro_name = document.querySelector("#pro_name")
    const cate_name = document.querySelector("#cate_name")
    const pro_det = document.querySelector("#pro_det")
    const pro_price = document.querySelector("#pro_price")
    const pro_amount = document.querySelector("#pro_amount")
    const tbody = document.querySelector("#tbody")

    // 後台取得商品
    fetch('http://localhost:8080/petpet/shoptestall', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(resp => resp.json())
        .then(data => {
            console.log(data)
            data.forEach(item => {
                const { pro_name, cate_name, pro_det, pro_price, pro_amount, pro_id ,pro_pic1} = item

                const newRow = document.createElement('tr');
                newRow.innerHTML = `
                <img src="data:image/png;base64,${pro_pic1}">
                    <td class="pro_name ${pro_id}">${pro_name}</td>
                    <td id="cate_name">${cate_name}</td>
                    <td id="pro_det">${pro_det}</td>
                    <td id="pro_price">${pro_price}</td>
                    <td id="pro_amount">${pro_amount}</td>
                    <td>
                        <button class="btn btn-action btn-edit">編輯</button>
                        <button class="btn btn-action btn-delete">刪除</button>
                    </td>
                `;

                tbody.appendChild(newRow);
            });
        });

        tbody.addEventListener('click', function (event) {
            if (event.target.classList.contains('btn-delete')) {
                const row = event.target.closest('tr');
                const proName = row.querySelector('.pro_name').textContent;
                const proId = row.querySelector('.pro_name').classList[1]; // 获取 pro_id 值
                console.log(proId);
                console.log("test");
                
                // 使用 alert 確認刪除操作
                const confirmDelete = confirm(`確定要刪除商品 ${proName} 嗎？`);
                
                if (confirmDelete) {
                    // 发送 DELETE 请求，删除对应商品
                    fetch(`http://localhost:8080/petpet/shopnumberdelete/${proId}`, {
                        method: 'DELETE',
                        headers: {
                            'Content-Type': 'text/plain',
                        },
                        body: {}
                    });
        
                    // 删除行
                    row.remove();
                }
            }
        });
        

    tbody.addEventListener('click', function (event) {
        if (event.target.classList.contains('btn-edit')) {
            const row = event.target.closest('tr');
            const proName = row.querySelector('.pro_name').textContent;
            const proId = row.querySelector('.pro_name').classList[1]; // 获取 pro_id 值
            const cateName = row.querySelector('#cate_name').textContent;
            const proDet = row.querySelector('#pro_det').textContent;
            const proPrice = row.querySelector('#pro_price').textContent;
            const proAmount = row.querySelector('#pro_amount').textContent;

            // 将商品信息填充到编辑模态框中
            document.querySelector('#edit-pro-name').value = proName;
            document.querySelector('#selecttest').value = cateName;
            document.querySelector('#edit-pro-det').value = proDet;
            document.querySelector('#edit-pro-price').value = proPrice;
            document.querySelector('#edit-pro-amount').value = proAmount;

            // 显示编辑模态框
            document.querySelector('#edit-modal').style.display = 'block';

            // 监听编辑确认按钮的点击事件
            document.querySelector('#edit-confirm').addEventListener('click', function () {
                // 获取修改后的商品信息
                const editedProName = document.querySelector('#edit-pro-name').value;
                const editedCateName = document.querySelector('#selecttest').value;
                const editedProDet = document.querySelector('#edit-pro-det').value;
                const editedProPrice = document.querySelector('#edit-pro-price').value;
                const editedProAmount = document.querySelector('#edit-pro-amount').value;

                // 构造包含修改后的商品信息的对象
                const modifiedData = {
                    pro_name: editedProName,
                    cate_name: editedCateName,
                    pro_det: editedProDet,
                    pro_price: editedProPrice,
                    pro_amount: editedProAmount
                };

                // 发送 PUT 请求，将修改后的商品信息发送给后端
                fetch(`http://localhost:8080/petpet/shoptest/${proId}`, {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify(modifiedData),
                })
                    .then(response => response.json())
                    .then(data => {
                        // 在成功收到后端的响应后，执行相应的处理逻辑
                        alert('商品信息已成功修改');
                        const editModal = document.querySelector('#edit-modal');
                        editModal.style.display = 'none';
                        window.location.reload();
                    })
                    .catch(error => {
                        // 处理错误情况
                        console.error('修改商品信息时发生错误:', error);
                    });
            });
        }
    });

      // 獲取取消按鈕元素
      const cancelBtn = document.querySelector("#cancel-btn");
      console.log("testcan");
       // 點擊取消按鈕時隱藏編輯小畫面
       cancelBtn.addEventListener("click", function() {
          console.log("te");
       const editModal = document.querySelector("#edit-modal");
       editModal.style.display = "none";
  
   });

    // const addForm = document.querySelector('#add-form');
    // addForm.addEventListener('submit', function (event) {
    //     event.preventDefault();

    //     // 获取新增商品的表单数据
    //     const formData = new FormData(addForm);
    //     const proName = formData.get('pro_name');
    //     const cateName = formData.get('cate_name');
    //     const proDet = formData.get('pro_det');
    //     const proPrice = formData.get('pro_price');
    //     const proAmount = formData.get('pro_amount');

    //     // 构造包含新增商品信息的对象
    //     const newProduct = {
    //         pro_name: proName,
    //         cate_name: cateName,
    //         pro_det: proDet,
    //         pro_price: proPrice,
    //         pro_amount: proAmount
    //     };

    //     // 发送 POST 请求，将新增商品信息发送给后端
    //     fetch('http://localhost:8080/petpet/shoptest', {
    //         method: 'POST',
    //         headers: {
    //             'Content-Type': 'application/json',
    //         },
    //         body: JSON.stringify(newProduct),
    //     })
    //         .then(response => response.json())
    //         .then(data => {
    //             // 在成功收到后端的响应后，执行相应的处理逻辑
    //             alert('商品已成功添加');
    //             addForm.reset();
    //             window.location.reload();
    //         })
    //         .catch(error => {
    //             // 处理错误情况
    //             console.error('添加商品时发生错误:', error);
    //         });
    // });
    
   

})();


