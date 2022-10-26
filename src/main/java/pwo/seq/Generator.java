package pwo.seq;

import java.math.BigDecimal;
import pwo.utils.SequenceGenerator;

import pwo.utils.SequenceGenerator;

/**
 * Klasa abstrakcyjna implementujaca interfejs SequenceGenerator
 * 
 * @version 1.0.0
 * @author gman
 */
abstract public class Generator implements SequenceGenerator {

    protected int lastIndex = 0;
    protected BigDecimal current = null,
            f_1 = null,
            f_2 = null,
            f_3 = null;

    /**
    * Metoda ustawiajaca wartosc indexu na 0
    */
    @Override
    public void reset() {
        lastIndex = 0;
    }

    /**
     * Zwraca wartosc ciagu dla podanego indeksu
     * 
     * @param i indeks
     * @return 
     */
    @Override
    public final BigDecimal getTerm(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i < lastIndex) {
            reset();
        }
        while (lastIndex <= i) {
            nextTerm();
        }
        return current;
    }
}
