package fifth;

public class City {
    String name;
    int population;
    int area;
    Street[] streets;

    public City(String name, int population, int area, Street[] streets) {

        this.name = name;
        this.population = population;
        this.area = area;
        this.streets = streets;
    }

    public void addStreet(Street streetToAdd) {
        if (this.streets == null) {
            Street[] temporary = new Street[1];
            temporary[0] = streetToAdd;
            this.streets = temporary;
        } else {
            int numberOfStreets = this.streets.length;
            Street[] temporary = new Street[numberOfStreets + 1];
            for (int i = 0; i < numberOfStreets; i++) {
                temporary[i] = this.streets[i];
            }
            temporary[numberOfStreets] = streetToAdd;
            this.streets = temporary;
        }
    }

    public int calcHousesNumber() {
        int numberOfStreets = this.streets.length;
        int sumNumber = 0;
        for (int i = 0; i < numberOfStreets; i++) {
            sumNumber = sumNumber + this.streets[i].calcHousesNumber();
        }
        return sumNumber;
    }

}
