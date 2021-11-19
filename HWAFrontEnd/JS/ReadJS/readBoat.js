'use strict';

// Get the required elements
let readAllBtn = document.querySelector('#readAllBtn');
let readByIdBtn = document.querySelector('#readByIdBtn');
let boatIdInput = document.querySelector('#boatIdInput');
let boatTable = document.querySelector('#boatTable');
let clearTableBtn = document.querySelector('#clearTableBtn');

// Check if elements are getting retrieved
console.log(readAllBtn);
console.log(readByIdBtn);
console.log(boatIdInput);
console.log(boatTable);
console.log(clearTableBtn);

// Function to save value of input field
let getId = () => {
    let boatIdValue = boatIdInput.value;
    readById(boatIdValue);
}

// Function to clear the table
let clearTable = () => {
    let clearBody = document.querySelector('tbody');
    boatTable.removeChild(clearBody);
}

// Function to read all boats
let readAll = () => {
    fetch('http://localhost:9000/boat/getAllBoats')
        .then((response) => {
            if (response.status !== 202) {
                console.error(`Status: ${response.status}`);
                return;
            }
            response.json()
                .then((data) => {
                    console.log(data);
                    for (let obj of data) {
                        createTable(obj);
                    }
                }).catch((error) => {
                    console.error(`${error}`);
                });
        });
}

// Function to read a boat by ID
let readById = (id) => {
    fetch(`http://localhost:9000/boat/getBoatById/${id}`)
        .then((response) => {
            if (response.status !== 200) {
                console.error(`Status: ${response.status}`);
                return;
            }
            response.json()
                .then((data) => {
                    console.log(data);
                    createTable(data);
                }).catch((error) => {
                    console.error(`${error}`);
                })
        })
}

// Function to create a table containing boat data
let createTable = (data) => {

    // Create elements
    let newTableBody = document.createElement('tbody');
    let newTableRow = document.createElement('tr');
    let newTableBoatIdCell = document.createElement('td');
    let newTableBoatTypeCell = document.createElement('td');
    let newTableBoatCompanyCell = document.createElement('td');
    let newTableAvgWeightCell = document.createElement('td');
    let newTableMaterialCell = document.createElement('td');
    let newTableWingRiggerCell = document.createElement('td');
    let newTableBoatClubIdCell = document.createElement('td');

    // Set text content for each cell
    newTableBoatIdCell.textContent = data.boatId;
    newTableBoatTypeCell.textContent = data.boatType;
    newTableBoatCompanyCell.textContent = data.boatCompany;
    newTableAvgWeightCell.textContent = data.averageCrewWeight;
    newTableMaterialCell.textContent = data.riggerMaterial;
    newTableWingRiggerCell.textContent = data.wingRigger;
    newTableBoatClubIdCell.textContent = data.boatClub.boatClubId;

    // Append everything
    newTableRow.appendChild(newTableBoatIdCell);
    newTableRow.appendChild(newTableBoatTypeCell);
    newTableRow.appendChild(newTableBoatCompanyCell);
    newTableRow.appendChild(newTableAvgWeightCell);
    newTableRow.appendChild(newTableMaterialCell);
    newTableRow.appendChild(newTableWingRiggerCell);
    newTableRow.appendChild(newTableBoatClubIdCell);
    newTableBody.appendChild(newTableRow);
    boatTable.appendChild(newTableBody);

}

// Event listeners
readAllBtn.addEventListener('click', readAll);
readByIdBtn.addEventListener('click', getId);
clearTableBtn.addEventListener('click', clearTable);