const SockJS = require('sockjs-client');
const Stomp = require('stompjs');

const socket = new SockJS('http://localhost:8080/chat');
const stompClient = Stomp.over(socket);

stompClient.connect({}, (frame) => {
    stompClient.subscribe('/topic/errors', (greeting) => {
        console.warn('errors: ' + greeting.body);
    });

    stompClient.subscribe('/topic/greetings', (greeting) => {
        console.log('greetings: ' + greeting.body);
    });

    stompClient.send('/app/chat', {}, JSON.stringify({name: 'Tammie'}));
    stompClient.send('/app/chat', {}, JSON.stringify({name: 'Josh'}));
});
