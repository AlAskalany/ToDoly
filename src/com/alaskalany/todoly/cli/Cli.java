package com.alaskalany.todoly.cli;

public class Cli {
    private CliPrinter cliPrinter;
    private CliParser cliParser;

    public Cli() {
        cliPrinter = new CliPrinter();
        cliParser = new CliParser();
    }
}
