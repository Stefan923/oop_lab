import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsAndLambdaExamples {

    public static void main(String[] args) {

        //filter
        int[] values = {8, 7, -6, 5, -4};
        int[] positiveValues = Arrays.stream(values)
                .filter(x -> x > 0).toArray();
        System.out.println("Filter positive values: ");
        ArrayOperations.printArray(positiveValues);
        System.out.println();

        //compute the sum using reduce and lambda expression
        int[] integers = {1000, 3, 70, 1, 206};
        Integer sum = Arrays.stream(integers)
                .reduce(0, (a, b) -> a + b);
        System.out.println("The computed sum is: " + sum);
        System.out.println();

        //compute the sum using reduce and an already existing method in java
        Integer sumOfIntegers = Arrays.stream(integers)
                .reduce(0, Integer::sum);
        System.out.println("The computed sumOfIntegers is: " + sumOfIntegers);
        System.out.println();

        //pirnt the values
        System.out.println("Print the values of the array: ");
        Arrays.stream(integers)
                .forEach(val -> {
                    System.out.print(val + " ");
                });
        System.out.println();

        //transform the values of the array
        System.out.println("Multiply the values of the array: ");
        int[] multipliedIntegers = Arrays.stream(integers)
                .map(val -> val * 10).toArray();
        ArrayOperations.printArray(multipliedIntegers);
        System.out.println();

        //chain multiple operations
        int[] stringIntegers = {3, 6, 10, -25, 10, 7, 21, 1, 3, -23};
        int[] newValues = Arrays.stream(stringIntegers)
                .map(intVal -> intVal * 10)
                .filter(intVal -> intVal > 0)
                .sorted()
                .distinct()
                .toArray();
        System.out.println("Multiply the values of the array: ");
        ArrayOperations.printArray(newValues);
        System.out.println();

        //example for Collections
        List<Integer> listOfIntegers = Arrays.asList(9, 50, 4, -10, 21, 33, 9, -71, -7, 88, 4, 10, -61, 103, 9);
        List<Integer> newListOfIntegers = listOfIntegers.stream()
                .map(intVal -> intVal * 10)
                .filter(intVal -> intVal > 0)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("The values of the collection after the chan of operations is: ");
        newListOfIntegers.stream()
                .forEach(val -> {
                    System.out.print(val + " ");
                });
    }
}
