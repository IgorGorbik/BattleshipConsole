package factories;

import ships.EmptyCell;
import ships.SingleShip;
import ships.DoubleShip;
import ships.QuatterShip;
import ships.TripleShip;
import ships.Ship;

public class ShipFactory {

    private static ShipFactory shipFactory;

    private ShipFactory() {
    }

    public static ShipFactory getInstance() {

        if (shipFactory == null) {
            shipFactory = new ShipFactory();
        }
        return shipFactory;

    }

    public Ship getShip(String name) {

        switch (name) {

            case "singleship":
                return new SingleShip();
            case "doubleship":
                return new DoubleShip();
            case "tripleship":
                return new TripleShip();
            case "quattership":
                return new QuatterShip();
            default:
                return new EmptyCell();

        }

    }

}

