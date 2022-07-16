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
}
