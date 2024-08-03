package com.aurionpro.model;

import java.util.Scanner;


public class Game {
    private Board board;
    private Player[] players;
    private Player currentPlayer;

    public Game(Player player1, Player player2) {
        board = new Board();
        players = new Player[]{player1, player2};
        currentPlayer = players[0];
    }

    public void startGame() {
        boolean gameWon = false;
        boolean draw = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameWon && !draw) {
            board.displayBoard();
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + "):");

            int row, col;
            boolean validMove;
            do {
                System.out.print("Enter row (0, 1, or 2): ");
                row = scanner.nextInt();
                System.out.print("Enter column (0, 1, or 2): ");
                col = scanner.nextInt();
                validMove = board.makeMove(row, col, currentPlayer.getSymbol());

                if (!validMove) {
                    System.out.println("Invalid move! Please try again.");
                }
            } while (!validMove);

            gameWon = board.checkWinner(currentPlayer.getSymbol());
            draw = board.isFull();

            if (!gameWon) {
                switchPlayer();
            }
        }

        board.displayBoard();

        if (gameWon) {
            System.out.println(currentPlayer.getName() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }

        scanner.close();
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
    }
}
