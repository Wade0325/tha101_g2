(() => {
    const pro_name = document.querySelector("#pro_name")
    const cate_name = document.querySelector("#cate_name")
    const pro_det = document.querySelector("#pro_det")
    const pro_price = document.querySelector("#pro_price")
    const pro_amount = document.querySelector("#pro_amount")

    //後台取得商品
    fetch('getProduct', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(resp => resp.json())
        .then(body => {

        })


})