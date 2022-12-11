package Lesson_9;


import java.util.Scanner;

public class HumanPlayer extends Player{

    public HumanPlayer(Simbol[][] gameField, Simbol simbol) {
        super(gameField, simbol);
    }

    @Override
    public void makeStep() {
        Scanner scn= new Scanner(System.in);
        int row;
        int col;
        boolean isInput=false;

            do {
                System.out.println("Enter row: ");
                row=scn.nextInt();
                System.out.println("Enter col: ");
                col=scn.nextInt();
                if (row>=0&&row<gameField.length&&col>=0&&col< gameField.length){
                    isInput=true;

                }else {
                    System.out.println("Не коректный ввод данных, Повторите!");

                }
            }while (!isInput);
        if (gameField[row][col]==Simbol.EMPTY) {
            gameField[row][col] = simbol;
        }else {
            System.out.println("Эта ячейка занета(( попробуйте еще раз!");
            makeStep();
        }


    }
}
