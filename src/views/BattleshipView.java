package views;

import ships.Field;

public class BattleshipView implements View {

    @Override
    public void initMessage() {
        System.out.println("Игра началась");
    }

    @Override
    public void finalScore(int shotsFired) {
        System.out.println("Итоговый счет: " + shotsFired + " shots");
    }

    @Override
    public void printField(Field f) {
        System.out.println(f);
    }

    @Override
    public void exitMessage() {
        System.out.println("Выход из программы");
    }

    @Override
    public void playAgain(String y, String n) {
        System.out.print("Сыграть еще раз? '" + y + "' or '" + n + "': ");
    }

    @Override
    public void invalidOption() {
        System.out.println("Неверный ввод. Еще раз.");
    }

    @Override
    public void enterShot() {
        System.out.println("Введите номер строки и столбца(5,5): ");
    }

    @Override
    public String invalidShot() {
        return "Неверные координаты. Еще раз.";
    }

    @Override
    public String invalidCharacters() {
        return "Неверные координаты. Еще раз.";
    }

    @Override
    public String invalidShotRange(int gridLength) {
        return "Диапазон координат 0-9" + gridLength + " Еще раз";
    }

    @Override
    public String userAffirmative() {
        return "y";
    }

    @Override
    public String userNegative() {
        return "n";
    }

    @Override
    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}

