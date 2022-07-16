public class FifthExercise {
    public static void main(String[] args) {
        House dom1 = new House(1, 30);
        House dom5 = new House(5, 560);
        House[] domaMoscow = {dom1, dom5};

        Park parkGorky = new Park("Парк Горького", 20000);
        Park sadBauman = new Park("Сад Баумана", 500);
        Park[] parksLenin = {parkGorky};
        Park[] parksBasmannaya = {sadBauman};

        Street moscowLenin = new Street("Lenina", 5000, 2000, 10,
                true, domaMoscow, parksLenin);
        Street moscowBasmannaya = new Street("Basmannaya", 3000, 500, 7,
                false, domaMoscow, parksBasmannaya);

        Street[] moscowStreet = {moscowLenin, moscowBasmannaya};

        City moscow = new City("Moscow", 12000000, 2511, moscowStreet);

        House dom = new House();
        House dom6 = new House(6);
        House[] domaNoBurg = {dom, dom6};

        Park parkEmptiness = new Park();
        Park[] parksNoBurg = {parkEmptiness};

        Street lost = new Street("Lost", domaNoBurg, parksNoBurg);
        Street empty = new Street("Empty", null, null);

        Street[] noBurgStreet = {lost, empty};

        City noBurg = new City("NoBurg", 0, 0, noBurgStreet);


    }
}
