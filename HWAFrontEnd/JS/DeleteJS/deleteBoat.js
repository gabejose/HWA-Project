'use strict';

// Get required elements
let deleteBoatIdInput = document.querySelector('#deleteBoatIdInput');
let deleteBtn = document.querySelector('#deleteBtn');

// Check if elements are being retrieved
console.log(deleteBoatIdInput);
console.log(deleteBtn);

// Function to save value from input field
let deleteId = () => {
    let idValue = deleteBoatIdInput.value;
    deleteBoat(idValue);
}

// Function to delete boat
let deleteBoat = (id) => {
    fetch(`http://localhost:9000/boat/deleteBoat/${id}`, {
        method: 'DELETE'
    })
        .then((response) => {
            if (response.status !== 200) {
                console.error(`Status: ${response.statusText}`);
                return;
            }
            console.log(response);
            console.log("Great success!");
        });
}

// Event listener
deleteBtn.addEventListener('click', deleteId);