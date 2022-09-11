package tenth;

public class VendingDemo {
    public static void main(String[] args) {

        VendingMachine myVending = new VendingMachine();

        do {
            myVending.printRules();
            myVending.getGoods(myVending.getInput());
        } while (myVending.isToContinue);

    }
}
