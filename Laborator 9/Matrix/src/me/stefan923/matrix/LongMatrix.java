package me.stefan923.matrix;

public class LongMatrix extends GenericMatrix<Long> {
    @Override
    /** Aduna doi intregi mari */
        protected Long add(Long o1, Long o2) {
        return o1 + o2;
    }

    @Override
    /** Inmulteste doi intregi mari */
    protected Long multiply(Long o1, Long o2) {
        return o1 * o2;
    }

    @Override
    /** Specifica zero pentru un intreg mare */
    protected Long zero() {
        return 0l;
    }
}
