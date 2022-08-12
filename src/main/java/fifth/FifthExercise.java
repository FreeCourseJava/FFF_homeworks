package fifth;

public class FifthExercise {
    public static void main(String[] args) {
        House dom1 = new House(1, 30, 20);
        House dom5 = new House(5, 560, 400);

        Park parkGorky = new Park("Парк Горького", 20000, 1000);
        Park sadBauman = new Park("Сад Баумана", 500, 100);

        Street moscowLenin = new Street("Lenina", 5000, 2000, 10,
                true);
        moscowLenin.addHouse(dom1);
        moscowLenin.addHouse(dom5);
        moscowLenin.addPark(parkGorky);
        System.out.println(moscowLenin.calcHousesArea());
        System.out.println(moscowLenin.calcParksArea());


        Street moscowBasmannaya = new Street("Basmannaya", 3000, 500, 7,
                false);
        moscowBasmannaya.addHouse(dom1);
        moscowBasmannaya.addHouse(dom5);
        moscowBasmannaya.addPark(sadBauman);

        City moscow = new City("Moscow", 12000000, 2511);
        moscow.addStreet(moscowLenin);
        moscow.addStreet(moscowBasmannaya);
        System.out.println(moscow.calcHousesNumber());


        House dom2 = new House(2);
        House dom6 = new House(6);
        Park parkEmptiness = new Park();


        Street lost = new Street("Lost");
        lost.addHouse(dom2);
        lost.addHouse(dom6);
        lost.addPark(parkEmptiness);
        Street empty = new Street("Empty");
        System.out.println(empty.calcHousesArea());
        empty.addHouse(dom5);

        City noBurg = new City("NoBurg", 0, 0);
        noBurg.addStreet(lost);
        noBurg.addStreet(empty);


    }
}
