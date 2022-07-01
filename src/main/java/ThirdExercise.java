public class ThirdExercise {

    public static void main(String[] args) {
        System.out.println(arrayChangesToCount(100));

        int[] TatarstanYears = {1992, 1920, 2006, 1990, 1438, 1236, 1458, 1917, 1552, 1708,
                1445, 1723, 1718, 1551, 1752, 965, 1380, 1891, 1970, 1937};
        int[] sortedTatarstanYears = bubbleSort(TatarstanYears);
        for (int i = 0; i < 20; i++) {
            System.out.println(sortedTatarstanYears[i]);
        }
        System.out.println(binarySearch(sortedTatarstanYears, 1718));
        System.out.println(binarySearch(sortedTatarstanYears, 965));
        System.out.println(binarySearch(sortedTatarstanYears, 2022));
    }

    private static int arrayChangesToCount(int size) {
        int[] massiv = new int[size];
        int counter = 0;
        for (int i = 1; i <= size; i++) {
            if (size % i == 0) {
                massiv[i - 1] = i;
            } else {
                massiv[i - 1] = Integer.MIN_VALUE;
            }
        }
        for (int i = 1; i <= size; i++) {
            if (massiv[i - 1] != Integer.MIN_VALUE) {
                counter++;
            }
        }
        return counter;
    }


    private static int[] bubbleSort(int[] massiv) {
        int swap;
        for (int j = 0; j < massiv.length; j++) {
            for (int i = 0; i < (massiv.length - j - 1); i++) {
                if (massiv[i] > massiv[i + 1]) {
                    swap = massiv[i + 1];
                    massiv[i + 1] = massiv[i];
                    massiv[i] = swap;
                }
            }
        }
        return massiv;
    }

    public static boolean binarySearch(int[] massiv, int value) {
        int key = (massiv.length - 1) / 2;
        for (; ; ) {

            if (massiv[key] > value) {
                key = (key - 1) / 2;
            } else if (massiv[key] < value) {
                key = (key + massiv.length) / 2;
            } else if (massiv[key] == value) {
                return true;
            }

            if (key == 0 || key == (massiv.length - 1)) {
                if (massiv[key] == value) {
                    return true;
                }
                return false;
            }
        }
    }
}


