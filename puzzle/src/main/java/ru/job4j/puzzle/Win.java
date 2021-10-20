package ru.job4j.puzzle;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == j && (chekVertical(board, j) || chekHorizontal(board, i))) {
                    rsl = true;
                    break;
                }
            }
            if (rsl) {
                break;
            }
        }
        return rsl;
    }

    public static boolean chekHorizontal(int[][] board, int row) {
        boolean result = true;
        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean chekVertical(int[][] board, int column) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }
}


