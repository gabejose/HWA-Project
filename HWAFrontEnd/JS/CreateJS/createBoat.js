'use strict';

// Get elements needed
let boatTypeInput = document.querySelector('#boatTypeInput');
let boatCompanyInput = document.querySelector('#boatCompanyInput');
let avgCrewWeightInput = document.querySelector('#avgCrewWeightInput');
let riggerMaterialInput = document.querySelector('#riggerMaterialInput');
let isWingRiggerInput = document.querySelector('#isWingRiggerInput');
let boatClubIdInput = document.querySelector('#boatClubIdInput');

let createBtn = document.querySelector('#createBtn');

// Check if elements are getting retrieved
console.log(boatTypeInput);
console.log(boatCompanyInput);
console.log(avgCrewWeightInput);
console.log(riggerMaterialInput);
console.log(isWingRiggerInput);
console.log(boatClubIdInput);
console.log(createBtn);

// Function that saves the values from the input fields
let postData = () => {
    let typeValue = boatTypeInput.value;
    let companyValue = boatCompanyInput.value;
    let weightValue = avgCrewWeightInput.value;
    let materialValue = riggerMaterialInput.value;
    let wingValue = isWingRiggerInput.value;
    let clubIdValue = boatClubIdInput.value;

    let newBoat = {
        boatType: typeValue,
        boatCompany: companyValue,
        averageCrewWeight: weightValue,
        riggerMaterial: materialValue,
        isWingRigger: wingValue,
        boatClubId: clubIdValue
    };

    postFetch(newBoat);
}

// Fetch request - POST method
let postFetch = (object) => {
    fetch('http://localhost:9000/boat/createBoat', {
        method: 'POST',
        headers: {
            "Content-type": "application/JSON"
        },
        body: JSON.stringify(object)
    })
        .then((response) => {
            console.log(response.status);
            if (response.status !== 200) {
                console.error(`Status: ${response.status}`);
                return;
            }
            response.json()
                .then((data) => {
                    console.log(data);
                    console.log("Great success!");
                }).catch((error) => {
                    console.error(`${error}`);
                });
        });
}

// Event listener
createBtn.addEventListener('click', postData);