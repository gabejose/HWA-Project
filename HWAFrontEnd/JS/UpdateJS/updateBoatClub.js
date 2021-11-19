'use strict';

// Get elements required
let boatClubIdInput = document.querySelector('#boatClubIdInput');
let boatClubNameInput = document.querySelector('#boatClubNameInput');
let boatClubAddressInput = document.querySelector('#boatClubAddressInput');
let boatClubCodeInput = document.querySelector('#boatClubCodeInput');
let headCoachFirstNameInput = document.querySelector('#headCoachFirstNameInput');
let headCoachSurnameInput = document.querySelector('#headCoachSurnameInput');
let updateBtn = document.querySelector('#updateBtn');

// Check if all elements are being retrieved
console.log(boatClubIdInput);
console.log(boatClubNameInput);
console.log(boatClubAddressInput);
console.log(boatClubCodeInput);
console.log(headCoachFirstNameInput);
console.log(headCoachSurnameInput);
console.log(updateBtn);

// Function that gets the ID
let getId = () => {
    let boatClubIdValue = boatClubIdInput.value;
    updateFetch(boatClubIdValue);
}

// Function that updates the desired boat club
let updateFetch = (id) => {

    let updatedBoatClub = {
        boatClubName: boatClubNameInput.value,
        address: boatClubAddressInput.value,
        boatClubCode: boatClubCodeInput.value,
        headCoachFirstName: headCoachFirstNameInput.value,
        headCoachSurname: headCoachSurnameInput.value
    }

    fetch(`http://localhost:9000/boatclub/update/${id}`, {
        method: 'PUT',
        headers: {
            "Content-type": "application/JSON"
        },
        body: JSON.stringify(updatedBoatClub)
    })
        .then((response) => {
            if (response.status !== 200) {
                console.error(`Status is: ${response.status}`);
                return;
            }
            response.json()
                .then((data) => {
                    console.log(data);
                }).catch((error) => {
                    console.error(`${error}`);
                });
        });
}

updateBtn.addEventListener('click', getId);