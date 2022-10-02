package twelfth;

import eleventh.StreetForSerialization;
import fifth.House;
import ninth.ArrayExtendable;

public class StreetForDictionary extends StreetForSerialization {

    public StreetForDictionary(String name) {
        super(name);
    }

    public StreetForDictionary(String name, int kadastr, boolean isMain, ArrayExtendable houses) {
        super(name, kadastr, isMain, houses);
    }

    @Override
    public String toString() {
        return "Street{" + "name='" + getName() + '\'' +
                ", kadastrNumber=" + getKadastrNumber() + ", isMain=" + getIsMain() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StreetForDictionary temp = (StreetForDictionary) o;

        if ((!getName().equals(temp.getName())) || (getKadastrNumber() != temp.getKadastrNumber())
                || (getIsMain() != temp.getIsMain())) {
            return false;
        }

        if (getHouses().length() == temp.getHouses().length()) {
            for (int i = 0; i < getHouses().length(); i++) {
                House tempHouse1 = (House) getHouses().get(i);
                House tempHouse2 = (House) temp.getHouses().get(i);
                if ((tempHouse1.getNumber() != tempHouse2.getNumber()) ||
                        (tempHouse1.getWidth() != tempHouse2.getWidth()) ||
                        (tempHouse1.getLengthMeasureable() != tempHouse2.getLengthMeasureable())) {
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;

    }

    @Override
    public int hashCode() {
        String temp;
        temp = "{" + getName() + getKadastrNumber() + getIsMain();
        if ((getHouses() != null) && getHouses().length() != 0) {
            for (int i = 0; i < getHouses().length(); i++) {
                House tempHouse = (House) getHouses().get(i);
                temp = temp + tempHouse.getNumber() + tempHouse.getWidth() +
                        tempHouse.getLengthMeasureable();
            }
        }
        return temp.hashCode();
    }
}