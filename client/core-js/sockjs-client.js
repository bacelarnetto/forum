const SockJS = require('sockjs-client');
const Stomp = require('stompjs');

const socket = new SockJS('http://localhost:8089/ws/chat');
const stompClient = Stomp.over(socket);

stompClient.connect({}, () => {
    console.log('Conexão estabelecida com sucesso!');
    stompClient.subscribe('/topic/errors', (greeting) => {
        console.warn('errors: ' + greeting.body);
    });

    stompClient.subscribe('/topic/greetings', (greeting) => {
        console.log('greetings: ' + greeting.body);
    });

    stompClient.send('/app/chat', {}, JSON.stringify({name: 'Admin'}));
    stompClient.send('/app/chat', {}, JSON.stringify({name: 'Josh'}));
}, (err) => {
    console.error('Erro ao conectar:', err);
});