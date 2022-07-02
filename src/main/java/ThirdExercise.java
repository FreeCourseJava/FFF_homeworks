public class ThirdExercise {

    public static void main(String[] args) {
        System.out.println(arrayChangesToCount(100));

        int[] TatarstanYears = {1992, 1920, 2006, 1990, 1438, 1236, 1458, 1917, 1552, 1708,
                1445, 1723, 1718, 1551, 1752, 965, 1380, 1891, 1970, 1937};
        int[] TatarstanYears2 = {1801, 1851, 1876, 1886, 1896, 1901, 1906, 1907, 1911, 1913,
                1916, 1921, 1926, 1931, 1936, 1956, 1961, 1966, 1976, 1996};
        int[] sortedTatarstanYears = bubbleSort(TatarstanYears);
        for (int i = 0; i < 20; i++) {
            System.out.println(sortedTatarstanYears[i]);
        }
        System.out.println(binarySearch(sortedTatarstanYears, 1718));
        System.out.println(binarySearch(sortedTatarstanYears, 965));
        System.out.println(binarySearch(sortedTatarstanYears, 1380));
        System.out.println(binarySearch(sortedTatarstanYears, 1915));
        System.out.println(binarySearch(TatarstanYears2, 1852));
    }

    private static int arrayChangesToCount(int size) {
        int[] array = new int[size];
        int counter = 0;
        for (int i = 1; i <= size; i++) {
            if (size % i == 0) {
                array[i - 1] = i;
            } else {
                array[i - 1] = Integer.MIN_VALUE;
            }
        }
        for (int i = 1; i <= size; i++) {
            if (array[i - 1] != Integer.MIN_VALUE) {
                counter++;
            }
        }
        return counter;
    }


    private static int[] bubbleSort(int[] array) {
        int swap;
        for (int j = 0; j < (array.length - 1); j++) {
            for (int i = 0; i < (array.length - j - 1); i++) {
                if (array[i] > array[i + 1]) {
                    swap = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = swap;
                }
            }
        }
        return array;
    }

    public static boolean binarySearch(int[] array, int value) {
        int left = 0;
        int right = array.length - 1;
        int key;
        for (; ; ) {
            key = (left + right) / 2;
            if (array[key] > value) {
                right = key - 1;
            } else if (array[key] < value) {
                left = key + 1;
            } else {
                return true;
            }

            if (left > right) {
                return false;
            }
        }
    }
}





