package inheritance;

public class Shadowing {

    public static void main(String[] args) {
        Sub s = new Sub();
        Base b = s;

        // variable shadowing
        System.out.println(s.field);
        System.out.println(((Base) s).field);

        System.out.println(b.field);
        System.out.println(((Sub) b).field);
    }
}
