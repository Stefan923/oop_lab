package me.stefan923.studenti;

public class SimulareStudenti {

    public static void main(String[] args) {
        Masina masina = new Masina("Volvo", "gri");
        Student student1 = new Student("Popescu", "Stefan", masina);

        Student student2 = shallowCopy(student1);
        student2.getMasina().revopsire("albastru");
        System.out.println(student1.toString() + "\n" + student2.toString() + "\n");

        Student student3 = null;
        try {
            student3 = deepCopy(student1);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        student3.getMasina().revopsire("negru");
        System.out.println(student1.toString() + "\n" + student3.toString() + "\n");
    }

    private static Student shallowCopy(Student student1) {
        return new Student(student1.getNume(), student1.getPrenume(), student1.getMasina());
    }

    private static Student deepCopy(Student student1) throws CloneNotSupportedException {
        Student student2 = (Student) student1.clone();
        student2.setMasina((Masina) student1.getMasina().clone());

        return student2;
    }

}
