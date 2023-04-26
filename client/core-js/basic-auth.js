const btoa = require('btoa');

const username = 'admin@admin.com';
const password = 'admin';

// Concatena o nome de usuário e senha separados por dois pontos
const credentials = `${username}:${password}`;

// Codifica a string em base64
const encodedCredentials = btoa(credentials);

console.log(encodedCredentials);