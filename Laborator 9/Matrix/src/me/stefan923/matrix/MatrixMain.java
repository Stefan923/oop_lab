package me.stefan923.matrix;

public class MatrixMain {

    public static void main(String[] args) {
        // Creaza tablourile de intregi m1, m2
        Integer[][] m1 = new Integer[][]{{1, 2, 3}, {4, 5, 6}, {1, 1, 1}};
        Integer[][] m2 = new Integer[][]{{1, 1, 1}, {2, 2, 2}, {0, 0, 0}};

        // Creaza o instanta de IntegerMatrix
        IntegerMatrix integerMatrix = new IntegerMatrix();
        System.out.println("\nm1 + m2 is ");
        GenericMatrix.printResult(m1, m2, integerMatrix.addMatrix(m1, m2), '+');
        System.out.println("\nm1 * m2 is ");
        GenericMatrix.printResult(m1, m2, integerMatrix.multiplyMatrix(m1, m2), '*');

        // Creaza tablourile de intregi mari l1, l1
        Long[][] l1 = new Long[][]{{1l, 1l, 1l}, {2l, 2l, 2l}, {3l, 3l, 3l}};
        Long[][] l2 = new Long[][]{{0l, 0l, 0l}, {1l, 1l, 1l}, {0l, 0l, 0l}};

        // Creaza o instanta de IntegerMatrix
        LongMatrix longMatrix = new LongMatrix();
        System.out.println("\nl1 + l2 is ");
        GenericMatrix.printResult(l1, l2, longMatrix.addMatrix(l1, l2), '+');
        System.out.println("\nl1 * l2 is ");
        GenericMatrix.printResult(l1, l2, longMatrix.multiplyMatrix(l1, l2), '*');

        // Creaza tablourile de intregi mari l1, l1
        Double[][] d1 = new Double[][]{{1d, 1d, 1d}, {2d, 2d, 2d}, {3d, 3d, 3d}};
        Double[][] d2 = new Double[][]{{1d, 1d, 1d}, {1d, 1d, 1d}, {1d, 1d, 1d}};

        // Creaza o instanta de IntegerMatrix
        DoubleMatrix doubleMatrix = new DoubleMatrix();
        System.out.println("\nd1 + d2 is ");
        GenericMatrix.printResult(d1, d2, doubleMatrix.addMatrix(d1, d2), '+');
        System.out.println("\nd1 * d2 is ");
        GenericMatrix.printResult(d1, d2, doubleMatrix.multiplyMatrix(d1, d2), '*');
    }

}
