package eleventh;

import fifth.House;

public class JSONSerializationDemo {

    public static void main(String[] args) {

        House dom1 = new House(1, 30, 20);
        House dom5 = new House(5, 560, 400);

        StreetForSerialization StreetToWrite = new StreetForSerialization("Java+JSON");
        StreetForSerialization StreetToRead = new StreetForSerialization("Temp");
        StreetToWrite.addHouse(dom1);
        StreetToWrite.addHouse(dom5);

        StreetToWrite.writeToFile("test.txt");
        StreetToRead.readFromFile("test.txt");
    }

}
