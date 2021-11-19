'use strict';

// Get the required elements
let readAllBtn = document.querySelector('#readAllBtn');
let readByIdBtn = document.querySelector('#readByIdBtn');
let boatClubIdInput = document.querySelector('#boatClubIdInput');
let boatClubTable = document.querySelector('#boatClubTable');
let clearTableBtn = document.querySelector('#clearTableBtn');

// Check if they are getting retrieved
console.log(readAllBtn);
console.log(readByIdBtn);
console.log(boatClubIdInput);
console.log(boatClubTable);
console.log(boatClubIdInput);

// Function to save value of input field
let getId = () => {
    let boatClubIdValue = boatClubIdInput.value;
    readById(boatClubIdValue);
}

// Function to clear the table
let clearTable = () => {
    let rowCount = boatClubTable.rows.length;
    for (let i = 1; i < rowCount; i++) {
        boatClubTable.deleteRow(i);
    }
}

// Function to read all boat clubs (Fetch request - GET method)
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
                    for (let obj of data) {
                        createTable(obj);
                    }
                }).catch((error) => {
                    console.error(`${error}`);
                });
        });
}

// Function to read a boat club by its ID (Fetch request - GET method)
let readById = (value) => {
    fetch(`http://localhost:9000/boatclub/getById/${value}`)
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
                });
        });
}

// Function to create a table containing boat club data
let createTable = (data) => {

    // Create elements
    let newTableBody = document.createElement('tbody');
    let newTableRow = document.createElement('tr');
    let newTableClubIdCell = document.createElement('td');
    let newTableClubNameCell = document.createElement('td');
    let newTableAddressCell = document.createElement('td');
    let newTableCodeCell = document.createElement('td');
    let newTableFirstNameCell = document.createElement('td');
    let newTableSurnameCell = document.createElement('td');

    // Set the text content for each cell
    newTableClubIdCell.textContent = data.boatClubId;
    newTableClubNameCell.textContent = data.boatClubName;
    newTableAddressCell.textContent = data.address;
    newTableCodeCell.textContent = data.boatClubCode;
    newTableFirstNameCell.textContent = data.headCoachFirstName;
    newTableSurnameCell.textContent = data.headCoachSurname;

    // Append everything
    newTableRow.appendChild(newTableClubIdCell);
    newTableRow.appendChild(newTableClubNameCell);
    newTableRow.appendChild(newTableAddressCell);
    newTableRow.appendChild(newTableCodeCell);
    newTableRow.appendChild(newTableFirstNameCell);
    newTableRow.appendChild(newTableSurnameCell);
    newTableBody.appendChild(newTableRow);
    boatClubTable.appendChild(newTableBody);
}

readAllBtn.addEventListener('click', readAll);
readByIdBtn.addEventListener('click', getId);
clearTableBtn.addEventListener('click', clearTable);