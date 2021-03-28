package tictactoe;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static boolean playing = true;

    public static void main(String[] args) {
        char[][] values = new char[3][3];
        startGame(values);
        playing(values);

    }

    public static void checkGameState(char[][] arr) {
        int empty = 0;
        for (char[] chars : arr) {
            for (char aChar : chars) {
                if (aChar != 'X' && aChar != 'O') {

                    empty++;
                }
            }

        }
        int diagonal1 = arr[0][0] + arr[1][1] + arr[2][2];
        int diagonal2 = arr[0][2] + arr[1][1] + arr[2][0];
        int horizontal1 = arr[0][0] + arr[0][1] + arr[0][2];
        int horizontal2 = arr[1][0] + arr[1][1] + arr[1][2];
        int horizontal3 = arr[2][0] + arr[2][1] + arr[2][2];
        int vertical1 = arr[0][0] + arr[1][0] + arr[2][0];
        int vertical2 = arr[0][1] + arr[1][1] + arr[2][1];
        int vertical3 = arr[0][2] + arr[1][2] + arr[2][2];
        int sumX = 'X' + 'X' + 'X';
        int sumO = 'O' + 'O' + 'O';
        boolean xWins = diagonal1 == sumX || diagonal2 == sumX || horizontal1 == sumX || horizontal2 == sumX ||
                horizontal3 == sumX || vertical1 == sumX || vertical2 == sumX || vertical3 == sumX;
        boolean oWins = diagonal1 == sumO || diagonal2 == sumO || horizontal1 == sumO || horizontal2 == sumO ||
                horizontal3 == sumO || vertical1 == sumO || vertical2 == sumO || vertical3 == sumO;
        if (xWins) {
            System.out.println("X wins");

            System.exit(0);
        } else if (oWins) {
            System.out.println("O wins");

            System.exit(0);
        } else if (empty == 0) {
            System.out.println("Draw");

            System.exit(0);
        }
    }

    public static void playing(char[][] values) {
        insertChart(values);
        insertXValue(values);
        //insertChart(values);
        checkGameState(values);
        insertOValue(values);
        checkGameState(values);
        if (playing = true) {
            playing(values);
        }
    }

    public static void startGame(char[][] arr) {
        for (char[] chars : arr) {
            Arrays.fill(chars, ' ');
        }
    }


    public static void insertChart(char[][] values) {
        System.out.println("---------");
        System.out.println("| " + values[0][0] + " " + values[0][1] + " " + values[0][2] + " |");
        System.out.println("| " + values[1][0] + " " + values[1][1] + " " + values[1][2] + " |");
        System.out.println("| " + values[2][0] + " " + values[2][1] + " " + values[2][2] + " |");
        System.out.println("---------");
    }

    public static void insertXValue(char[][] arr) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the coordinates: ");
        String str = scanner.nextLine();
        char xCoordinate = str.charAt(0);
        char yCoordinate = str.charAt(2);
        int x = Character.getNumericValue(xCoordinate);
        int y = Character.getNumericValue(yCoordinate);
        if (xCoordinate < 48 || xCoordinate > 57 || yCoordinate < 48 || yCoordinate > 57) {
            System.out.println("You should enter numbers!");
            insertXValue(arr);
        } else if (x < 1 || x > 3 || y < 1 || y > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            insertXValue(arr);
        } else if (arr[x - 1][y - 1] != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            insertXValue(arr);
        } else {
            arr[x - 1][y - 1] = 'X';
        }
        insertChart(arr);
    }

    public static void insertOValue(char[][] arr) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter the coordinates: ");
        String str = scanner1.nextLine();
        char xCoordinate = str.charAt(0);
        char yCoordinate = str.charAt(2);
        int x = Character.getNumericValue(xCoordinate);
        int y = Character.getNumericValue(yCoordinate);
        if (xCoordinate < 48 || xCoordinate > 57 || yCoordinate < 48 || yCoordinate > 57) {
            System.out.println("You should enter numbers!");
            insertOValue(arr);
        } else if (x < 1 || x > 3 || y < 1 || y > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            insertOValue(arr);
        } else if (arr[x - 1][y - 1] != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            insertOValue(arr);
        } else {
            arr[x - 1][y - 1] = 'O';
        }
        insertChart(arr);
    }
}
