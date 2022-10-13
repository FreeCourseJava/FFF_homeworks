package thirteenth;

import java.util.Scanner;

public class NewVendingDemo {

    public static void main(String[] args) {

        NewVendingMachine myVending = new NewVendingMachine();
        Scanner scanner = new Scanner(System.in);

        do {
            myVending.initialize();
            myVending.printPrice();
            myVending.analizeInput(myVending.getInput(scanner), scanner);
            myVending.closeTransaction();
        } while (myVending.isToContinue);
    }
}
