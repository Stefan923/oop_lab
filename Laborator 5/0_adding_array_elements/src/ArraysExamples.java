public class ArraysExamples {

    public static void main(String[] args) {
        //vectori
        int[] array = new int[1000];
        ArrayOperations.initArray(array);

        // suma elementelor unui array
        System.out.println("The sum is: " + ArrayOperations.computeSum(array));
        System.out.println("The sum is: " + ArrayOperations.computeSumShorter(array));

        //testarea referintelor
        ArrayOperations.testArrayReferences();

        // invert an array
        int[] values = new int[]{45, 22, 5, 67, 55, 1, 100, 231, 9, 17, 19, 72, 395};
        ArrayOperations.printArray(values);
        ArrayOperations.printArray(ArrayOperations.invertArray1(values));
        ArrayOperations.printArray(ArrayOperations.invertArray2(values));

        //two dimentional arrays
        int[][] matrix = new int[2][3];
        ArrayOperations.initMatrix(matrix);
        ArrayOperations.printMatrix(matrix);

        //check types
        System.out.println("Type of int[]: " + values.getClass().getName());
        System.out.println("Type of int[][]: " + matrix.getClass().getName());

    }
}
