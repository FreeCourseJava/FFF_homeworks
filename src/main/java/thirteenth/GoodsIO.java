package thirteenth;

import java.io.*;
import java.util.HashMap;

public final class GoodsIO {

    private GoodsIO() {

    }

    public static void writeToFile(HashMap<Integer, Goods> tempGoods) {
        try (OutputStream outputStream = new FileOutputStream("config.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(tempGoods);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка записи");
        }
    }

    public static HashMap<Integer, Goods> readFromFile() {
        HashMap<Integer, Goods> tempGoods = new HashMap<>();
        try (InputStream inputStream = new FileInputStream("config.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            tempGoods = (HashMap<Integer, Goods>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка записи");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return tempGoods;
    }
}
