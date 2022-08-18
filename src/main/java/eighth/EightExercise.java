package eighth;

import fifth.House;
import fifth.Park;
import fifth.Street;

public class EightExercise {
    public static void main(String[] args) {
        House dom1 = new House(1, 30, 20);
        House dom5 = new House(5, 560, 400);

        StreetByList moscowLenin = new StreetByList("Lenina");
        moscowLenin.addHouse(dom1);
        moscowLenin.addHouse(dom5);
        System.out.println(moscowLenin.calcHousesArea());

    }
}
