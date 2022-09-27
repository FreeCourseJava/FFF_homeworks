package twelfth;

import eleventh.StreetForSerialization;
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

}
