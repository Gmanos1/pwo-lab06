/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.seq;

/**
 * Jest to generator ciagu Lucasa,
 * @author gman
 */
import java.math.BigDecimal;

public class LucasGenerator extends FibonacciGenerator {

     /**
     * Konstruktor klasy LucasGenerator, 
     * ustawia poczatkowy wyraz na 2
     */
    public LucasGenerator() {
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
    }

    /**
    * Powoduje, że metoda {@link #nextTerm()} rozpoczyna liczenie od 2.<br>
    */
    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
    }

    /**
    * Zwraca koleny wyraz ciągu Lucasa.
    *
    * @return Wartość wyrazu ciągu
    */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex == 0) {
            lastIndex++;
            return new BigDecimal(2);
        }
        return super.nextTerm();
    }
}
