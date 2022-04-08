package com.rex50.kawaspacecoding2;

import android.util.Log;
import android.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TicketGenerator {

    private static final String TAG = "TicketGenerator";

    private final int rows;
    private final int columns;
    private int[][] ouptut;

    public TicketGenerator(int rows, int columns) {
        this.columns = columns;
        this.rows = rows;
        ouptut = new int[rows][columns];
    }

    public int[][] generateTicket() {
        for (int i = 0; i < columns; i++) {
            generateColumn(i);
        }
        return ouptut;
    }

    private void generateColumn(int columnIndex) {
        Pair<Integer, Integer> range = getRange(columnIndex+1);
        List<Integer> randoms = getRandoms(rows, range.first, range.second);
        Collections.sort(randoms);
        for (int i = 0; i < rows; i++) {
            ouptut[i][columnIndex] = randoms.get(i);
        }
        Log.e(TAG, "generateColumn: " + ouptut);
    }

    private List<Integer> getRandoms(int count, int min, int max) {
        List<Integer> randoms = new ArrayList<>();
        do {
            int value = getRandom(min, max);
            if(randoms.contains(value))
                continue;
            randoms.add(value);
        } while (randoms.size() != count);
        return randoms;
    }

    private int getRandom(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private Pair<Integer, Integer> getRange(int position) {
        Pair<Integer, Integer> range;
        switch (position) {
            case 1: range = new Pair<>(1, 10); break;
            case 2: range = new Pair<>(11, 20); break;
            case 3: range = new Pair<>(21, 30); break;
            case 4: range = new Pair<>(31, 40); break;
            case 5: range = new Pair<>(41, 50); break;
            case 6: range = new Pair<>(51, 60); break;
            case 7: range = new Pair<>(61, 70); break;
            case 8: range = new Pair<>(71, 80); break;
            default: range = new Pair<>(81, 90); break;
        }
        Log.e(TAG, "getRange: " + range);
        return range;
    }
}
