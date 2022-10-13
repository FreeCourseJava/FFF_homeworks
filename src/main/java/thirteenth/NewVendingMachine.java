package thirteenth;

import java.io.File;
import java.util.*;

public class NewVendingMachine {

    boolean isToContinue = true;
    HashMap<Integer, Goods> goodsForSale = new HashMap<>();

    public int getInput(Scanner scanner) {
        int result = -1;
        try {
            result = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Неправильный ввод");
        }
        return result;
    }


    public void analizeInput(int number, Scanner scanner) {
        if (goodsForSale.containsKey(number)) {
            sellGoods(number, scanner);
        } else if (number == -1) {
            isToContinue = false;
        } else if (number == -2) {
            maintence(scanner);
        } else {
            System.out.println("Введен неверный номер");
        }
    }


    public void printPrice() {
        System.out.println("Введите номер желаемого товара");
        for (Map.Entry<Integer, Goods> entry : goodsForSale.entrySet()) {
            System.out.println("Номер " + entry.getKey() + " - " + entry.getValue().getGoodsName() +
                    ", цена: " + entry.getValue().getPrice());
        }
        System.out.println("Введите номер, -1 для выхода, -2 для обслуживания");
    }


    public void initialize() {
        File file = new File("config.txt");
        if (file.exists()) {
            goodsForSale = GoodsIO.readFromFile();
        } else {
            factoryParams();
        }
    }

    public void factoryParams() {
        Goods cola = new Goods(1, "cola", 10, 150);
        Goods snickers = new Goods(5, "snickers", 10, 70);
        Goods nuts = new Goods(10, "nuts", 10, 250);
        Goods lays = new Goods(13, "lays", 10, 100);

        goodsForSale.put(cola.getCode(), cola);
        goodsForSale.put(snickers.getCode(), snickers);
        goodsForSale.put(nuts.getCode(), nuts);
        goodsForSale.put(lays.getCode(), lays);
    }

    public void maintence(Scanner scanner) {
        int input;
        String getName = "";
        do {
            System.out.println("Введите 1 для добавления товара, для выхода -1");
            input = getInput(scanner);
            if (input == 1) {
                System.out.println("Введите номер товара");
                int getCode = getInput(scanner);
                if (goodsForSale.containsKey(getCode)) {
                    System.out.println("Товар в наличии, введите количество добавляемого");
                    int getQuantity = getInput(scanner);
                    Goods tempGoods = goodsForSale.get(getCode);
                    goodsForSale.remove(getCode, tempGoods);
                    tempGoods.setQuantity(tempGoods.getQuantity() + getQuantity);
                    goodsForSale.put(getCode, tempGoods);
                } else {
                    System.out.println("Это новый товар. Введите его название");
                    try {
                        scanner.nextLine();
                        getName = scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Неправильный ввод");
                        return;
                    }
                    System.out.println("Введите количество товара");
                    int getQuantity = getInput(scanner);
                    System.out.println("Введите стоимость товара");
                    int getPrice = getInput(scanner);
                    Goods newGood = new Goods(getCode, getName, getQuantity, getPrice);
                    goodsForSale.put(newGood.getCode(), newGood);
                }
            }
        } while (input != -1);
    }

    public void closeTransaction() {
        GoodsIO.writeToFile(goodsForSale);
    }

    public void sellGoods(int number, Scanner scanner) {
        System.out.println("Вы выбрали " + goodsForSale.get(number).getGoodsName());
        System.out.println("В наличии " + goodsForSale.get(number).getQuantity() + " штук товара");
        System.out.println("Введите, сколько штук товара Вы хотите купить:");
        int numberToBuy = getInput(scanner);
        if ((numberToBuy > goodsForSale.get(number).getQuantity()) || (numberToBuy <= 0)) {
            System.out.println("Товара в таком количестве нет!");
            return;
        }
        int priceToPay = numberToBuy * goodsForSale.get(number).getPrice();
        System.out.println("К оплате " + priceToPay + "$. Внесите деньги");
        int moneyForPay = getInput(scanner);
        if (moneyForPay < priceToPay) {
            System.out.println("Недостаточно денег!");
        } else {
            System.out.println("Получите Ваш товар. Ваша сдача " + (moneyForPay - priceToPay) + "$");
            Goods tempGoods = goodsForSale.get(number);
            goodsForSale.remove(number, tempGoods);
            tempGoods.setQuantity(tempGoods.getQuantity() - numberToBuy);
            goodsForSale.put(number, tempGoods);
        }
    }
}
