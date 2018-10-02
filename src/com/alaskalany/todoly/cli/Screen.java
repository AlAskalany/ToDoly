package com.alaskalany.todoly.cli;

import java.util.ArrayList;

public abstract class Screen {

    private String title;
    private ArrayList<String> lines;

    protected Screen(String title) {

        this.title = title;
        lines = new ArrayList<>();
        addLines();
    }

    protected void addLine(String line) {

        lines.add(line);
    }

    protected abstract void addLines();

    @Override
    public String toString() {

        String allLines = title.concat("\n").concat("__________").concat("\n");
        for (String line : lines) {
            allLines = allLines.concat(line).concat("\n");
        }
        return allLines;
    }
}
