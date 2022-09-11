package ninth;

import fifth.House;

import java.util.Arrays;

public class NinthExercise {

    public static void main(String[] args) {
        int[] tatarstanYears = {1992, 1920, 2006, 1990, 1438, 1236, 1458, 1917, 1552, 1708,
                1445, 1723, 1718, 1551, 1752, 965, 1380, 1891, 1970, 1937};

        int[] sortedTatarstanYears = IntArrayUtils.bubbleSort(tatarstanYears);
        System.out.println(Arrays.toString(sortedTatarstanYears));

        int[] sortedTatarstanYears2 = IntArrayUtils.cocktailShakerSort(tatarstanYears);
        System.out.println(Arrays.toString(sortedTatarstanYears2));

        System.out.println(IntArrayUtils.binarySearch(sortedTatarstanYears, 1718));
        System.out.println(IntArrayUtils.binarySearch(sortedTatarstanYears, 965));
        System.out.println(IntArrayUtils.binarySearch(sortedTatarstanYears, 1380));
        System.out.println(IntArrayUtils.binarySearch(sortedTatarstanYears, 1915));

        ListLinked housesList = new ListLinked();
        ArrayExtendable housesArray = new ArrayExtendable();

        House dom1 = new House(1, 30, 20);
        House dom5 = new House(5, 560, 400);
        House dom3 = new House(3, 60, 4000);
        House dom6 = new House(6, 5600, 400);

        System.out.println(housesArray.length());
        housesArray.remove(5);
        housesArray.add(dom1);
        housesArray.remove(dom5);
        housesArray.add(dom5);
        housesArray.add(dom3);
        housesArray.remove(dom5);
        dom5 = (House) housesArray.get(0);
        System.out.println(housesArray.exists(dom3));


        housesList.remove(5);
        housesList.add(dom1);
        housesList.remove(dom6);
        housesList.add(dom6);
        housesList.add(dom3);
        housesList.remove(dom6);
        dom6 = (House) housesList.get(0);
        System.out.println(housesList.exists(dom1));
    }
}
