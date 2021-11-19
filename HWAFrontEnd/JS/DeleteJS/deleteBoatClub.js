'use strict';

// Get required elements
let deleteBoatClubIdInput = document.querySelector('#deleteBoatClubIdInput');
let deleteBtn = document.querySelector('#deleteBtn');

// Check if elements are being retrieved
console.log(deleteBoatClubIdInput);
console.log(deleteBtn);

// Function to save value from input field
let deleteId = () => {
    let idValue = deleteBoatClubIdInput.value;

    // Fetch request - DELETE method
    deleteBoatClub(idValue);
}

// Function to delete boat club
let deleteBoatClub = (id) => {
    fetch(`http://localhost:9000/boatclub/delete/${id}`, {
        method: 'DELETE'
    })
        .then((response) => {
            if (response.status !== 200) {
                console.error(`Status: ${response.statusText}`);
                return;
            }
            console.log(response);
            console.log("Great success!");
        })
}

deleteBtn.addEventListener('click', deleteId);