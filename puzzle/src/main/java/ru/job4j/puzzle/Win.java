package ru.job4j.puzzle;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == j && (chekVertical(board, j) || chekHorizontal(board[i]))) {
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

    public static boolean chekHorizontal(int[] array) {
        boolean rsl = true;
        for (int value : array) {
            if (value != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean chekVertical(int[][] array, int j) {
        boolean rsl = true;
        for (int[] value : array) {
            if (value[j] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}


