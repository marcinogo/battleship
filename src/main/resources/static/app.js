var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/chatMessage', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });

        stompClient.subscribe('/topic/randomShipsOnBoard', function (ships) {
                showRandomShips(JSON.parse(ships.body).ships);
        });

        stompClient.subscribe('/topic/putMyShipMan', function (placeResult) {
                        putShipOnBoard(JSON.parse(placeResult.body));
                });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    stompClient.send("/app/chat", {}, JSON.stringify({'name': $("#name").val()}));
}

function tryToPlaceShip(shiftKey,id){
  var shiftKeyResult = shiftKey;
  stompClient.send("/app/putShip", {} ,JSON.stringify({'shiftPressed': shiftKeyResult, 'id':id}));
}

function objectToMap(obj) {
    const map = new Map;
    Object.keys (obj).forEach (k => { map.set(k, obj[k]) });
    return map;
}

function putShipOnBoard(result){
    if(result.valid){
      myMap = objectToMap(result.fieldsOfShip);

    for (var [key, value] of myMap) {
        var button = document.getElementById(key);
        button.style.background=value;
      }
    } else{
    alert("Invalid");
    }
}

//function startGame() {
//    stompClient.send("/app/color", {}, JSON.stringify({'color': $("#name").val()}));
//}

function sendShips() {
    stompClient.send("/app/ships", {}, JSON.stringify({'ships': $("#name").val()}));
}

function clearBoard(){
  for(i=0;i<100;i++){
    var button = document.getElementById(i);
    button.style.background="#FFFFFF";
  }
}

function showRandomShips(ship){
  clearBoard();
  for (var i in ship){
  var button = document.getElementById(ship[i]);
  button.style.background="#000000";
  }
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}


$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendMessage(); });
    $( "#start" ).click(function() { startGame(); });
    $( "#randomShips" ).click(function() { sendShips(); });
    for(i=0;i<200;i++){
     $( "#"+i).click(function(event) {
        var isShiftPressed = event.shiftKey;
        var id=event.target.id;
        tryToPlaceShip(isShiftPressed,id); });
        }

});

