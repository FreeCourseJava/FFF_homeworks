package fifth;

public class City {
    private String name;
    private int population;
    private int area;
    private ArrayExtended streets;

    public City(String name, int population, int area) {

        this.name = name;
        this.population = population;
        this.area = area;
        this.streets = new ArrayExtended();
    }

    public void addStreet(Street streetToAdd) {
        streets.addToArray(streetToAdd);
    }

    public int calcHousesNumber() {
        int numberOfStreets = this.streets.length();
        int sumNumber = 0;
        for (int i = 0; i < numberOfStreets; i++) {
            Street temp = (Street) this.streets.getFromArray(i);
            sumNumber = sumNumber + temp.calcHousesNumber();
        }
        return sumNumber;
    }

}
