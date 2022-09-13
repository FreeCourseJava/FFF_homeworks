package eleventh;


import fifth.House;
import ninth.ArrayExtendable;

public class StreetForSerialization {
    private String name;
    private int kadastrNumber;
    private boolean isMain;
    private ArrayExtendable houses;

    public StreetForSerialization(String name) {
        this.name = name;
        this.kadastrNumber = 1000;
        this.isMain = false;
        this.houses = new ArrayExtendable();
    }

    public StreetForSerialization(String name, int kadastr, boolean isMain, ArrayExtendable houses) {
        this.name = name;
        this.kadastrNumber = kadastr;
        this.isMain = isMain;
        this.houses = houses;
    }

    public int calcHousesNumber() {
        if (this.houses == null) {
            return 0;
        }
        return this.houses.length();
    }

    public String getName() {
        return this.name;
    }

    public int getKadastrNumber() {
        return this.kadastrNumber;
    }

    public boolean getIsMain() {
        return this.isMain;
    }

    public ArrayExtendable getHouses() {
        return this.houses;
    }

    public void addHouse(House houseToAdd) {
        houses.add(houseToAdd);
    }
}
