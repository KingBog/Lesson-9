package Lesson_9;

import java.util.Scanner;

public class Game {
    Simbol[][] gameField = new Simbol[3][3];

    {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                gameField[i][j] = Simbol.EMPTY;
            }
        }
    }

    public void startGame() {
        Player player1 = null;
        Player player2 = null;
        Scanner scn = new Scanner(System.in);
        System.out.println("1.Человек vs Человек\n" + "2.Человек vs Компьютер\n" + "3.Компьютер vs Компьютер");
        int input = scn.nextInt();
        if (input == 1) {
            player1 = new HumanPlayer(gameField, Simbol.X);
            player2 = new HumanPlayer(gameField, Simbol.O);
        } else if (input == 2) {
            player1 = new HumanPlayer(gameField, Simbol.X);
            player2 = new ComputerPlayer(gameField, Simbol.O);
        } else if (input == 3) {
            player1 = new ComputerPlayer(gameField, Simbol.X);
            player2 = new ComputerPlayer(gameField, Simbol.O);
        }
        int truy = 0;
        Simbol winner;
        while ((winner = finish()) == null) {
            System.out.println(toString());
            if (truy % 2 == 0) {
                player1.makeStep();
            } else {
                player2.makeStep();
            }
            truy++;
        }
        System.out.println(toString());
        System.out.println("Результат игры: "+winner);

    }

    private Simbol finish(){
        if (checkHorizontalWinner()!=null){
            return checkHorizontalWinner();
        }else if (checkVerticalWinner()!=null){
            return checkVerticalWinner();
        }else if (checkDiagonalWinner()!=null){
            return checkDiagonalWinner();
        }else if (checkDraw()!=null){
            return checkDraw();
        }
        return null;
    }
    private Simbol checkHorizontalWinner() {
        for (int i = 0; i < gameField.length; i++) {
            int num = 0;
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[i][0] != Simbol.EMPTY && gameField[i][0] == gameField[i][j]) {
                    num++;
                    if (num==3){
                        return gameField[i][0];
                    }
                }
            }

        }
        return null;
    }
    private Simbol checkVerticalWinner() {
        for (int i = 0; i < gameField.length; i++) {
            int num = 0;
            int num1 = 0;
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[j][i] != Simbol.EMPTY && gameField[j][i] == Simbol.X) {
                    num++;
                    if (num == 3) {
                        return Simbol.X;
                    }
                } else if (gameField[j][i] != Simbol.EMPTY && gameField[j][i] == Simbol.O) {
                    num1++;
                    if (num1 == 3) {
                        return Simbol.O;
                    }
                }

            }

        }
        return null;
    }
    private Simbol checkDraw(){
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[i][j]==Simbol.EMPTY) {
                    return null;
                }
            }

        }
        return Simbol.DRAW;
    }
    private Simbol checkDiagonalWinner() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[0][0] != Simbol.EMPTY && gameField[0][0] == gameField[1][1] && gameField[0][0] == gameField[2][2]) {
                    return gameField[0][0];
                } else if (gameField[0][2] != Simbol.EMPTY && gameField[0][2] == gameField[1][1] && gameField[0][2] == gameField[2][0]) {
                    return gameField[0][2];

                }

            }

        }
        return null;
    }






    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                sb.append(gameField[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

