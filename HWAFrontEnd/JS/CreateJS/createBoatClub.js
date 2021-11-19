'use strict';

// Get the elements needed
let nameInput = document.querySelector('#boatClubNameInput');
let addressInput = document.querySelector('#boatClubAddressInput');
let codeInput = document.querySelector('#boatClubCodeInput');
let coachFirstNameInput = document.querySelector('#headCoachFirstNameInput');
let coachSurnameInput = document.querySelector('#headCoachSurnameInput');

let createBtn = document.querySelector('#createBtn');

// Check if elements are getting retrieved
console.log(nameInput);
console.log(addressInput);
console.log(codeInput);
console.log(coachFirstNameInput);
console.log(coachSurnameInput);
console.log(createBtn);

// Function that saves the values from the input fields
let postData = () => {
    let nameValue = nameInput.value;
    let addressValue = addressInput.value;
    let codeValue = codeInput.value;
    let coachFirstNameValue = coachFirstNameInput.value;
    let coachSurnameValue = coachSurnameInput.value;

    let newBoatClub = {
        boatClubName: nameValue,
        address: addressValue,
        boatClubCode: codeValue,
        headCoachFirstName: coachFirstNameValue,
        headCoachSurname: coachSurnameValue
    };

    postFetch(newBoatClub);
}


// Fetch Request - POST method
let postFetch = (object) => {
    fetch('http://localhost:9000/boatclub/create', {
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
                    creationSuccess();
                }).catch((error) => {
                    creationFailure();
                    console.error(`${error}`);
                });
        });
}

// Function to create an alert when a boat club
// is successfully created
let creationSuccess = () => {
    let newAlert = document.createElement('div');
    newAlert.classList = "alert alert-success";
    newAlert.textContent = "Success! Your boat club has been created!";
    parentDiv.appendChild(newAlert);
}

// Function to create an alert if creation failed
let creationFailure = () => {
    let newAlert = document.createElement('div');
    newAlert.classList = "alert alert-danger";
    newAlert.textContent = "Something went wrong. Try again!";
    parentDiv.appendChild(newAlert);
}

// Event listener
createBtn.addEventListener('click', postData);