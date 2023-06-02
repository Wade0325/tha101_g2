(() => {
    const btn = document.querySelector('#submitbtn');
    const clinicName = document.querySelector('#clinicName');
    const vetName = document.querySelector('#vetName');
    const appointTime = document.querySelector('#appointTime');
    const userName = document.querySelector('#userName');
    const ownerMobile = document.querySelector('#ownerMobile');
    const serviceItem = document.querySelector('#serviceItem');
    const petName = document.querySelector('#petName');
    const petType = document.querySelector('#petType');
    const petSituation = document.querySelector('#petSituation');
    const inputs = document.querySelectorAll('input');

    btn.addEventListener('click', () => {

        fetch('clinicAppointment', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                clinicName: clinicName.value,
                vetName: vetName.value,
                appointTime: appointTime.value,
                userName: userName.value,
                ownerMobile: ownerMobile.value,
                serviceItem: serviceItem.value,
                petName: petName.value,
                petType: petType.value,
                petSituation: petSituation.value
            }),
        })
            .then(resp => resp.json())
            .then(body => {
                //解構賦值 const successful = body.successful
                const { successful, message } = body;
                if (successful) {
                    for (let input of inputs) {
                        input.disabled = true;
                    }
                    btn.disabled = true;
                    msg.className = 'info';
                    msg.textContent = '預約成功';
                } else {
                    msg.className = 'error';
                    msg.textContent = '預約失敗，' + message;

                }
            });
    });

})();



