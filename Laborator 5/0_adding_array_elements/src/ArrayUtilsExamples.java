import org.apache.commons.lang3.ArrayUtils;

public class ArrayUtilsExamples {

    public static void main(String[] args) {

        //add and addAll
        int[] oldArray = {2, 3, 4, 5, 6, 7, 8};

        int[] newArray1 = ArrayUtils.add(oldArray, 0, 1);
        int[] newArray2 = ArrayUtils.add(oldArray, 1);

        System.out.println("add with position specified: ");
        ArrayOperations.printArray(newArray1);
        System.out.println("add without position specified: ");
        ArrayOperations.printArray(newArray2);
        System.out.println();

        //remove and removeElement
        int[] newArray3 = ArrayUtils.remove(oldArray, 1);
        int[] newArray4 = ArrayUtils.removeElement(oldArray, 5);

        System.out.println("remove element at given index: ");
        ArrayOperations.printArray(newArray3);
        System.out.println("remove element by value: ");
        ArrayOperations.printArray(newArray4);
        System.out.println();

        //contains
        int[] values = {1, 3, 5, 7, 9};
        boolean evenContained = ArrayUtils.contains(values, 2);
        boolean oddContained = ArrayUtils.contains(values, 7);

        ArrayOperations.printArray(newArray4);
        System.out.println("Contains 2: " + evenContained);
        System.out.println("Contains 3: " + oddContained);
        System.out.println();

        //reverse
        int[] originalArray = {1, 88, 10, 4, 21};
        System.out.println("Before reverse: ");
        ArrayOperations.printArray(originalArray);
        ArrayUtils.reverse(originalArray);
        System.out.println("After reverse: ");
        ArrayOperations.printArray(originalArray);
    }
}
