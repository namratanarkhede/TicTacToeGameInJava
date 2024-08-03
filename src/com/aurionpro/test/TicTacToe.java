package com.aurionpro.test;

import com.aurionpro.model.Game;
import com.aurionpro.model.Player;

public class TicTacToe {
    public static void main(String[] args) {
        Player player1 = new Player("Player 1", 'X');
        Player player2 = new Player("Player 2", 'O');

        Game game = new Game(player1, player2);
        game.startGame();
    }
}
