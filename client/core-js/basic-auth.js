const btoa = require('btoa');
const bcrypt = require('bcrypt');

const username = 'ana@email.com';
const password = '123456';
const saltRounds = 10;

// Concatena o nome de usuário e senha separados por dois pontos
const credentials = `${username}:${password}`;

// Codifica a string em base64
const encodedCredentials = btoa(credentials);

console.log(`String em Base64: ${encodedCredentials}`);

bcrypt.hash(password, saltRounds, (err, hash) => {
  if (err) {
    console.error(err);
    return;
  }
  const base64Hash = btoa(hash);
  console.log(`Hash: ${hash}`);
  console.log(`Hash em Base64: ${base64Hash}`);
});