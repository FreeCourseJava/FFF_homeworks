package eleventh;

import fifth.House;

public class JSONSerializationDemo {

    public static void main(String[] args) {

        House dom1 = new House(1, 30, 20);
        House dom5 = new House(5, 560, 400);

        StreetForSerialization streetToWrite = new StreetForSerialization("Java+JSON");
        streetToWrite.addHouse(dom1);
        streetToWrite.addHouse(dom5);

        StreetForSerialization streetToRead = new StreetForSerialization("Temp");

        JSONUtils.writeStreetToFile(streetToWrite, "test.txt");
        streetToRead = JSONUtils.readStreetFromFile("test.txt");
    }
}
