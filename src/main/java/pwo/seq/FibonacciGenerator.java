package pwo.seq;
import java.math.BigDecimal;

/**
 * Klasa implementujaca generator ciagu Fibonacciego
 * 
 * @version 1.0.0
 * @author gman
 */
public class FibonacciGenerator extends Generator {

     /**
     * Konstruktor klasy TribonacciGenerator, 
     * ustawia poczatkowe wyrazu na 1 i 0
     */
    public FibonacciGenerator() {
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }
    
    /**
    * Powoduje, że metoda {@link #nextTerm()} rozpoczyna od 0.<br>
    * Nie wplywa na działanie metody {@link #getTerm(int)}.
    */
    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }

    /**
    * Zwraca kolejny wyraz ciągu Fibonacciego.
    *
    * @return Wartość wyrazu ciągu
    */
    @Override
    public BigDecimal nextTerm() {

        if (lastIndex > 1) {
            current = f_1.add(f_2);
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 1) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(0);
        }

        lastIndex++;
        return current;
    }
}
