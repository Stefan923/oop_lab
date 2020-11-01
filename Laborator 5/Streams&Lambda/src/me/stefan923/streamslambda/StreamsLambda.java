package me.stefan923.streamslambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsLambda {

    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex4();
        ex5();
        ex6();
        ex7();
        ex8();
        ex9();
        ex10();
        ex11();
        ex12();
        ex13();
    }

    public static void ex1() {
        List<String> list = new ArrayList<>();
        list.add("mar");
        list.add("para");
        list.add("cireasa");

        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(string -> stringBuilder.append(string.charAt(0)));
        System.out.println("1. " + stringBuilder);
    }

    public static void ex2() {
        List<String> list = new ArrayList<>();
        list.add("mar");
        list.add("para");
        list.add("cireasa");

        list.removeIf(string -> string.length() % 2 == 1);
        System.out.println("2. " + list.toString());
    }

    public static void ex3() {
        List<String> list = new ArrayList<>();
        list.add("mar");
        list.add("para");
        list.add("cireasa");

        list.replaceAll(String::toUpperCase);
        System.out.println("3. " + list.toString());
    }

    public static void ex4() {
        HashMap<String, String> strings = new HashMap<>();
        strings.put("1", "2");
        strings.put("3", "4");
        strings.put("5", "6");

        StringBuilder stringBuilder2 = new StringBuilder();
        strings.forEach((s1, s2) -> stringBuilder2.append(s1).append(s2));
        System.out.println("4. " + stringBuilder2.toString());
    }

    public static void ex5() {
        List<String> originalList = new ArrayList<>();
        originalList.add("MAR");
        originalList.add("PAra");
        originalList.add("ciREASa");

        List<String> list = new ArrayList<>();
        originalList.forEach(string -> list.add(string.toLowerCase()));

        System.out.println("5. " + list.toString());
    }

    public static void ex6() {
        List<String> originalList = new ArrayList<>();
        originalList.add("MAR");
        originalList.add("PAra");
        originalList.add("ciREASa");

        List<String> list = new ArrayList<>();
        originalList.stream().filter(string -> string.length() % 2 == 1).forEach(string -> list.add(string.toLowerCase()));

        System.out.println("6. " + list.toString());
    }

    public static void ex7() {
        List<String> originalList = new ArrayList<>();
        originalList.add("s1");
        originalList.add("s2");
        originalList.add("s3");
        originalList.add("s4");

        String string = IntStream.range(1, 4).mapToObj(originalList::get).collect(Collectors.joining("-"));
        System.out.println("7. " + string);
    }

    public static void ex8() {
        List<Integer> list = Stream.iterate(1, i -> i * 2).limit(14).collect(Collectors.toList());
        System.out.println("8. " + list.toString());
    }

    public static void ex9() {
        List<Integer> list = new ArrayList<>();
        list.add(122);
        list.add(121);
        list.add(123321);
        list.add(7);
        list.add(10);

        System.out.println("9. " + list.stream().filter(integer -> isPalindrome(integer).isPresent()).count());
    }

    public static Optional<Integer> isPalindrome(int number) {
        int reverse = 0, n = number;

        while (n > 0) {
            reverse *= 10;
            reverse += n % 10;
            n /= 10;
        }

        if (reverse == number)
            return Optional.of(number);
        return Optional.empty();
    }

    public static void ex10() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Stefan", 20, 5000.50));
        list.add(new Employee("George", 25, 4500.10));
        list.add(new Employee("Elena", 25, 500.39));

        System.out.println("10. " + list.stream().mapToDouble(Employee::getSalary).sum());
    }

    public static void ex11() {
        List<Student> list = new ArrayList<>();
        Student student = new Student("Alin", 9.8);
        student.addCourse("Mate");
        student.addCourse("Romana");
        student.addCourse("Geografie");
        list.add(student);
        student = new Student("Ion", 9);
        student.addCourse("Mate");
        student.addCourse("Romana");
        student.addCourse("Geografie");
        student.addCourse("Istorie");
        list.add(student);

        Map<String, Integer> numOfCourses = list.stream().collect(Collectors.toMap(Student::getName, student1 -> student1.getCourses().size()));
        System.out.println("10. " + numOfCourses.toString());
    }

    public static void ex12() {
        List<Car> list = new ArrayList<>();
        list.add(new Car("Ford", 2020, "Copper", 21000));
        list.add(new Car("Tesla", 2020, "Dark Blue", 42000));
        list.add(new Car("Volvo", 2019, "Light Gray", 32000));

        list.sort(Car::compareTo);
        System.out.println("12. " + list.stream().map(Car::getBrand).collect(Collectors.toList()));
    }

    public static void ex13() {
        int limit = 10;

        Stream<long[]> stream = Stream.iterate(new long[]{0, 1}, number -> new long[]{number[1], number[0] + number[1]});
        System.out.println("13. " + stream.limit(limit).mapToLong(number -> number[0]).sum());
    }

}
