package fifth;

public class Street extends Measureable {
    private String name;
    private int kadastrNumber;
    private boolean isMain;
    private ArrayExtended houses, parks;

    public Street(String name) {
        super(5000, 10);
        this.name = name;
        this.kadastrNumber = 1000;
        this.isMain = false;
        this.houses = new ArrayExtended();
        this.parks = new ArrayExtended();
    }

    public Street(String name, int kadastrNumber, int length, int meanWidth,
                  boolean isMain) {
        super(length, meanWidth);
        this.name = name;
        this.kadastrNumber = kadastrNumber;
        this.isMain = isMain;
        this.houses = new ArrayExtended();
        this.parks = new ArrayExtended();
    }

    public void addHouse(House houseToAdd) {
        houses.addToArray(houseToAdd);
        }

    public void addPark(Park parkToAdd) {
        parks.addToArray(parkToAdd);
    }

    public int calcHousesArea() {
        if (this.houses == null) {
            return 0;
        }
        int numberOfHouses = this.houses.length();
        int sumArea = 0;
        for (int i = 0; i < numberOfHouses; i++) {
            House temp = (House) this.houses.getFromArray(i);
            sumArea = sumArea + temp.calcArea();
        }
        return sumArea;
    }

    public int calcParksArea() {
        int numberOfParks = this.parks.length();
        int sumArea = 0;
        for (int i = 0; i < numberOfParks; i++) {
            Park temp = (Park) this.parks.getFromArray(i);
            sumArea = sumArea + temp.calcArea();
        }
        return sumArea;
    }

    public int calcHousesNumber() {
        if (this.houses == null) {
            return 0;
        }
        return this.houses.length();
    }
}
