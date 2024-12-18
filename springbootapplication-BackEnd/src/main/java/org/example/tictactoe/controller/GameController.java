package org.example.tictactoe.controller;

import org.example.tictactoe.model.GameState;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {
    private final GameState gameState = new GameState();

    @GetMapping("/board")
    public int[][] getBoard() {
        byte[][] board = gameState.getBoard();
        int[][] convertedBoard = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                convertedBoard[i][j] = board[i][j]; // Konvertiere byte zu int
            }
        }

        return convertedBoard; // Gib das Board als JSON-kompatibles int[][] zurück
    }




    // Endpunkt zum Senden eines Spielzugs
    @PostMapping("/move")
    public byte[][] makeMove(@RequestParam int x, @RequestParam int y) {
        if (gameState.makeMove(x, y)) {
            return gameState.getBoard(); // Rückgabe des aktuellen Spielfelds
        }

        throw new IllegalArgumentException("Invalid move.");
    }


    // Endpunkt zum Abrufen des aktuellen Spielers
    @GetMapping("/player")
    public byte getCurrentPlayer() {
        return gameState.getCurrentPlayer();
    }

    // Endpunkt zum Zurücksetzen des Spiels
    @PostMapping("/reset")
    public String resetGame() {
        gameState.resetGame();
        return "Game reset successfully!";
    }
}
