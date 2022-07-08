import java.util.Arrays;

public class FourthExercise {
    public static void main(String[] args) {
        int[] tatarstanYears = {1992, 1920, 2006, 1990, 1438, 1236, 1458, 1917, 1552, 1708,
                1445, 1723, 1718, 1551, 1752, 965, 1380, 1891, 1970, 1937};
        int[] sortedTatarstanYears = cocktailShakerSort(tatarstanYears);
        System.out.println(Arrays.toString(sortedTatarstanYears));
        System.out.println(binarySearchRecursive(sortedTatarstanYears, 1718));
        System.out.println(binarySearchRecursive(sortedTatarstanYears, 965));
        System.out.println(binarySearchRecursive(sortedTatarstanYears, 1380));
        System.out.println(binarySearchRecursive(sortedTatarstanYears, 1915));
    }

    private static int[] cocktailShakerSort(int[] array) {

        if (array.length == 0 || array.length == 1) {
            return array;
        }

        int swap;
        int bound = array.length - 1;
        boolean isSwap;

        do {
            isSwap = false;

            for (int i = 0; i < bound; i++) {
                if (array[i] > array[i + 1]) {
                    swap = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = swap;
                    isSwap = true;
                }
            }

            for (int i = bound - 2; i > 0; i--) {
                if (array[i] > array[i + 1]) {
                    swap = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = swap;
                    isSwap = true;
                }

            }

            bound -= 1;

        } while (isSwap);
        return array;
    }

    private static boolean binarySearchRecursive(int[] array, int value) {
        if (array.length == 0) {
            return false;
        }

        int left = 0;
        int right = array.length - 1;
        int key = (left + right) / 2;
        int[] halfArray = new int[key];
        if (array[key] > value) {
            System.arraycopy(array, 0, halfArray, 0, key );
            binarySearchRecursive(halfArray, value);
        } else if (array[key] < value) {
            System.arraycopy(array, key , halfArray, 0, key );
            binarySearchRecursive(halfArray, value);
        } else {
            return true;
        }

        return false;

    }

}




