public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {

        int rows = array2d.length;
        int cols = array2d[0].length;
        int[] result = new int[rows * cols];
        int index = 0;

        int topRow = 0;
        int bottomRow = rows - 1;
        int leftCol = 0;
        int rightCol = cols - 1;

        while (topRow <= bottomRow && leftCol <= rightCol) {
            // Traverse right
            for (int i = leftCol; i <= rightCol; i++) {
                result[index++] = array2d[topRow][i];
            }
            topRow++;

            // Traverse down
            for (int i = topRow; i <= bottomRow; i++) {
                result[index++] = array2d[i][rightCol];
            }
            rightCol--;

            if (topRow <= bottomRow) {
                // Traverse left
                for (int i = rightCol; i >= leftCol; i--) {
                    result[index++] = array2d[bottomRow][i];
                }
                bottomRow--;
            }

            if (leftCol <= rightCol) {
                // Traverse up
                for (int i = bottomRow; i >= topRow; i--) {
                    result[index++] = array2d[i][leftCol];
                }
                leftCol++;
            }
        }

        return result;
    }


    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {
        int length = array1d.length;
        int size = (int) Math.ceil(Math.sqrt(length));
        int[][] result = new int[size][size];

        int topRow = 0;
        int bottomRow = size - 1;
        int leftCol = 0;
        int rightCol = size - 1;
        int index = 0;

        while (index < length) {
            // Traverse right
            for (int i = leftCol; i <= rightCol && index < length; i++) {
                result[topRow][i] = array1d[index++];
            }
            topRow++;

            // Traverse down
            for (int i = topRow; i <= bottomRow && index < length; i++) {
                result[i][rightCol] = array1d[index++];
            }
            rightCol--;

            if (index < length) {
                // Traverse left
                for (int i = rightCol; i >= leftCol && index < length; i--) {
                    result[bottomRow][i] = array1d[index++];
                }
                bottomRow--;
            }

            if (index < length) {
                // Traverse up
                for (int i = bottomRow; i >= topRow && index < length; i--) {
                    result[i][leftCol] = array1d[index++];
                }
                leftCol++;
            }
        }

        return result;
    }


    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        for (int i = 0; i < array1d.length; i++) {
            System.out.print(array1d[i] + " ");
        }
        System.out.println();
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        for (int[] row : array2d) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        int length = array1d.length;
        int sqrt = (int) Math.sqrt(length);
        return sqrt * sqrt == length;
    }

    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        int rows = array2d.length;
        for (int[] row : array2d) {
            if (row.length != rows) {
                return false;
            }
        }
        return true;
    }}
