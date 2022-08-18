package eighth;

import fifth.House;
import fifth.Street;

public class StreetByList extends Street {
    private LinkedList houses;

    public StreetByList(String name) {
        super(name);
        this.houses = new LinkedList();
    }

    public void addHouse(House houseToAdd) {
        houses.addNode(houseToAdd);
    }

    public int calcHousesArea() {
        if (this.houses == null) {
            return 0;
        }
        int numberOfHouses = this.houses.getSize();
        int sumArea = 0;
        for (int i = 0; i < numberOfHouses; i++) {
            sumArea = sumArea + this.houses.getNode(i).calcArea();
        }
        return sumArea;
    }

    public int calcHousesNumber() {
        if (this.houses == null) {
            return 0;
        }
        return this.houses.getSize();
    }
}

