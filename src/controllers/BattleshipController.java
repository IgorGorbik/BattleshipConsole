package controllers;

import ships.Field;

import java.util.NoSuchElementException;
import java.util.Scanner;
import views.View;

public class BattleshipController implements Controller {

    private final Scanner scanner;
    private View view;
    private Field f;

    public BattleshipController(View battleshipGameView, Field f) {

        this.scanner = new Scanner(System.in);
        this.view = battleshipGameView;
        this.f = f;

    }

    @Override
    public void start() {

        view.initMessage();

        while (true) {

            f.init();
            f.placeAllShipsRandomly();

            gameLoop(f);

            if (!playAgain()) {
                break;
            }

        }

        view.exitMessage();
        scanner.close();

    }

    private void gameLoop(Field f) {

        int[] coordinates;

        while (!f.isGameOver()) {

            view.printField(f);

            do {
                try {
                    coordinates = getUserCoordinates();
                    f.shootAt(coordinates[0], coordinates[1]);
                    break;
                } catch (IllegalArgumentException e) {
                    view.printErrorMessage(e);
                } catch (NoSuchElementException e) {
                    break;
                }
            } while (true);

        }

        view.printField(f);
        view.finalScore(f.getShotsFired());

    }

    private int[] getUserCoordinates() throws IllegalArgumentException, NoSuchElementException {

        int[] coordinates = new int[2];

        view.enterShot();

        String[] userInput = scanner.nextLine().split(",");

        if (userInput.length != 2) {
            throw new IllegalArgumentException(view.invalidShot());
        }

        try {
            coordinates[0] = Integer.parseInt(userInput[0].trim());
            coordinates[1] = Integer.parseInt(userInput[1].trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(view.invalidCharacters());
        }

        if (coordinates[0] > Field.GRID_SIZE - 1 || coordinates[1] > Field.GRID_SIZE - 1) {
            throw new IllegalArgumentException(view.invalidShotRange(Field.GRID_SIZE - 1));
        }

        return coordinates;

    }

    private boolean playAgain() {

        boolean playAgain;

        while (true) {
            view.playAgain(view.userAffirmative(), view.userNegative());
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase(view.userAffirmative())) {
                playAgain = true;
                break;
            } else if (choice.equalsIgnoreCase(view.userNegative())) {
                playAgain = false;
                break;
            } else {
                view.invalidOption();
            }
        }

        return playAgain;

    }

}

