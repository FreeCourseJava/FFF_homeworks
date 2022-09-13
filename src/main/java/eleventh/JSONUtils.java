package eleventh;

import fifth.House;
import ninth.ArrayExtendable;

import java.io.*;
import java.util.Scanner;

public final class JSONUtils {

    private JSONUtils() {

    }

    public static void writeStreetToFile(StreetForSerialization street, String fileName) {
        try (OutputStream outputStream = new FileOutputStream(fileName);
             PrintStream writer = new PrintStream(outputStream)) {
            writer.println("{");
            writer.println("\"name\": " + "\"" + street.getName() + "\",");
            writer.println("\"kadastrNomer\": " + street.getKadastrNumber() + ",");
            writer.println("\"isMain\": " + street.getIsMain() + ",");
            if (street.calcHousesNumber() != 0) {
                writer.println("\"houses\": [");
                for (int i = 0; i < street.calcHousesNumber(); i++) {
                    House theHouse = (House) street.getHouses().get(i);
                    writer.println("{");
                    writer.println("\"number\": " + theHouse.getNumber() + ",");
                    writer.println("\"length\": " + theHouse.getLengthMeasureable() + ",");
                    writer.println("\"width\": " + theHouse.getWidth() + ",");
                    if (i == (street.calcHousesNumber() - 1)) {
                        writer.println("}");
                    } else {
                        writer.println("},");
                    }
                }
                writer.println("]");
            }
            writer.println("}");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка записи");
        }
    }

    public static StreetForSerialization readStreetFromFile(String fileName) {
        StreetForSerialization dummyStreet = new StreetForSerialization("Заглушка");
        try (InputStream inputStream = new FileInputStream(fileName);
             Scanner reader = new Scanner(inputStream)) {
            String temp;
            ArrayExtendable tempHouses = new ArrayExtendable();
            reader.nextLine();
            temp = reader.nextLine();
            String name = temp.substring(temp.indexOf(" ") + 2, temp.lastIndexOf("\""));
            temp = reader.nextLine();
            int kadastrNumber = Integer.valueOf(temp.substring(temp.indexOf(" ") + 1, temp.indexOf(",")));
            temp = reader.nextLine();
            boolean isMain = Boolean.valueOf(temp.substring(temp.indexOf(" ") + 1, temp.indexOf(",")));
            temp = reader.nextLine();
            if (temp.compareTo("}") != 0) {
                do {
                    temp = reader.nextLine();
                    temp = reader.nextLine();
                    int num = Integer.valueOf(temp.substring(temp.indexOf(" ") + 1, temp.indexOf(",")));
                    temp = reader.nextLine();
                    int len = Integer.valueOf(temp.substring(temp.indexOf(" ") + 1, temp.indexOf(",")));
                    temp = reader.nextLine();
                    int wid = Integer.valueOf(temp.substring(temp.indexOf(" ") + 1, temp.indexOf(",")));
                    tempHouses.add(new House(num, len, wid));
                    temp = reader.nextLine();
                } while (temp.compareTo("}") != 0);
                dummyStreet = new StreetForSerialization(name, kadastrNumber, isMain, tempHouses);
            } else {
                dummyStreet = new StreetForSerialization(name, kadastrNumber, isMain, null);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка записи");
        }
        return dummyStreet;
    }

}
