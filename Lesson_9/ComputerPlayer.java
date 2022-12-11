package Lesson_9;

import java.util.Random;

public class ComputerPlayer extends Player{


    public ComputerPlayer(Simbol[][] gameField, Simbol simbol) {
        super(gameField, simbol);
    }

    @Override
    public void makeStep()  {
        Random random = new Random();
       int row;
       int col;
        boolean isInput=false;
        do {
            row = random.nextInt(gameField.length);
            col = random.nextInt(gameField.length);
            if (gameField[row][col]==Simbol.EMPTY) {
                isInput =false;
            }else isInput=true;
        }while (isInput);
        gameField[row][col]=simbol;




    }
}
