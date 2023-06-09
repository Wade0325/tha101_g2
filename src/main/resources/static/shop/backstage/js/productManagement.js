(() => {
    const pro_name = document.querySelector("#pro_name")
    const cate_name = document.querySelector("#cate_name")
    const pro_det = document.querySelector("#pro_det")
    const pro_price = document.querySelector("#pro_price")
    const pro_amount = document.querySelector("#pro_amount")
    const tbody = document.querySelector("#tbody")
    console.log("aaa")
    //後台取得商品
    fetch('../../getProduct', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(resp => resp.json())
        .then(data => {
            console.log(data)
            data.forEach(
                item => {
                    const { pro_name, cate_name, pro_det, pro_price, pro_amount } = item
                    console.log(pro_name)
                    const newRow = document.createElement('tr');
                    newRow.innerHTML = `
                        <td id="pro_name">${pro_name}</td>
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


                    // tbody.innerHTML +=
                    //     `<tr>
                    //     <td id="pro_name">${pro_name}</td>
                    //     <td id="cate_name">${cate_name}</td>
                    //     <td id="pro_det">${pro_det}</td>
                    //     <td id="pro_price">${pro_price}</td>
                    //     <td id="pro_amount">${pro_amount}</td>
                    //     <td>
                    //         <button class="btn btn-action btn-edit">編輯</button>
                    //         <button class="btn btn-action btn-delete">刪除</button>
                    //     </td>
                    //     </tr>`
                }
            )
        })

    tbody.addEventListener('click', function (event) {
        if (event.target.classList.contains('btn-delete')) {
            const row = event.target.closest('tr');
            const pro_name = row.querySelector('#pro_name').textContent;

            // 在這裡執行刪除按鈕的處理邏輯
            console.log(this);
            const proName = document.querySelector("#pro_name").textContent
            console.log(proName);

            fetch(`../../delProduct/${proName}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'text/plain', // 將 Content-Type 設置為 'text/plain'
                },
                body: {

                }
            })

            // 刪除
            row.remove();
        }
    })
})()