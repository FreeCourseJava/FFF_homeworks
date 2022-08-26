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
    }
}
