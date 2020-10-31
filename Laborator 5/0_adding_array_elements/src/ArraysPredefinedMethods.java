import java.util.Arrays;
import java.lang.*;
import java.util.List;

public class ArraysPredefinedMethods {

    public static void main(String[] args) {
        int[] values = new int[10];
        ArrayOperations.initArray(values);
        System.out.println("Array values: ");
        ArrayOperations.printArray(values);

        int[] copyArray = new int[10];
        System.arraycopy(values, 0, copyArray, 0, values.length);
        System.out.println("Array copyArray: ");
        ArrayOperations.printArray(values);

        //check equal arrays
        System.out.println("Equal arrays: " + Arrays.equals(values, copyArray));

        //binarySearch
        int key = 116;
        System.out.println("Binary search result for key=" + key + " : " + (Arrays.binarySearch(values, key) > 0));

        //sort array
        Arrays.sort(values);
        System.out.println("Sorted array: ");
        ArrayOperations.printArray(values);

        //fill array with a single value
        int[] filledArray = new int[10];
        int valueToFill = 104;
        Arrays.fill(filledArray, valueToFill);
        System.out.println("Filled array: ");
        ArrayOperations.printArray(filledArray);

        //array to String
        System.out.println("Array values as a string: ");
        System.out.println(Arrays.toString(values));

        //array as collection
        List<Integer> listValues = Arrays.asList(10, 11, 12);

        //check the types
        System.out.println("Type of array values: " + values.getClass().getName());
        System.out.println("type of list listValues: " + listValues.getClass().getName());
    }
}
