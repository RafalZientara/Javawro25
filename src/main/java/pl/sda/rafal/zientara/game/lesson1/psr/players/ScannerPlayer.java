package pl.sda.rafal.zientara.game.lesson1.psr.players;

import pl.sda.rafal.zientara.game.lesson1.psr.GameAction;

import java.util.Scanner;

public class ScannerPlayer implements Player {

    @Override
    public GameAction chooseAction() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Wpisz r/p/s");
            String input = scanner.next().toLowerCase();
            switch (input) {
                case "rock":
                case "r":
                    return GameAction.ROCK;
                case "paper":
                case "p":
                    return GameAction.PAPER;
                case "scissors":
                case "s":
                    return GameAction.SCISSORS;
                default:
                    System.out.println("Wprowadz jeszcze raz");

            }
        } while (true);

    }
}
