package eleventh;


import fifth.House;
import ninth.ArrayExtendable;

import java.io.*;
import java.util.Scanner;


public class StreetForSerialization implements Serializable {
    private String name;
    private int kadastrNumber;
    private boolean isMain;
    private ArrayExtendable houses;

    public StreetForSerialization(String name) {
        this.name = name;
        this.kadastrNumber = 1000;
        this.isMain = false;
        this.houses = new ArrayExtendable();

    }

    public int calcHousesNumber() {
        if (this.houses == null) {
            return 0;
        }
        return this.houses.length();
    }

    public void addHouse(House houseToAdd) {
        houses.add(houseToAdd);
    }

    public void writeToFile(String name) {
        try (OutputStream outputStream = new FileOutputStream(name);
             PrintStream writer = new PrintStream(outputStream)) {
            writer.println("{");
            writer.println("\"name\": " + "\"" + this.name + "\",");
            writer.println("\"kadastrNomer\": " + this.kadastrNumber + ",");
            writer.println("\"isMain\": " + this.isMain + ",");
            if (this.calcHousesNumber() != 0) {
                writer.println("\"houses\": [");
                for (int i = 0; i < this.calcHousesNumber(); i++) {
                    House theHouse = (House) this.houses.get(i);
                    writer.println("{");
                    writer.println("\"number\": " + theHouse.getNumber() + ",");
                    writer.println("\"length\": " + theHouse.getLengthMeasureable() + ",");
                    writer.println("\"width\": " + theHouse.getWidth() + ",");
                    if (i == (this.calcHousesNumber() - 1)) {
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

    public void readFromFile(String name) {
        try (InputStream inputStream = new FileInputStream(name);
             Scanner reader = new Scanner(inputStream)) {
            String temp;
            reader.nextLine();
            temp = reader.nextLine();
            this.name = temp.substring(9, temp.length() - 2);
            temp = reader.nextLine();
            this.kadastrNumber = Integer.valueOf(temp.substring(16, temp.length() - 1));
            temp = reader.nextLine();
            this.isMain = Boolean.valueOf(temp.substring(10, temp.length() - 1));
            temp = reader.nextLine();
            if (temp.compareTo("}") == 0) {
                return;
            }
            do {
                temp = reader.nextLine();
                temp = reader.nextLine();
                int num = Integer.valueOf(temp.substring(10, temp.length() - 1));
                temp = reader.nextLine();
                int len = Integer.valueOf(temp.substring(10, temp.length() - 1));
                temp = reader.nextLine();
                int wid = Integer.valueOf(temp.substring(9, temp.length() - 1));
                houses.add(new House(num, len, wid));
                temp = reader.nextLine();
            } while (temp.compareTo("}") != 0);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка записи");
        }

    }

}
