package ninth;

public final class IntArrayUtils {

    private IntArrayUtils(){

    }
    public static int[] bubbleSort(int[] array) {
        int swap;
        int bound = array.length - 1;
        for (int j = 0; j < bound; j++) {
            for (int i = 0; i < (bound - j); i++) {
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
        if (array.length == 0) {
            return false;
        }
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

    public static int[] cocktailShakerSort(int[] array) {

        if (array.length < 2) {
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


}


