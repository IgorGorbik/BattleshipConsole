package views;

import ships.Field;

public interface View {

    void initMessage();

    void finalScore(int shotsFired);

    void printField(Field f);

    void exitMessage();

    void playAgain(String affirmative, String negative);

    void invalidOption();

    void enterShot();

    String invalidShot();

    String invalidCharacters();

    String invalidShotRange(int gridLength);

    String userAffirmative();

    String userNegative();

    void printErrorMessage(IllegalArgumentException e);
}

