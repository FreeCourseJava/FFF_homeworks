package twelfth;

import fifth.House;

public class DictionaryDemo {
    public static void main(String[] args) {
        House dom1 = new House(1, 30, 20);
        House dom5 = new House(5, 560, 400);

        StreetForDictionary streetForDictionary = new StreetForDictionary("First");
        streetForDictionary.addHouse(dom1);
        streetForDictionary.addHouse(dom5);
        StreetForDictionary anotherStreetForDictionary = new StreetForDictionary("Second", 2345, false, null);


        DictionaryHashTable<StreetForDictionary, House> demoDictionary = new DictionaryHashTable<>();
        demoDictionary.put(streetForDictionary, dom1);
        House dom = demoDictionary.get(anotherStreetForDictionary);
        demoDictionary.put(anotherStreetForDictionary, dom5);
        dom = demoDictionary.get(streetForDictionary);
        demoDictionary.put(anotherStreetForDictionary, dom1);
    }
}
