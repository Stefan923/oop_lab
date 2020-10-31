public class ArrayOperations {
    
    public static void initArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
    }

    public static int computeSum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        return sum;
    }

    public static int computeSumShorter(int[] a) {
        int sum = 0;
        for (int v : a) {
            sum = sum + v;
        }
        return sum;
    }

    public static void testArrayReferences() {
        int[] array1 = new int[]{100, 99, 98};
        int[] array2;
        array2 = array1;
        array2[1] = 0;

        System.out.println("Value of array1[1] " + array1[1]);
        System.out.println("Value of array2[1] " + array2[1]);
    }

    public static int[] invertArray1(int[] b) {
        int stinga = 0;
        int dreapta = b.length - 1;
        while (stinga < dreapta) {
            int temp = b[stinga];
            b[stinga] = b[dreapta];
            b[dreapta] = temp;
            stinga++;
            dreapta--;
        }
        return b;
    }

    public static int[] invertArray2(int[] b) {
        int stanga;
        int dreapta;
        for (stanga = 0, dreapta = b.length - 1; stanga < dreapta; stanga++, dreapta--) {
            int temp = b[stanga];
            b[stanga] = b[dreapta];
            b[dreapta] = temp;
        }
        return b;
    }

    public static void initMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (i + j) * 2;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void printArray(int[] values) {
        for (int val : values) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
