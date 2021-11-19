'use strict';

// Get the required elements
let readAllBtn = document.querySelector('#readAllBtn');
let readByIdBtn = document.querySelector('#readByIdBtn');
let boatClubIdInput = document.querySelector('#boatClubIdInput');

// Check if they are getting retrieved
console.log(readAllBtn);
console.log(readByIdBtn);
console.log(boatClubIdInput);

// Function to read all boats (Fetch request - GET method)
let readAll = () => {
    fetch('http://localhost:9000/boatclub/getAll')
        .then((response) => {
            if (response.status !== 202) {
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


readAllBtn.addEventListener('click', readAll);