for(i = 0; i < 100; i++) {
let button = document.createElement("button");
let buttonEnemy = document.createElement("button");
let buttonDiv = document.getElementById("left_board");
let buttonEnemyDiv = document.getElementById("right_board");

button.id = i
buttonEnemy.id = i+100

button.className = "mybutton"
buttonEnemy.className = "enemybutton"

buttonDiv.appendChild(button);
buttonEnemyDiv.appendChild(buttonEnemy);
}
