package tenth;

import java.util.Scanner;

public class VendingMachine implements VendingFunctions {
    boolean isToContinue = true;

    @Override
    public int getInput() {
        System.out.println("Введите номер, -1 для выхода");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public void getGoods(int number) {
        Goods[] goodsToArray = Goods.values();
        if ((number >= 0) && (number < goodsToArray.length)) {
            System.out.println("Получите Ваш " + goodsToArray[number]);
        } else if (number == -1) {
            isToContinue = false;
        } else {
            System.out.println("Введен неверный номер");
        }
    }

    @Override
    public void printRules() {
        System.out.println("Введите номер желаемого товара");
        Goods[] goodsToPrint = Goods.values();
        for (int i = 0; i < goodsToPrint.length; i++) {
            System.out.println("Номер " + i + " - " + goodsToPrint[i]);
        }
    }
}
