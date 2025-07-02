package org.example.snakeLadder;

import java.util.ArrayList;
import java.util.List;

public class SnakeLadder {
    private Board board;
    private List<Players> playersList;
    private Dice dice;

    public SnakeLadder(){
        board = new Board();
        dice = new Dice(DiceType.CROOKED); //handle the dice type
        playersList = new ArrayList<>();
        playersList.add(new Players("P1"));
        playersList.add(new Players("P2"));
        playersList.add(new Players("P3"));
        playersList.add(new Players("P4"));
    }

    public void playGame(){
        int currPlayerIndex = 0;
        int totalPlayer = playersList.size();
        while(true){
            Players currentPlayer = playersList.get(currPlayerIndex);
            System.out.println(currentPlayer.getName() + " rolling the dice from " + currentPlayer.getPosition());

            int roll = dice.roll();

            int nextPosition = currentPlayer.getPosition() + roll;
            System.out.println(currentPlayer.getName() + " get the nextPosition as " + nextPosition);

            if(nextPosition <= 100){
                nextPosition = board.getNextPosition(nextPosition);
                System.out.println(currentPlayer.getName() + " final nextPosition after moving " + nextPosition);

                currentPlayer.setPosition(nextPosition);

                System.out.println(currentPlayer.getName() + " moved to nextPosition " + currentPlayer.getPosition());
            } else if(nextPosition > 100){
                //can't move skip the chance
                System.out.println(currentPlayer.getName() + " rolled a invalid move.");
            }


            //check for winner condition
            if(currentPlayer.getPosition() == 100){
                // current Player won
                System.out.println(currentPlayer.getName() + " won the game!");
                break;
            }

            currPlayerIndex = (currPlayerIndex + 1) % totalPlayer;
        }
    }
}
