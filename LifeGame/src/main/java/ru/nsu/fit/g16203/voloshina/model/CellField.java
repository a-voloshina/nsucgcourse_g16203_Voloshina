package ru.nsu.fit.g16203.voloshina.model;

import ru.nsu.fit.g16203.voloshina.general.Pair;
import ru.nsu.fit.g16203.voloshina.general.exception.OutOfFieldRangeException;

import java.util.ArrayList;

public class CellField extends Field<CellStatus> {

    public CellField(int width, int height) {
        super(width, height, CellStatus.DEAD);
    }

    public void addAliveCell(int coordinateX, int coordinateY) throws OutOfFieldRangeException {
        setItem(coordinateX, coordinateY, CellStatus.ALIVE);
    }

    public void reverseCellState(int coordinateX, int coordinateY) throws OutOfFieldRangeException {
        CellStatus cell = getItem(coordinateX, coordinateY);
        if (cell == CellStatus.ALIVE) {
            setItem(coordinateX, coordinateY, CellStatus.DEAD);
        } else if (cell == CellStatus.DEAD) {
            setItem(coordinateX, coordinateY, CellStatus.ALIVE);
        }
    }

    @Override
    public void printField() {
        for (int i = 0; i < height; i++) {
            int curWidth = checkWidth(width, i);
            if (i % 2 == 1) {
                System.out.print(" ");
            }
            for (int j = 0; j < curWidth; j++) {
                System.out.print(field.get(i).get(j).value() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public ArrayList<Pair<Integer, Integer>> getAliveCells() {
        ArrayList<Pair<Integer, Integer>> aliveCells = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            int curWidth = checkWidth(width, i);
            for (int j = 0; j < curWidth; j++) {
                if (field.get(i).get(j) == CellStatus.ALIVE) {
                    aliveCells.add(new Pair<>(j, i));
                }
            }
        }
        return aliveCells;
    }
}
