package com.company;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        playGame();

    }

    static void playGame() {
        final char playerSing = 'X';
        final char computerSing = 'O';
        char emptyCell = '*';
        String winnerName;

        char[][] field = playingField(emptyCell);

        drawField(field);

        do {

            playerMove(field, playerSing, emptyCell);
            drawField(field);
            if(checkWin(field,playerSing)){
                winnerName = "Игрок!";
                break;
            }
            if(checkField(field,emptyCell)){
                winnerName = "Арбуз!";
                break;
            }
            computerMove(field, computerSing, emptyCell);
            drawField(field);
            if(checkWin(field,computerSing)){
                winnerName = "Компьютер!";
                break;
            }


        } while (true);
        System.out.println("Поздравляем!");
        System.out.println("В этой игре победил " + winnerName);
    }

    static void playerMove(char[][] field, char sing, char emptyCell) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ход игрока.");
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y [1-3]");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;

        } while (!cellCheck(x, y, field, emptyCell));
        field[x][y] = sing;
    }

    static void computerMove(char[][] field, char sing, char emptyCell) {
        Random random = new Random();
        System.out.println("Ход компьютера.");
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);

        } while (!cellCheck(x, y, field, emptyCell));
        field[x][y] = sing;
    }

    static boolean cellCheck(int x, int y, char[][] field, char emptyCell) {
        if (x < 0 || x >= 3 || y < 0 || y >= 3) {
            System.out.println("Было введено неверное значение!");
            return false;
        } else if (field[x][y] == emptyCell) {
            return true;
        } else
            System.out.println("Ячейка занята");
        return false;
    }

    static boolean checkWin(char[][] field, char sing){
        for(int i = 0; i < field.length; i++){
            if (field[i][0] == sing && field[i][1] == sing && field[i][2] == sing){
                return true;
            }
        }
        for(int j = 0; j < field.length; j++){
            if (field[0][j] == sing && field[1][j] == sing && field[2][j] == sing){
                return true;
            }
        }
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field.length; j++){
                if (field[0][0] == sing && field[1][1] == sing && field[2][2] == sing){
                    return true;
                } else if (field[2][0] == sing && field[1][1] == sing && field[0][2] == sing){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean checkField(char[][] field, char emptyCell){
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field.length; j++){
                if(field[i][j] == emptyCell){
                    return false;
                }
            }
        }
        return true;
    }


    static char[][] playingField(char emptyCell) {
        char[][] field = new char[3][3];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = emptyCell;
            }
        }
        return field;
    }

    static void drawField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}
