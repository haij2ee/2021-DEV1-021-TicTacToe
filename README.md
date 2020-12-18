# 2010-DEV1-001-LeapYears
Tic Tac Toe Game in Java n Spring


The rules of Tic Tac Toe Game are described below :

X always goes first.
Players cannot play on a played position.
Players alternate placing X’s and O’s on the board until either:
One player has three in a row, horizontally, vertically or diagonally
All nine squares are filled.
If a player is able to draw three X’s or three O’s in a row, that player wins.
If all nine squares are filled and neither player has three in a row, the game is a draw.


-------

The application is designed to be extendable to support the board with the dimension bigger than 3*3


System Requirement Java 8, Maven


To run application from the source code mvn spring-boot:run 

mvn spring-boot:run -Dspring-boot.run.arguments=--board.size=4 (In the comming version he application is designed to be extendable to support the board with the dimension bigger than 3)




