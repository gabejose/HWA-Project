'use strict';

// Get elements required
let boatIdInput = document.querySelector('#boatIdInput');
let boatTypeInput = document.querySelector('#boatTypeInput');
let boatCompanyInput = document.querySelector('#boatCompanyInput');
let avgCrewWeightInput = document.querySelector('#avgCrewWeightInput');
let riggerMaterialInput = document.querySelector('#riggerMaterialInput');
let isWingRiggerInput = document.querySelector('#isWingRiggerInput');
let boatClubIdInput = document.querySelector('#boatClubIdInput');
let updateBtn = document.querySelector('#updateBtn');

// Check if all elements are being retrieved
console.log(boatIdInput);
console.log(boatTypeInput);
console.log(boatCompanyInput);
console.log(avgCrewWeightInput);
console.log(riggerMaterialInput);
console.log(isWingRiggerInput);
console.log(boatClubIdInput);
console.log(updateBtn);

// Function that gets the ID
let getId = () => {
    let boatIdValue = boatIdInput.value;
    updateFetch(boatIdValue);
}


// Function that updates the desired boat
let updateFetch = (id) => {
    let updatedBoat = {
        boatType: boatTypeInput.value,
        boatCompany: boatCompanyInput.value,
        averageCrewWeight: avgCrewWeightInput.value,
        riggerMaterial: riggerMaterialInput.value,
        wingRigger: isWingRiggerInput.value,
        boatClubId: boatClubIdInput.value
    }

    fetch(`http://localhost:9000/boat/update/${id}`, {
        method: 'PUT',
        headers: {
            "Content-type": "application/JSON"
        },
        body: JSON.stringify(updatedBoat)
    })
        .then((response) => {
            if (response.status !== 200) {
                console.error(`Status: ${response.status}`);
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

// Event Listener
updateBtn.addEventListener('click', getId);