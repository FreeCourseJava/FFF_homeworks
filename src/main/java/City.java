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
}
