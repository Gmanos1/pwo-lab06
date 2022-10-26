package pwo.seq;

/**
 * Jest to generator ciagu Tribonnaciego,
 * @author gman
 */

import java.math.BigDecimal;

public class TribonacciGenerator extends
        FibonacciGenerator {

    /**
     * Konstruktor klasy TribonacciGenerator, 
     * ustawia poczatkowy wyraz na 0
     */
    public TribonacciGenerator() {
        f_3 = new BigDecimal(0);
    }

    /**
     * Metoda sluzaca do zresetowania ciagu (ustawienienia pierwszego wyrazu ciagu na 0)
     * 
     */
    @Override
    public void reset() {
        super.reset();
        f_3 = new BigDecimal(0);
    }
    /**
    * Zwraca koleny wyraz ciągu Tribonnaciego.
    *
    * @return Wartość wyrazu ciągu
    */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 2) {
            current = f_1.add(f_2).add(f_3);
            f_3 = f_2;
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 2) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(0);
        }
        lastIndex++;
        return current;
    }
}
