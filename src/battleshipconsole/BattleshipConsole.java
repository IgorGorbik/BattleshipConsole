package battleshipconsole;

import controllers.BattleshipController;
import ships.Field;
import views.BattleshipView;
import controllers.Controller;
import views.View;

public class BattleshipConsole {

    public static void main(String[] args) {

        BattleshipConsole bs = new BattleshipConsole();
        bs.start();

    }

    private void start() {

        View view1 = new BattleshipView();

        Field f1 = new Field();

        Controller controller1 = new BattleshipController(view1, f1);
        controller1.start();

    }

}

