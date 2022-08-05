package fifth;

public class Street {
    String name;
    int kadastrNumber;
    int length;
    int meanWidth;
    boolean isMain;
    House[] houses;
    Park[] parks;

    public Street(String name, House[] houses, Park[] parks) {
        this.name = name;
        this.kadastrNumber = 1000;
        this.length = 5000;
        this.meanWidth = 10;
        this.isMain = false;
        this.houses = houses;
        this.parks = parks;
    }

    public Street(String name, int kadastrNumber, int length, int meanWidth,
                  boolean isMain, House[] houses, Park[] parks) {
        this.name = name;
        this.kadastrNumber = kadastrNumber;
        this.length = length;
        this.meanWidth = meanWidth;
        this.isMain = isMain;
        this.houses = houses;
        this.parks = parks;
    }

    public void addHouse(int number, int length, int width) {
        if (this.houses == null) {
            House[] temporary = new House[1];
            temporary[0] = new House(number, length, width);
            this.houses = temporary;
        } else {
            int numberOfHouses = this.houses.length;
            House[] temporary = new House[numberOfHouses + 1];
            for (int i = 0; i < numberOfHouses; i++) {
                temporary[i] = this.houses[i];
            }
            temporary[numberOfHouses] = new House(number, length, width);
            this.houses = temporary;
        }
    }

    public int calcHousesArea() {
        if (this.houses == null) {
            return 0;
        }
        int numberOfHouses = this.houses.length;
        int sumArea = 0;
        for (int i = 0; i < numberOfHouses; i++) {
            sumArea = sumArea + this.houses[i].calcHouseArea();
        }
        return sumArea;
    }

    public int calcParksArea() {
        int numberOfParks = this.parks.length;
        int sumArea = 0;
        for (int i = 0; i < numberOfParks; i++) {
            sumArea = sumArea + this.parks[i].calcParkArea();
        }
        return sumArea;
    }

    public int calcHousesNumber() {
        if (this.houses == null) {
            return 0;
        }
        return this.houses.length;
    }
}
